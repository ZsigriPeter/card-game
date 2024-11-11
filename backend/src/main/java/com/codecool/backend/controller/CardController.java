package com.codecool.backend.controller;

import java.util.List;

import com.codecool.backend.model.dto.CardDTO;
import com.codecool.backend.model.dto.NewCardDTO;
import com.codecool.backend.model.entity.card.Card;
import com.codecool.backend.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CardController {

    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/api/cards")
    public List<CardDTO> getAllCards() {
        return cardService.getAllCards().stream().map(Card::convertToDTO).toList();
    }

    @GetMapping("/api/card")
    public CardDTO getCardById(@RequestParam String id) {
        return cardService.getCard(id).convertToDTO();
    }

    @PostMapping("/api/card")
    public void createCard(@RequestBody NewCardDTO newCardDTO) {
        cardService.saveCard(newCardDTO);
    }
}
