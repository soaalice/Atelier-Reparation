<style>
    body{
        font-family: Avenir, Helvetica, Arial, sans-serif;
        text-align: center;
        width: 100%;
        margin: auto;
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
    align-items: center; /* Aligner verticalement tous les éléments dans la liste */
    }

    /* Items de la navbar */
    .navbar-item {
    margin-left: 30px;  /* Espacement entre les items */
    position: relative;
    display: flex; /* S'assurer que l'élément a le même comportement que les autres */
    align-items: center;  /* Aligner les éléments horizontalement */
    }

    /* Liens de la navbar */
    .navbar-link {
    color: #fff;
    font-size: 1rem;
    font-weight: 500;
    text-decoration: none;
    transition: all 0.3s ease-in-out;
    display: inline-block; /* S'assurer que tous les éléments sont sur la même ligne */
    text-align: center;
    }

    /* Hover sur les liens */
    .navbar-link:hover {
    color: #f39c12;
    }

    /* Responsive: Menu sur mobile */
    @media (max-width: 768px) {
        .navbar-logo{
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
    }
</style>

<header>
    <nav class="navbar">
    <div class="navbar-container">
        <div class="navbar-logo">
            <a href="/" class="navbar-brand">MyApp</a>
        </div>

        <!-- Menu de navigation -->
        <ul class="navbar-list">
            <li class="navbar-item">
                <a href="/" class="navbar-link">Home</a>
            </li>
        </ul> 
    </div>
    </nav>
</header>

<script>
</script>