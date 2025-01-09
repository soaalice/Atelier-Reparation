# Liste et Formulaire tsotra
  - modele (done)
  - ordinateur(done)
  - type_composant(done)
  - composant(done)
  - composant_modele(done)
  - type_composant_modele(done)
  - tarif(done)
  - mvt_stock(done)

# Formulaire
    - reparation (ordinateur, date_reparation)(done)
  
# Liste avec recherche
    - reparation(done)
      - date_reparation (min et max)
      - modele
    - mvt_stock(done)
      - date_mvt (min et max)
    - etat_stock
      - date_etat (min et max)


# Features 2:
    -tables :
      -unite(id,name)
      -type_ordinateur(id,description)
      -type_composant=>(unite_id)
      -composant => (valeur)
      -retour(reparation,date)