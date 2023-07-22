<%@page contentType="text/html" pageEncoding="UTF-8" import="entidade.Usuario" %>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="#">
        <title>Área Restrita</title>
        <link href="http://localhost:8080/aplicacaoMVC/views/bootstrap/bootstrap.min.css"  rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <jsp:include page="../../comum/menu.jsp" />
            <div class="mt-5">

                <h1>Área Restrita</h1>
                <%
                    Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
                    out.println("<br>");
                    out.println("<h3>Por favor, faça login com um usuário autorizado para acessar o conteúdo.</p>");
                    out.println("<h3>Nome do usuário logado: " + usuarioLogado.getNome() + "</h2>");
                    out.println("<h3>ME REMOVA DEPOIS! id: " + usuarioLogado.getId() + " | status: " + usuarioLogado.getStatus() + "</h2>");
                    
                %>


            </div>
        </div>
        <script src="http://localhost:8080/aplicacaoMVC/views/bootstrap/bootstrap.bundle.min.js"></script>
    </body>
</html>
