package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UsuarioDAO;

@WebServlet(name = "AprovarUsuarioController", urlPatterns = {"/AprovarUsuarioController"})
public class AprovarUsuarioController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuarioId = request.getParameter("usuarioId");

        UsuarioDAO.aprovarUsuario(usuarioId);
        response.sendRedirect("admin/dashboard");
    }
}
