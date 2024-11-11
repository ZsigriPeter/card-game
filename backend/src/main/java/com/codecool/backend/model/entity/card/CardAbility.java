package com.codecool.backend.model.entity.card;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class CardAbility {
    @Id
    @GeneratedValue
    private long id;
    private String description;

}
