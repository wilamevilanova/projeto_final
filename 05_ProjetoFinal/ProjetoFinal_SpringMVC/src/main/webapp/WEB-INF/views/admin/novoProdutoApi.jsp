<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::Cadastro de ProdutosApi::</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>


<!-- COR DE FUNDO -->
<body style="background-color:burlywood;">

	<div class="container">
		<div class="row">
			<div class="col-sm-5">
				<h3>Novo Produto</h3>
				<div>
				
					<div class="md-3">
						<label class="form-label">Descrição: </label>
						<input class="form-control" type="text" name="descricao" id="descricao" />
					</div>
					
					<div class="md-3">
						<label class="form-label">Data: </label>
						<input class="form-control" type="date" name="data" id="data"  />
					</div>
					
					<div class="md-3">
						<label class="form-label">Responsável:</label>
						<input class="form-control" type="text" name="responsavel" id="responsavel" />
					</div>
					
					<div class="md-3">
						<label class="form-label">Preço de compra: </label>
						<input class="form-control" type="text" name="preco_compra" id="preco_compra"  />
					</div>
					
					<div class="md-3">
						<label class="form-label">Preço de venda: </label>
						<input class="form-control" type="text" name="preco_venda" id="preco_venda"  />
					</div>
				
					<button type="button" class="btn btn-primary" id="btnIncluir">Incluir Produto</button>	
				</div>
				
			</div>
			<div class="col-sm-7">
				<h3>Lista de Produtos</h3>
				<table class="table table-striped" id="tabela">
					<thead>
						<tr>
							<th>ID</th>
							<th>DESCRICAO</th>
							<th>RESPONSAVEL</th>
						</tr>
					</thead>
					<tbody>
						
					</tbody>
				</table>	
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
	
		function listarProdutos() {
				$.ajax({
					dataType: 'json',
					url: 'http://localhost:8080/ProjetoFinal_SpringMVC/api/admin',
					method: 'GET',
					success: function(resposta) {
						//console.log(resposta);	
						$('#tabela > tbody').html('');
						
						$.each(resposta, function(index, item){
							let linha = $('<tr>');
							
							let colunas = '<td>' + item.id + '</td>';
							colunas += '<td>' + item.descricao + '</td>';
							colunas += '<td>' + item.responsavel + '</td>';
							
							linha.append(colunas);
							
							$('#tabela > tbody').append(linha);
						});
					},
						
					error: function (erro) {
						console.log(erro.responseText);
					}
						
				});
		}	
	
		$(document).ready(function(){
			listarProdutos();
			
			// Instrução  para adicionar um novo Produto através da API
			
			$('#btnIncluir').click(function(){
				$.ajax({
					headers: {
						"Accept": "application/json",
						"Content-Type": "application/json"
					},
					dataType: 'json',
					url:'http://localhost:8080/ProjetoFinal_SpringMVC/api/admin',
					method: 'POST',
					data: JSON.stringify({
						descricao: $('#descricao').val(),
						responsavel: $('#responsavel').val(),
						data: $('#data').val(),
						preco_compra: $('#preco_compra').val(),
						preco_venda: $('#preco_venda').val()
					}),
					success: function(resposta){
						window.alert('Dados incluídos');
						listarProdutos();
					},
					error: function(erro) {
						window.alert('Erro: ' + erro.responseText());
					}
				});
				
			});
			
		});	
	</script>
</body>
</html>