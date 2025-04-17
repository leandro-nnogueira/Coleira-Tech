package com.coleiratech.Coleira.Tech.repository;

import com.coleiratech.Coleira.Tech.model.Coleira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ColeiraRepository extends JpaRepository<Coleira, UUID> {
}
