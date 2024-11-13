package com.codecool.backend.model.dto;

import java.util.UUID;

public record CardDTO(UUID publicId, String name, String description, byte[] image, String rarity, int cost,int health,int strength) {
}
