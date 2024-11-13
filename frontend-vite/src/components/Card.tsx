import React from 'react';
import { CardType} from "../Interfaces.ts";

const Card: React.FC<CardType> = ({ name, description, image, rarity, cost, health, strength }) => {
    return (
        <div className="card-container">
                <h2>{name}</h2>
                <p>{description}</p>
                <p>Rarity: {rarity}</p>
                <p>Cost: {cost}</p>
                <p>Health: {health}</p>
                <p>Strength: {strength}</p>
                <img src={URL.createObjectURL(new Blob([image]))} alt={name} />
        </div>
    );
}

export default Card;
