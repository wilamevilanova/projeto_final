<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::Produtos::</title>
</head>
<body>

<!-- COR DE FUNDO -->
<body style="background-color:burlywood;">

	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div>
		<h1>Gestão de Produtos</h1>

		<ul>
			<li><a href=<c:url value="/admin/listar" />>Lista de Produto</a></li>
			<li><a href=<c:url value="/admin/incluir" />>Cadastrar Produto</a></li>
			<li><a href=<c:url value="/admin/fornecedor" />>Cadastrar Fornecedor</a></li>
		</ul>
	</div>
</body>
</html>