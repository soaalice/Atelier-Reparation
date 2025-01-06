<!DOCTYPE html>
<html>
<head>
    <title>Ajouter un Type de Composant</title>
</head>
<body>
    <jsp:include page="inc/header.jsp" />
    <h1>Ajouter un Type de Composant</h1>
    <form action="/typeComposants" method="post">
        <label for="name">Nom:</label>
        <input type="text" id="name" name="name" required />
        <button type="submit">Enregistrer</button>
    </form>
</body>
</html>