package com.codecool.backend.model.dto;

import java.util.List;

public record DeckDTO(long id, String name, List<CardDTO> cards,int MAX_SIZE) {
}
