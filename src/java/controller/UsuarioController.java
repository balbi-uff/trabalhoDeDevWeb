package controller;

import entidade.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UsuarioDAO;

@WebServlet(name = "UsuarioController", urlPatterns = {"/admin/UsuarioController"})
public class UsuarioController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // get parametro ação indicando o que fazer
        String acao = (String) request.getParameter("acao");
        Usuario usuario = new Usuario();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        RequestDispatcher rd;
        
        switch (acao) {
            case "Listar":
                ArrayList<Usuario> listaUsuarios = usuarioDAO.getAll();
                request.setAttribute("listaUsuarios", listaUsuarios);

                rd = request.getRequestDispatcher("/views/admin/usuario/listaUsuarios.jsp");
                rd.forward(request, response);

                break;
            case "Alterar":
            case "Excluir":

                // get parametro ação indicando sobre qual usuário será a ação
                int id = Integer.parseInt(request.getParameter("ID"));
                usuario = usuarioDAO.getUsuario(id);


                request.setAttribute("usuario", usuario);
                request.setAttribute("msgError", "");
                request.setAttribute("acao", acao);

                rd = request.getRequestDispatcher("/views/admin/autenticacao/formLogin.jsp");
                rd.forward(request, response);
                break;
            case "Incluir":
                request.setAttribute("usuario", usuario);
                request.setAttribute("msgError", "");
                request.setAttribute("acao", acao);

                rd = request.getRequestDispatcher("/views/admin/autenticacao/formLogin.jsp");
                rd.forward(request, response);
        }

    }


    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        //String cpf = request.getParameter("cpf");
       // String endereco = request.getParameter("endereco");
       // String senha = request.getParameter("senha");
        
        String btEnviar = request.getParameter("btEnviar");

        RequestDispatcher rd;

        if (nome.isEmpty()) {
            Usuario usuario = new Usuario();
            switch (btEnviar) {
                case "Alterar":
                case "Excluir":
                    try {
                    UsuarioDAO usuarioDAO = new UsuarioDAO();
                    usuario = usuarioDAO.get(id);

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    throw new RuntimeException("Falha em uma query para cadastro de usuario");
                }
                break;
            }

            request.setAttribute("usuario", usuario);
            request.setAttribute("acao", btEnviar);

            request.setAttribute("msgError", "É necessário preencher todos os campos");

            rd = request.getRequestDispatcher("/views/admin/autenticacao/formLogin.jsp");
            rd.forward(request, response);

        } else {
            
             Usuario usuario = new Usuario ();
             UsuarioDAO usuarioDAO = new UsuarioDAO();

            try {
                switch (btEnviar) {
                    case "Incluir":
                        usuarioDAO.Inserir(usuario);
                        request.setAttribute("msgOperacaoRealizada", "Inclusão realizada com sucesso");
                        break;
                    case "Alterar":
                        usuarioDAO.Alterar(usuario);
                        request.setAttribute("msgOperacaoRealizada", "Alteração realizada com sucesso");
                        break;
                    case "Excluir":
                        usuarioDAO.Excluir(usuario);
                        request.setAttribute("msgOperacaoRealizada", "Exclusão realizada com sucesso");
                        break;
                }

                request.setAttribute("link", "/aplicacaoMVC/admin/UsuarioController?acao=Listar");
                rd = request.getRequestDispatcher("../views/comum/showMessage.jsp");
                rd.forward(request, response);

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                throw new RuntimeException("Falha em uma query para cadastro de usuario");
            }
        }
    }

}

