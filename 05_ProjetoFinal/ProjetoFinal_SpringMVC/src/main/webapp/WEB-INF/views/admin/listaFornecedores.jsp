<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::Lista de Fornecedores::</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.2/font/bootstrap-icons.css">
<style>

	.borda {
		max-width: 400px;
		margin: auto;
	}
	
</style>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
</head>

<!-- COR DE FUNDO -->
<body style="background-color:burlywood;">

<body>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<div class="container">
		<h1 class="text-primary">Lista de Fornecedores:</h1>
		<div>
			<ul>
			
			<!-- VOLTAR P/MENU -->
			
				<li><a href=<c:url value="/admin/inicio"/>>Voltar para
						menu de opções</a></li>
				
				<!-- VOLTAR P/MENU -->	
				<li><a href=<c:url value="/"/>>Voltar para página inicial</a></li>
			</ul>
		</div>
		
		<!--BOTÃO CADASTRA NOVO FORNECEDOR-->
		
		<button type="button" class="btn btn-primary" data-bs-toggle="modal"
			data-bs-target="#modalinc">Novo Fornecedores</button>

		<table class="table table-hover">
			<thead>
				<tr>
					<th>ID</th>
					<th>NOME</th>
					<th>FONE</th>
					<th>E-MAIL</th>
					<th>SITE</th>
					<th>INSTAGRAM</th>
					<th>FACEBOOK</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ev" items="${admin}">
					<tr>
						<td>${ev.id}</td>
						<td>${ev.fornecedores}</td>
						<td>${ev.telefone}</td>
						<td>${ev.site}</td>
						<td>${ev.instagram}</td>
						<td>${ev.facebook}</td>
						<td>
							<%--	<a href=<c:url value="/admin/alterar/${ev.id}" />>Alterar</a> --%>

							<button type="button" class="btn btn-warning altera"
								data-id="${ev.id}" data-fornecedores="${ev.fornecedores}"
								data-dataFornecedor="${ev.telefone}"
								data-responsavel="${ev.site}" 
								data-preco_compra="${ev.instagram}"
								data-preco_venda="${ev.facebook}"
								data-bs-toggle="modal" data-bs-target="#modalupd">
								<i class="bi bi-pencil"></i>
							</button> |


							<button type="button" class="btn btn-danger remove"
								data-id="${ev.id}" data-bs-toggle="modal"
								data-bs-target="#modal">
								<i class="bi bi-trash"></i>
							</button>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<!-- MODAL REMOVER  -->
	<div class="modal fade" id="modal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- CABEÇALHO (header) -->
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Confirmar
						exclusão</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>

				<!-- CONTEUDO (body) -->
				<div class="modal-body">
					<h4>Tem certeza que deseja remover este fornecedor?</h4>

				</div>

				<!-- RODAPÉ (footer) -->
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Não, voltar para a lista</button>
					<button type="button" id="btnRemover" class="btn btn-danger"
						data-bs-dismiss="modal">Sim, remover</button>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal - ALTERAR -->
	<div class="modal fade" id="modalupd" tabindex="-1" 
			aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	    	<form action=<c:url value="/alterafornecedor" /> method="post">
	    	
	      <!-- CABEÇALHO (header) -->
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Alteração</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      
	      <!-- CONTEÚDO (body) -->
	      <div class="modal-body">
			<div class="borda">
				<input type="hidden" id="id" name="id" />

				
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
				
			</div>
	      </div>
	      
	      <!-- Rodapé (footer) -->
	      
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
	        	Cancelar
	        </button>
	        
	        <!-- BUTÃO ALTERAR FORNECEDOR CADASTRADO -->
	        <button type="submit" class="btn btn-primary" data-bs-dismiss="modal">
	        	Alterar Fornecedor
	        </button>
	        
	      </div>
	      </form>
	      
	    </div>
	  </div>
	</div>


	<!-- Modal - Novo -->
	<div class="modal fade" id="modalinc" tabindex="-1" 
			aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	    	<form action=<c:url value="/cadfornecedor" /> method="post">
	      <!-- CabeÃ§alho (header) -->
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Novo Fornecedor</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      
	      <!-- ConteÃºdo (body) -->
	      <div class="modal-body">
			<div class="borda">

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
				
			</div>
	      </div>
	      
	      <!-- RodapÃ© (footer) -->
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
	        	Cancelar
	        </button>
	        <button type="submit" class="btn btn-primary" data-bs-dismiss="modal">
	        	Incluir
	        </button>
	      </div>
	      </form>
	      
	    </div>
	  </div>
	</div>
	
			
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		$(document).ready(function(){
			let id;

			$('.remove').click(function(){
				id = $(this).attr('data-id');
			});
			
			$('.altera').click(function() {
				$('#id').val($(this).attr('data-id'));
				$('#dnome').val($(this).attr('data-nome'));
				$('#dataFornecedor').val($(this).attr('data-dataFornecedor'));
				$('#fone').val($(this).attr('data-fone'));
				$('#email').val($(this).attr('data-email'));
				$('#site').val($(this).attr('data-site'));
				$('#instagram').val($(this).attr('data-instagram'));
				$('#facebook').val($(this).attr('data-facebook'));
			});
			
			$('#btnRemover').click(function() {
				let url = "http://localhost:8080/ProjetoFinal_SpringMVC/admin/remover/" + id;
				$(location).attr('href', url);
			});
			
			
		});
	
	</script>
</body>
</html>