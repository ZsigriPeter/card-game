package com.codecool.backend.service;

import com.codecool.backend.model.dto.DeckDTO;
import com.codecool.backend.model.entity.Deck;
import com.codecool.backend.model.entity.card.Card;
import com.codecool.backend.repository.CardRepository;
import com.codecool.backend.repository.DeckRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class DeckService {

    private final DeckRepository deckRepository;
    private final CardRepository cardRepository;

    @Autowired
    public DeckService(DeckRepository deckRepository, CardRepository cardRepository) {
        this.deckRepository = deckRepository;
        this.cardRepository = cardRepository;
    }

    @Transactional
    public boolean overrideDeck(long deckId, DeckDTO deckDTO) {
        Deck deck = deckRepository.findById(deckId).orElse(null);
        if (deck == null) {
            return false;
        }
        deck.removeAllCards();
        List<Card> cardsToAdd = deckDTO.cards().stream()
                .map(cardDTO -> cardRepository.findByPublicId(cardDTO.publicId())
                        .orElseThrow(() -> new IllegalArgumentException("Card not found with ID: " + cardDTO.publicId())))
                .toList();
        cardsToAdd.forEach(deck::addCard);
        deckRepository.save(deck);
        return true;
    }


    @Transactional
    public DeckDTO getDeckById(Long id) {
        Optional<Deck> deck = deckRepository.findById(id);

        deck.ifPresent(d -> {
            List<Card> cards = d.getCards();
            cards.sort(Comparator.comparing(Card::getId));
        });

        return deck.orElseThrow().convertToDTO();
    }

}
