package com.example.pede_pra_mim.servicos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Servicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long clienteId;
    private Long profissionalId;
    private String descricaoServico;
    private String status;  // Valores possíveis: pendente, aceito, recusado

    public void setStatus(String status){
        this.status = status;
    }
}
