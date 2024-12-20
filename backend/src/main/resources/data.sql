
INSERT INTO card (id, dtype, name, description, image, rarity, cost, public_id, health, strength) VALUES
    (1, 'Card', 'Fire Drake', 'A fierce dragon that breathes fire.', NULL, 'Epic', 7, gen_random_uuid(), 10, 12),
    (2, 'Card', 'Shadow Wraith', 'An eerie spirit that haunts its foes.', NULL, 'Rare', 6, gen_random_uuid(), 8, 9),
    (3, 'Card', 'Elven Archer', 'A skilled archer with deadly aim.', NULL, 'Common', 3, gen_random_uuid(), 4, 6),
    (4, 'Card', 'Stone Golem', 'A giant made of rock and earth.', NULL, 'Uncommon', 5, gen_random_uuid(), 12, 7),
    (5, 'Card', 'Bloodfang Wolf', 'A vicious wolf with a thirst for blood.', NULL, 'Common', 2, gen_random_uuid(), 5, 5),
    (6, 'Card', 'Celestial Griffin', 'A majestic beast with wings of light.', NULL, 'Legendary', 8, gen_random_uuid(), 9, 11),
    (7, 'Card', 'Doom Bringer', 'A dark creature that saps life.', NULL, 'Rare', 5, gen_random_uuid(), 6, 8),
    (8, 'Card', 'Forest Ent', 'A guardian of the forest, slow but powerful.', NULL, 'Uncommon', 4, gen_random_uuid(), 14, 6),
    (9, 'Card', 'Sea Serpent', 'A giant serpent from the depths.', NULL, 'Epic', 7, gen_random_uuid(), 10, 9),
    (10, 'Card', 'Ice Elemental', 'A creature formed of pure ice.', NULL, 'Rare', 5, gen_random_uuid(), 7, 8),
    (11, 'Card', 'Necromancer', 'A mage who can raise the dead.', NULL, 'Epic', 6, gen_random_uuid(), 5, 9),
    (12, 'Card', 'Light Paladin', 'A holy knight with protective powers.', NULL, 'Rare', 4, gen_random_uuid(), 8, 7),
    (13, 'Card', 'Goblin Rogue', 'A sneaky and mischievous goblin.', NULL, 'Common', 1, gen_random_uuid(), 3, 4),
    (14, 'Card', 'Phoenix', 'A legendary bird reborn from its ashes.', NULL, 'Legendary', 9, gen_random_uuid(), 7, 10),
    (15, 'Card', 'Swamp Hag', 'A vile creature lurking in the swamp.', NULL, 'Uncommon', 3, gen_random_uuid(), 4, 5),
    (16, 'Card', 'Crystal Golem', 'A golem wth a bodiy of crystal.', NULL, 'Epic', 8, gen_random_uuid(), 11, 8),
    (17, 'Card', 'Dark Elf Assassin', 'A deadly assassin from the shadows.', NULL, 'Rare', 6, gen_random_uuid(), 4, 9),
    (18, 'Card', 'Vampire Lord', 'A powerful undead with life drain.', NULL, 'Legendary', 8, gen_random_uuid(), 7, 10),
    (19, 'Card', 'Mountain Troll', 'A hulking brute from the mountains.', NULL, 'Uncommon', 4, gen_random_uuid(), 13, 6),
    (20, 'Card', 'Stormcaller', 'A shaman who commands lightning.', NULL, 'Epic', 7, gen_random_uuid(), 6, 9),
    (21, 'Card', 'Fire Imp', 'A small demon with fiery attacks.', NULL, 'Common', 2, gen_random_uuid(), 3, 5),
    (22, 'Card', 'Lich King', 'A master of necromancy and frost.', NULL, 'Legendary', 9, gen_random_uuid(), 8, 12),
    (23, 'Card', 'Giant Spider', 'A massive spider with venomous fangs.', NULL, 'Uncommon', 3, gen_random_uuid(), 6, 5),
    (24, 'Card', 'War Bear', 'A bear trained for battle.', NULL, 'Uncommon', 4, gen_random_uuid(), 10, 7),
    (25, 'Card', 'Fire Mage', 'A wizard who specializes in fire spells.', NULL, 'Rare', 5, gen_random_uuid(), 4, 7),
    (26, 'Card', 'Skeleton Warrior', 'An undead warrior risen from the grave.', NULL, 'Common', 2, gen_random_uuid(), 5, 5),
    (27, 'Card', 'Merfolk Scout', 'An aquatic scout with agility.', NULL, 'Common', 3, gen_random_uuid(), 3, 4),
    (28, 'Card', 'Iron Golem', 'A golem with a body of iron.', NULL, 'Epic', 7, gen_random_uuid(), 12, 7),
    (29, 'Card', 'Thunder Roc', 'A massive bird that summons storms.', NULL, 'Rare', 6, gen_random_uuid(), 6, 8),
    (30, 'Card', 'Cursed Knight', 'A knight cursed with dark powers.', NULL, 'Epic', 7, gen_random_uuid(), 7, 9);

INSERT INTO deck (id,name) VALUES
    (1,'Deck 1'),
    (2,'Deck 2');

INSERT INTO deck_cards (deck_id,cards_id) VALUES
    (1,1),
    (1,1),
    (1,2),
    (1,3),
    (1,4),
    (1,5),
    (1,6);

INSERT INTO deck_cards (deck_id,cards_id) VALUES
    (2,4),
    (2,7),
    (2,8),
    (2,5),
    (2,6),
    (2,9);
