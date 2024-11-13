package com.codecool.backend.model.entity.card;

import com.codecool.backend.model.dto.CardDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

import java.util.UUID;

@Entity
public class Card {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String description;
    @Lob
    private byte[] image;
    private String rarity;
    private int cost;
    private UUID publicId;
    private int health;
    private int strength;

    public Card() {
    }

    public Card(String name, String description, byte[] image, String rarity, int cost, int health, int strength) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.rarity = rarity;
        this.cost = cost;
        this.health = health;
        this.strength = strength;
        this.publicId = UUID.randomUUID();
    }

    public CardDTO convertToDTO() {
        return new CardDTO(publicId, name, description, image, rarity, cost, health, strength);
    }

}
