package biblioteca;

/**
 * La clase Libro representa un libro en una biblioteca.
 * Contiene información como título, autor, editorial y número de páginas.
 * También proporciona métodos para acceder y modificar esta información.
 * Además, implementa el método toString() para obtener una representación en cadena del libro.
 * 
 * Esta clase es parte de un programa de gestión de bibliotecas.
 * 
 * @author manbolq
 */
public class Libro {
    private String titulo;           // Título del libro
    private Escritor autor;          // Autor del libro (clase Escritor)
    private String editorial;        // Editorial del libro
    private int numPaginas;          // Número de páginas del libro
    
    /**
     * Constructor vacío de la clase Libro.
     * Inicializa los atributos con valores predeterminados.
     */
    public Libro(){
        titulo = "";
        autor = new Escritor();       // Crea un nuevo objeto Escritor vacío
        editorial = "";
        numPaginas = 0;
    }
    
    /**
     * Constructor de la clase Libro.
     * Inicializa los atributos con los valores especificados.
     * 
     * @param titulo Título del libro
     * @param editorial Editorial del libro
     * @param numPaginas Número de páginas del libro
     */
    public Libro(String titulo, String editorial, int numPaginas){
        this.titulo = titulo;
        this.autor = new Escritor();       // Crea un nuevo objeto Escritor vacío
        this.editorial = editorial;
        this.numPaginas = numPaginas;
    }
    
    /**
     * Constructor de la clase Libro.
     * Inicializa los atributos con los valores especificados.
     * 
     * @param titulo Título del libro
     * @param autor Autor del libro (objeto de la clase Escritor)
     * @param editorial Editorial del libro
     * @param numPaginas Número de páginas del libro
     */
    public Libro(String titulo, Escritor autor, String editorial, int numPaginas){
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.numPaginas = numPaginas;
    }
    
    /**
     * Getter para obtener el título del libro.
     * 
     * @return El título del libro
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Getter para obtener el autor del libro.
     * 
     * @return El autor del libro (objeto de la clase Escritor)
     */
    public Escritor getAutor() {
        return autor;
    }

    /**
     * Getter para obtener la editorial del libro.
     * 
     * @return La editorial del libro
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * Getter para obtener el número de páginas del libro.
     * 
     * @return El número de páginas del libro
     */
    public int getNumPaginas() {
        return numPaginas;
    }
    
    /**
     * Setter para modificar el título del libro.
     * 
     * @param titulo El nuevo título del libro
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Setter para modificar el autor del libro.
     * 
     * @param autor El nuevo autor del libro (objeto de la clase Escritor)
     */
    public void setAutor(Escritor autor) {
        this.autor = autor;
    }

    /**
     * Setter para modificar la editorial del libro.
     * 
     * @param editorial La nueva editorial del libro
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     * Setter para modificar el número de páginas del libro.
     * 
     * @param numPaginas El nuevo número de páginas del libro
     */
    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }
    
    /**
     * Método toString() que devuelve una representación en cadena del libro.
     * La representación incluye el título, el nombre del autor, la editorial y el número de páginas.
     * 
     * @return Una cadena que representa el libro
     */
    @Override
    public String toString(){
        return titulo + ", " + autor.getNombre() + ", " + editorial + ", " + numPaginas;
    }
}