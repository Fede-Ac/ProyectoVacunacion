/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;
import excepciones.PersistenciaException;
import excepciones.VacunadoException;
import excepciones.VacunadorException;
import excepciones.VacunasException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTextField;
import persistencia.PersistenciaUsuario;
import persistencia.PersistenciaVacuna;
import logica.Vacuna;
import persistencia.PersistenciaVacunado;
import persistencia.PersistenciaVacunador;

/**
 *
 * @author Otros
 */
public class FachadaLogica {
    
    public static Boolean existeUsuario(Usuario usuario){
        Boolean resultado = false;
        PersistenciaUsuario pers = new PersistenciaUsuario();
    
        resultado = pers.existeUsuario(usuario);
    
        return resultado;
    }
    
    //limita los caracteres que se pueden escribir en un campo
    public static void maxText(JTextField campo, int max){
        if(campo.getText().length() >= max){
            campo.setText(campo.getText().substring(0, max));            
        }
    }
    
    public static String crearVacuna(Vacuna vacuna) throws VacunasException, PersistenciaException{
        PersistenciaVacuna pers = new PersistenciaVacuna();
        return pers.crearVacuna(vacuna);
    }
    
    public static void modificarVacuna(Vacuna vacuna) throws PersistenciaException, VacunasException{
        PersistenciaVacuna pers = new PersistenciaVacuna();
        pers.modificarVacuna(vacuna);            
    }
    
    public static void borrarVacuna(int codigoVacuna) throws VacunasException, PersistenciaException{       
        PersistenciaVacuna pers = new PersistenciaVacuna();
        pers.borrarVacuna(codigoVacuna);
    }     
    
    public static void agregarVacunador(Vacunadores vacunador) throws PersistenciaException, VacunadorException{
       PersistenciaVacunador pers = new PersistenciaVacunador();
       pers.agregarVacunador(vacunador);    
    }
    
    public static void modificarVacunador(Vacunadores vacunador) throws PersistenciaException, VacunadorException{
       PersistenciaVacunador pers = new PersistenciaVacunador();
       pers.modificarVacunador(vacunador);            
    }
   
    public static void borrarVacunador(int codigoVacunador) throws VacunadorException, PersistenciaException{
        PersistenciaVacunador pers = new PersistenciaVacunador();
        pers.borrarVacunador(codigoVacunador);
    }
    
    public static void agregarVacunador(Vacunado vacunado) throws PersistenciaException, VacunadoException{
        PersistenciaVacunado pers = new PersistenciaVacunado();
        pers.agregarVacunado(vacunado);
    }
    
    public static void modificarVacunado(Vacunado vacunado) throws PersistenciaException, VacunadoException{
        PersistenciaVacunado pers = new PersistenciaVacunado();
        pers.modificarVacunado(vacunado);
    }
    
    public static void borrarVacunado(String documento) throws VacunadoException, PersistenciaException{    
        PersistenciaVacunado pers = new PersistenciaVacunado();
        pers.borrarVacunado(documento);
    }

    public static ArrayList<Vacunador> listVacunadosTurno(int turno) throws VacunadorException, PersistenciaException{
        PersistenciaVacunador pers = new PersistenciaVacunador();
        return pers.listVacunadosTurno(turno);
    }
    
    public static ArrayList<Historial> listVacunadofecha(String fechaI, String fechaF) throws VacunadoException, PersistenciaException{
        PersistenciaVacunado pers = new PersistenciaVacunado();
        return pers.listVacunadofecha(fechaI, fechaF);
    }

    public static ArrayList listVacunadoPersona(String documento) throws VacunadoException, PersistenciaException {
        PersistenciaVacunado pers = new PersistenciaVacunado();
        return pers.listVacunadoPersona(documento);
    }
}
