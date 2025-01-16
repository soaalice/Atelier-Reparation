CREATE DATABASE atelier_reparation;
\c atelier_reparation;

--Table: unite
CREATE TABLE unite(
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
);

--Table: type_ordinateur
CREATE TABLE type_ordinateur(
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
);

-- Table: modele
CREATE TABLE modele (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE client(
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL UNIQUE
);

-- Table: ordinateur
CREATE TABLE ordinateur (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    modele_id INT NOT NULL REFERENCES modele(id),
    type_ordinateur_id INT NOT NULL REFERENCES type_ordinateur(id)
);



-- Table : unite
CREATE TABLE unite(
    id SERIAL PRIMARY KEY,
    name VARCHAR(10) NOT NULL
);

-- Table: type_composant
CREATE TABLE type_composant (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    unite_id INT NOT NULL REFERENCES unite(id)
);

-- Table: composant
CREATE TABLE composant (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    valeur NUMERIC NOT NULL DEFAULT 0,
    type_composant_id INT NOT NULL REFERENCES type_composant(id),
    UNIQUE (name, valeur)
);

-- Table: composant_modele
CREATE TABLE composant_modele (
    id SERIAL PRIMARY KEY,
    composant_id INT NOT NULL REFERENCES composant(id),
    modele_id INT NOT NULL REFERENCES modele(id),
    UNIQUE (composant_id, modele_id)
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
    date_reparation DATE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    -- montant_total DECIMAL(10,2) NOT NULL,
    -- duree_totale DECIMAL NOT NULL
    client_id INT NOT NULL REFERENCES client(id)
);

-- Table: type_reparation
CREATE TABLE type_reparation (
    id SERIAL PRIMARY KEY
);

-- Table: tarif
CREATE TABLE tarif (
    id SERIAL PRIMARY KEY,
    prix DECIMAL(10,2) NOT NULL,
    duree DECIMAL NOT NULL,
    composant_id INT NOT NULL REFERENCES composant(id),
    type_reparation_id INT NOT NULL REFERENCES type_reparation(id)
);

-- Table: reparation_details
CREATE TABLE reparation_details (
    id SERIAL PRIMARY KEY,
    reparation_id INT NOT NULL REFERENCES reparation(id),
    -- composant_id INT NOT NULL REFERENCES composant(id)
    tarif_id INT NOT NULL REFERENCES tarif(id),
    new_composant_id INT NOT NULL REFERENCES composant(id)
);

-- Table: mvt_stock
CREATE TABLE mvt_stock (
    id SERIAL PRIMARY KEY,
    entree INT DEFAULT 0,
    sortie INT DEFAULT 0,
    composant_id INT NOT NULL REFERENCES composant(id),
    date_mvt DATE NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Table:  retour
CREATE TABLE retour (
    id SERIAL PRIMARY KEY,
    reparation_id INT NOT NULL REFERENCES reparation(id),
    date_retour DATE NOT NULL DEFAULT CURRENT_TIMESTAMP
);
