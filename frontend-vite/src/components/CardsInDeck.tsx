import React, {useEffect, useState} from 'react';
import {CardType, DeckType} from "../Interfaces.ts";
import './CardsInDeck.css';

async function fetchSaveDeck(deck: DeckType): Promise<boolean> {
    console.log("Save Clicked")
    const res: Response = await fetch(`/api/deck`, {
        method: 'PATCH', // HTTP method
        headers: {
            'Content-Type': 'application/json', // Inform the server about the JSON payload
        },
        body: JSON.stringify(deck), // Serialize the updated data into a JSON string
    });

    return await res.json();
}

interface CardsInDeckProps {
    deck: DeckType;
}

const CardsInDeck: React.FC<CardsInDeckProps> = ({ deck }) => {

    const [deckLocal, setDeckLocal] = useState<DeckType>();
    const [cardsArray, setCardsArray] = useState<CardType[]>([]);

    useEffect(() => {
        if (deck) {
            setDeckLocal(deck);
            setCardsArray(deck.cards);
        }
    })

    function removeCardFormDeck(cardToRemove: CardType) {
        const index: number = cardsArray.indexOf(cardToRemove);
        if (index > -1) {
            setCardsArray([...cardsArray.splice(index, 1)]);
            if (deckLocal) {
                setDeckLocal({MAX_SIZE: deckLocal.MAX_SIZE, cards: cardsArray, name: deckLocal.name, deckId : deckLocal?.deckId})
            }
        }
    }

    if (!deckLocal) {
        return <div>Loading...</div>; // Handle case when deck is undefined
    }
    return (
        <div className="deck-container">
            <div className="deck-name">
                <p>{deckLocal.name}</p>
            </div>
            <div className="deck-save" onClick={() => fetchSaveDeck(deckLocal)}>
                <p>Save Deck</p>
            </div>
            <div className="deck-size">
                <p>Cards: ( {deckLocal.MAX_SIZE} / {cardsArray.length} )</p>
            </div>
            {cardsArray.map((card: CardType, index) => (
                <div className="card-in-deck" key={index} onClick={() => (removeCardFormDeck(card))}>
                    <p>{card.name}</p>
                </div>
            ))}
        </div>
    );
}

export default CardsInDeck;
