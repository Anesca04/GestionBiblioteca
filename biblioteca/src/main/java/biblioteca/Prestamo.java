package biblioteca;

import java.time.LocalDate;

/**
 * La clase Prestamo representa un préstamo de un libro a un cliente en la biblioteca.
 * Contiene información sobre el cliente, el libro prestado, la fecha del préstamo y si el libro ha sido devuelto.
 * Proporciona métodos para acceder y modificar esta información, así como un método para obtener la fecha de devolución.
 * También implementa el método toString() para obtener una representación en cadena del préstamo.
 * 
 * Esta clase es parte de un programa de gestión de bibliotecas.
 * 
 * @author manbolq
 */
public class Prestamo {
    final int MAX_DIAS_PRESTAMO = 14;  // Número máximo de días permitidos para el préstamo
    
    private Cliente cliente;            // Cliente al que se le prestó el libro
    private Libro libro;                // Libro prestado
    private LocalDate fechaPrestamo;    // Fecha del préstamo
    private boolean devuelto;           // Indica si el libro ha sido devuelto
    
    
    /**
     * Constructor de la clase Prestamo.
     * Inicializa los atributos con los valores especificados, la fecha del prestamo, la de hoy, y marca el libro como no devuelto.
     * 
     * @param cliente El cliente al que se le prestó el libro
     * @param libro El libro prestado
     */
    public Prestamo(Cliente cliente, Libro libro){
        this.cliente = cliente;
        this.libro = libro;
        this.fechaPrestamo = LocalDate.now();
        this.devuelto = false;
    }
    
    
    /**
     * Constructor de la clase Prestamo.
     * Inicializa los atributos con los valores especificados y marca el libro como no devuelto.
     * 
     * @param cliente El cliente al que se le prestó el libro
     * @param libro El libro prestado
     * @param fechaPrestamo La fecha del préstamo
     */
    public Prestamo(Cliente cliente, Libro libro, LocalDate fechaPrestamo) {
        this.cliente = cliente;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.devuelto = false;
    }
    
    /**
     * Constructor de la clase Prestamo.
     * Inicializa los atributos con los valores especificados y marca el libro como no devuelto.
     * 
     * @param cliente El cliente al que se le prestó el libro
     * @param libro El libro prestado
     * @param fechaPrestamo La fecha del préstamo
     * @param devuelto Si el libro ha sido devuelto
     */
    public Prestamo(Cliente cliente, Libro libro, LocalDate fechaPrestamo, boolean devuelto) {
        this.cliente = cliente;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.devuelto = devuelto;
    }
    
    /**
     * Getter para obtener el cliente al que se le prestó el libro.
     * 
     * @return El cliente al que se le prestó el libro
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Getter para obtener el libro prestado.
     * 
     * @return El libro prestado
     */
    public Libro getLibro() {
        return libro;
    }

    /**
     * Getter para obtener la fecha del préstamo.
     * 
     * @return La fecha del préstamo
     */
    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    /**
     * Getter para comprobar si el libro ha sido devuelto.
     * 
     * @return true si el libro ha sido devuelto, false de lo contrario
     */
    public boolean estaDevuelto() {
        return devuelto;
    }
    
    /**
     * Setter para modificar el cliente al que se le prestó el libro.
     * 
     * @param cliente El nuevo cliente al que se le prestó el libro
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Setter para modificar el libro prestado.
     * 
     * @param libro El nuevo libro prestado
     */
    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    /**
     * Setter para modificar la fecha del préstamo.
     * 
     * @param fechaPrestamo La nueva fecha del préstamo
     */
    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    /**
     * Setter para marcar si el libro ha sido devuelto o no.
     * 
     * @param devuelto true si el libro ha sido devuelto, false de lo contrario
     */
    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }
    
    /**
     * Método toString() que devuelve una representación en cadena del préstamo.
     * La representación incluye información sobre el cliente, el libro, la fecha del préstamo y si el libro ha sido devuelto.
     * 
     * @return Una cadena que representa el préstamo
     */
    @Override
    public String toString() {
        String res = "Cliente: " + cliente.toString();
        res += "\nLibro prestado: " + libro.toString();
        res += "\nFecha de Prestamo: " + fechaPrestamo.toString();
        res += "\nLo ha devuelto: " + devuelto;
        
        return res;
    }
    
    /**
     * Método para obtener la fecha de devolución del préstamo.
     * Calcula la fecha sumando el número máximo de días permitidos para el préstamo a la fecha de préstamo.
     * 
     * @return La fecha de devolución del préstamo
     */
    public LocalDate getFechaDevolucion() {
        return this.fechaPrestamo.plusDays(MAX_DIAS_PRESTAMO);
    }
}