package com.coleiratech.Coleira.Tech.Repository;

import com.coleiratech.Coleira.Tech.Entity.CollarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CollarRepository extends JpaRepository<CollarEntity, String> {
}
