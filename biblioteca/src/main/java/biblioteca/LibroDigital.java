package biblioteca;

/**
 * La clase LibroDigital representa un libro en formato digital.
 * Es una subclase de la clase Libro y hereda sus atributos y métodos.
 * Además, agrega atributos adicionales como formato y tamaño en MB.
 * Proporciona métodos para acceder y modificar estos atributos.
 * También implementa el método toString() para obtener una representación en cadena del libro digital.
 * 
 * Esta clase es parte de un programa de gestión de bibliotecas.
 * 
 * @author manbolq
 */
public class LibroDigital extends Libro {
    private String formato;         // Formato del libro digital
    private int tamMB;              // Tamaño en megabytes del libro digital
    
    /**
     * Constructor de la clase LibroDigital.
     * Inicializa los atributos con los valores especificados.
     * Además, llama al constructor de la clase padre (Libro) para inicializar los atributos heredados.
     * 
     * @param titulo Título del libro digital
     * @param autor Autor del libro digital (objeto de la clase Escritor)
     * @param editorial Editorial del libro digital
     * @param numPaginas Número de páginas del libro digital
     * @param formato Formato del libro digital
     * @param tamMB Tamaño en megabytes del libro digital
     */
    public LibroDigital(String titulo, Escritor autor, String editorial, int numPaginas, String formato, int tamMB) {
        super(titulo, autor, editorial, numPaginas);   // Llama al constructor de la clase padre (Libro)
        this.formato = formato;
        this.tamMB = tamMB;
    }
    
    /**
     * Getter para obtener el formato del libro digital.
     * 
     * @return El formato del libro digital
     */
    public String getFormato() {
        return this.formato;
    }
    
    /**
     * Getter para obtener el tamaño en megabytes del libro digital.
     * 
     * @return El tamaño en megabytes del libro digital
     */
    public int getTamanioMB() {
        return this.tamMB;
    }
    
    /**
     * Setter para modificar el formato del libro digital.
     * 
     * @param formato El nuevo formato del libro digital
     */
    public void setFormato(String formato) {
        this.formato = formato;
    }
    
    /**
     * Setter para modificar el tamaño en megabytes del libro digital.
     * 
     * @param tamMB El nuevo tamaño en megabytes del libro digital
     */
    public void setTamanioMB(int tamMB) {
        this.tamMB = tamMB;
    }
    
    /**
     * Método toString() que devuelve una representación en cadena del libro digital.
     * La representación incluye la representación en cadena del libro padre (super.toString())
     * seguido por el formato y el tamaño en MB del libro digital.
     * 
     * @return Una cadena que representa el libro digital
     */
    @Override
    public String toString() {
        return super.toString() + ", Formato: " + formato + ", Tamaño en MB: " + tamMB;
    }
}