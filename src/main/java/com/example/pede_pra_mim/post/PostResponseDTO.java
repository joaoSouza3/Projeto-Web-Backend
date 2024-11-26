package com.example.pede_pra_mim.post;

public record PostResponseDTO(Long id_servicos, String titulo, String descricao, String preco,
                              String cidadeServico, String imagemCaminho) {
    public PostResponseDTO(Post post){
        this(post.getId_servicos(), post.getTitulo(), post.getDescricao(),
                post.getPreco(), post.getCidadeServico(), post.getImagemCaminho());
    }
}
