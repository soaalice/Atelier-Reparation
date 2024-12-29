<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.web.atelier.Models.Reparation" %>
<%@ page import="com.web.atelier.Models.Ordinateur" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajouter une Reparation</title>
</head>
<body>
    <h1>Ajouter une Reparation</h1>
    <form action="/reparations" method="post">
        <label for="ordinateur">Ordinateur:</label>
        <select id="ordinateur" name="ordinateurId">
            <%
                List<Ordinateur> listOrdinateurs = (List<Ordinateur>) request.getAttribute("listOrdinateurs");
                for (Ordinateur ordinateur : listOrdinateurs) {
            %>
                <option value="<%= ordinateur.getId() %>"><%= ordinateur.getName() %></option>
            <% } %>
        </select>

        <label for="dateReparation">Date de Réparation:</label>
        <input type="date" id="dateReparation" name="dateReparation" required />

        <label for="montantTotal">Montant Total:</label>
        <input type="number" id="montantTotal" name="montantTotal" step="0.01" required />

        <label for="dureeTotale">Durée Totale (en heures):</label>
        <input type="number" id="dureeTotale" name="dureeTotale" step="0.01" required />

        <button type="submit">Enregistrer</button>
    </form>
</body>
</html>
