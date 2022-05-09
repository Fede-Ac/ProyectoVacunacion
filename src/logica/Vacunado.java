/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.sql.Date;

/**
 *
 * @author Otros
 */
public class Vacunado {
    String documento;
    String nacionalidad;
    String direccion;
    String telefono;
    String email;
    java.sql.Date fechaNac;
    int vacunas;

    public String getDocumento() {
        return documento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public int getVacunas() {
        return vacunas;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public void setVacunas(int vacunas) {
        this.vacunas = vacunas;
    }
    
    
}
