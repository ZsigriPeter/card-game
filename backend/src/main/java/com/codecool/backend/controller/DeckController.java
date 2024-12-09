package com.codecool.backend.controller;

import com.codecool.backend.model.dto.DeckDTO;
import com.codecool.backend.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class DeckController {

    private final DeckService deckService;

    @Autowired
    public DeckController(DeckService deckService) {
        this.deckService = deckService;
    }

    @GetMapping("/api/deck")
    public DeckDTO getAllCards(@RequestParam long id) {
        return deckService.getDeckById(id);
    }

    @PatchMapping("/api/deck")
    public boolean updateDeck(@RequestBody DeckDTO deckDTO) {
        return deckService.overrideDeck(deckDTO.id(), deckDTO);
    }


}
