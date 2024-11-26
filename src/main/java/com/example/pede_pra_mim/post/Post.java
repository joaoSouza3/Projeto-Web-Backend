package com.example.pede_pra_mim.post;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "servico")
@Entity(name = "Post")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_servicos")
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_servicos;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco")
    private String preco;

    @Column(name = "cidadeServico")
    private String cidadeServico;

    @Column(name = "imagemCaminho")
    private String imagemCaminho;

    public Post(PostRequestDTO data, String imagemCaminho){
        this.imagemCaminho = imagemCaminho;
        this.cidadeServico = data.cidadeServico();
        this.preco = data.preco();
        this.descricao = data.descricao();
        this.titulo = data.titulo();
    }
}
