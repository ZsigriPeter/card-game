export interface CardType {
    name:string;
    publicId:string;
    description:string;
    image: string;
    rarity:string;
    cost:number;
    health:number;
    strength:number;
};

export interface DeckType {
    deckId:number;
    name:string;
    cards:CardType[];
    MAX_SIZE:number;
};

