package controller.admin;

import entidade.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "DashboardController", urlPatterns = {"/admin/dashboard"})
public class DashboardController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
        String statusUsuario = usuarioLogado.getStatus();
        
        if ("S".equals(statusUsuario)){
            request.getRequestDispatcher("/views/admin/dashboard/dashboard.jsp")
                .forward(request, response);
        }
        
        request.getRequestDispatcher("/views/admin/dashboard/areaRestrita.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
        String statusUsuario = usuarioLogado.getStatus();

        if ("S".equals(statusUsuario)) {
            request.getRequestDispatcher("/views/admin/dashboard/dashboard.jsp")
                    .forward(request, response);
        }
        request.getRequestDispatcher("/views/admin/dashboard/areaRestrita.jsp")
                .forward(request, response);
    }

}
