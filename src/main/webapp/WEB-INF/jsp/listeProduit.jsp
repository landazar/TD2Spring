<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste Produits</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
</head>
<body>

	<%@ include file="/WEB-INF/menu.jsp" %>
	<table class="table align-middle">
  <thead>
    <tr>
      <th scope="col">Id</th>
	  <th scope="col">Nom</th>
	  <th scope="col">reference</th>
	  <th scope="col">prix</th>
	  <th scope="col">poids</th>
	  <th scope="col">Actions</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="produit" items="${ listeP }">
    <tr>
    
      <th scope="row"><a href="afficherProduit?id=${ produit.id }">${ produit.id }</a></th>
      <td>${ produit.nom }</td>
      <td>${ produit.reference }</td>
      <td>${ produit.prix }</td>
      <td>${ produit.poids }</td>
      
      <td>
        <a href="supprimerProduit?id=${ produit.id }"><button type="button" class="btn btn-danger">Supprimer</button></a>
     </td>
    </tr>
    </c:forEach>
  </tbody>
</table>

	
	

</body>
</html>