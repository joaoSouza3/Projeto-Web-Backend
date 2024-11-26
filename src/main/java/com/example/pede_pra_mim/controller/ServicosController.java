package com.example.pede_pra_mim.controller;

import com.example.pede_pra_mim.servicos.ServicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/servicos")
public class ServicosController {

    @Autowired
    private ServicosService servicosService;

    @PostMapping("/{id}/aceitar")
    public ResponseEntity<String> aceitarSolicitacao(@PathVariable Long id) {
        servicosService.aceitarServico(id);
        return ResponseEntity.ok("Solicitação aceita com sucesso");
    }

    @PostMapping("/{id}/recusar")
    public ResponseEntity<String> recusarSolicitacao(@PathVariable Long id) {
        servicosService.recusarServico(id);
        return ResponseEntity.ok("Solicitação recusada com sucesso");
    }
}
