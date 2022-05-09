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
public class Vacunados {
    
    public ArrayList<Vacunado> getVacunados(){
        return vacunados;
    }

    public void setVacunados(ArrayList<Vacunado> vacunados) {
        this.vacunados = vacunados;
    }
    
    private ArrayList<Vacunado> vacunados = new ArrayList();

    public void setVacunado(Vacunado vacunado){
        
        vacunados.add(vacunado);
        
    }
}
