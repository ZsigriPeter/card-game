import React from 'react';
import {useEffect, useState} from "react";
import Card from "../components/Card";
import {CardType, DeckType} from "../Interfaces.ts";
import "./CardCollection.css";
import CardsInDeck from "../components/CardsInDeck.tsx";

async function fetchAllCards(): Promise<CardType[]> {
    const res: Response = await fetch('/api/cards');
    return await res.json();
}

async function fetchDeckById(deckId: number): Promise<DeckType> {
    const res: Response = await fetch(`/api/deck?id=${deckId}`);
    return await res.json();
}

const CardsCollection: React.FC = () => {
    const [cards, setCards] = useState<CardType[]>([]);
    const [deck, setDeck] = useState<DeckType>({
        deckId: 1,
        name: "Missing Deck",
        cards: [],
        MAX_SIZE: 10,
    });

    useEffect(() => {
        fetchAllCards().then(cardList => setCards(cardList))
        fetchDeckById(1).then(c => setDeck(c))
    }, [])

    const addCardToDeck = (card: CardType) => {
        console.log(card.name, card.cost);
        if (deck.cards.length < deck.MAX_SIZE) {
            setDeck((prevDeck) => ({
                ...prevDeck,
                cards: [...prevDeck.cards, card],
            }));
        } else {
            alert("Deck is full!");
        }
    };

    return (
        <div className="cards-and-deck-container">
            <CardsInDeck deck={deck!}/>
            <div className="card-collection-container">
                {cards.map((card: CardType) => (
                    <Card card={card} addCardToDeck={addCardToDeck} />
                ))}
            </div>
        </div>
    );
}

export default CardsCollection;
