<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::Produtos::</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<!-- COR DE FUNDO -->
<body style="background-color:burlywood;">

	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<div>
		<h1>Gestão de Produtos</h1>
		<div>
			<a href=<c:url value="/admin/listar"/>> <button class="btn btn-primary">Lista de Produtos</button></a>
		</div>
		<br>
		<div>
			<a href=<c:url value="/admin/incluir"/>><button class="btn btn-primary">Cadastro de Produtos</button></a>
		</div>
		<br>
		<div>
			<a href=<c:url value="/admin/fornecedor"/>> <button class="btn btn-primary">Cadastra de Fornecedor</button></a>
		</div>
	</div>
</body>
</html>