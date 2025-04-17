package com.coleiratech.Coleira.Tech.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coleira {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String identificador;

    @OneToOne
    @JoinColumn(name = "pet_id", nullable = false)
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "dono_id", nullable = false)
    private Dono dono;
}
