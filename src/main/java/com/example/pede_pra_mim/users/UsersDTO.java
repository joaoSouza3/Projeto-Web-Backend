package com.example.pede_pra_mim.users;

import java.util.List;

public record UsersDTO(Long id_usuarios, String nome,
                       String senha, String email,
                       String telefone, List<String> profissao,
                       Integer avaliacao, String cidade) {
    public UsersDTO(Users users){

        this(users.getId_usuarios(),
                users.getNome(),
                users.getSenha(),
                users.getEmail(),

                users.getTelefone(),
                users.getProfissao(),
                users.getAvaliacao(),
                users.getCidade());

    }

}
