/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author Fede-PC
 */
public class VacunasException extends Exception {

    /**
     * Creates a new instance of <code>VacunasException</code> without detail
     * message.
     */
    public VacunasException() {
    }

    /**
     * Constructs an instance of <code>VacunasException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public VacunasException(String msg) {
        super(msg);
    }
}
