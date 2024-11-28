import React from 'react';
import {useEffect, useState} from "react";
import Card from "../components/Card";
import { CardType} from "../Interfaces.ts";
import "./CardCollection.css";

async function fetchAllCards(): Promise<CardType[]> {
    const res: Response = await fetch('/api/cards');
    return await res.json();
}

const CardsCollection: React.FC = () => {
    const [cards, setCards] = useState<CardType[]>([]);

    useEffect(()=> {
        fetchAllCards().then(cardList => setCards(cardList))
    },[])

    return (
        <div className="card-collection-container">
            {cards.map((card:CardType) => (
                <Card name={card.name} publicId={card.publicId} key={card.publicId}
                      cost={card.cost} description={card.description} health={card.health} image={card.image}
                      rarity={card.rarity} strength={card.strength}/>
            ))}
        </div>
    );
}

export default CardsCollection;
