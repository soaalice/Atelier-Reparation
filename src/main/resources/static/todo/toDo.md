# TO DO LIST

## TABLES

    - Modele (id, name)
    - Ordinateur (id, name, modele_id)
    - Type_composant(id, name)
    - Composant (id, name, type_composant_id)
    - Composant_modele (id, composant_id, modele_id)
    - Type_composant_modele(id, modele_id, type_composant_id, min, max)
    - Reparation (id, ordinateur_id, date_reparation, montant_total, duree_totale)
    - Type_reparation (id, name)
    - Tarif(id, prix, duree, composant_id, type_reparation_id)
    - Reparation_details(id, reparation_id, tarif_id, qte, pu)
    - mvt_stock(id, entree, sortie, composant_id, date_mvt)

## TACHES

    1. Initialisation environnement springboot
    2. Initialisation base & modeles
    3. Création des pages jsp:
        -  MODELE: 
           - (nomPage: 'FormModele', route: '/modeles/form')  formulaire : name
           - (nomPage: 'ListModele', route: '/modeles', method: GET) liste: id, name
            
        -  ORDINATEUR:
           - (nomPage: 'FormOrdinateur', route: '/ordinateurs/form') formulaire : name, modele_id
           - (nomPage: 'ListOrdinateur', route: '/ordinateurs', method: GET) liste: id
          
        - TYPE COMPOSANT: 
          - (nomPage: 'FormTypeComposant', route: '/type-composants/form')  formulaire : name
          - (nomPage: 'ListTypeComposant', route: '/type-composants', method: GET) liste: id, name
            
        - COMPOSANT
          - (nomPage: 'FormComposant', route: '/composants/form')  formulaire : name, type_composant_id
          - (nomPage: 'ListComposant', route: '/composants', method: GET) liste: id, name 
    4. 
