package com.coleiratech.Coleira.Tech.Service;

import com.coleiratech.Coleira.Tech.Entity.CollarEntity;
import com.coleiratech.Coleira.Tech.Repository.CollarRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class CollarService {

    private final CollarRepository repository;

    public CollarService(CollarRepository collarRepository) {
        this.repository = collarRepository;
    }

    public CollarEntity saveLocaltion(CollarEntity collar) {
        collar.setDateTime(LocalDateTime.now());
        return repository.save(collar);
    }

    public Optional<CollarEntity> getLocationById(UUID id) {
        return repository.findById(id);
    }
}
