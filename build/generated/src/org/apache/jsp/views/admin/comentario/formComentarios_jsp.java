package org.apache.jsp.views.admin.comentario;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import entidade.Categoria;
import entidade.Usuario;
import java.util.ArrayList;
import entidade.Comentario;

public final class formComentarios_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"pt-br\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"shortcut icon\" href=\"#\">\n");
      out.write("        <title>Lista de Comentários</title>\n");
      out.write("        <link href=\"http://localhost:8080/aplicacaoMVC/views/bootstrap/bootstrap.min.css\"  rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../comum/menu.jsp", out, false);
      out.write("\n");
      out.write("            <div class=\"col-sm-6 offset-3 mt-5\">\n");
      out.write("               ");

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
                        if ((msgError != null) && (!msgError.isEmpty())) {
      out.write("\n");
      out.write("                        \n");
      out.write("                    <div class=\"alert alert-danger\" role=\"alert\">\n");
      out.write("                        ");
      out.print( msgError);
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    ");
 }
      out.write("\n");
      out.write("                    \n");
      out.write("                    ");
 Usuario usuarioLogado = (Usuario) session.getAttribute("usuario"); 
      out.write("\n");
      out.write("                    <form action=\"/aplicacaoMVC/admin/MostrarComentariosRestrito\" method=\"POST\">\n");
      out.write("                        <input type=\"hidden\" name=\"id\" value=\"");
      out.print( comentario.getId());
      out.write("\" class=\"form-control\">\n");
      out.write("                        <input type=\"hidden\" name=\"data\" value=\"");
      out.print( comentario.getData() );
      out.write("\" class=\"form-control\">\n");
      out.write("                        <input type=\"hidden\" name=\"idusuario\" value=\"");
      out.print( usuarioLogado.getId() );
      out.write("\" class=\"form-control\">\n");
      out.write("                        <div class=\"mb-3\">\n");
      out.write("                            <label for=\"texto\" class=\"form-label\" >Texto</label>\n");
      out.write("                            <input type=\"text\" name=\"texto\" ");
      out.print( acao.equals("Excluir") ? "readonly" : "");
      out.write(" value=\"");
      out.print(comentario.getComentario());
      out.write("\" class=\"form-control\">\n");
      out.write("                        </div>\n");
      out.write("                        ");
 if(!acao.equals("Excluir")) { 
      out.write("\n");
      out.write("                        <div class=\"mb-3\">\n");
      out.write("                            <label for=\"idcategoria\" class=\"form-label\">Categoria</label>\n");
      out.write("                            <select name=\"idcategoria\" class=\"form-select\">\n");
      out.write("                            ");

                                ArrayList<Categoria> listaCategorias = (ArrayList<Categoria>) request.getAttribute("listaCategorias");
                                for (Categoria categoria : listaCategorias) {
                            
      out.write("\n");
      out.write("                                <option value=\"");
      out.print( categoria.getId() );
      out.write('"');
      out.write(' ');
      out.print( categoria.getId() == comentario.getIdcategoria() ? "selected" : "" );
      out.write(">\n");
      out.write("                                ");
      out.print( categoria.getDescricao() );
      out.write("\n");
      out.write("                                </option>\n");
      out.write("                            ");
 } 
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                            ");
 } 
      out.write("\n");
      out.write("                        \n");
      out.write("                        <div>\n");
      out.write("                            <input type=\"submit\" name=\"btEnviar\" value=\"");
      out.print(acao);
      out.write("\" class=\"btn btn-primary\">\n");
      out.write("                            <a href=\"/aplicacaoMVC/admin/MostrarComentarios?acao=Listar\" class=\"btn btn-danger\">Retornar</a>\n");
      out.write("                        </div>\n");
      out.write("                            \n");
      out.write("                        \n");
      out.write("                            \n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("                \n");
      out.write("                            \n");
      out.write("            </div>\n");
      out.write("                \n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    <script src=\"http://localhost:8080/aplicacaoMVC/views/bootstrap/bootstrap.bundle.min.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
