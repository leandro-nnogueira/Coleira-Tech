package com.coleiratech.Coleira.Tech.repository;

import com.coleiratech.Coleira.Tech.model.Dono;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DonoRepository extends JpaRepository<Dono, UUID> {
}
