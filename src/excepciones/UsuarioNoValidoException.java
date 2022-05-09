/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author Otros
 */
public class UsuarioNoValidoException extends Exception {

    /**
     * Creates a new instance of <code>UsuarioNoValidoException</code> without
     * detail message.
     */
    public UsuarioNoValidoException() {
    }

    /**
     * Constructs an instance of <code>UsuarioNoValidoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public UsuarioNoValidoException(String msg) {
        super(msg);
    }
}
