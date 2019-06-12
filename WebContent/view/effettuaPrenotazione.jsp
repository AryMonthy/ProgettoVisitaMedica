<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title> Effettua una prenotazione </title>
	
	</head>
	<body>

	<form action="./ServletEsitoPrenotazione">
	<c:forEach var="cur" items="${listaVisite}"> 
	
		<input type="radio" name="seleziona" value="${cur.codice_visita}" checked>
		${cur.descrizione}
		${cur.nome}
		${cur.cognome}
		<br>
	</c:forEach>
	
	
	<input type="date" name="d" max="2019-12-31"><br><br>
	
	<input type ="submit" value="Prenota">
	
	
	</form>
	
	</body>
</html>