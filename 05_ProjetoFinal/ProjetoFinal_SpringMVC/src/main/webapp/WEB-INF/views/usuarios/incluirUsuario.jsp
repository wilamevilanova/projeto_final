<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::Incluir usuários::</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
	.borda {
		max-width: 400px;
		margin: auto;
	}
</style>
</head>

<body>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<div class="container">
		<div class="borda">
			<h1 class="text-primary">Cadastro de Usuários </h1>
			<form action=<c:url value = "/users/cadusuario" /> method="post">
				
				<div class="md-3">
					<label class="form-label">Username:</label>
					<input class="form-control" type="text" name="login">
				</div>
				<div class="md-3"> 
					<label class="form-label">Password:</label>
					<input class="form-control" type="password" name="password">
 				</div>
				<button type="submit" class="btn btn-primary">Incluir Usuário</button>
			</form>
		</div>
	</div>
</body>

</html>