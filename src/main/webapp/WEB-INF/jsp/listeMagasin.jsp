<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste Magasins</title>
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
	  <th scope="col">adresse</th>
	  <th scope="col">CP</th>
	  <th scope="col">Ville</th>
	  <th scope="col">Actions</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="magasin" items="${ listeM }">
    <tr>
    
      <th scope="row"><a href="afficherMagasin?id=${ magasin.id }">${ magasin.id }</a></th>
      <td>${ magasin.nom }</td>
      <td>${ magasin.adresse }</td>
      <td>${ magasin.cp }</td>
      <td>${ magasin.ville }</td>
      
      <td>
        <a href="supprimerMagasin?id=${ magasin.id }"><button type="button" class="btn btn-danger">Supprimer</button></a>
        <a href="modifierMagasin?id=${ magasin.id }"><button type="button" class="btn btn-danger">Modifier</button></a>
     </td>
    </tr>
    </c:forEach>
  </tbody>
</table>

	
	

</body>
</html>