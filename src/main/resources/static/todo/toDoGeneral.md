# TO DO LIST

## STRUCTURE DES TABLES
  - **modele** (id, name)
  - **ordinateur** (id, name, modele_id)
  - **type_composant** (id, name)
  - **composant** (id, name, type_composant_id)
  - **composant_modele** (id, composant_id, modele_id)
  - **type_composant_modele** (id, modele_id, type_composant_id, min, max)
  - **reparation** (id, ordinateur_id, date_reparation, montant_total, duree_totale)
  - **type_reparation** (id, name)
  - **tarif** (id, prix, duree, composant_id, type_reparation_id)
  - **reparation_details** (id, reparation_id, tarif_id, qte, pu)
  - **mvt_stock** (id, entree, sortie, composant_id, date_mvt)

---

## TACHES À RÉALISER

### 1. Initialisation de l'Environnement
- **Initialiser un projet Spring Boot**.
- **Configurer les dépendances nécessaires** :
  - JPA
  - Lombok
  - Tomcat + Servlet
  - Spring Web
  - Postgres
- **Configurer la connexion à la base de données** :  
  Modifier le fichier `application.properties` ou `application.yml` pour inclure les informations nécessaires à la connexion PostgreSQL et l'utilisation de jsp :  
  ```properties
  spring.datasource.url=jdbc:postgresql://localhost:5432/atelier_reparation
  spring.datasource.username=postgres
  spring.datasource.password=sql
  spring.jpa.hibernate.ddl-auto=update  # (ou create, validate, none selon besoin)
  spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
  # Indique où se trouvent les fichiers JSP
  spring.mvc.view.prefix=/WEB-INF/templates/models/
  spring.mvc.view.suffix=.jsp
  ```

### 2. Initialisation de la Base de Données et des Modèles
- Créer les entités correspondant aux tables définies ci-dessus.
- Mettre en place les relations entre les entités (par exemple, `@ManyToOne`, `@OneToMany`, `@ManyToMany`).

---

### 3. Création des Pages JSP

#### **MODELE**
- **FormModele**  
  - Route: `/modeles/form`  
  - Formulaire : `name`
- **ListModele**  
  - Route: `/modeles` (Méthode: `GET`)  
  - Liste : `id`, `name`

#### **ORDINATEUR**
- **FormOrdinateur**  
  - Route: `/ordinateurs/form`  
  - Formulaire : `name`, `modele_id`
- **ListOrdinateur**  
  - Route: `/ordinateurs` (Méthode: `GET`)  
  - Liste : `id`, `name`

#### **TYPE COMPOSANT**
- **FormTypeComposant**  
  - Route: `/type-composants/form`  
  - Formulaire : `name`
- **ListTypeComposant**  
  - Route: `/type-composants` (Méthode: `GET`)  
  - Liste : `id`, `name`

#### **COMPOSANT**
- **FormComposant**  
  - Route: `/composants/form`  
  - Formulaire : `name`, `type_composant_id`
- **ListComposant**  
  - Route: `/composants` (Méthode: `GET`)  
  - Liste : `id`, `name`

#### **COMPOSANT MODELE**
- **FormComposantModele**  
  - Route: `/composant-modeles/form`  
  - Formulaire : `composant_id`, `modele_id`
- **ListComposantModele**  
  - Route: `/composant-modeles` (Méthode: `GET`)  
  - Liste : `id`, `composant_id`, `modele_id`

#### **TYPE REPARATION**
- **FormTypeReparation**  
  - Route: `/type-reparations/form`  
  - Formulaire : `name`
- **ListTypeReparation**  
  - Route: `/type-reparations` (Méthode: `GET`)  
  - Liste : `id`, `name`

#### **TARIF**
- **FormTarif**  
  - Route: `/tarifs/form`  
  - Formulaire : `prix`, `duree`, `composant_id`, `type_reparation_id`
- **ListTarif**  
  - Route: `/tarifs` (Méthode: `GET`)  
  - Liste : `id`, `prix`, `duree`, `composant_id`, `type_reparation_id`

#### **REPARATION**
- **FormReparation**  
  - Route: `/reparations/form`  
  - Formulaire : `ordinateur_id`, `date_reparation`, `montant_total`, `duree_totale`
- **ListReparation**  
  - Route: `/reparations` (Méthode: `GET`)  
  - Liste : `id`, `ordinateur_id`, `date_reparation`, `montant_total`, `duree_totale`

#### **REPARATION DETAILS**
- **FormReparationDetails**  
  - Route: `/reparation-details/form`  
  - Formulaire : `reparation_id`, `tarif_id`, `qte`, `pu`
- **ListReparationDetails**  
  - Route: `/reparation-details` (Méthode: `GET`)  
  - Liste : `id`, `reparation_id`, `tarif_id`, `qte`, `pu`

---

### 4. Fonctions (hors CRUD) :
  - `getAllRepairableOrdinateurs()`:  
    Récupère tous les ordinateurs réparables, c'est-à-dire ceux qui ne sont pas encore associés à une réparation.  
    **Requête SQL** :  
    ```sql
    SELECT o.* 
    FROM ordinateur o 
    WHERE o.id NOT IN (SELECT ordinateur_id FROM reparation);
    ```

  - `getAllComposantsByOrdinateur(int id)`:  
    Récupère tous les composants associés à un ordinateur spécifique, en fonction de son modèle.  
    **Requête SQL** :  
    ```sql
    SELECT c 
    FROM Composant c 
    JOIN ComposantModele cm ON cm.composant = c 
    WHERE cm.modele.id = (SELECT o.modele.id FROM Ordinateur o WHERE o.id = :id);
    ```

  - `getAllReparationsByTypeComposant(int id)`:  
    Récupère toutes les réparations effectuées pour un type de composant spécifique, basé sur l'identifiant du composant.  
    **Requête SQL** :
    ```sql
    ```

