<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::Cadastro de Fornecedor::</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
	.borda {
		max-width: 400px;
		margin: auto;
	}
</style>
</head>

<!-- COR DE FUNDO -->
<body style="background-color:burlywood;">

<body>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<div class="container">
		<div class="borda">
		
			<h1 class="text-primary">Cadastro de Fornecedor</h1>
			<form action=<c:url value = "/cadfornecedor" /> method="post">
				
				<div class="md-3">
					<label class="form-label">Nome:</label>
					<input class="form-control" type="text" name="nome">
				</div>
				
				<div class="md-3">
					<label class="form-label">Telefone:</label>
					<input class="form-control" type="text" name="telefone">
				</div>
 				
				<div class="md-3">
					<label class="form-label">E-mail:</label>
					<input class="form-control" type="text" name="email">
				</div>
				
				<div class="md-3">
					<label class="form-label">Site:</label>
					<input class="form-control" type="text" name="site">
				</div>

				<div class="md-3">
					<label class="form-label">Instagram:</label>
					<input class="form-control" type="text" name="instagram">
				</div>
				
				<div class="md-3">
					<label class="form-label">Facebook:</label>
					<input class="form-control" type="text" name="facebook">
				</div>
				
				<button type="submit" class="btn btn-primary">Incluir Produto</button>
			</form>
		</div>
		
	</div>
</body>
</html>