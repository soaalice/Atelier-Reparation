<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.List"%>
<%@page import="com.web.atelier.Models.Client"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List clients</title>
    <script>
        function filterClients() {
            // Récupérer le texte de recherche
            const filterText = document.getElementById("searchName").value.toLowerCase();
            
            // Récupérer toutes les lignes du tableau, sauf l'en-tête
            const rows = document.querySelectorAll("table tbody tr");
            
            // Parcourir toutes les lignes du tableau
            rows.forEach(row => {
                const nameCell = row.cells[1]; // La cellule contenant le nom du client (index 1)
                const nameText = nameCell.textContent.toLowerCase();
                
                // Si le nom du client contient le texte de recherche, afficher la ligne, sinon la cacher
                if (nameText.includes(filterText)) {
                    row.style.display = "";
                } else {
                    row.style.display = "none";
                }
            });
        }
    </script>
</head>
<body>
    <jsp:include page="inc/header.jsp" />

    <h1>Liste de clients</h1>

    <!-- Formulaire de recherche -->
    <input 
        style="width: 200px;
            padding: 10px;
            font-size: 1rem;
            font-weight: 400;
            margin-bottom: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #fff;
            transition: border-color 0.3s ease;" 
        type="text" 
        id="searchName" 
        onkeyup="filterClients()" 
        placeholder="Rechercher par nom..."
    >

    <table border="1">
        <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Email</th>
                <th>Birth Date</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Client> listClients = (List<Client>) request.getAttribute("listClients");
                for (Client client : listClients){
            %>
                <tr>
                    <td><%= client.getId() %></td>
                    <td><%= client.getFullName() %></td>
                    <td><%= client.getEmail() %></td>
                    <td><%= client.getBirthDate() %></td>
                </tr>
            <%
                }
            %>
        </tbody>
    </table>

    <form action="/clients" method="get">
        <label for="dateReparation">Date de réparation:</label>
        <input type="date" name="dateReparation">
        <button type="submit">Filtrer</button>
    </form>
</body>
</html>
