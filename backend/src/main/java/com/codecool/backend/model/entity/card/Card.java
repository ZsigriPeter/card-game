package com.codecool.backend.model.entity.card;

import com.codecool.backend.model.dto.CardDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Card {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String description;
    private String image;
    private String rarity;
    private int cost;
    private UUID publicId;

    public Card() {}
    public Card(String name, String description, String image, String rarity, int cost) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.rarity = rarity;
        this.cost = cost;
        this.publicId = UUID.randomUUID();
    }

    public CardDTO convertToDTO() {
        return new CardDTO(publicId, name, description, image, rarity, cost);
    }

}
