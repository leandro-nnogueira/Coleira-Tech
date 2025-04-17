package com.coleiratech.Coleira.Tech.service;

import com.coleiratech.Coleira.Tech.model.Dono;
import com.coleiratech.Coleira.Tech.repository.DonoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DonoService {

    private final DonoRepository repository;

    public Dono salvar(Dono dono) {
        return repository.save(dono);
    }

    public List<Dono> listarTodos() {
        return repository.findAll();
    }

    public Dono buscarPorId(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Dono não encontrado com ID: " + id));
    }

    public Dono atualizar(UUID id, Dono donoAtualizado) {
        Dono donoExistente = buscarPorId(id);

        donoExistente.setNome(donoAtualizado.getNome());
        donoExistente.setEmail(donoAtualizado.getEmail());
        donoExistente.setTelefone(donoAtualizado.getTelefone());

        return repository.save(donoExistente);
    }

    public void deletar(UUID id) {
        repository.deleteById(id);
    }

}
