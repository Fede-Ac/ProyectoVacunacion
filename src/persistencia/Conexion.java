/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Otros
 */
public class Conexion {
    
    private static final String user = "root";
    private static final String pass = "root"; //Sdfghj2315";//"root" //"JCdm.22.AB"
    
    public Connection conectar() {

        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_vacunacion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", user, pass);
            System.out.println("Conexión establecida");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println("[ERROR]: \n" + ex.getSQLState() + " - " + ex.getMessage());
        } catch (Exception ex){
            System.out.println("Error: " + ex);
        }

        return con;
    }
    
    public void desconectar(){
        Connection con = null;
        if (con == null){
            System.out.println("Conexión terminada");
        }
    }
}
