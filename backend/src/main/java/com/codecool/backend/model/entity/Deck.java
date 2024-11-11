package com.codecool.backend.model.entity;

import com.codecool.backend.model.entity.card.Card;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Deck {

    @Id
    private Long id;
    private String name;
    private int size;
    @OneToMany
    private List<Card> cards;

    public Deck() {}

    public void addCard(Card card) {
        cards.add(card);
    }
}
