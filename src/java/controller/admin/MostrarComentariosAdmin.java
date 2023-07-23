package controller.admin;

// mostrar comentarios (área admin)

import entidade.Categoria;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ComentarioDAO;
import entidade.Comentario;
import model.CategoriaDAO;


@WebServlet(name = "MostrarComentariosAdmin", urlPatterns = {"/admin/MostrarComentariosAdmin"})
public class MostrarComentariosAdmin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // get parametro ação indicando o que fazer
        String acao = (String) request.getParameter("acao");
        Comentario comentario = new Comentario();
        ComentarioDAO comentarioDAO = new ComentarioDAO();
        
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        
        ArrayList<Categoria> listaCategorias = categoriaDAO.getAll();
        ArrayList<Comentario> listaComentarios = comentarioDAO.getAll();
        
        RequestDispatcher rd;
        switch (acao) {
            case "Listar":
                
                request.setAttribute("listaComentarios", listaComentarios);
                rd = request.getRequestDispatcher("/views/public/comentarios.jsp");
                rd.forward(request, response);

                break;
            case "Alterar":
            case "Excluir":
                int id = Integer.parseInt(request.getParameter("id"));
                comentario = comentarioDAO.get(id);
                comentario.setId(id);
                
                request.setAttribute("comentario", comentario);
                request.setAttribute("msgError", "");
                request.setAttribute("acao", acao);
                request.setAttribute("listaCategorias", listaCategorias);

                rd = request.getRequestDispatcher("/views/admin/comentario/formComentarios.jsp");
                rd.forward(request, response);
                break;
                
            case "Incluir":
                
                request.setAttribute("comentario", comentario);
                request.setAttribute("msgError", "");
                request.setAttribute("acao", acao);
                request.setAttribute("listaCategorias", listaCategorias);
                

                rd = request.getRequestDispatcher("/views/admin/comentario/formComentarios.jsp");
                rd.forward(request, response);
                break;
                
                
        }
    }
      
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String btEnviar = request.getParameter("btEnviar");
        int idComentario = Integer.parseInt(request.getParameter("id"));
        String textoComentario = request.getParameter("texto");
        String dataComentario = request.getParameter("data");
        int idUsuario = Integer.parseInt(request.getParameter("idusuario"));
        int idCategoria;
        if (btEnviar.equals("Excluir")) {
            idCategoria = 0;
        } else {
            idCategoria = Integer.parseInt(request.getParameter("idcategoria"));
        }
        
        ComentarioDAO comentarioDAO = new ComentarioDAO();
        Comentario comentario = new Comentario(idComentario, textoComentario, dataComentario, idUsuario, idCategoria);

        RequestDispatcher rd;
        try {
            switch (btEnviar) {
                case "Incluir":
                    if (!textoComentario.isEmpty() && (idCategoria != 0)) {
                        comentarioDAO.insert(comentario);
                        request.setAttribute("msgOperacaoRealizada", "Comentário adicionado.");
                        break;
                    } else {
                        request.setAttribute("msgError", "Preencher todos os campos!");
                        rd = request.getRequestDispatcher("/views/admin/comentario/formComentarios.jsp");
                        rd.forward(request, response);
                        break;
                    }
                case "Alterar":
                    if (!textoComentario.isEmpty() && (idCategoria != 0)) {
                        comentarioDAO.update(comentario);
                        request.setAttribute("msgOperacaoRealizada", "Comentário alterado.");
                        break;
                    } else {
                        request.setAttribute("msgError", "Preencher todos os campos");
                        rd = request.getRequestDispatcher("/views/admin/comentario/formComentarios.jsp");
                        rd.forward(request, response);
                        break;
                    }
                case "Excluir":
                    comentarioDAO.delete(idComentario);                  
                    request.setAttribute("msgOperacaoRealizada", "Comentário excluído.");
                    break;
            }

            request.setAttribute("comentario", comentario);
            request.setAttribute("acao", btEnviar);

            request.setAttribute("link", "/aplicacaoMVC/admin/MostrarComentariosAdmin?acao=Listar");
            rd = request.getRequestDispatcher("/views/comum/showMessage.jsp");
            rd.forward(request, response);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException("Falha em uma query para cadastro de comentário");
        }
    }
}
