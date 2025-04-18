package com.coleiratech.Coleira.Tech.service;

import com.coleiratech.Coleira.Tech.model.Localizacao;
import com.coleiratech.Coleira.Tech.repository.LocalizacaoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LocalizacaoService {

    private final LocalizacaoRepository repository;

    public Localizacao salvar(Localizacao localizacao) {
        localizacao.setDataHoraRecebimento(LocalDateTime.now());
        return repository.save(localizacao);
    }

    public List<Localizacao> listarTodas() {
        return repository.findAll();
    }

    public Localizacao buscarPorId(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Localização não encontrada com ID: " + id));
    }

    public List<Localizacao> listarPorPet(UUID petId) {
        return repository.findAll().stream()
                .filter(loc -> loc.getPet().getId().equals(petId))
                .collect(Collectors.toList());
    }

    public List<Localizacao> listarPorColeira(UUID coleiraId) {
        return repository.findAll().stream()
                .filter(loc -> loc.getColeira().getId().equals(coleiraId))
                .collect(Collectors.toList());
    }

    public Localizacao buscarUltimaLocalizacaoDoPet(UUID petId) {
        return listarPorPet(petId).stream()
                .max(Comparator.comparing(Localizacao::getDataHoraRecebimento))
                .orElseThrow(() -> new EntityNotFoundException("Nenhuma localização encontrada para o pet: " + petId));
    }

}
