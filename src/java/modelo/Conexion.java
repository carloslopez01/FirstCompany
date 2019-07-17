package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 * @author Carlos Lopez
 * Version: 0.1 Alpha
 * Contacto: cl640900@gmail.com || carlos.lopez17@itca.edu.sv
 */
public class Conexion {
    private Connection conection = null;

    public Connection getConection() {
        return conection;
    }

    public Conexion() {
        
    }
    
    public void conectarBD()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/firstCompany", "root", "");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Causa: " + e.getCause()
                   + "\nMensaje: " + e.getMessage(), "Error al conectar a la base de datos",
                   JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void desconectarDB()
    {
        try {
            if( conection != null )
            {
                this.conection.close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Causa: " + e.getCause()
                   + "\nMensaje: " + e.getMessage(), "Error al desconectar a la base de datos",
                   JOptionPane.ERROR_MESSAGE);
        }
    }
}
