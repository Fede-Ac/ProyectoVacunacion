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
public class Vacunas {

    public ArrayList<Vacuna> getVacunas() {
        return vacunas;
    }

    public void setVacunas(ArrayList<Vacuna> vacunas) {
        this.vacunas = vacunas;
    }

    private ArrayList<Vacuna> vacunas = new ArrayList();

    public void setUno(Vacuna vacuna) {

        vacunas.add(vacuna);

    }

}
