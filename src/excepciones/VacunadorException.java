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
public class VacunadorException extends Exception {

    /**
     * Creates a new instance of <code>Vacunador</code> without detail message.
     */
    public VacunadorException() {
    }

    /**
     * Constructs an instance of <code>Vacunador</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public VacunadorException(String msg) {
        super(msg);
    }
}
