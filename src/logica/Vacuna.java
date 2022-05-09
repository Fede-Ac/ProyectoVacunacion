/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;


/**
 *
 * @author Fede-PC
 */
public class Vacuna {
    int codigo;
    String nombre;
    int cantidadDosis;
    java.sql.Date fechaVencimiento;//para que sea compatible con el formato de la BBDD
    int categoria;

    public Vacuna() {}

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadDosis() {
        return cantidadDosis;
    }

    public java.sql.Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidadDosis(int cantidadDosis) {
        this.cantidadDosis = cantidadDosis;
    }

    public void setFechaVencimiento(java.sql.Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
    
    
}
