<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Pagina de Cadastro de Usuario</title>
	</head>
	<body>
		<div align="center">
			<h1>Pagina de Cadastro de Usuario</h1>
			<form action="cadastro" method="post">
				<table>
					<tr>
						<td>Nome:</td>
						<td><input type="text" name="username"></td>
					</tr>
					<tr>
						<td>Senha:</td>
						<td><input type="password" name="password"></td>
					</tr>
					<tr>
						<td>Confirme Senha:</td>
						<td><input type="password" name="confirmepassword"></td>
					</tr>
					<tr>
						<td><input type="submit" value="Cadastrar"></td>
					</tr>
					<tr>
						<td><a href="login.jsp">Cancelar</a></td>
						
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>