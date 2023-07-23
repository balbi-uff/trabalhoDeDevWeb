<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="entidade.Categoria"%>
<%@page import="entidade.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.time.LocalDate"%>
<%@page import="entidade.Comentario"%>

<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="#">
        <title>Comentário</title>
        <link href="http://localhost:8080/aplicacaoMVC/views/bootstrap/bootstrap.min.css"  rel="stylesheet">
    </head>

    <body>

        <div class="container">
            <jsp:include page="../../comum/menu.jsp" />
            <div class="row mt-5">
                <div class="col-sm-4 offset-3">
                    <%
                        Comentario comentario = (Comentario) request.getAttribute("comentario");
                        String acao = (String) request.getAttribute("acao");
                        switch (acao) {
                            case "Incluir":
                                out.println("<h1>Incluir comentário: </h1>");
                                break;
                            case "Alterar":
                                out.println("<h1>Alterar comentário: </h1>");
                                break;
                            case "Excluir":
                                out.println("<h1>Excluir comentário: </h1>");
                                break;
                        }
                        String msgError = (String) request.getAttribute("msgError");
                        if ((msgError != null) && (!msgError.isEmpty())) {%>
                        
                    <div class="alert alert-danger" role="alert">
                        <%= msgError%>
                    </div>
                    <% }%>
                    
                    <% Usuario usuarioLogado = (Usuario) session.getAttribute("usuario"); %>
                    <form action="/aplicacaoMVC/admin/MostrarComentariosAdmin" method="POST">
                        <input type="hidden" name="id" value="<%= comentario.getId()%>" class="form-control">
                        <input type="hidden" name="data" value="<%= comentario.getData() %>" class="form-control">
                        <input type="hidden" name="idusuario" value="<%= usuarioLogado.getId() %>" class="form-control">
                        <div class="mb-3">
                            <label for="texto" class="form-label" >Texto</label>
                            <input type="text" name="texto" <%= acao.equals("Excluir") ? "readonly" : ""%> value="<%=comentario.getComentario()%>" class="form-control">
                        </div>
                        <% if(!acao.equals("Excluir")) { %>
                        <div class="mb-3">
                            <label for="idcategoria" class="form-label">Categoria</label>
                            <select name="idcategoria" class="form-select">
                            <%
                                ArrayList<Categoria> listaCategorias = (ArrayList<Categoria>) request.getAttribute("listaCategorias");
                                for (Categoria categoria : listaCategorias) {
                            %>
                                <option value="<%= categoria.getId() %>" <%= categoria.getId() == comentario.getIdcategoria() ? "selected" : "" %>>
                                <%= categoria.getDescricao() %>
                                </option>
                            <% } %>
                            </select>
                        </div>
                            <% } %>
                      
                        <div>
                            <input type="submit" name="btEnviar" value="<%=acao%>" class="btn btn-primary">
                          
                            <a href="/aplicacaoMVC/admin/MostrarComentariosAdmin?acao=Listar" class="btn btn-danger">Retornar</a>
                        </div>
                            
                        
                            
                    </form>

                </div>
            </div>
        </div>
        <script src="http://localhost:8080/aplicacaoMVC/views/bootstrap/bootstrap.bundle.min.js"></script>
    </body>

</html>

