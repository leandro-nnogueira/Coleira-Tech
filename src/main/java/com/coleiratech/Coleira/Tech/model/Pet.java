package com.coleiratech.Coleira.Tech.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;

    private String tipo;

    private String raca;

    private String cor;

    @ManyToOne
    @JoinColumn(name = "dono_id", nullable = false)
    @JsonBackReference
    private Dono dono;

    @OneToOne(mappedBy = "pet", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private Coleira coleira;

}
