package com.codecool.backend.model.entity.card;

import jakarta.persistence.Entity;

import java.util.Set;

@Entity
public class UnitCard extends Card {
    private int health;
    private int strength;

    public UnitCard() {}
}
