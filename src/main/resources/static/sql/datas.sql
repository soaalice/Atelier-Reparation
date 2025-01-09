INSERT INTO unite(name) VALUES('hz'),
('Go');

INSERT INTO type_composant (name,unite_id) VALUES 
('Processeur',1), 
('Mémoire RAM',2), 
('Disque Dur',2), 
('Carte Graphique',2);

INSERT INTO composant (type_composant_id, name,valeur) VALUES 
(1, 'Intel Core i5',8000), 
(1, 'AMD Ryzen 7',7000), 
(2, '16GB DDR4 RAM',16), 
(2, '8GB DDR4 RAM',8), 
(3, '1TB HDD',1000), 
(3, '512GB SSD',512), 
(4, 'NVIDIA GTX 1050',6), 
(4, 'AMD Radeon RX 580',8);
