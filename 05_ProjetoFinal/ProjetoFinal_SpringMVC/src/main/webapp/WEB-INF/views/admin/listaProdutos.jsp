<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::Lista de Produtos::</title>
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
		<h1 class="text-primary">Lista de Produtos:</h1>
		<div>
			<ul>		
			<!-- VOLTAR P/MENU -->
			
				<li><a href=<c:url value="/admin/inicio"/>>Voltar para
						menu de opções</a></li>
				
				<!-- VOLTAR P/MENU -->	
				<li><a href=<c:url value="/"/>>Voltar para página inicial</a></li>
			</ul>
		</div>
		
		<!--BOTÃO CADASTRA NOVO PRODUTO-->
		
		<button type="button" class="btn btn-primary" data-bs-toggle="modal"
			data-bs-target="#modalinc">Novo Produto</button>

		<table class="table table-hover">
			<thead>
				<tr>
					<th>ID</th>
					<th>DESCRIÇÃO</th>
					<th>DATA</th>
					<th>FORNECEDOR</th>
					<th>PREÇO DE COMPRA</th>
					<th>PREÇO DE VENDA</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ev" items="${admin}">
					<tr>
						<td>${ev.id}</td>
						<td>${ev.descricao}</td>
						<td>${ev.data}</td>
						<td>${ev.responsavel}</td>
						<!-- CONVERTE MOEDA -->
						<td><fmt:formatNumber value="${ev.preco_compra}"  type="currency" /></td>
						<td><fmt:formatNumber value="${ev.preco_venda}"  type="currency" /></td>
						<td>
							<%--	<a href=<c:url value="/admin/alterar/${ev.id}" />>Alterar</a> --%>

							<button type="button" class="btn btn-warning altera"
								data-id="${ev.id}" data-descricao="${ev.descricao}"
								data-dataProduto="${ev.data}"
								data-responsavel="${ev.responsavel}" 
								data-preco_compra="${ev.preco_compra}"
								data-preco_venda="${ev.preco_venda}"
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
					<h4>Tem certeza que deseja remover este produtos?</h4>

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
	    	<form action=<c:url value="/alteraproduto" /> method="post">
	    	
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
					<label class="form-label">Descrição:</label>
					<input class="form-control" type="text" id="descricao" name="descricao"  />
				</div>
				
				<div class="md-3">
					<label class="form-label">Data:</label>
					<input class="form-control" type="date" id="dataProduto" name="dataProduto" />
				</div>
				
				<div class="md-3">
					<label class="form-label">Responsável:</label>
					<input class="form-control" type="text" id="responsavel" name="responsavel"  />
				</div>	
				
				<div class="md-3">
					<label class="form-label">Preço da Compra:</label>
					<input class="form-control" type="text" id="preco_compra" name="preco_compra" />
				</div>
				
				<div class="md-3">
					<label class="form-label">Preço da Venda:</label>
					<input class="form-control" type="text" id="preco_venda" name="preco_venda" />
				</div>
				
			</div>
	      </div>
	      
	      <!-- Rodapé (footer) -->
	      
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
	        	Cancelar
	        </button>
	        
	        <!-- BUTÃO ALTERAR PRODUTO CADASTRADO -->
	        <button type="submit" class="btn btn-primary" data-bs-dismiss="modal">
	        	Alterar Produto
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
	    	<form action=<c:url value="/cadproduto" /> method="post">
	      <!-- CabeÃ§alho (header) -->
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Novo Produto</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      
	      <!-- ConteÃºdo (body) -->
	      <div class="modal-body">
			<div class="borda">

				<div class="md-3">
					<label class="form-label">Descrição:</label>
					<input class="form-control" type="text" id="descricao" name="descricao"  />
				</div>
				
				<div class="md-3">
					<label class="form-label">Data:</label>
					<input class="form-control" type="date" id="dataProduto" name="dataProduto" />
				</div>
				
				<div class="md-3">
					<label class="form-label">Responsável:</label>
					<input class="form-control" type="text" id="responsavel" name="responsavel"  />
				</div>	
				
				<div class="md-3">
					<label class="form-label">Preço da Compra:</label>
					<input class="form-control" type="text" id="preco_compra" name="preco_compra" />
				</div>
				
				<div class="md-3">
					<label class="form-label">Preço da Venda:</label>
					<input class="form-control" type="text" id="preco_venda" name="preco_venda" />
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
				$('#descricao').val($(this).attr('data-descricao'));
				$('#dataProduto').val($(this).attr('data-dataProduto'));
				$('#responsavel').val($(this).attr('data-responsavel'));
				$('#preco_compra').val($(this).attr('data-preco_compra'));
				$('#preco_venda').val($(this).attr('data-preco_venda'));
			});
			
			$('#btnRemover').click(function() {
				let url = "http://localhost:8080/ProjetoFinal_SpringMVC/admin/remover/" + id;
				$(location).attr('href', url);
			});
			
			
		});
	
	</script>
</body>
</html>