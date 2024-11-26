package com.example.pede_pra_mim.users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Table(name = "usuario")
@Entity(name = "users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_usuarios")
public class Users {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuarios;

    private String nome;

    private String senha;

    private String email;

   // private String image;

    private String telefone;

    @ElementCollection
    @CollectionTable(name="profissao", joinColumns = @JoinColumn(name = "id_usuario"))
    @Column(name = "nome_profissao")

    private List<String> profissao;

    private Integer avaliacao;

    private String cidade;



    public Users(UsersRequestDTO data){
        this.nome = data.nome();
        this.senha = data.senha();
        this.email = data.email();
        //this.image = data.image();
        this.telefone = data.telefone();
        this.profissao = data.profissao();
        this.avaliacao = data.avaliacao();
        this.cidade = data.cidade();

    }
}
