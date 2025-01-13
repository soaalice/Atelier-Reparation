<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.List"%>
<%@page import="com.web.atelier.Models.Modele"%>
<%@page import="com.web.atelier.Models.TypeOrdinateur"%>

<html>
<head>
    <title>Formulaire Ordinateur</title>
</head>
<body>
    <jsp:include page="inc/header.jsp" />
    <% 
        String successMessage = (String) request.getAttribute("successMessage");
        String errorMessage = (String) request.getAttribute("errorMessage");
        if (successMessage != null) {
    %>
        <div style="color: green; font-weight: bold;">
            <%= successMessage %>
        </div>
    <% 
        } 
        if (errorMessage != null) {
    %>
        <div style="color: red; font-weight: bold;">
            <%= errorMessage %>
        </div>
    <% 
        }
    %>
    <form action="/ordinateurs" method="post">
        <h1>Ordinateur</h1>
        <label for="name">Nom:</label>
        <input type="text" id="name" name="name" required />
        <label for="modele">Modèle:</label>
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
        <label for="typeOrdinateur">Type d'Ordinateur:</label>
        <select id="typeOrdinateur" name="typeOrdinateurId">
            <%
                List<TypeOrdinateur> listTypeOrdinateur = (List<TypeOrdinateur>) request.getAttribute("listTypeOrdinateur");
                for (TypeOrdinateur typeOrdinateur : listTypeOrdinateur) {
                    %>
                        <option value="<%= typeOrdinateur.getId() %>"><%= typeOrdinateur.getName() %></option>   
                    <%
                }
            %>
        </select>
        <button type="submit">Enregistrer</button>
    </form>
</body>
</html>