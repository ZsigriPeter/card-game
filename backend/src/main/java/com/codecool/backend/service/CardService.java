package com.codecool.backend.service;

import com.codecool.backend.model.dto.AllData;
import com.codecool.backend.model.dto.NewCardDTO;
import com.codecool.backend.model.entity.card.Card;
import com.codecool.backend.repository.CardRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CardService {

    private final CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Card getCard(String id) {
        UUID publicId = UUID.fromString(id);
        return cardRepository.findByPublicId(publicId).orElse(null);
    }

    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public void saveCard(@NotNull NewCardDTO newCard) {
        Card card = new Card(
                newCard.getName(), newCard.getDescription(), newCard.getImgStr(), newCard.getRarity(), newCard.getCost(),newCard.getHealth(),newCard.getStrength());
        cardRepository.save(card);
    }

    @Transactional
    public void setImgToCard(long id, String imgStr) {
        Card card = cardRepository.findById(id).orElse(null);
        if (card != null) {
            card.setImage(imgStr);
        }
    }

    @Transactional
    public void initialiseCards() {
        try {
            // Load JSON file content
            String jsonContent = JsonLoader.loadJsonFromResources("allData.json");

            // Parse JSON
            ObjectMapper objectMapper = new ObjectMapper();
            AllData allData = objectMapper.readValue(jsonContent, AllData.class);

            // Access the parsed data
            allData.getData().forEach(imageData -> {
//                System.out.println("ID: " + imageData.getId());
//                System.out.println("Image String: " + imageData.getImageString());
                Card card = cardRepository.findById((long)imageData.getId()).orElse(null);
                if (card != null) {
                    card.setImage(imageData.getImageString());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
