<%@page import="model.UsuarioDAO"%>
<%@page import="entidade.Comentario"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

                <%
                    ArrayList<Comentario> listaComentarios = (ArrayList<Comentario>) request.getAttribute("listaComentarios");
                    for (Comentario comentario : listaComentarios){ %>

                <div class="card mb-2 col-sm-6">
                    <div class="card-body">
                        <p><%= comentario.getComentario()%></p>
                        <p>ID do usuário: <%= comentario.getNomeUsuario()%></p>
                        <p>Data do comentário: <%= comentario.getData()%></p>
                    </div>
                </div>

                <%  }%>
            </div>
        </div>
        <script src="http://localhost:8080/aplicacaoMVC/views/bootstrap/bootstrap.bundle.min.js"></script>
    </body>
</html>

