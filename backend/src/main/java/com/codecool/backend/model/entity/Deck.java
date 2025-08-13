package com.codecool.backend.model.entity;

import com.codecool.backend.model.dto.DeckDTO;
import com.codecool.backend.model.entity.card.Card;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Deck {
    @Id
    private Long id;
    private String name;
    private static final int MAX_SIZE = 20;
    @ManyToMany
    private List<Card> cards;

    public Deck() {
    }

    public DeckDTO convertToDTO() {
        return new DeckDTO(id, name, cards.stream().map(Card::convertToDTO).toList(), MAX_SIZE);
    }

    public void removeAllCards() {
        cards.clear();
    }

    public void addCard(Card card) {
        if (cards != null && cards.size() < MAX_SIZE) {
            cards.add(card);
        }
    }
}
