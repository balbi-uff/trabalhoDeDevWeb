<%--
    Document   : dashboard
    Created on : 14 Jul 2023, 17:24:10
    Author     : balbi
--%>

<%@page import="model.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entidade.Usuario" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="#">
        <title>Dashboard</title>
        <link href="http://localhost:8080/aplicacaoMVC/views/bootstrap/bootstrap.min.css"  rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <jsp:include page="../../comum/menu.jsp" />
            <% ArrayList<Usuario> ListaDeUsuarios = UsuarioDAO.ListaDeUsuarios(); %>
            <div class="container">
                <div class="row">
                    <div class="col">
                        <br>
                        <h1>LISTA DE USUÁRIOS</h1>
                        <br>
                        <% for (Usuario usuario : ListaDeUsuarios) { %>
                            <% if (usuario.getStatus().equals("N")) {%>
                            <div class="card mb-3">
                                <div class="card-body d-flex justify-content-between">
                                    <h3><%= usuario.getNome()%></h3>
                                    <p><i>pendente de aprovação!</i></p>
                                    <form action="UsuarioController" method="POST">
                                        <input type="hidden" name="usuarioId" value="<%= usuario.getId()%>">
                                        <input type="hidden" name="type" value="aprovar">
                                        <input type="submit" value="APROVAR USUÁRIO" class="btn btn-primary">
                                    </form>
                                </div>
                            </div>
                            <% } else {%>
                            <div class="card mb-3">
                                <div class="card-body d-flex justify-content-between">
                                    <h3><%= usuario.getNome()%></h3>
                                    <input type="submit" value="APROVADO" class="btn btn-info">
                                    
                                    <form action="UsuarioController" method="GET">
                                        <input type="hidden" name="usuarioId" value="<%= usuario.getId()%>">
                                        <input type="hidden" name="type" value="alterar">
                                        <input type="submit" value="ALTERAR USUÁRIO" class="btn btn-warning">
                                    </form>
                                    
                                    <form action="UsuarioController" method="POST">
                                        <input type="hidden" name="usuarioId" value="<%= usuario.getId()%>">
                                        <input type="hidden" name="type" value="deletar">
                                        <input type="submit" value="DELETAR USUÁRIO" class="btn btn-danger">
                                    </form>
                                </div>
                            </div>
                            <%}%>
                        <% }%>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
