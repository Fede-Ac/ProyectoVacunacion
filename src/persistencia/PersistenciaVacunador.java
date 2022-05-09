/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import excepciones.PersistenciaException;
import excepciones.VacunadorException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import logica.Vacunador;
import logica.Vacunadores;

/**
 *
 * @author Otros
 */
public class PersistenciaVacunador {
    Conexion cc = new Conexion();
    Connection cn = cc.conectar();
    
    public Vacunadores consultar() throws VacunadorException, PersistenciaException{
        Vacunadores vacunadores = new Vacunadores();
        try {
            ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM vacunador");
            while (rs.next()){
                Vacunador vacunador = new Vacunador();
                vacunador.setCodigo(rs.getInt(1));
                vacunador.setNombre(rs.getString(2));
                vacunador.setTurno(rs.getInt(3));
                vacunadores.setVacunador(vacunador);
            }
            cc.desconectar();
        }catch(SQLException ex){
            System.out.println("[ERROR]: \n" + ex.getSQLState() + " - " + ex.getMessage());
            throw new VacunadorException ("Error al mostrar un vacunador");
        }catch(Exception ex){
            System.out.println("[ERROR]: \n" + ex.getMessage());
            throw new PersistenciaException ("Ocurrio un error, contactese con soperte");
        }
        return vacunadores;
    }
    
    public void agregarVacunador(Vacunadores vacunador) throws PersistenciaException, VacunadorException{
        try{
            PreparedStatement pst = cn.prepareStatement("INSERT INTO sistema_vacunacion.vacunador (nombre,turno) VALUES (?,?);");
            pst.setString(1, vacunador.getNombre());
            pst.setInt(2, vacunador.getTurno());
            pst.executeUpdate();
            cc.desconectar();
        }catch(SQLException ex){
            System.out.println("[ERROR]: \n" + ex.getSQLState() + " - " + ex.getMessage());
            throw new VacunadorException ("Error al añadir un vacunador");
        }catch(Exception ex){
            System.out.println("[ERROR]: \n" + ex.getMessage());
            throw new PersistenciaException ("Ocurrio un error, contactese con soperte");
        }
    }
    
    public void modificarVacunador(Vacunadores vacunador) throws PersistenciaException, VacunadorException{
        try{
            PreparedStatement pst = cn.prepareStatement("UPDATE sistema_vacunacion.vacunador SET nombre=?, turno=? WHERE codigo=?;");
            pst.setString(1, vacunador.getNombre());
            pst.setInt(2, vacunador.getTurno());
            pst.setInt(3,vacunador.getCodigo());
            pst.executeUpdate();
            cc.desconectar();
        }catch(SQLException ex){
            System.out.println("[ERROR]: \n" + ex.getSQLState() + " - " + ex.getMessage());
            throw new VacunadorException ("Error al modificar un vacunador");
        }catch(Exception ex){
            System.out.println("[ERROR]: \n" + ex.getMessage());
            throw new PersistenciaException ("Ocurrio un error, contactese con soperte");
        }
    }
    public void borrarVacunador(int codigoVacunador) throws VacunadorException, PersistenciaException {
        try{
            PreparedStatement pst = cn.prepareStatement ("delete from vacunador where codigo =?;");
            pst.setInt(1,codigoVacunador);
            pst.executeUpdate();
            cc.desconectar();
        }catch(SQLException ex){
            System.out.println("[ERROR]: \n" + ex.getSQLState() + " - " + ex.getMessage());
            throw new VacunadorException ("Error al borrar un vacunador");
        }catch(Exception ex){
            System.out.println("[ERROR]: \n" + ex.getMessage());
            throw new PersistenciaException ("Ocurrio un error, contactese con soperte");
        }
    }
    
        public ArrayList listVacunadosTurno(int turno) throws VacunadorException, PersistenciaException {
            ArrayList<Vacunador> vacunadores = new ArrayList<>();
            try{
                ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM sistema_vacunacion.vacunador where turno="+ turno +";");
                int i=0;
                while (rs.next()){
                    Vacunador vacunador = new Vacunador();
                    vacunador.setCodigo(rs.getInt(1));
                    vacunador.setNombre(rs.getString(2));
                    vacunador.setTurno(rs.getInt(3));
                    vacunadores.add(vacunador);
                    i++;
                }
                cc.desconectar();
        }catch(SQLException ex){
            System.out.println("[ERROR]: \n" + ex.getSQLState() + " - " + ex.getMessage());
            throw new VacunadorException ("Error al listar vacunadores");
        }catch(Exception ex){
            System.out.println("[ERROR]: \n" + ex.getMessage());
            throw new PersistenciaException ("Ocurrio un error, contactese con soperte");
        }
        return vacunadores;
    }
}
