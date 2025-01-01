<!DOCTYPE html>
<html>
<head>
    <title>Formulaire Modele</title>
</head>
<body>
    <jsp:include page="inc/header.jsp" />

    <form action="/modeles" method="post">
        <h1>Modele</h1>
        <label for="name">Nom:</label>
        <input type="text" id="name" name="name" required />
        <button type="submit">Enregistrer</button>
    </form>
</body>
</html>