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
public class VacunadoException extends Exception {

    /**
     * Creates a new instance of <code>VacunadoException</code> without detail
     * message.
     */
    public VacunadoException() {
    }

    /**
     * Constructs an instance of <code>VacunadoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public VacunadoException(String msg) {
        super(msg);
    }
}
