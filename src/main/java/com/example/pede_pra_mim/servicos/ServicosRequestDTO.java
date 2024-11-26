package com.example.pede_pra_mim.servicos;

public record ServicosRequestDTO(
        Long clienteId,
        Long profissionalId,
        String descricaoServico,
        String status
) {}
