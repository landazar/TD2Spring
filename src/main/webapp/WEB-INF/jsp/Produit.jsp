<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nom Produit</title>
</head>
<body>
	<p>nom : ${ param.nom }</p>
	<p>prix : ${ param.prix }</p>
	
	<p>nom: ${ param.nom } </p>
	<p>prix HT : ${ param.prix }</p>
	<p>prix TTC : ${ prixTTC }</p>
</body>
</html>