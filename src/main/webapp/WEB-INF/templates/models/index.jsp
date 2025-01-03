<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Accueil</title>
        <style>
            /* Bannière principale */
            .banner {
                padding: 80px 0;
                /* color: white; */
                text-align: center;
            }
        
            .banner h1 {
                font-size: 2.5rem;
                font-weight: 700;
            }
        
            .banner p {
                font-size: 1.2rem;
                margin-top: 10px;
            }
        </style>
    </head>

    <body>
        <jsp:include page="inc/header.jsp" />
        
        <div class="banner">
            <h1>Bienvenue à l'Atelier de Réparation d'Ordinateurs</h1>
            <p>Réparation rapide et fiable pour tous vos appareils informatiques</p>
        </div>
    </body>

</html>