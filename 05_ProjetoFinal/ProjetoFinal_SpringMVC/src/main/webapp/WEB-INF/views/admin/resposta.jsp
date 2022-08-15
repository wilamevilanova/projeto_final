<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<script>
		$(documento).ready(function (){
			int cep;
			$("#btnEnviar").click(function () {
				$.ajax({
					dataType: 'json',
					url: 'https://viacep.com.br/ws/01001000/json/',
					method: 'GET',
					success: function () {},
					error: function () {}
				});
			});
		});
	</script>
	
</body>
</html>