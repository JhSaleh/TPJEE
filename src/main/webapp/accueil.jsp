<%--
  Created by IntelliJ IDEA.
  User: jeanhanna
  Date: 05/02/2021
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.List, org.tutorial.Book"%> <!--Réalise des imports-->
<%
    List<Book> listBooks = (List<Book>)request.getAttribute("listBooks"); //Récupère l'objet mis sur le servlet
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>accueil</h1>
    <form action="MainServlet" method="POST">
        <div>
            <label for="Titre">Titre :</label>
            <input type="text" id="Titre" name="searchText">
        </div>
        <div>
            <button type="submit">Submit</button>
        </div>
    </form>

    <table border="1">
        <tr> <!--une ligne de la table-->
            <th>Titre</th> <!--titre des colonnes de la table, met en gras les titres-->
            <th>Auteur</th>
        </tr>
        <%
            //On génére dynamiquement du code html pour construire une page
            //Le code java est en continu, ici la boucle for inclu les différentes lignes du tableau html
            //Récupère le contenu des livres
            for(Book book:listBooks){
                String title = book.getTitle();
                String author = book.getAuthor();

        %>
        <tr>
            <td><%=title %></td>
            <td><%=author %></td>
        </tr>

        <%
        }
        %>
    </table>



</body>
</html>
