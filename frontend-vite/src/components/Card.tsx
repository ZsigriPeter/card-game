import React from 'react';
import { CardType} from "../Interfaces.ts";
import './Card.css';

const Card: React.FC<CardType> = ({ name, description, image, rarity, cost, health, strength }) => {
    return (
        <div className="card-container">
            <div className="card-header">
                <h2 className="card-name">{name}</h2>
                <div className="card-cost"><p >{cost}</p></div>
            </div>
            <img
                src={image}
                alt={name}
                className="card-image"
                onError={(e) => (e.currentTarget.src = "/default-image.png")} // Fallback image
            />
            <div className="card-body">
                <p className="card-rarity">Rarity: {rarity}</p>
                <p className="card-description">{description}</p>
            </div>
            <div className="card-footer">
                <div className="card-health"><p>{health}</p></div>
                <div className="card-strength"><p>{strength}</p></div>
            </div>
        </div>
    );
}

export default Card;
