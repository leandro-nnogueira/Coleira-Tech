package com.coleiratech.Coleira.Tech.controller;

import com.coleiratech.Coleira.Tech.model.Dono;
import com.coleiratech.Coleira.Tech.service.DonoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/donos")
@RequiredArgsConstructor
public class DonoController {

    private final DonoService service;

    @PostMapping
    public ResponseEntity<Dono> criar(@RequestBody Dono dono) {
        Dono novoDono = service.salvar(dono);
        return ResponseEntity.ok(novoDono);
    }

    @GetMapping
    public ResponseEntity<List<Dono>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dono> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dono> atualizar(@PathVariable UUID id, @RequestBody Dono dono) {
        return ResponseEntity.ok(service.atualizar(id, dono));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
