<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Cadastro de Livros</h1>
	<form action="livrosmdb" method="post">
		<label for="nome">Título:</label><br/>
		<input type="text" name="titulo"/><br/>
		<label for="nome">Autor:</label><br/>
		<input type="text" name="autor"/><br/>
		<label for="nome">Preço:</label><br/>
		<input type="number" step="0.1" name="preco"/><br/>
		<input class="btn btn-primary" type="submit" value="Enviar"/>
	</form>
</body>
</html>
