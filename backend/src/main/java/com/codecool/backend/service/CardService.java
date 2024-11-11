package com.codecool.backend.service;

import com.codecool.backend.model.dto.NewCardDTO;
import com.codecool.backend.model.entity.card.Card;
import com.codecool.backend.repository.CardRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CardService {

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

//    public Card getCard(int id) {
//        return cardRepository.findById(id).orElse(null);
//    }

    public Card getCard(String id) {
        UUID publicId = UUID.fromString(id);
        return cardRepository.findByPublicId(publicId).orElse(null);
    }

    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public void saveCard(NewCardDTO newCard) {
        Card card = new Card(
                newCard.getName(), newCard.getDescription(), newCard.getImage(), newCard.getRarity(), newCard.getCost());
        cardRepository.save(card);
    }




}
