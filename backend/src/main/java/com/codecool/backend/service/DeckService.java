package com.codecool.backend.service;

import com.codecool.backend.model.entity.Deck;
import com.codecool.backend.model.entity.card.Card;
import com.codecool.backend.repository.DeckRepository;
import org.springframework.stereotype.Service;

@Service
public class DeckService {

    private final DeckRepository deckRepository;

    public DeckService(DeckRepository deckRepository) {
        this.deckRepository = deckRepository;
    }

    public void addCardToDeck(Deck deck, Card card) {
        deck.addCard(card);
        deckRepository.save(deck);
    }
}
