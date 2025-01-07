<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Formulaire Type de Composant</title>
</head>
<body>
    <jsp:include page="inc/header.jsp" />
    <form action="/type-composants" method="post">
        <h1>Type de Composant</h1>
        <label for="name">Nom:</label>
        <input type="text" id="name" name="name" required />
        <button type="submit">Enregistrer</button>
    </form>
</body>
</html>