package com.coleiratech.Coleira.Tech.controller;

import com.coleiratech.Coleira.Tech.model.Coleira;
import com.coleiratech.Coleira.Tech.service.ColeiraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/coleiras")
@RequiredArgsConstructor
public class ColeiraController {

    private final ColeiraService service;

    @PostMapping
    public ResponseEntity<Coleira> criar(@RequestBody Coleira coleira) {
        Coleira novaColeira = service.salvar(coleira);
        return ResponseEntity.ok(novaColeira);
    }

    @GetMapping
    public ResponseEntity<List<Coleira>> listarTodas() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coleira> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coleira> atualizar(@PathVariable UUID id, @RequestBody Coleira coleiraAtualizada) {
        return ResponseEntity.ok(service.atualizar(id, coleiraAtualizada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
