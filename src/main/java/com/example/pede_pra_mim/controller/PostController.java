package com.example.pede_pra_mim.controller;

import com.example.pede_pra_mim.post.Post;
import com.example.pede_pra_mim.post.PostRequestDTO;
import com.example.pede_pra_mim.post.PostResponseDTO;
import com.example.pede_pra_mim.post.PostRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostRepository repository;

    @Value("${upload.directory}")
    private String uploadDir;

    private final ObjectMapper objectMapper = new ObjectMapper(); // Inicializa o ObjectMapper

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping(consumes = "multipart/form-data")
    public void savePost(@RequestPart("data") String data, @RequestPart("imagem") MultipartFile imagem) {
        try {
            // Converte o JSON do campo "data" para o DTO
            PostRequestDTO postData = objectMapper.readValue(data, PostRequestDTO.class);

            // Verifica se o arquivo de imagem foi enviado
            if (imagem == null || imagem.isEmpty()) {
                throw new IllegalArgumentException("A imagem é obrigatória para o post.");
            }

            // Cria um nome único para o arquivo de imagem
            String uniqueFileName = UUID.randomUUID().toString() + "_" + imagem.getOriginalFilename();
            Path filePath = Paths.get(uploadDir, uniqueFileName);

            // Garante que o diretório existe antes de salvar
            Files.createDirectories(filePath.getParent());
            Files.write(filePath, imagem.getBytes());

            // Cria o objeto Post e salva no banco de dados
            Post post = new Post(postData, filePath.toString());
            repository.save(post);

        } catch (IOException e) {
            System.err.println("Erro ao salvar a imagem ou processar o JSON: " + e.getMessage());
            throw new RuntimeException("Erro ao salvar o arquivo de imagem ou processar o JSON.", e);
        } catch (IllegalArgumentException e) {
            System.err.println("Erro: " + e.getMessage());
            throw e;
        }
    }

    @CrossOrigin(origins = "", allowedHeaders = "")
    @GetMapping
    public List<PostResponseDTO> getAll() {
        // Retorna todos os posts mapeados para o DTO de resposta
        return repository.findAll().stream()
                .map(PostResponseDTO::new)
                .toList();
    }
}
