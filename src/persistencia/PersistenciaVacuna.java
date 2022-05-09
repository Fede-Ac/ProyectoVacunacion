/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import excepciones.PersistenciaException;
import excepciones.VacunasException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.Vacuna;
import logica.Vacunas;

/**
 *
 * @author Fede-PC
 */
public class PersistenciaVacuna {
    Conexion cc = new Conexion();
    Connection cn = cc.conectar();
    
    public String crearVacuna(Vacuna vacuna)throws VacunasException, PersistenciaException{
        try{
            PreparedStatement pst = cn.prepareStatement("INSERT INTO sistema_vacunacion.vacuna(nombre,cantidad_dosis,fecha_vencimiento,categoria)VALUES (?,?,?,?);");
            pst.setString(1, vacuna.getNombre());
            pst.setInt(2, vacuna.getCantidadDosis());
            pst.setDate(3, vacuna.getFechaVencimiento());
            pst.setInt(4, vacuna.getCategoria());
            pst.executeUpdate();
            cc.desconectar();
        }catch(SQLException ex){
            System.out.println("[ERROR]: \n" + ex.getSQLState() + " - " + ex.getMessage());
            throw new VacunasException ("Error al insertar una vacuna");
        }catch(Exception ex){
            System.out.println("[ERROR]: \n" + ex.getMessage());
            throw new PersistenciaException ("Ocurrio un error, contactese con soperte");
        }
        return "Añadida con exito";
    }
    
    public Vacunas consultar()throws VacunasException, PersistenciaException{
            Vacunas vacunas = new Vacunas();
        try {
            ResultSet resultado = cn.createStatement().executeQuery("SELECT * FROM vacuna"); 
            while (resultado.next()){
                Vacuna vacuna = new Vacuna();
                vacuna.setCodigo(resultado.getInt(1));
                vacuna.setNombre(resultado.getString(2));
                vacuna.setCantidadDosis(resultado.getInt(3));
                vacuna.setFechaVencimiento(resultado.getDate(4));
                vacuna.setCategoria(resultado.getInt(5));
                vacunas.setUno(vacuna);
            }
            cc.desconectar();
        }catch(SQLException ex){
            System.out.println("[ERROR]: \n" + ex.getSQLState() + " - " + ex.getMessage());
            throw new VacunasException ("Error al mostrar una vacuna");
        }catch(Exception ex){
            System.out.println("[ERROR]: \n" + ex.getMessage());
            throw new PersistenciaException ("Ocurrio un error, contactese con soperte");
        }
        return vacunas;
    }
    
    public void modificarVacuna(Vacuna vacuna)throws VacunasException, PersistenciaException{
        try{
            PreparedStatement pst = cn.prepareStatement("UPDATE sistema_vacunacion.vacuna SET nombre=?,cantidad_dosis=?,fecha_vencimiento=?,categoria=? WHERE codigo=?;");
            pst.setInt(5,vacuna.getCodigo());
            pst.setString(1, vacuna.getNombre());
            pst.setInt(2, vacuna.getCantidadDosis());
            pst.setString(3, vacuna.getFechaVencimiento().toString());
            pst.setInt(4, vacuna.getCategoria());
            pst.executeUpdate();
            cc.desconectar();
        }catch(SQLException ex){
            System.out.println("[ERROR]: \n" + ex.getSQLState() + " - " + ex.getMessage());
            throw new VacunasException ("Error al modificar una vacuna");
        }catch(Exception ex){
            System.out.println("[ERROR]: \n" + ex.getMessage());
            throw new PersistenciaException ("Ocurrio un error, contactese con soperte");
        }
    }
    
    public void borrarVacuna(int codigoVacuna) throws VacunasException, PersistenciaException {
        try{
            PreparedStatement pst = cn.prepareStatement ("delete from vacuna where codigo =?;");
            pst.setInt(1,codigoVacuna);
            pst.executeUpdate();
            cc.desconectar();
        }catch(SQLException ex){
            System.out.println("[ERROR]: \n" + ex.getSQLState() + " - " + ex.getMessage());
            throw new VacunasException ("Error al borrar una vacuna");
        }catch(Exception ex){
            System.out.println("[ERROR]: \n" + ex.getMessage());
            throw new PersistenciaException ("Ocurrio un error, contactese con soperte");
        }
    }    
}
