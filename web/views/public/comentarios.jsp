<%@page import="model.CategoriaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="entidade.Comentario"%>
<%@page import="entidade.Usuario"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="#">
        <title>Login</title>
        <link href="http://localhost:8080/aplicacaoMVC/views/bootstrap/bootstrap.min.css"  rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="mt-5 text-center">
                <h1>Comentários dos usuários</h1>
                <% Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
                    if (usuarioLogado != null) { %>
                        <a href="/aplicacaoMVC/admin/MostrarComentariosAdmin?acao=Incluir" class="mb-2 btn btn-primary">Adicionar Comentário</a>
                <%  }else{  %>
                        <a href="/aplicacaoMVC/AutenticaController?acao=Login" class="mb-2 btn btn-primary">Entrar</a>
                <%  }%>
                    <a href="/aplicacaoMVC/home" class="mb-2 btn btn-secondary">Home</a>
                <%
                    ArrayList<Comentario> listaComentarios = (ArrayList<Comentario>) request.getAttribute("listaComentarios");
                    if (listaComentarios != null){
                    for (Comentario comentario : listaComentarios) {%>

                <div class="card mb-2 col-sm-6 mx-auto">
                    <div class="card-body">                   
                        <h6 class="card-subtitle mb-2 text-muted "><%= CategoriaDAO.getCategoriaNameById(comentario.getIdcategoria()) %></h6>                  
                        <p class="card-text">"<%= comentario.getComentario()%>"</p>
                        
                        <% if (usuarioLogado != null) { %>
                            <a href="/aplicacaoMVC/admin/MostrarComentariosAdmin?acao=Alterar&id=<%=comentario.getId()%>" class="mb-2 btn btn-warning">Alterar</a>
                            <a href="/aplicacaoMVC/admin/MostrarComentariosAdmin?acao=Excluir&id=<%=comentario.getId()%>" class="mb-2 btn btn-danger">Excluir</a>
                        <%  }  %>
                        
                       </div>
                    <div class="card-footer">
                        <small class="text-muted">Postado por: <%= comentario.getNomeUsuario() %> em <%= comentario.getData()%></small>                 
                    </div>
                </div>

                <%  }}%>
            
                
            </div>
        </div>
        <script src="http://localhost:8080/aplicacaoMVC/views/bootstrap/bootstrap.bundle.min.js"></script>
    </body>
</html>
