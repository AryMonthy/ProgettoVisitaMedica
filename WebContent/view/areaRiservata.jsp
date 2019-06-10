<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	
	</head>
	<body>
	<body bgcolor="#fOfffO">
	<h1> <center><font face="Tw Cen MT Condensed" color="#OOOOOO">  Benvenuto </center> </h1>
	
	<div class="card">
	<br>
	<br>
	<br>
	<br>
	
	  <center> 
	  <img src="http://www.dottrinalavoro.it/wp-content/uploads/2018/04/omino2.png" style="width:20%">
	  <h1><%=request.getSession().getAttribute("nome")%> 
	  <%=request.getSession().getAttribute("cognome")%> <br></h1>
	  <h2><%=request.getSession().getAttribute("città")%> <br> </h2>
	  <h4><%=request.getSession().getAttribute("telefono")%></h4>
	  <a href=""> Le mie prenotazioni</a>
	  </font>
	  
	  </center> 
	
</div>
	 
	</body>
</html>