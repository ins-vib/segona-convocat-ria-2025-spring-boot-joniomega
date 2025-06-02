DELETE FROM categories;
INSERT INTO categories (id, nom) VALUES (1, 'Motel');
INSERT INTO categories (id, nom) VALUES (2, '1 estrella');
INSERT INTO categories (id, nom) VALUES (3, '2 estrelles');
INSERT INTO categories (id, nom) VALUES (4, '3 estrelles');
INSERT INTO categories (id, nom) VALUES (5, '4 estrelles');
INSERT INTO categories (id, nom) VALUES (6, '5 estrelles');


INSERT INTO equip (id, nom) VALUES (1, 'Equip A');
INSERT INTO equip (id, nom) VALUES (2, 'Equip B');
INSERT INTO equip (id, nom) VALUES (3, 'Equip C');
INSERT INTO equip (id, nom) VALUES (4, 'Equip D');

INSERT INTO jugador (id, nom, posicio, equip_id) VALUES (1, 'Marc', 'PORTER', 1);
INSERT INTO jugador (id, nom, posicio, equip_id) VALUES (2, 'Jordi', 'DEFENSA', 1);
INSERT INTO jugador (id, nom, posicio, equip_id) VALUES (3, 'Sergi', 'MIGCAMPISTA', 1);
INSERT INTO jugador (id, nom, posicio, equip_id) VALUES (4, 'Ferran', 'DELANTER', 1);
INSERT INTO jugador (id, nom, posicio, equip_id) VALUES (5, 'David', 'PORTER', 2);
INSERT INTO jugador (id, nom, posicio, equip_id) VALUES (6, 'Pau', 'DEFENSA', 2);
INSERT INTO jugador (id, nom, posicio, equip_id) VALUES (7, 'Pedri', 'MIGCAMPISTA', 2);
INSERT INTO jugador (id, nom, posicio, equip_id) VALUES (8, 'Ansu', 'DELANTER', 2);
INSERT INTO jugador (id, nom, posicio, equip_id) VALUES (9, 'Álex', 'PORTER', 3);
INSERT INTO jugador (id, nom, posicio, equip_id) VALUES (10, 'Eric', 'DEFENSA', 3);
INSERT INTO jugador (id, nom, posicio, equip_id) VALUES (11, 'Gavi', 'MIGCAMPISTA', 3);
INSERT INTO jugador (id, nom, posicio, equip_id) VALUES (12, 'Lamine', 'DELANTER', 3);
INSERT INTO jugador (id, nom, posicio, equip_id) VALUES (13, 'Arnau', 'PORTER', 4);
INSERT INTO jugador (id, nom, posicio, equip_id) VALUES (14, 'Alejandro', 'DEFENSA', 4);
INSERT INTO jugador (id, nom, posicio, equip_id) VALUES (15, 'Fre', 'MIGCAMPISTA', 4);
INSERT INTO jugador (id, nom, posicio, equip_id) VALUES (16, 'Rob', 'DELANTER', 4);


INSERT INTO partit (id, data, equip_local_id, equip_visitant_id, gols_local, gols_visitant, resultat_local, resultat_visitant) 
VALUES (1, '2024-03-15 20:00:00', 1, 2, 2, 1, 3, 0);

INSERT INTO partit (id, data, equip_local_id, equip_visitant_id, gols_local, gols_visitant, resultat_local, resultat_visitant) 
VALUES (2, '2024-03-16 18:00:00', 3, 4, 1, 1, 1, 1);


