/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import logica.Usuario;
/**
 *
 * @author Otros
 */
public class PersistenciaUsuario {
    
    private final static String SQL_CONSULTA = "select * from sistema_vacunacion.usuario where usuario=? and clave=?";

    public Boolean existeUsuario(Usuario usuario) {

        PreparedStatement st = null;
        ResultSet rs = null;
        Boolean existe= false;
        try {

            Conexion con = new Conexion();
            st = (PreparedStatement) con.conectar().prepareStatement(SQL_CONSULTA);
            st.setString(1, usuario.getUsuario());
            st.setString(2, usuario.getClave());
            rs = st.executeQuery();
            while (rs.next()){
            existe=true;
            }
            con.desconectar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return existe;
    }
}
