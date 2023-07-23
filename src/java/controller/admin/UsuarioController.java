package controller.admin;

import entidade.Usuario;
import model.UsuarioDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "UsuarioController", urlPatterns = {"/UsuarioController"})
public class UsuarioController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd;
        HttpSession session = request.getSession();

        String type = request.getParameter("type");
        String usuarioId = request.getParameter("usuarioId");

        System.out.println("Received usuarioId: " + usuarioId);
        
        session.setAttribute("type", type);
        session.setAttribute("usuarioId", usuarioId);

        rd = request.getRequestDispatcher("/views/admin/usuario/formAlterar.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        String usuarioId = request.getParameter("usuarioId");
        if (type != null && !type.isEmpty()) {
            switch (type) {
                case "aprovar":
                    aprovarUsuario(usuarioId);
                    break;
                // Update
                case "alterar":
                    String nome = request.getParameter("nome");
                    String endereco = request.getParameter("endereco");
                    String cpf = request.getParameter("cpf");
                    String senha = request.getParameter("senha");
                    {
                        try {
                            alterarUsuario(usuarioId, nome, endereco, cpf, senha);
                        } catch (Exception ex) {
                            throw new RuntimeException("Erro na alteração: " + ex);
                        }
                    }
                    break;

                // Delete
                case "deletar": {
                    try {
                        deletarUsuario(usuarioId);
                    } catch (Exception ex) {
                        throw new RuntimeException("Erro na deleção: " + ex);
                    }
                }
                default:
                    break;
            }
        }

        // Redirect back to the dashboard after processing the action
        response.sendRedirect(request.getContextPath() + "/admin/dashboard");
    }

    private void aprovarUsuario(String usuarioId) {
        UsuarioDAO.aprovarUsuario(usuarioId);
    }

    private void deletarUsuario(String usuarioId) throws Exception {
        UsuarioDAO user = new UsuarioDAO();
        Usuario usuarioADeletar = user.getUsuario(Integer.parseInt(usuarioId));
        UsuarioDAO.Excluir(usuarioADeletar);
    }

//    private void alterarUsuario(String usuarioId, String nome, String endereco, String cpf, String senha) throws Exception {
//
//        Usuario user = new Usuario(nome, cpf, endereco, senha);
//        user.setId(Integer.parseInt(usuarioId));
//        UsuarioDAO.Alterar(user);
//
//    }
    private void alterarUsuario(String usuarioId, String nome, String endereco, String cpf, String senha) throws Exception {
        // Create a new Usuario object
        String userStatus = UsuarioDAO.getUserStatusById(usuarioId);
        Usuario user = new Usuario(nome, cpf, endereco, senha, userStatus);
        
        // Parse the usuarioId to an Integer
        int id = Integer.parseInt(usuarioId);
        
        // Set the id of the Usuario object
        user.setId(id);
        
        // Call the static Alterar method in UsuarioDAO
        UsuarioDAO.Alterar(user);
    }

}
