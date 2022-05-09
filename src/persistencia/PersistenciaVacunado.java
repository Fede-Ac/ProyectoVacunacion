/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import excepciones.PersistenciaException;
import excepciones.VacunadoException;
import excepciones.VacunasException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import logica.Historial;
import logica.Vacunado;
import logica.Vacunado;
import logica.Vacunados;

/**
 *
 * @author Otros
 */
public class PersistenciaVacunado {
    Conexion cc = new Conexion();
    Connection cn = cc.conectar();
    
    public Vacunados consultar(){
        
        try {
            Vacunados vacunados = new Vacunados();
            ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM vacunado");
            while (rs.next()){
                Vacunado vacunado = new Vacunado();
                vacunado.setDocumento(rs.getString(1));
                vacunado.setNacionalidad(rs.getString(2));
                vacunado.setDireccion(rs.getString(3));
                vacunado.setTelefono(rs.getString(4));
                vacunado.setEmail(rs.getString(5));
                vacunado.setFechaNac(rs.getDate(6));
                vacunado.setVacunas(rs.getInt(7));
                vacunados.setVacunado(vacunado);
            }
            cc.desconectar();
            return vacunados;
        } catch (SQLException ex) {
            System.out.println("[ERROR]: \n" + ex.getSQLState() + " - " + ex.getMessage());
            return null;
        }
        
    }
    
    public void agregarVacunado(Vacunado vacunado) throws PersistenciaException, VacunadoException {
        try{
            PreparedStatement pst = cn.prepareStatement("INSERT INTO sistema_vacunacion.vacunado (documento,nacionalidad,direccion,telefono,email,fecha_nacimiento,vacunas_otorgadas) VALUES(?,?,?,?,?,?,?);");
            pst.setString(1, vacunado.getDocumento());
            pst.setString(2, vacunado.getNacionalidad());
            pst.setString(3, vacunado.getDireccion());
            pst.setString(4, vacunado.getTelefono());
            pst.setString(5, vacunado.getEmail());
            pst.setString(6, vacunado.getFechaNac().toString());
            pst.setInt(7, vacunado.getVacunas());
            pst.executeUpdate();
            cc.desconectar();
        }catch(SQLException ex){
            System.out.println("[ERROR]: \n" + ex.getSQLState() + " - " + ex.getMessage());
            throw new VacunadoException ("Error al insertar un vacunado");
        }catch(Exception ex){
            System.out.println("[ERROR]: \n" + ex.getMessage());
            throw new PersistenciaException ("Ocurrio un error, contactese con soperte");
        }
    }
    
    
    public void modificarVacunado(Vacunado vacunado) throws VacunadoException, PersistenciaException {
        try{
            PreparedStatement pst = cn.prepareStatement("UPDATE sistema_vacunacion.vacunado SET documento = ?,nacionalidad = ?,direccion = ?,telefono = ?,email = ?,fecha_nacimiento = ?,vacunas_otorgadas = ? WHERE documento = ?;");
            pst.setString(1, vacunado.getDocumento());
            pst.setString(2, vacunado.getNacionalidad());
            pst.setString(3, vacunado.getDireccion());
            pst.setString(4, vacunado.getTelefono());
            pst.setString(5, vacunado.getEmail());
            pst.setString(6, vacunado.getFechaNac().toString());
            pst.setInt(7, vacunado.getVacunas());
            pst.setString(8, vacunado.getDocumento());
            pst.executeUpdate();
            cc.desconectar();
        }catch(SQLException ex){
            System.out.println("[ERROR]: \n" + ex.getSQLState() + " - " + ex.getMessage());
            throw new VacunadoException ("Error al modificar un vacunado");
        }catch(Exception ex){
            System.out.println("[ERROR]: \n" + ex.getMessage());
            throw new PersistenciaException ("Ocurrio un error, contactese con soperte");
        }
    }
    
    public void borrarVacunado(String documento) throws VacunadoException, PersistenciaException{
        try{
            PreparedStatement pst = cn.prepareStatement ("delete from sistema_vacunacion.vacunado where documento=?;");
            pst.setString(1,documento);
            pst.executeUpdate();
            cc.desconectar();
        }catch(SQLException ex){
            System.out.println("[ERROR]: \n" + ex.getSQLState() + " - " + ex.getMessage());
            throw new VacunadoException ("Error al borrar un vacunado");
        }catch(Exception ex){
            System.out.println("[ERROR]: \n" + ex.getMessage());
            throw new PersistenciaException ("Ocurrio un error, contactese con soperte");
        }
    }

    public ArrayList<Historial> listVacunadofecha(String fechaI,String fechaF) throws VacunadoException, PersistenciaException {
        ArrayList<Historial> vacunados = new ArrayList<>();
        try{
            ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM sistema_vacunacion.historial WHERE fecha_vacunacion>='"+fechaI+"' AND fecha_vacunacion<='"+fechaF+"';");
                int i=0;
                while (rs.next()){
                    Historial vacunado = new Historial();
                    vacunado.setId(rs.getInt(1));
                    vacunado.setFechaVacunacion(rs.getDate(2));
                    vacunado.setVacunaInoculada(rs.getInt(3));
                    vacunado.setPersonaVacunada(rs.getString(4));
                    vacunado.setCentroSalud(rs.getString(5));
                    vacunados.add(vacunado);
                    i++;
                }            
            cc.desconectar();
        }catch(SQLException ex){
            System.out.println("[ERROR]: \n" + ex.getSQLState() + " - " + ex.getMessage());
            throw new VacunadoException ("Error al listar vacunados");
        }catch(Exception ex){
            System.out.println("[ERROR]: \n" + ex.getMessage());
            throw new PersistenciaException ("Ocurrio un error, contactese con soperte");
        }

        return vacunados;
    }

    public ArrayList listVacunadoPersona(String documento) throws VacunadoException, PersistenciaException {
        ArrayList<Historial> vacunados = new ArrayList<>();
        try{
            ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM sistema_vacunacion.historial WHERE persona_vacunada='"+documento+"';");
                int i=0;
                while (rs.next()){
                    Historial vacunado = new Historial();
                    vacunado.setId(rs.getInt(1));
                    vacunado.setFechaVacunacion(rs.getDate(2));
                    vacunado.setVacunaInoculada(rs.getInt(3));
                    vacunado.setPersonaVacunada(rs.getString(4));
                    vacunado.setCentroSalud(rs.getString(5));
                    vacunados.add(vacunado);
                    i++;
                }            
            cc.desconectar();
        }catch(SQLException ex){
            System.out.println("[ERROR]: \n" + ex.getSQLState() + " - " + ex.getMessage());
            throw new VacunadoException ("Error al listar vacunados");
        }catch(Exception ex){
            System.out.println("[ERROR]: \n" + ex.getMessage());
            throw new PersistenciaException ("Ocurrio un error, contactese con soperte");
        }

        return vacunados;        
    }


}
