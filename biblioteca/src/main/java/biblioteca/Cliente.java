package biblioteca;

import java.util.ArrayList;
import exceptions.DNIInvalidoException;
import exceptions.EdadInvalidaException;
import exceptions.TelefonoInvalidoException;

/**
 * La clase Cliente representa a un cliente en la biblioteca.
 * Hereda los atributos y métodos de la clase Usuario.
 * Además, agrega atributos específicos como el ID de cliente, una lista de libros prestados y un número de teléfono.
 * Proporciona métodos para acceder y modificar esta información, así como métodos para añadir y quitar libros prestados.
 * También implementa el método toString() para obtener una representación en cadena del cliente.
 * 
 * Esta clase es parte de un programa de gestión de bibliotecas.
 * 
 * @author manbolq
 */
public class Cliente extends Usuario {
    private ArrayList<Libro> librosPrestados;   // Lista de libros prestados al cliente
    private String numTelefono;                 // Número de teléfono del cliente
    
    /**
     * Constructor sin parámetros de la clase Cliente.
     * Inicializa los atributos con valores predeterminados.
     * Llama al constructor sin parámetros de la clase padre (Usuario) usando la palabra clave super().
     * Inicializa la lista de libros prestados como una nueva instancia de ArrayList.
     */
    public Cliente() {
        super();
        this.librosPrestados = new ArrayList<>();
        this.numTelefono = "";
    }
    
    /**
     * Constructor de la clase Cliente.
     * Inicializa los atributos con los valores especificados.
     * Llama al constructor de la clase padre (Usuario) usando la palabra clave super().
     * Inicializa la lista de libros prestados como una nueva instancia de ArrayList.
     * 
     * @param nombre Nombre del cliente
     * @param dni DNI del cliente
     * @param edad Edad del cliente
     * @param numTelefono Número de teléfono del cliente
     */
    public Cliente(String nombre, String dni, int edad, String numTelefono) throws DNIInvalidoException, TelefonoInvalidoException, EdadInvalidaException{        
        super(nombre, dni, edad);
        
        if (!Cliente.telefonoValido(numTelefono))
            throw new TelefonoInvalidoException("El telefono no tiene un formato correcto");
        
        this.librosPrestados = new ArrayList<>();
        this.numTelefono = numTelefono;
    }
    
    /**
     * Constructor de la clase Cliente.
     * Inicializa los atributos con los valores especificados.
     * Llama al constructor de la clase padre (Usuario) usando la palabra clave super().
     * 
     * @param nombre Nombre del cliente
     * @param dni DNI del cliente
     * @param edad Edad del cliente
     * @param librosPrestados Lista de libros prestados al cliente
     * @param numTelefono Número de teléfono del cliente
     */
    public Cliente(String nombre, String dni, int edad, ArrayList<Libro> librosPrestados, String numTelefono) throws DNIInvalidoException, TelefonoInvalidoException, EdadInvalidaException{
        super(nombre, dni, edad);
        
        if (!Cliente.telefonoValido(numTelefono))
            throw new TelefonoInvalidoException("El telefono no tiene un formato correcto");
        
        this.librosPrestados = librosPrestados;
        this.numTelefono = numTelefono;
    }
    
    /**
     * Getter para obtener la lista de libros prestados al cliente.
     * 
     * @return La lista de libros prestados al cliente
     */
    public ArrayList<Libro> getLibrosPrestados() {
        return this.librosPrestados;
    }
    
    /**
     * Getter para obtener el número de teléfono del cliente.
     * 
     * @return El número de teléfono del cliente
     */
    public String getNumTelefono() {
        return this.numTelefono;
    }

    
    /**
     * Setter para modificar la lista de libros prestados al cliente.
     * 
     * @param librosPrestados La nueva lista de libros prestados al cliente
     */
    public void setLibrosPrestados(ArrayList<Libro> librosPrestados) {
        this.librosPrestados = librosPrestados;
    }
    
    /**
     * Setter para modificar el número de teléfono del cliente.
     * 
     * @param numTelefono El nuevo número de teléfono del cliente
     */
    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }
    
    /**
     * Método toString() que devuelve una representación en cadena del cliente.
     * La representación incluye la información del cliente y los atributos adicionales (ID de cliente, libros prestados, número de teléfono).
     * 
     * @return Una cadena que representa al cliente
     */
    @Override
    public String toString() {
        String res = super.toString();  // Llama al método toString() de la clase padre (Usuario)
        res += "\nLibros prestados:";
        
        for (Libro libro : librosPrestados) {
            res += "\n\t- " + libro.toString();
        }
        
        res += "\nNum. Telefono: " + numTelefono;
        
        return res;
    }
    
    /**
     * Método que añade un libro prestado al cliente.
     * 
     * @param libro El libro que se va a añadir a la lista de libros prestados
     */
    public void aniadirLibro(Libro libro) {
        librosPrestados.add(libro);
    }
    
    /**
     * Método para quitar un libro prestado al cliente (lo ha devuelto).
     * 
     * @param libro El libro que se va a quitar de la lista de libros prestados
     */
    public void quitarLibro(Libro libro) {
        librosPrestados.remove(libro);
    }
    
    private static boolean telefonoValido(String numTelefono){
        boolean valido = numTelefono.length() == 9;
        
        if (valido){
            for (int i = 0; i < numTelefono.length(); i++){
                if (!('0' <= numTelefono.charAt(i) && numTelefono.charAt(i) <= '9')){
                    valido = false;
                }
            }
        }
        
        return valido;
    }
}