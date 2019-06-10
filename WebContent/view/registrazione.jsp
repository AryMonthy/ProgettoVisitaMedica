<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<style> 
body {
  font-family: Tw Cen MT Condensed Extra Bold,SANS-SERIF; COLOR: #000000; size:30;
  background-color: #f0fff0;
}

* {
  box-sizing: border-box; size:5
}

/* Add padding to containers */
.container {
  padding: 16px;
  background-color: =#f0fff0;
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 40%;
  padding: 10px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
  background-color: #4169E1;
  color: white;
  padding: 10px 4px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 40%;
  opacity: 0.9;
}

.registerbtn:hover {
  opacity: 1;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
  background-color: #f1f1f1;
  text-align: center;
  padding: 6px 2px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 45%;
  opacity: 0.9;
 
}
</style>
</head>
<body>
	<form action="./ServletRegistrazione">
  <div class="container">
    <center> <h1> Registrati qui <br> </h1>
    <p>Compila i campi per creare un nuovo account</p>
    <hr>

    <label for="Inserisci qui il tuo codice fiscale"><b></b></label><br>
    <input type="text" placeholder="Inserisci qui il tuo codice fiscale" name="cf" required > <br>
	<label for="Nome"><b></b></label>
    <input type="text" placeholder="Nome" name="nome" required><br>
	<label for="Cognome"><b></b></label>
    <input type="text" placeholder="Cognome" name="cognome" required><br>
	<label for="DataNascita"><b></b></label>
    <input type="text" placeholder="Data di nascita: gg/mm/aaaa" name="dataNascita" required><br>
	<label for="Città"><b></b></label>
    <input type="text" placeholder="Città" name="citta" required><br>
	<label for="Telefono"><b></b></label>
    <input type="text" placeholder="Telefono" name="telefono" required><br>
    <label for="password"><b></b></label>
    <input type="password" placeholder="Password" name="p" required><br>

    <hr>
	<button type="submit" class="registerbtn">Registrati</button>
	</center>
  </div>
</form>

	<% String cf=request.getParameter("cf");%>
	<% String nome=request.getParameter("nome");%>
	<% String cognome= request.getParameter("cognome");%>
	<% String dataNascita=request.getParameter("dataNascita");%>
	<% String città=request.getParameter("città");%>
	<% String telefono=request.getParameter("telefono");%>
	<% String p=request.getParameter("password");%>
</body>
</html>