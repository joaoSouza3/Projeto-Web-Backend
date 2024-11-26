package com.example.pede_pra_mim.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicosService {
    private final ServicosRepository servicosRepository;

    @Autowired
    public ServicosService(ServicosRepository servicosRepository) {
        this.servicosRepository = servicosRepository;
    }

    public void aceitarServico(Long id) {
        var servico = servicosRepository.findById(id).orElseThrow(() -> new RuntimeException("Serviço não encontrado"));
        servico.setStatus("aceito");
        servicosRepository.save(servico);
    }

    public void recusarServico(Long id) {
        var servico = servicosRepository.findById(id).orElseThrow(() -> new RuntimeException("Serviço não encontrado"));
        servico.setStatus("recusado");
        servicosRepository.save(servico);
    }
}
