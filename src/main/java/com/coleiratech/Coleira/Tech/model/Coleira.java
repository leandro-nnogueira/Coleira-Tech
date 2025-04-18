package com.coleiratech.Coleira.Tech.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonBackReference(value = "pet-coleira")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "dono_id", nullable = false)
    @JsonBackReference(value = "dono-coleira")
    private Dono dono;
}
