<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::Menu::</title>
</head>

<!-- COR DE FUNDO -->
<body style="background-color:burlywood;">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<div>
		<h1>Menu de Op��es</h1>
		<ul>
			<li><a href=<c:url value="/admin/inicio" />>Gest�o de Produtos</a></li>
			<li><a href=<c:url value="/viacep" />>Buscar Endere�o</a></li>
			<li><a href=<c:url value="/admin/incluirapi" />>Cadastrar Produtos API</a></li>
			<li><a href=<c:url value="/users/incluir" />>Cadastro de Usu�rios</a></li>
		</ul>
	</div>
	
</body>
</html>