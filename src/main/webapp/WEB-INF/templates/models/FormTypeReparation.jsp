<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulaire Type de Réparation</title>
</head>
<body>
    <jsp:include page="inc/header.jsp" />
    <form action="/type-reparations" method="post">
        <h1>Type de Réparation</h1>
        <label for="name">Nom:</label>
        <input type="text" id="name" name="name" required />
        <button type="submit">Enregistrer</button>
    </form>
</body>
</html>