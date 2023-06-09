package biblioteca;

import exceptions.DNIInvalidoException;
import exceptions.EdadInvalidaException;

/**
 * La clase Usuario representa a un usuario de la biblioteca.
 * Almacena información como el nombre, DNI y edad del usuario.
 * Proporciona métodos para acceder y modificar esta información.
 * También implementa el método toString() para obtener una representación en cadena del usuario.
 * 
 * Esta clase es parte de un programa de gestión de bibliotecas.
 * 
 * @author manbolq
 */
public class Usuario {
    private String nombre;   // Nombre del usuario
    private String dni;      // DNI del usuario
    private int edad;        // Edad del usuario
    
    /**
     * Constructor sin parámetros de la clase Usuario.
     * Inicializa los atributos con valores predeterminados.
     */
    public Usuario(){
        this.nombre = "";
        this.dni = "";
        this.edad = 0;
    }
    
    /**
     * Constructor de la clase Usuario.
     * Inicializa los atributos con los valores especificados.
     * 
     * @param nombre Nombre del usuario
     * @param dni DNI del usuario
     * @param edad Edad del usuario
     */
    public Usuario(String nombre, String dni, int edad) throws DNIInvalidoException, EdadInvalidaException{
        if (!Usuario.dniValido(dni))
            throw new DNIInvalidoException("El formato del DNI no es correcto");
        
        if (!Usuario.edadValida(edad))
            throw new EdadInvalidaException("La edad introducida no es correcta");
        
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }
    
    /**
     * Getter para obtener el nombre del usuario.
     * 
     * @return El nombre del usuario
     */
    public String getNombre(){
        return this.nombre;
    }
    
    /**
     * Getter para obtener el DNI del usuario.
     * 
     * @return El DNI del usuario
     */
    public String getDni(){
        return this.dni;
    }
    
    /**
     * Getter para obtener la edad del usuario.
     * 
     * @return La edad del usuario
     */
    public int getEdad(){
        return this.edad;
    }    
    
    /**
     * Setter para modificar el nombre del usuario.
     * 
     * @param nombre El nuevo nombre del usuario
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    /**
     * Setter para modificar el DNI del usuario.
     * 
     * @param dni El nuevo DNI del usuario
     */
    public void setDni(String dni){
        this.dni = dni;
    }
    
    /**
     * Setter para modificar la edad del usuario.
     * 
     * @param edad La nueva edad del usuario
     */
    public void setEdad(int edad){
        this.edad = edad;
    }
    
    /**
     * Método toString() que devuelve una representación en cadena del usuario.
     * La representación incluye el nombre, DNI y edad del usuario.
     * 
     * @return Una cadena que representa al usuario
     */
    @Override
    public String toString(){
        return "Nombre: " + nombre + "\nDNI: " + dni + "\nEdad: " + edad;
    }
    
    
    public static boolean dniValido(String dni){
        boolean esValido = dni.length() == 9; // 33333333C
        
        if (esValido){
            
            for (int i = 0; i < 8; i++){
                if (!('0' <= dni.charAt(i) && dni.charAt(i) <= '9')){
                    esValido = false;
                }
            }
            
            if (!(('A' <= dni.charAt(8) && dni.charAt(8) <= 'Z') || ('a' <= dni.charAt(8) && dni.charAt(8) <= 'z'))){
                esValido = false;
            }
        }
        
        return esValido;
    }
    
    public static boolean edadValida(int edad){
        return (1 <= edad && edad <= 100);
    }
}