package biblioteca;

import exceptions.DNIInvalidoException;
import exceptions.EdadInvalidaException;
import java.util.ArrayList;

/**
 * La clase Escritor representa a un escritor en la biblioteca.
 * Hereda los atributos y métodos de la clase Usuario.
 * Además, agrega atributos específicos como una lista de libros publicados y un idioma.
 * Proporciona métodos para acceder y modificar esta información, así como un método para añadir un libro publicado.
 * También implementa el método toString() para obtener una representación en cadena del escritor.
 * 
 * Esta clase es parte de un programa de gestión de bibliotecas.
 * 
 * @author manbolq
 */
public class Escritor extends Usuario {
    private ArrayList<Libro> librosPublicados;  // Lista de libros publicados por el escritor
    private String idioma;                      // Idioma del escritor
    
    /**
     * Constructor sin parámetros de la clase Escritor.
     * Inicializa los atributos con valores predeterminados.
     * Llama al constructor sin parámetros de la clase padre (Usuario) usando la palabra clave super().
     * Inicializa la lista de libros publicados como una nueva instancia de ArrayList.
     */
    public Escritor() {
        super();
        this.librosPublicados = new ArrayList<>();
        this.idioma = "";
    }
    
    /**
     * Constructor de la clase Escritor.
     * Inicializa los atributos con los valores especificados.
     * Llama al constructor de la clase padre (Usuario) usando la palabra clave super().
     * Inicializa la lista de libros publicados como una nueva instancia de ArrayList.
     * 
     * @param nombre Nombre del escritor
     * @param dni DNI del escritor
     * @param edad Edad del escritor
     * @param idioma Idioma del escritor
     */
    public Escritor(String nombre, String dni, int edad, String idioma) throws DNIInvalidoException, EdadInvalidaException{
        super(nombre, dni, edad);
        this.librosPublicados = new ArrayList<>();
        this.idioma = idioma;
    }
    
    /**
     * Constructor de la clase Escritor.
     * Inicializa los atributos con los valores especificados.
     * Llama al constructor de la clase padre (Usuario) usando la palabra clave super().
     * 
     * @param nombre Nombre del escritor
     * @param dni DNI del escritor
     * @param edad Edad del escritor
     * @param librosPublicados Lista de libros publicados por el escritor
     * @param idioma Idioma del escritor
     */
    public Escritor(String nombre, String dni, int edad, ArrayList<Libro> librosPublicados, String idioma) throws DNIInvalidoException, EdadInvalidaException{
        super(nombre, dni, edad);
        this.librosPublicados = librosPublicados;
        this.idioma = idioma;
    }
    
    /**
     * Getter para obtener la lista de libros publicados por el escritor.
     * 
     * @return La lista de libros publicados por el escritor
     */
    public ArrayList<Libro> getLibrosPublicados() {
        return this.librosPublicados;
    }
    
    /**
     * Getter para obtener el idioma del escritor.
     * 
     * @return El idioma del escritor
     */
    public String getIdioma() {
        return this.idioma;
    }
    
    /**
     * Setter para modificar la lista de libros publicados por el escritor.
     * 
     * @param librosPublicados La nueva lista de libros publicados por el escritor
     */
    public void setLibrosPublicados(ArrayList<Libro> librosPublicados) {
        this.librosPublicados = librosPublicados;
    }
    
    /**
     * Setter para modificar el idioma del escritor.
     * 
     * @param idioma El nuevo idioma del escritor
     */
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    
    /**
     * Método toString() que devuelve una representación en cadena del escritor.
     * La representación incluye la información del escritor y los atributos adicionales (idioma y libros publicados).
     * 
     * @return Una cadena que representa al escritor
     */
    @Override
    public String toString() {
        String res = super.toString();  // Llama al método toString() de la clase padre (Usuario)
        res += "\nIdioma: " + idioma;
        res += "\nLibros publicados:";
        
        for (Libro libro : librosPublicados) {
            res += "\n\t- " + libro.toString();
        }
        
        return res;
    }
    
    /**
     * Método que añade un libro publicado por el escritor a la lista de libros publicados.
     * 
     * @param libro El libro publicado que se va a añadir
     */
    public void aniadeLibro(Libro libro) {
        librosPublicados.add(libro);
    }
}