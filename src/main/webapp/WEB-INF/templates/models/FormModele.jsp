<!DOCTYPE html>
<html>
<head>
    <title>Ajouter un Modele</title>
</head>
<body>
    <jsp:include page="inc/header.jsp" />
    <h1>Ajouter un Modele</h1>
    <form action="/modeles" method="post">
        <label for="name">Nom:</label>
        <input type="text" id="name" name="name" required />
        <button type="submit">Enregistrer</button>
    </form>
</body>
</html>