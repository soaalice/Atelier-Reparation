<%@ page contentType="text/html; charset=UTF-8" %>

<style>

    body {
        font-family: Avenir, Helvetica, Arial, sans-serif;
        text-align: center;
        width: 100%;
        margin: auto;
    }

    /* Style général pour le formulaire */
    form {
        max-width: 600px;
        margin: 20px auto;
        padding: 20px;
        background-color: #ffff;
        border-radius: 8px;
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        width: 40%;
        padding-left: 70px;
        padding-right: 70px;
    }

    form h1 {
        font-size: 1.8rem;
        font-weight: 700;
        color: #1e2a47;
        text-align: center;
        margin-bottom: 20px;
    }

    /* Style des labels */
    form label {
        display: block;
        margin-bottom: 10px;
        font-size: 1rem;
        font-weight: 500;
        color: #34495e;
    }

    /* Style des éléments select et input */
    form select,
    form input {
        width: 100%;
        padding: 10px;
        font-size: 1rem;
        font-weight: 400;
        margin-bottom: 20px;
        border: 1px solid #ddd;
        border-radius: 5px;
        background-color: #fff;
        transition: border-color 0.3s ease;
    }

    form input{
        width: -webkit-fill-available;
    }

    /* Focus sur les champs de formulaire */
    form select:focus,
    form input:focus {
        border-color: #f39c12;
        outline: none;
    }

    /* Style du bouton de soumission */
    form button {
        padding: 10px 20px;
        font-size: 1.1rem;
        font-weight: 600;
        color: white;
        background-color: #1e2a47;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    /* Effet de survol sur le bouton */
    form button:hover {
        background-color: #f39c12;
    }

    /* Style général pour la table */
    table {
        width: 80%;
        margin: 20px auto;
        border-collapse: collapse;
        background-color: #fff;
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
        overflow: hidden;
    }

    th, td {
        padding: 12px;
        text-align: left;
        font-size: 1rem;
        font-weight: 500;
        color: #34495e;
    }

    /* Style pour les en-têtes de colonne */
    th {
        background-color: #1e2a47;
        color: white;
        font-size: 1.2rem;
        text-transform: uppercase;
        letter-spacing: 1px;
    }

    /* Style pour les lignes de données */
    tr:nth-child(even) {
        background-color: #f9f9f9;
    }

    tr:hover {
        background-color: #f39c12;
        color: white;
    }

    /* Espacement pour les éléments de tableau */
    td {
        border-bottom: 1px solid #ddd;
    }


    /* Style général de la navbar */
    .navbar {
        background-color: #1e2a47;
        padding: 15px 0;
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    }

    /* Conteneur principal de la navbar */
    .navbar-container {
        display: flex;
        justify-content: space-between;
        align-items: center;
        max-width: 1200px;
        margin: 0 auto;
        padding: 0 20px;
    }

    /* Logo / Nom de l'application */
    .navbar-logo .navbar-brand {
        font-size: 1.8rem;
        font-weight: 700;
        color: #fff;
        text-decoration: none;
        text-transform: uppercase;
        letter-spacing: 2px;
    }

    /* Liste de la navbar */
    .navbar-list {
        display: flex;
        list-style: none;
        padding: 0;
        margin: 0;
        align-items: center;
    }

    /* Items de la navbar */
    .navbar-item {
        margin-left: 30px;
        position: relative;
        display: flex;
        align-items: center;
    }

    /* Liens de la navbar */
    .navbar-link {
        color: #fff;
        font-size: 1rem;
        font-weight: 500;
        text-decoration: none;
        transition: all 0.3s ease-in-out;
        display: inline-block;
        text-align: center;
    }

    /* Hover sur les liens */
    .navbar-link:hover {
        color: #f39c12;
    }

    /* Style pour les dropdowns */
    .dropdown {
        position: relative;
        display: inline-block;
    }

    /* Ajout d'une flèche pour indiquer un dropdown */
    .dropdown::after {
        content: " ▼";
        color: #fff;
        font-size: 0.8rem;
        margin-left: 5px;
        transition: transform 0.3s ease;
    }

    /* Contenu du dropdown */
    .dropdown-content {
        display: none;
        position: absolute;
        background-color: rgba(44, 62, 80, 0.9); /* Fond légèrement transparent */
        min-width: 160px;
        z-index: 1;
        border-radius: 5px;
        box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
        opacity: 0;
        visibility: hidden;
        transition: opacity 0.3s ease, visibility 0.3s ease;
        left: 0;
        right: auto;
    }

    /* Affichage du dropdown au survol */
    .dropdown:hover .dropdown-content {
        display: block;
        opacity: 1;
        visibility: visible;
        left: auto;
        right: 0;
    }

    /* Items du dropdown */
    .dropdown-item {
        color: white;
        padding: 12px 16px;
        text-decoration: none;
        display: block;
        border-bottom: 1px solid #34495e; /* Ligne séparatrice entre les éléments */
    }

    .dropdown-item:hover {
        background-color: #f39c12;
        color: #fff;
    }

    /* Supprimer la ligne sous le dernier élément */
    .dropdown-item:last-child {
        border-bottom: none;
    }

    /* Responsive: Menu sur mobile */
    @media (max-width: 768px) {
        .navbar-logo {
            margin: auto;
        }
        .navbar-container {
            flex-direction: column;
            align-items: flex-start;
        }

        .navbar-list {
            flex-direction: column;
            width: 100%;
            margin-top: 15px;
        }

        .navbar-item {
            margin-left: 0;
            margin-top: 10px;
        }

        .dropdown-content {
            position: static;
            width: 100%;
        }

        .dropdown::after {
            content: none; /* Retirer la flèche sur mobile */
        }
    }
</style>

<header>
    <nav class="navbar">
        <div class="navbar-container">
            <div class="navbar-logo">
                <a href="/" class="navbar-brand">Atelier</a>
            </div>

            <!-- Menu de navigation -->
            <ul class="navbar-list">
                <li class="navbar-item">
                    <a href="/" class="navbar-link">Home</a>
                </li>

                <li class="navbar-item">
                    <a href="/etat-stock" class="navbar-link">Etat Stock</a>
                </li>

                <!-- Dropdown Insertion -->
                <li class="navbar-item dropdown">
                    <a href="#" class="navbar-link">Insertion</a>
                    <div class="dropdown-content">
                        <a href="/type-composants/form" class="dropdown-item">Type Composant</a>
                        <a href="/type-reparations/form" class="dropdown-item">Type Réparation</a>
                        <a href="/modeles/form" class="dropdown-item">Modèle</a>
                        <a href="/ordinateurs/form" class="dropdown-item">Ordinateur</a>
                        <a href="/composants/form" class="dropdown-item">Composant</a>
                        <a href="/tarifs/form" class="dropdown-item">Tarif</a>
                        <a href="/reparations/form" class="dropdown-item">Réparation</a>
                        <a href="/composant-modeles/form" class="dropdown-item">Composant Modèle</a>
                        <a href="/mvt-stocks/form" class="dropdown-item">Mvt Stock</a>
                        <a href="/retours/form" class="dropdown-item">Retour</a>
                        <a href="/recommendations/form" class="dropdown-item">Recommendation</a>
                        <a href="/clients/form" class="dropdown-item">Client</a>
                    </div>
                </li>

                <!-- Dropdown Liste -->
                <li class="navbar-item dropdown">
                    <a href="#" class="navbar-link">Liste</a>
                    <div class="dropdown-content">
                        <a href="/type-composants" class="dropdown-item">Type Composant</a>
                        <a href="/type-reparations" class="dropdown-item">Type Réparation</a>
                        <a href="/modeles" class="dropdown-item">Modèle</a>
                        <a href="/ordinateurs" class="dropdown-item">Ordinateur</a>
                        <a href="/composants" class="dropdown-item">Composant</a>
                        <a href="/tarifs" class="dropdown-item">Tarif</a>
                        <a href="/reparations" class="dropdown-item">Réparation</a>
                        <a href="/composant-modeles" class="dropdown-item">Composant Modèle</a>
                        <a href="/mvt-stocks" class="dropdown-item">Mvt Stock</a>
                        <a href="/retours" class="dropdown-item">Retour</a>
                        <a href="/recommendations" class="dropdown-item">Recommendation</a>
                        <a href="/clients" class="dropdown-item">Client</a>
                    </div>
                </li>
            </ul>
        </div>
    </nav>
</header>
