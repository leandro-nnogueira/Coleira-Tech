package com.coleiratech.Coleira.Tech.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CollarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String location;
    private String timeStamp;
}
