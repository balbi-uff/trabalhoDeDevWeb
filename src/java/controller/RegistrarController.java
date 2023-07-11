package controller;

import entidade.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.UsuarioDAO;
import Utils.RequestUtils;
/**
 *
 * @author Leonardo
 */
@WebServlet(name = "RegistrarController", urlPatterns = {"/RegistrarController"})
public class RegistrarController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/views/registro/formRegistro.jsp");
        rd.forward(request, response);

    }
        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd;
        
        if(RequestUtils.possuiParametrosVazios(request)){
            request.setAttribute("msgError", "Formulário preenchido incorretamente!");
            rd = request.getRequestDispatcher("/views/registro/formRegistro.jsp");
            rd.forward(request, response);
        }else{
            
            // Pega parâmetros para registro
            String nome = request.getParameter("nome");
            String endereco = request.getParameter("endereco");
            String cpf = request.getParameter("cpf");
            String senha = request.getParameter("senha");
            
            
            // Gera instância do usuário no BD
            Usuario usuarioGerado;
            Usuario usuario = new Usuario(nome, cpf, endereco, senha);
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            try {
                usuarioDAO.Inserir(usuario);
                
                // Loga no usuário recém registrado
                try {
                    usuarioGerado = usuarioDAO.Logar(usuario);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    throw new RuntimeException("Falha na query para Logar");
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                throw new RuntimeException("Falha na query para Logar");
            }
            
            // Atribui usuário na sessão e direciona ele para o local correto
            HttpSession session = request.getSession();
                session.setAttribute("usuario", usuarioGerado);

                rd = request.getRequestDispatcher("/admin/dashboard");
                rd.forward(request, response);
            
        }     
    }
}
