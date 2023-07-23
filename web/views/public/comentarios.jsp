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
            <jsp:include page="../comum/menu.jsp" />
            <div class="mt-5">
                <h1>Comentários dos usuários</h1>
                <% Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
                    if (usuarioLogado != null) { %>
                        <a href="/aplicacaoMVC/admin/MostrarComentariosAdmin?acao=Incluir" class="mb-2 btn btn-primary">Incluir</a>
                <%  }  %>
                
                <%
                    ArrayList<Comentario> listaComentarios = (ArrayList<Comentario>) request.getAttribute("listaComentarios");
                    for (Comentario comentario : listaComentarios) {%>

                <div class="card mb-2 col-sm-6">
                    <div class="card-body">                   
                        <h6 class="card-subtitle mb-2 text-muted ">Usuário: <%= comentario.getNomeUsuario() %> </h6>                  
                        <p class="card-text">"<%= comentario.getComentario()%>"</p>
                        
                        <% if (usuarioLogado != null) { %>
                            <a href="/aplicacaoMVC/admin/MostrarComentariosAdmin?acao=Alterar&id=<%=comentario.getId()%>" class="mb-2 btn btn-warning">Alterar</a>
                            <a href="/aplicacaoMVC/admin/MostrarComentariosAdmin?acao=Excluir&id=<%=comentario.getId()%>" class="mb-2 btn btn-danger">Excluir</a>
                        <%  }  %>
                        
                       </div>
                    <div class="card-footer">
                        <small class="text-muted">Data de publicação: <%= comentario.getData()%></small>                 
                    </div>
                </div>

                <%  }%>
            
                
            </div>
        </div>
        <script src="http://localhost:8080/aplicacaoMVC/views/bootstrap/bootstrap.bundle.min.js"></script>
    </body>
</html>
