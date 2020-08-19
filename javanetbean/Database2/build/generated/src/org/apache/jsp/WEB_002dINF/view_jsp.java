package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import web.module.connect.KetNoi;

public final class view_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>HOME</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>WELCOME</h1>\n");
      out.write("\n");
      out.write("        <div align=\"center\">\n");
      out.write("            <table border=\"1\" cellpadding=\"5\">\n");
      out.write("                <caption><h2>List of Student</h2></caption>\n");
      out.write("                <tr>\n");
      out.write("                    <th>StudentID</th>\n");
      out.write("                    <th>FirstName</th>\n");
      out.write("\n");
      out.write("                    <th>LastName</th>\n");
      out.write("                    <th>Address</th>\n");
      out.write("                    <th>Telephone</th>\n");
      out.write("                    <th>Email</th>\n");
      out.write("                    <th>Password</th>\n");
      out.write("                </tr>\n");
      out.write("                ");

                KetNoi conn = new KetNoi();
                ResultSet rs = conn.selectData("select * from Student");
                //int count = 1;
                while (rs.next()) {
                    out.println("<tr>");
                    
                    out.print("<th>" +rs.getString("StudentID")+ "</th>");
                    out.print("<th>" +rs.getString("FirstName")+ "</th>");
                    out.print("<th>" +rs.getString("LastName")+ "</th>");
                    out.print("<th>" +rs.getString("Address")+ "</th>");
                    out.print("<th>" +rs.getString("Telephone")+ "</th>");
                    out.print("<th>" +rs.getString("Email")+ "</th>");
                    out.print("<th>" +rs.getString("Password")+ "</th>");
                    out.println("");
                    out.println("</tr>");
                }
                
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
