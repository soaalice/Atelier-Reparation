<%@page import="java.util.List"%>
<%@page import="com.web.atelier.Models.Modele"%>

<html>
<head>
    <title>Formulaire Ordinateur</title>
</head>
<body>
    <jsp:include page="inc/header.jsp" />

    <form action="/ordinateurs" method="post">
        <h1>Ordinateur</h1>
        <label for="name">Nom:</label>
        <input type="text" id="name" name="name" required />
        <label for="modele">Modele:</label>
        <select id="modele" name="modeleId">
            <%
                List<Modele> listModele = (List<Modele>) request.getAttribute("listModele");
                for (Modele modele : listModele) {
                    %>
                        <option value="<%= modele.getId() %>"><%= modele.getName() %></option>   
                    <%
                }
            %>
        </select>
        <button type="submit">Enregistrer</button>
    </form>
</body>
</html>