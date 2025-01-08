# TO DO LIST - FONCTIONNALITÉ 1

## MODIFICATIONS DE LA BASE DE DONNÉES

1. **Modification de la table `reparation`** :
   - Supprimer les colonnes `montant_total` et `duree_totale`.

2. **Modification de la table `reparation_details`** :
   - Remplacer `tarif_id` par `composant_id`.

---

## TACHES À RÉALISER

### 1. Mise à jour des entités

- **Réparation** :
  - Supprimer les attributs `montant_total` et `duree_totale` dans l'entité `Reparation`.
  
- **RéparationDetails** :
  - Remplacer l'attribut `tarif_id` par `composant_id` dans l'entité `ReparationDetails`.
  - Mettre à jour les relations entre `ReparationDetails` et `Composant`.

---

### 2. Mise à jour des Pages JSP

#### **REPARATION**
- **ListReparation**  
  - Route : `/reparations` (Méthode: GET)  
  - Ajouter un filtre par `type_composant` pour filtrer les réparations en fonction du type de composant.
  - Les paramètres de la requête : `?type_composant=<id_type_composant>`
  - Liste : id, ordinateur_id, date_reparation, type_composant (ajouter ce champ de filtrage).

#### **Réparation et Composants**
- Ajouter un lien vers le filtre de type de composant directement sur la page de liste des réparations, afin de pouvoir afficher les réparations par type de composant spécifique.

---

### 3. Fonctionnalité de Filtrage des Réparations

- Ajouter une nouvelle méthode dans le service pour récupérer les réparations filtrées par type de composant :
  
  **Méthode :**  
  - `getReparationsByTypeComposant(int typeComposantId)`
  
  **Requête SQL** :  
  ```sql
  SELECT r.*
  FROM reparation r
  JOIN reparation_details rd ON rd.reparation_id = r.id
  JOIN composant c ON c.id = rd.composant_id
  WHERE c.type_composant_id = :typeComposantId;
  ```