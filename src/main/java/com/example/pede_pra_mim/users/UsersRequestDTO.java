package com.example.pede_pra_mim.users;
import java.util.List;

public record UsersRequestDTO(String nome, String senha, String email,
                              String telefone, List<String> profissao, Integer avaliacao, String cidade ){
}
