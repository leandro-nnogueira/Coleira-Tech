package com.coleiratech.Coleira.Tech.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Localizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private double latitude;

    private double longitude;

    private LocalDateTime dataHoraRecebimento;

    private LocalDateTime dataHoraGPS;

    @ManyToOne
    @JoinColumn(name = "pet_id", nullable = false)
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "coleira_id", nullable = false)
    private Coleira coleira;

}
