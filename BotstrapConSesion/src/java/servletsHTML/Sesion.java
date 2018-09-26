package servletsHTML;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class Sesion extends HttpServlet {   
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    String Correoelec = request.getParameter("Correo");
    String Contraseña = request.getParameter("Cont");
        HttpSession sesion = request.getSession();
        sesion.setAttribute("Correo", Correoelec);
        sesion.setAttribute("Contraseña", Contraseña);
        response.setContentType("text/html");
      response.sendRedirect("http://localhost:8080/BotstrapConSesion/Validacion");
  
    }
   

}
