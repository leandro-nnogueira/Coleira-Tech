package com.coleiratech.Coleira.Tech.controller;

import com.coleiratech.Coleira.Tech.model.Localizacao;
import com.coleiratech.Coleira.Tech.service.LocalizacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/localizacoes")
@RequiredArgsConstructor
public class LocalizacaoController {

    private final LocalizacaoService service;

    @PostMapping
    public ResponseEntity<Localizacao> criar(@RequestBody Localizacao localizacao) {
        Localizacao novaLocalizacao = service.salvar(localizacao);
        return ResponseEntity.ok(novaLocalizacao);
    }

    @GetMapping
    public ResponseEntity<List<Localizacao>> listarTodas() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Localizacao> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/pet/{petId}")
    public ResponseEntity<List<Localizacao>> listarPorPet(@PathVariable UUID petId) {
        return ResponseEntity.ok(service.listarPorPet(petId));
    }

    @GetMapping("/coleira/{coleiraId}")
    public ResponseEntity<List<Localizacao>> listarPorColeira(@PathVariable UUID coleiraId) {
        return ResponseEntity.ok(service.listarPorColeira(coleiraId));
    }

    @GetMapping("/ultima/pet/{petId}")
    public ResponseEntity<Localizacao> buscarUltimaLocalizacao(@PathVariable UUID petId) {
        return ResponseEntity.ok(service.buscarUltimaLocalizacaoDoPet(petId));
    }

}
