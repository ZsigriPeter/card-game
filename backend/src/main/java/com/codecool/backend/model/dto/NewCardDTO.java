package com.codecool.backend.model.dto;

import lombok.Data;

@Data
public class NewCardDTO {
    private String name;
    private String description;
    private String imgStr;
    private String rarity;
    private int cost;
    private int health;
    private int strength;
}
