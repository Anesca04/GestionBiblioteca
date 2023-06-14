package biblioteca;

import exceptions.LibroNoExisteException;
import exceptions.UsuarioNoExisteException;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import utils.DAO;

/**
 * @brief Clase que representa una biblioteca.
 *
 * Esta clase contiene métodos para administrar libros, clientes, bibliotecarios y préstamos en una biblioteca.
 */
public class Biblioteca {
    private ArrayList<Libro> librosDisponibles; /**< Lista de libros disponibles en la biblioteca. */
    private ArrayList<Cliente> clientes; /**< Lista de clientes registrados en la biblioteca. */
    private ArrayList<Bibliotecario> bibliotecarios; /**< Lista de bibliotecarios registrados en la biblioteca. */
    private ArrayList<Prestamo> prestamos; /**< Lista de préstamos realizados en la biblioteca. */

    /**
     * @brief Constructor de la clase Biblioteca.
     *
     * Crea una instancia de la clase Biblioteca inicializando las listas de libros, clientes, bibliotecarios y préstamos.
     */
    public Biblioteca(){
        librosDisponibles = new ArrayList<>();
        clientes = new ArrayList<>();
        bibliotecarios = new ArrayList<>();
        prestamos = new ArrayList<>();
    }
    
    // Getters
    
    /**
     * @brief Obtiene la lista de libros disponibles en la biblioteca.
     * @return Lista de libros disponibles.
     */
    public ArrayList<Libro> getLibrosDisponibles() {
        return librosDisponibles;
    }

    /**
     * @brief Obtiene la lista de clientes registrados en la biblioteca.
     * @return Lista de clientes registrados.
     */
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    /**
     * @brief Obtiene la lista de bibliotecarios registrados en la biblioteca.
     * @return Lista de bibliotecarios registrados.
     */
    public ArrayList<Bibliotecario> getBibliotecarios() {
        return bibliotecarios;
    }

    /**
     * @brief Obtiene la lista de préstamos realizados en la biblioteca.
     * @return Lista de préstamos realizados.
     */
    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }
    
    // Setters
    
    /**
     * @brief Establece la lista de libros disponibles en la biblioteca.
     * @param librosDisponibles Lista de libros disponibles.
     */
    public void setLibrosDisponibles(ArrayList<Libro> librosDisponibles) {
        this.librosDisponibles = librosDisponibles;
    }

    /**
     * @brief Establece la lista de clientes registrados en la biblioteca.
     * @param clientes Lista de clientes registrados.
     */
    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    /**
     * @brief Establece la lista de bibliotecarios registrados en la biblioteca.
     * @param bibliotecarios Lista de bibliotecarios registrados.
     */
    public void setBibliotecarios(ArrayList<Bibliotecario> bibliotecarios) {
        this.bibliotecarios = bibliotecarios;
    }

    /**
     * @brief Establece la lista de préstamos realizados en la biblioteca.
     * @param prestamos Lista de préstamos realizados.
     */
    public void setPrestamos(ArrayList<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }
    
    
    /**
     * Añade un libro a la lista de libros disponibles en la biblioteca.
     *
     * @param libro El libro que se desea añadir.
     */
    public void aniadirLibro(Libro libro){
        librosDisponibles.add(libro);
    }

    /**
     * Retira un libro de la lista de libros disponibles en la biblioteca.
     *
     * @param libro El libro que se desea retirar.
     */
     public void retirarLibro(Libro libro){
        librosDisponibles.remove(libro);
     } 

    /**
     * Añade un cliente a la lista de clientes de la biblioteca.
     *
     * @param cliente El cliente que se desea añadir.
     */
    public void aniadirCliente(Cliente cliente){
        clientes.add(cliente);
    }  

    /**
     * Retira un cliente de la lista de clientes de la biblioteca.
     *
     * @param cliente El cliente que se desea retirar.
     */
    public void retirarCliente(Cliente cliente){
        clientes.remove(cliente);
    }

    /**
     * Añade un bibliotecario a la lista de bibliotecarios de la biblioteca.
     *
     * @param b El bibliotecario que se desea añadir.
     */
    public void aniadirBibliotecario(Bibliotecario b){
        bibliotecarios.add(b);
    }

    /**
     * Retira un bibliotecario de la lista de bibliotecarios de la biblioteca.
     *
     * @param b El bibliotecario que se desea retirar.
     */
    public void retirarBibliotecario(Bibliotecario b){
        bibliotecarios.remove(b);
    }

    /**
     * Realiza un préstamo y lo agrega a la lista de préstamos de la biblioteca.
     *
     * @param p El préstamo que se desea realizar.
     */
    public void realizaPrestamo(Prestamo p){
        prestamos.add(p);
    }

    /**
     * Realiza un préstamo de un libro a un cliente.
     *
     * @param c El cliente al que se le presta el libro.
     * @param l El libro que se presta.
     * 
     * @throws UsuarioNoExisteException 
     * @throws LibroNoExisteException
     */
    public void prestarLibro(Cliente c, Libro l) throws UsuarioNoExisteException, LibroNoExisteException{
        boolean clienteEncontrado = false;
        for (Cliente cliente : clientes){
            if (cliente.getDni().equals(c.getDni())){
                clienteEncontrado = true;
            }
        }
        
        if (!clienteEncontrado){
            throw new UsuarioNoExisteException("El usuario no existe");
        }
        
        boolean libroEncontrado = false;
        for (Libro libro : librosDisponibles){
            if (libro.getTitulo().equals(l.getTitulo())){
                libroEncontrado = true;
            }
        }
        
        if (!libroEncontrado){
            throw new LibroNoExisteException("El libro no existe");
        }
        
        realizaPrestamo(new Prestamo(c, l));
    }

    /**
     * Marca como devuelto un préstamo.
     *
     * @param p El préstamo que se desea marcar como devuelto.
     */
    public void devolverLibro(Prestamo p){
        int i = prestamos.indexOf(p);
        prestamos.get(i).setDevuelto(true);
    }

    /**
     * Marca como devuelto un libro prestado por un cliente.
     *
     * @param libro   El libro que se desea marcar como devuelto.
     * @param cliente El cliente que devolvió el libro.
     */
    public void devolverLibro(Libro libro, Cliente cliente){
        for (Prestamo p : prestamos){
            if (p.getCliente() == cliente && p.getLibro() == libro){
                p.setDevuelto(true);
            }
        }
    }

    /**
     * Obtiene la lista de libros prestados por un cliente.
     *
     * @param cliente El cliente del que se desea obtener los libros prestados.
     * @return Una lista de libros prestados por el cliente.
     */
    public ArrayList<Libro> librosPrestadosDeCliente(Cliente cliente){
        ArrayList<Libro> libros = new ArrayList<>();
        for (Prestamo p : prestamos){
            if (p.getCliente().getDni().equals(cliente.getDni()) && !p.estaDevuelto()){
                libros.add(p.getLibro());
            }
        }

        return libros;
    }
    
    /**
     * Obtiene un cliente a partir de su DNI
     * 
     * @param dni El dni del cliente que se desea encontrar
     * @return Un objeto del tipo Cliente, que representa al cliente con dni @dni
     */
    public Cliente clienteAPartirDNI(String dni){
        for (Cliente cliente : clientes){
            if (cliente.getDni().equals(dni)){
                return cliente;
            }
        }
        
        return null;
    }
    
    public Bibliotecario bibliotecarioAPartirDNI(String dni){
        for (Bibliotecario b : bibliotecarios){
            if (b.getDni().equals(dni)){
                return b;
            }
        }
        
        return null;
    }
    
    public void crearCliente(String nombre, String dni, int edad, String numTelefono){
        HashMap<String, Object> columnasUsuario = new HashMap<>();
        columnasUsuario.put("dni", dni);
        columnasUsuario.put("nombre", nombre);
        columnasUsuario.put("edad", edad);
        try{
            DAO.insertar("usuario", columnasUsuario);
        }
        catch(SQLException e){
            System.out.println("Hubo un problema al insertar en la BD");
        }
        
        HashMap<String, Object> columnasCliente = new HashMap<>();
        columnasCliente.put("telefono", numTelefono);
        columnasCliente.put("Usuario_dni", dni);
        try{
            DAO.insertar("cliente", columnasCliente);
        }
        catch(SQLException e){
            System.out.println("Hubo un problema al insertar en la BD");
        }
        
        try{
            clientes = DAO.consultarClientes();

            for (Cliente cliente : clientes){
                cliente.setLibrosPrestados(librosPrestadosDeCliente(cliente));
            }
        }
        catch(SQLException e){
            System.out.println("Hubo algún error al consultar la base de datos");
        }
    }
    
    
    public void editarCliente(String dni, String nombre, int edad, String telefono){
        HashMap<String, Object> datosAModificar = new HashMap<>();
        datosAModificar.put("telefono", telefono);
        HashMap<String, Object> restricciones = new HashMap<>();
        restricciones.put("Usuario_dni", dni);
        
        try{
            DAO.actualizar("cliente", datosAModificar, restricciones);
        }
        catch(SQLException e){
            System.out.println("Hubo un error al modificar la BD");
        }
        
        datosAModificar.clear();
        restricciones.clear();
        
        datosAModificar.put("nombre", nombre);
        datosAModificar.put("edad", edad);
        restricciones.put("dni", dni);
        
        try{
            DAO.actualizar("usuario", datosAModificar, restricciones);
        }
        catch(SQLException e){
            System.out.println("Hubo un error al modificar la BD");
        }
        
        
        try{
            clientes = DAO.consultarClientes();

            for (Cliente cliente : clientes){
                cliente.setLibrosPrestados(librosPrestadosDeCliente(cliente));
            }
        }
        catch(SQLException e){
            System.out.println("Hubo algún error al consultar la base de datos");
        }
    }

    /**
     * Rellena la biblioteca a partir de los datos almacenados en la base de datos.
     * Actualiza las listas de clientes, libros disponibles, bibliotecarios y préstamos.
     */
    public void rellenarAPartirDeBD(){
        try{
            clientes = DAO.consultarClientes();
            librosDisponibles = DAO.consultarLibrosDisponibles();
            bibliotecarios = DAO.consultarBibliotecarios();
            prestamos = DAO.consultarPrestamos();

            for (Cliente cliente : clientes){
                cliente.setLibrosPrestados(librosPrestadosDeCliente(cliente));
            }
        }
        catch(SQLException e){
            System.out.println("Hubo algún error al consultar la base de datos");
        }
    }
    
    /**
     * Vuelca los datos de la biblioteca en un fichero de texto.
     *
     * @param fichero El nombre del fichero en el que se volcarán los datos.
     * @throws FileNotFoundException Si el fichero no puede ser encontrado.
     * @throws IOException           Si ocurre un error al escribir en el fichero.
     */
    public void volcarDatosEnFichero(String fichero) throws FileNotFoundException, IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(fichero));

        volcarLibrosEnFichero(pw);
        pw = new PrintWriter(new FileWriter(fichero, true));
        pw.println();
        pw.println();
        pw = new PrintWriter(new FileWriter(fichero, true));
        volcarClientesEnFichero(pw);
        pw.println();
        pw.println();
        pw = new PrintWriter(new FileWriter(fichero, true));
        volcarBibliotecariosEnFichero(pw);
        pw.println();
        pw.println();
        pw = new PrintWriter(new FileWriter(fichero, true));
        volcarPrestamosEnFichero(pw);

        pw.close();
    }

    /**
     * Vuelca los libros disponibles en el fichero de texto.
     *
     * @param pw El objeto PrintWriter para escribir en el fichero.
     * @throws FileNotFoundException Si el fichero no puede ser encontrado.
     * @throws IOException           Si ocurre un error al escribir en el fichero.
     */
    public void volcarLibrosEnFichero(PrintWriter pw) throws FileNotFoundException, IOException{
        pw.println("===== LIBROS DISPONIBLES =====");
        pw.println();
        for (Libro libro : librosDisponibles){
            pw.println(libro);
            pw.println();
        }

        pw.close();
    }

    /**
     * Vuelca los libros disponibles en el fichero de texto.
     *
     * @param fichero El nombre del fichero en el que se volcarán los datos.
     * @throws FileNotFoundException Si el fichero no puede ser encontrado.
     * @throws IOException           Si ocurre un error al escribir en el fichero.
     */
    public void volcarLibrosEnFichero(String fichero) throws FileNotFoundException, IOException{
        FileWriter fw = new FileWriter(fichero);
        PrintWriter pw = new PrintWriter(fw);
        volcarLibrosEnFichero(pw);
        fw.close();
    }

    /**
     * Vuelca los clientes en el fichero de texto.
     *
     * @param pw El objeto PrintWriter para escribir en el fichero.
     * @throws FileNotFoundException Si el fichero no puede ser encontrado.
     * @throws IOException           Si ocurre un error al escribir en el fichero.
     */
    public void volcarClientesEnFichero(PrintWriter pw) throws FileNotFoundException, IOException{
        pw.println("===== CLIENTES =====");
        pw.println();
        for (Cliente cliente : clientes){
            pw.println(cliente);
            pw.println();
        }

        pw.close();
    }

    /**
     * Vuelca los clientes en el fichero de texto.
     *
     * @param fichero El nombre del fichero en el que se volcarán los datos.
     * @throws FileNotFoundException Si el fichero no puede ser encontrado.
     * @throws IOException           Si ocurre un error al escribir en el fichero.
     */
    public void volcarClientesEnFichero(String fichero) throws FileNotFoundException, IOException{
        FileWriter fw = new FileWriter(fichero);
        PrintWriter pw = new PrintWriter(fw);
        volcarClientesEnFichero(pw);
        fw.close();
    }

    /**
     * Vuelca los bibliotecarios en el fichero de texto.
     *
     * @param pw El objeto PrintWriter para escribir en el fichero.
     * @throws FileNotFoundException Si el fichero no puede ser encontrado.
     * @throws IOException           Si ocurre un error al escribir en el fichero.
     */
    public void volcarBibliotecariosEnFichero(PrintWriter pw) throws FileNotFoundException, IOException{
        pw.println("===== BIBLIOTECARIOS =====");
        pw.println();
        for (Bibliotecario b : bibliotecarios){
            pw.println(b);
            pw.println();
        }

        pw.close();
    }

    /**
     * Vuelca los bibliotecarios en el fichero de texto.
     *
     * @param fichero El nombre del fichero en el que se volcarán los datos.
     * @throws FileNotFoundException Si el fichero no puede ser encontrado.
     * @throws IOException           Si ocurre un error al escribir en el fichero.
     */
    public void volcarBibliotecariosEnFichero(String fichero) throws FileNotFoundException, IOException{
        FileWriter fw = new FileWriter(fichero);
        PrintWriter pw = new PrintWriter(fw);
        volcarBibliotecariosEnFichero(pw);
        fw.close();
    }

    /**
     * Vuelca los préstamos en el fichero de texto.
     *
     * @param pw El objeto PrintWriter para escribir en el fichero.
     * @throws FileNotFoundException Si el fichero no puede ser encontrado.
     * @throws IOException           Si ocurre un error al escribir en el fichero.
     */
    public void volcarPrestamosEnFichero(PrintWriter pw) throws FileNotFoundException, IOException{
        pw.println("===== PRESTAMOS =====");
        pw.println();
        for (Prestamo p : prestamos){
            pw.println(p);
            pw.println();
        }

        pw.close();
    }

    /**
     * Vuelca los préstamos en el fichero de texto.
     *
     * @param fichero El nombre del fichero en el que se volcarán los datos.
     * @throws FileNotFoundException Si el fichero no puede ser encontrado.
     * @throws IOException           Si ocurre un error al escribir en el fichero.
     */
    public void volcarPrestamosEnFichero(String fichero) throws FileNotFoundException, IOException{
        PrintWriter pw = new PrintWriter(new FileWriter(fichero));
        volcarPrestamosEnFichero(pw);
    }
    
    public static void main(String [] args){
        Biblioteca biblioteca = new Biblioteca();
        
        biblioteca.rellenarAPartirDeBD();
        
        // biblioteca.crearCliente("pepito", "99999999I", 18, "673892671");
        
        for (Cliente cliente : biblioteca.clientes){
            System.out.println(cliente);
            System.out.println();
        }
    }
    
}
