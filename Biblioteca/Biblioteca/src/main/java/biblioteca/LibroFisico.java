package biblioteca;

/**
 * La clase LibroFisico representa un libro en formato físico.
 * Es una subclase de la clase Libro y hereda sus atributos y métodos.
 * Además, agrega atributos adicionales como número de copias y si tiene tapa dura.
 * Proporciona métodos para acceder y modificar estos atributos.
 * También implementa el método toString() para obtener una representación en cadena del libro físico.
 * 
 * Esta clase es parte de un programa de gestión de bibliotecas.
 * 
 * @author manbolq
 */
public class LibroFisico extends Libro {
    private int numCopias;          // Número de copias del libro físico
    private boolean tapaDura;       // Indica si el libro físico tiene tapa dura
    
    /**
     * Constructor de la clase LibroFisico.
     * Inicializa los atributos con los valores especificados.
     * Además, llama al constructor de la clase padre (Libro) para inicializar los atributos heredados.
     * 
     * @param titulo Título del libro físico
     * @param autor Autor del libro físico (objeto de la clase Escritor)
     * @param editorial Editorial del libro físico
     * @param numPaginas Número de páginas del libro físico
     * @param numCopias Número de copias del libro físico
     * @param tapaDura Indica si el libro físico tiene tapa dura
     */
    public LibroFisico(String titulo, Escritor autor, String editorial, int numPaginas, int numCopias, boolean tapaDura) {
        super(titulo, autor, editorial, numPaginas);   // Llama al constructor de la clase padre (Libro)
        this.numCopias = numCopias;
        this.tapaDura = tapaDura;
    }
    
    /**
     * Getter para obtener el número de copias del libro físico.
     * 
     * @return El número de copias del libro físico
     */
    public int getNumCopias() {
        return numCopias;
    }

    /**
     * Getter para verificar si el libro físico tiene tapa dura.
     * 
     * @return `true` si el libro físico tiene tapa dura, `false` de lo contrario
     */
    public boolean tieneTapaDura() {
        return tapaDura;
    }
    
    /**
     * Setter para modificar el número de copias del libro físico.
     * 
     * @param numCopias El nuevo número de copias del libro físico
     */
    public void setNumCopias(int numCopias) {
        this.numCopias = numCopias;
    }

    /**
     * Setter para especificar si el libro físico tiene tapa dura o no.
     * 
     * @param tapaDura `true` si el libro físico tiene tapa dura, `false` de lo contrario
     */
    public void setTieneTapaDura(boolean tapaDura) {
        this.tapaDura = tapaDura;
    }
    
    /**
     * Método toString() que devuelve una representación en cadena del libro físico.
     * La representación incluye la representación en cadena del libro padre (super.toString())
     * seguido por el número de copias y si tiene tapa dura o no.
     * 
     * @return Una cadena que representa el libro físico
     */
    @Override
    public String toString() {
        return super.toString() + ", Num. Copias: " + numCopias + ", Tapa dura: " + tapaDura;
    }
}
