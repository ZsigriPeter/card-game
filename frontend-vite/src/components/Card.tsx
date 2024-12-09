import React from 'react';
import {CardType} from "../Interfaces.ts";
import './Card.css';

const Card: React.FC<{ card: CardType; addCardToDeck: (card: CardType) => void }> = ({ card, addCardToDeck }) => {
    return (
        <div className="card-container" onClick={() => addCardToDeck(card)}>
            <div className="card-header">
                <h2 className="card-name">{card.name}</h2>
                <div className="card-cost"><p>{card.cost}</p></div>
            </div>
            <img
                src={card.image}
                alt={card.name}
                className="card-image"
                onError={(e) => (e.currentTarget.src = "/default-image.png")}
            />
            <div className="card-body">
                <p className={`card-rarity ${card.rarity.toLowerCase()}`}>{card.rarity}</p>
                <p className="card-description">{card.description}</p>
            </div>
            <div className="card-footer">
                <div className="card-health"><p>{card.health}</p></div>
                <div className="card-strength"><p>{card.strength}</p></div>
            </div>
        </div>
    );
}

export default Card;
