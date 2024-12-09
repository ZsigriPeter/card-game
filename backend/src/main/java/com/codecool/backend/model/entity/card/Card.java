package com.codecool.backend.model.entity.card;

import com.codecool.backend.model.dto.CardDTO;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Base64;
import java.util.UUID;

@Entity
public class Card {
    @Id
    @GeneratedValue
    @Getter
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

    public Card(String name, String description, String imageStr, String rarity, int cost, int health, int strength) {
        this.name = name;
        this.description = description;
        this.image = convertBase64Image(imageStr);
        this.rarity = rarity;
        this.cost = cost;
        this.health = health;
        this.strength = strength;
        this.publicId = UUID.randomUUID();
    }

    public void setImage(String imageStr) {
        this.image = convertBase64Image(imageStr);
    }

    public CardDTO convertToDTO() {
        return new CardDTO(publicId, name, description, convertImageToBase64(), rarity, cost, health, strength);
    }

    private byte[] convertBase64Image(String imgString) {
        if (imgString != null && !imgString.isEmpty()) {
            return Base64.getDecoder().decode(imgString);
        }
        return null;
    }

    private String convertImageToBase64() {
        String base64Image = null;
        if (image != null) {
            base64Image = "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(image);
        }
        return base64Image;
    }

}
