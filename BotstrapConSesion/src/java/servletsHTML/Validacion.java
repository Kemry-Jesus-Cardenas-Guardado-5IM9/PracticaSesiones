
package servletsHTML;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Conn.Basse;
public class Validacion extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
      response.setContentType("text/html");
      HttpSession sesion = request.getSession();
      Basse Conectar = new Basse();
      String titulo = null;
      String Usua = (String)sesion.getAttribute("Correoelec");
      String Contra = (String)sesion.getAttribute("Contraseña");     
      if(Conectar.ConectaR(Usua, Contra)){          
        out.println("<h2> Usuario" + Conectar.OBtipo(Usua) + "</h2>");        
        if(Conectar.OBtipo(Usua).equals("admin"))
        {
            out.println("Pag publica");
            out.println("Admin 1");
        }
        else
            if(Conectar.OBtipo(Usua).equals("invitado"))
            {
                out.println("Pagina de inviados");
                out.println("Pag inv 1");
            }            
      }
      else
      {
          titulo = "Error sesion not found" ;
          out.println("<h1>" + titulo + "</h1>");         
      }
    }
}
