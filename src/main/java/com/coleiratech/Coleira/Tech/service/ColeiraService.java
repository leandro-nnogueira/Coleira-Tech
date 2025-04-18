package com.coleiratech.Coleira.Tech.service;

import com.coleiratech.Coleira.Tech.model.Coleira;
import com.coleiratech.Coleira.Tech.repository.ColeiraRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ColeiraService {

    private final ColeiraRepository repository;

    public Coleira salvar(Coleira coleira) {
        return repository.save(coleira);
    }

    public List<Coleira> listarTodas() {
        return repository.findAll();
    }

    public Coleira buscarPorId(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Coleira não encontrada com ID: " + id));
    }

    public Coleira atualizar(UUID id, Coleira coleiraAtualizada) {
        Coleira coleiraExistente = buscarPorId(id);

        coleiraExistente.setIdentificador(coleiraAtualizada.getIdentificador());
        coleiraExistente.setDono(coleiraAtualizada.getDono());
        coleiraExistente.setPet(coleiraAtualizada.getPet());

        return repository.save(coleiraExistente);
    }

    public void deletar(UUID id) {
        repository.deleteById(id);
    }

}
