package biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import utils.DAO;

/**
 *
 * @author manbolq
 */
public class Biblioteca {
    private ArrayList<Libro> librosDisponibles;
    private ArrayList<Cliente> clientes;
    private ArrayList<Bibliotecario> bibliotecarios;
    private ArrayList<Prestamo> prestamos;
    
    
    public Biblioteca(){
        librosDisponibles = new ArrayList<>();
        clientes = new ArrayList<>();
        bibliotecarios = new ArrayList<>();
        prestamos = new ArrayList<>();
    }
    
    // getters
    public ArrayList<Libro> getLibrosDisponibles() {
        return librosDisponibles;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Bibliotecario> getBibliotecarios() {
        return bibliotecarios;
    }

    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }
    
    // setters
    public void setLibrosDisponibles(ArrayList<Libro> librosDisponibles) {
        this.librosDisponibles = librosDisponibles;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void setBibliotecarios(ArrayList<Bibliotecario> bibliotecarios) {
        this.bibliotecarios = bibliotecarios;
    }

    public void setPrestamos(ArrayList<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }
    
    
    public void aniadirLibro(Libro libro){
        librosDisponibles.add(libro);
    }
    
    public void retirarLibro(Libro libro){
        librosDisponibles.remove(libro);
    }
    
    public void aniadirCliente(Cliente cliente){
        clientes.add(cliente);
    }
    
    public void retirarCliente(Cliente cliente){
        clientes.remove(cliente);
    }
    
    public void aniadirBibliotecario(Bibliotecario b){
        bibliotecarios.add(b);
    }
    
    public void retirarBibliotecario(Bibliotecario b){
        bibliotecarios.remove(b);
    }
    
    public void realizaPrestamo(Prestamo p){
        prestamos.add(p);
    }
    
    public void prestarLibro(Cliente c, Libro l){
        realizaPrestamo(new Prestamo(c, l, LocalDate.now()));
    }
    
    public void devolverLibro(Prestamo p){
        int i = prestamos.indexOf(p);
        prestamos.get(i).setDevuelto(true);
    }
    
    public void devolverLibro(Libro libro, Cliente cliente){
        for (Prestamo p : prestamos){
            if (p.getCliente() == cliente && p.getLibro() == libro){
                devolverLibro(p);
            }
        }
    }
    
    
    public void rellenarAPartirDeBD(){
        librosDisponibles = DAO.consultarLibrosDisponibles();
        clientes = DAO.consultarClientes();
        bibliotecarios = DAO.consultarBibliotecarios();
        prestamos = DAO.consultarPrestamos();
    }
    
}
