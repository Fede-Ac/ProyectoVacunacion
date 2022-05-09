/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;

/**
 *
 * @author Otros
 */
public class Vacunadores {
    
    private int codigo;
    
    private String nombre;

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTurno() {
        return turno;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }
    
    private int turno;
    
    public ArrayList<Vacunador> getVacunadores(){
        return vacunadores;
    }

    public void setVacunadores(ArrayList<Vacunador> vacunadores) {
        this.vacunadores = vacunadores;
    }
    
    private ArrayList<Vacunador> vacunadores = new ArrayList();

    public void setVacunador(Vacunador vacunador){
        
        vacunadores.add(vacunador);
        
    }
}