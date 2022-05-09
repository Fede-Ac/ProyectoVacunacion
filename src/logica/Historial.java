/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Date;

/**
 *
 * @author Fede-PC
 */
public class Historial {
    int id;
    java.sql.Date fechaVacunacion;
    int vacunaInoculada;
    String personaVacunada;
    String centroSalud;

    public void setId(int id) {
        this.id = id;
    }

    public void setVacunaInoculada(int vacunaInoculada) {
        this.vacunaInoculada = vacunaInoculada;
    }

    public void setPersonaVacunada(String personaVacunada) {
        this.personaVacunada = personaVacunada;
    }

    public void setCentroSalud(String centroSalud) {
        this.centroSalud = centroSalud;
    }

    public int getId() {
        return id;
    }

    public java.sql.Date getFechaVacunacion() {
        return fechaVacunacion;
    }

    public void setFechaVacunacion(java.sql.Date fechaVacunacion) {
        this.fechaVacunacion = fechaVacunacion;
    }

    public int getVacunaInoculada() {
        return vacunaInoculada;
    }

    public String getPersonaVacunada() {
        return personaVacunada;
    }

    public String getCentroSalud() {
        return centroSalud;
    }

    public Historial() {
    }
}
