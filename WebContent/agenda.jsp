<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "model.JavaBeans" %> 
<%@ page import = "java.util.ArrayList" %>
<%
	ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");
%>
    
<!DOCTYPE html>
<html lang = "pt-br">
<head>
<meta charset="UTF-8">
<title>Agenda de Contatos</title>
<link rel="icon" href="imagens/telefone.png"> 
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1> Agenda de Contatos </h1> 
	<a href="novo.html" class="Botao_Novo_Contato"> Novo Contato </a>
	<a href="report" class="Botao_Relatorio">Relatório</a>
	
	<table id="tabela"> 
		
		<thead>
		
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Fone</th>
				<th>Email</th>
				<th>Opções</th> 
			</tr>
			
		</thead>
		
		<tbody>
		
			<%for (int i = 0; i < lista.size(); i++) {  %> 
				
				<tr>
					<td> <%=lista.get(i).getIdcon() %> </td> 
					<td> <%=lista.get(i).getNome() %> </td> 
					<td> <%=lista.get(i).getFone() %> </td> 
					<td> <%=lista.get(i).getEmail() %> </td> 
					<td><a href="select?idcon=<%=lista.get(i).getIdcon()%>" class="Botao_Editar">Editar</a>
						<a href="javascript: confirmar(<%=lista.get(i).getIdcon()%>)" class="Botao_Excluir">Excluir</a></td>
				</tr>
				
			<%} %>
			
		</tbody>
		
	</table>
	<script src="scripts/confirmador.js"></script>
</body>
</html>