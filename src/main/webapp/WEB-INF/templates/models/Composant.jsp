<!DOCTYPE html>
<html>
<head>
    <title>Ajouter un Composant</title>
</head>
<body>
    <h1>Ajouter un Composant</h1>
    <form action="#" method="post">
        <label for="name">Nom:</label>
        <input type="text" id="name" name="name" required />
        <label for="typeComposant">Type de Composant:</label>
        <select id="typeComposant" name="typeComposantId">
            <!-- Options générées dynamiquement côté serveur -->
        </select>
        <button type="submit">Enregistrer</button>
    </form>
</body>
</html>