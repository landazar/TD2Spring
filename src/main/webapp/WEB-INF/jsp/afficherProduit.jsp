<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Afficher un Produit</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
</head>
<body>

	<%@ include file="/WEB-INF/menu.jsp" %>
	
	<div class="card" style="width: 18rem;">
	  		<img src="https://m.media-amazon.com/images/I/61bK6PMOC3L._AC_UF1000,1000_QL80_.jpg" class="card-img-top" alt="Chicago Skyscrapers"/>
	  		<div class="card-body">
	    		<h5 class="card-title">${ produit.nom } - ${ produit.reference }</h5>
	  		</div>
	  	<ul class="list-group list-group-light list-group-small">
	    	<li class="list-group-item px-4"> id : ${ produit.id }</li>
	    	<li class="list-group-item px-4">prix : ${ produit.prix }</li>
	   	 	<li class="list-group-item px-4">poids : ${ produit.poids }g</li>
	  	</ul>
	</div>
	
</body>
</html>