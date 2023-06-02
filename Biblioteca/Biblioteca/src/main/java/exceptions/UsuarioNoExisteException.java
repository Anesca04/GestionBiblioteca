package exceptions;

/**
 *
 * @author manbolq
 */
public class UsuarioNoExisteException extends Exception{
    public UsuarioNoExisteException(String mensaje){
        super(mensaje);
    }
}
