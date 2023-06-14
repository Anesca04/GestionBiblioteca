package exceptions;

/**
 *
 * @author manbolq
 */
public class LibroNoExisteException extends Exception{
    public LibroNoExisteException(String mensaje){
        super(mensaje);
    }
}
