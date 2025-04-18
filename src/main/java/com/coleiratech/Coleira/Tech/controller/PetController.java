package com.coleiratech.Coleira.Tech.controller;

import com.coleiratech.Coleira.Tech.model.Pet;
import com.coleiratech.Coleira.Tech.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/pets")
@RequiredArgsConstructor
public class PetController {

    private final PetService service;

    @PostMapping
    public ResponseEntity<Pet> criar(@RequestBody Pet pet) {
        Pet novoPet = service.salvar(pet);
        return ResponseEntity.ok(novoPet);
    }

    @GetMapping
    public ResponseEntity<List<Pet>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pet> atualizar(@PathVariable UUID id, @RequestBody Pet petAtualizado) {
        return ResponseEntity.ok(service.atualizar(id, petAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
