package com.coleiratech.Coleira.Tech.service;

import com.coleiratech.Coleira.Tech.model.Pet;
import com.coleiratech.Coleira.Tech.repository.PetRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository repository;

    public Pet salvar(Pet pet) {
        return repository.save(pet);
    }

    public List<Pet> listarTodos() {
        return repository.findAll();
    }

    public Pet buscarPorId(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pet não encontrado com ID: " + id));
    }

    public Pet atualizar(UUID id, Pet petAtualizado) {
        Pet petExistente = buscarPorId(id);

        petExistente.setNome(petAtualizado.getNome());
        petExistente.setTipo(petAtualizado.getTipo());
        petExistente.setRaca(petAtualizado.getRaca());
        petExistente.setCor(petAtualizado.getCor());
        petExistente.setDono(petAtualizado.getDono());

        return repository.save(petExistente);
    }

    public void deletar(UUID id) {
        repository.deleteById(id);
    }

}
