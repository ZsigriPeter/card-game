package com.codecool.backend.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Player {
    @Id
    @GeneratedValue
    private Long id;

}
