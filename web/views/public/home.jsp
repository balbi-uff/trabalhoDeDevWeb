<%@page contentType="text/html" pageEncoding="UTF-8" import="entidade.Usuario"%>
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
                <h3>Bem vindo ao Trabalho de Desenvolvimento Web do André e da Dani!</h3>
                

                <%
                    // testar se está logado
                    HttpSession sessao = request.getSession(false);
                    if (sessao != null) {
                        Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
                        if (usuarioLogado != null) { %>
                <%
                    out.println("<br>");
                    out.println("<h3>Como você está, " + usuarioLogado.getNome() + "?</h2>");
                    out.println("<h3>ME REMOVA DEPOIS! id / status: " + usuarioLogado.getId() + "|" + usuarioLogado.getStatus() + "</h2>");
                    
                %>
                <jsp:include page="comentarios.jsp" />
                <%  } else { %>
                <br><br>
                <p>Não entrou ainda?</p>
                <p><a href="/aplicacaoMVC/AutenticaController?acao=Login">Login ou Registro</a></p>
                <%    }
                    }%>

            </div>
        </div>
        <script src="http://localhost:8080/aplicacaoMVC/views/bootstrap/bootstrap.bundle.min.js"></script>
    </body>
</html>

