package Conn;

import static java.io.FileDescriptor.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Basse {
    String url = "jdbc:mysql://localhost/lab3";
    String usr = "root";
    String pass = "n0m3l0";
    Connection cone = null;
    Statement stat = null;
    ResultSet r = null;   
    String tipo;   
    public Connection getConnection()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException ex)
        {
            System.out.print("Error class not found");
        }
        
        try
        {
            cone= DriverManager.getConnection(url, usr, pass);
        }
        catch(SQLException e)
        {
            System.out.println("Conexion error" + e.getMessage());
        }
            
        return cone;
    }
    
    public void cerrar() throws SQLException {
        cone.close();
    }   
    public boolean ConectaR (String Usuario, String Contraseña)
    {
        boolean valida = false;
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            cone = DriverManager.getConnection(url, usr, pass);
        } 
        catch (Exception e) 
        {
            System.out.println("Error de conexió" + e.toString());
        }
        
        try 
        {
            stat = cone.createStatement();
            r = stat.executeQuery("select * from Usuarios where usuario = '" + Usuario + "' and contraseña = '" + Contraseña + "'");
            
            
            if(r.next())
            {
                valida = true;
            }
            else
                valida = false;
        } 
        catch (Exception e) 
        {
            System.out.println("Error: " + e.toString());
        }
        
        return valida;
    }    
    public String OBtipo(String Usuario)
    {
        String tipo="";
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, usr, pass);
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery ("select * from Usuarios where usuario = '" + Usuario + "'"); 
                     while(rs.next()){
                     tipo =  rs.getString("tipo");}
        } 
        catch (Exception e) 
        {
            System.out.println("Error en la conexión" + e.toString());
        }
    return tipo;
    }
}
