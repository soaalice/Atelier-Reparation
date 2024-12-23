CREATE DATABASE atelier_reparation;
\c atelier_reparation;

-- Table: modele
CREATE TABLE modele (
    id SERIAL PRIMARY KEY
);

-- Table: ordinateur
CREATE TABLE ordinateur (
    id SERIAL PRIMARY KEY,
    modele_id INT NOT NULL REFERENCES modele(id)
);

-- Table: type_composant
CREATE TABLE type_composant (
    id SERIAL PRIMARY KEY
);

-- Table: composant
CREATE TABLE composant (
    id SERIAL PRIMARY KEY,
    type_composant_id INT NOT NULL REFERENCES type_composant(id)
);

-- Table: composant_modele
CREATE TABLE composant_modele (
    id SERIAL PRIMARY KEY,
    composant_id INT NOT NULL REFERENCES composant(id),
    modele_id INT NOT NULL REFERENCES modele(id)
);

-- Table: type_composant_modele
CREATE TABLE type_composant_modele (
    id SERIAL PRIMARY KEY,
    modele_id INT NOT NULL REFERENCES modele(id),
    type_composant_id INT NOT NULL REFERENCES type_composant(id),
    min INT NOT NULL,
    max INT NOT NULL
);

-- Table: reparation
CREATE TABLE reparation (
    id SERIAL PRIMARY KEY,
    ordinateur_id INT NOT NULL REFERENCES ordinateur(id),
    date_reparation DATE NOT NULL,
    montant_total DECIMAL(10,2) NOT NULL,
    duree_totale INTERVAL NOT NULL
);

-- Table: type_reparation
CREATE TABLE type_reparation (
    id SERIAL PRIMARY KEY
);

-- Table: tarif
CREATE TABLE tarif (
    id SERIAL PRIMARY KEY,
    prix DECIMAL(10,2) NOT NULL,
    duree INTERVAL NOT NULL,
    composant_id INT NOT NULL REFERENCES composant(id),
    type_reparation_id INT NOT NULL REFERENCES type_reparation(id)
);

-- Table: reparation_details
CREATE TABLE reparation_details (
    id SERIAL PRIMARY KEY,
    id_reparation INT NOT NULL REFERENCES reparation(id),
    qte INT NOT NULL,
    pu DECIMAL(10,2) NOT NULL,
    tarif_id INT NOT NULL REFERENCES tarif(id)
);

-- Table: mvt_stock
CREATE TABLE mvt_stock (
    id SERIAL PRIMARY KEY,
    entree INT DEFAULT 0,
    sortie INT DEFAULT 0,
    composant_id INT NOT NULL REFERENCES composant(id),
    date_mvt DATE NOT NULL
);
