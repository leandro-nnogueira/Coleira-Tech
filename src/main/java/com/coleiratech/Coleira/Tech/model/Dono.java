package com.coleiratech.Coleira.Tech.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dono {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;

    private String email;

    private String telefone;

    @OneToMany(mappedBy = "dono", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pet> pets;

    @OneToMany(mappedBy = "dono", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Coleira> coleiras;

}
