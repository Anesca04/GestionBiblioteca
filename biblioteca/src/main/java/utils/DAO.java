package utils;

import biblioteca.Bibliotecario;
import biblioteca.Cliente;
import biblioteca.Escritor;
import biblioteca.Libro;
import biblioteca.LibroDigital;
import biblioteca.LibroFisico;
import biblioteca.Prestamo;
import exceptions.DNIInvalidoException;
import exceptions.EdadInvalidaException;
import exceptions.TelefonoInvalidoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map.Entry;
import java.time.LocalDate;
import java.sql.Date;

public abstract class DAO {
	private static Connection conexion;

	private static Statement conectar() {
            try {
                conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/biblioteca", "manbolq", "12345");
                return conexion.createStatement();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return null;
            }
	}

	private static void desconectar(Statement s) {
            try {
                s.close();
                conexion.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
	}

	public static int insertar(String tabla, HashMap<String, Object> columnas) throws SQLException {
		Statement smt = conectar();
		String consulta = "insert into " + tabla + " (";
		Iterator it = columnas.keySet().iterator();
		while (it.hasNext()) {
                    
			consulta += (String) it.next() + ",";
		}
		consulta = consulta.substring(0, consulta.length() - 1);
		consulta += ") values (";
		it = columnas.values().iterator();
		while (it.hasNext()) {
			Object elemento = it.next();
			if (elemento.getClass() != String.class && elemento.getClass() != Character.class) {
				consulta += elemento + ",";
			} else {
				consulta += "'" + (String) elemento + "',";
			}
		}
		consulta = consulta.substring(0, consulta.length() - 1);
		consulta += ")";
		// System.out.println(consulta);
		int ret = smt.executeUpdate(consulta);
		desconectar(smt);
		return ret;
	}

	public static int borrar(String tabla, HashMap<String, Object> columnas) throws SQLException {
		Statement smt = conectar();
		String consulta = "delete from " + tabla + " where ";
		Iterator it = columnas.entrySet().iterator();
		while (it.hasNext()) {
			Entry actual = (Entry) it.next();
			if (actual.getValue().getClass() != String.class && actual.getValue().getClass() != Character.class) {
				consulta += (String) actual.getKey() + "=" + (String) actual.getValue() + " and ";
			} else {
				consulta += (String) actual.getKey() + "='" + (String) actual.getValue() + "' and ";
			}
		}
		consulta = consulta.substring(0, consulta.length() - 5);
		// System.out.println(consulta);
		int ret = smt.executeUpdate(consulta);
		desconectar(smt);
		return ret;
	}

	public static ArrayList<Object> consultar(String tabla, LinkedHashSet<String> columnasSelect,
			HashMap<String, Object> restricciones) throws SQLException {
		Statement smt = conectar();

		String query = "select ";
		Iterator ith = columnasSelect.iterator();
		while (ith.hasNext()) {
			query += (String) ith.next() + ",";
		}
		query = query.substring(0, query.length() - 1) + " from " + tabla + (restricciones.size() > 0 ? " where " : "");
		Iterator itm = restricciones.entrySet().iterator();
		while (itm.hasNext()) {
			Entry actual = (Entry) itm.next();
			if (actual.getValue().getClass() != String.class && actual.getValue().getClass() != Character.class) {
				query += (String) actual.getKey() + "=" + (String) actual.getValue() + " and ";
			} else {
				query += (String) actual.getKey() + "='" + (String) actual.getValue() + "' and ";
			}
		}
		if (restricciones.size() > 0) {
			query = query.substring(0, query.length() - 5);
		}
		// System.out.println(query);
		ResultSet cursor = smt.executeQuery(query);
		ArrayList<Object> fila = new ArrayList<Object>();
		while (cursor.next()) {
			Iterator hsCols = columnasSelect.iterator();
			while (hsCols.hasNext()) {
				String nombreCol = (String) hsCols.next();
				try {
					fila.add(cursor.getInt(cursor.findColumn(nombreCol)));
				} catch (NumberFormatException | SQLException e) {
					fila.add(cursor.getString(cursor.findColumn(nombreCol)));
				}
			}

		}
		desconectar(smt);
		return fila;
	}

	public static int actualizar(String tabla, HashMap<String, Object> datosAModificar,
			HashMap<String, Object> restricciones) throws SQLException {
		String query = "update " + tabla + " set ";
		Iterator itm = datosAModificar.entrySet().iterator();
		while (itm.hasNext()) {
			Entry actual = (Entry) itm.next();
			if (actual.getValue().getClass() != String.class && actual.getValue().getClass() != Character.class) {
				query += actual.getKey() + " = " + actual.getValue() + ",";
			} else {
				query += actual.getKey() + " = '" + actual.getValue() + "',";
			}
		}
		query = query.substring(0, query.length() - 1) + " where ";
		Iterator itr = restricciones.entrySet().iterator();
		while (itr.hasNext()) {
			Entry actual = (Entry) itr.next();
			if (actual.getValue().getClass() != String.class && actual.getValue().getClass() != Character.class) {
				query += actual.getKey() + " = " + actual.getValue() + " and ";
			} else {
				query += actual.getKey() + " = '" + actual.getValue() + "' and ";
			}
		}
		query=query.substring(0,query.length()-5);
		
		Statement smt=conectar();
		// System.out.println(query);
		int ret=smt.executeUpdate(query);
		desconectar(smt);
		
		return ret;
	}
        
        /**
        * @brief Obtiene un objeto Escritor basado en el ID del escritor.
        * @param idEscritor El ID del escritor.
        * @return Un objeto Escritor si se encuentra, de lo contrario, null.
        * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
        */
       public static Escritor obtenerEscritor(int idEscritor) throws SQLException, EdadInvalidaException {
            Escritor escritor = null;

            Statement smt = conectar();
            String query = "SELECT e.idEscritor, e.idioma, e.Usuario_dni, u.nombre, u.edad " +
                           "FROM escritor e " +
                           "JOIN usuario u ON e.Usuario_dni = u.dni " +
                           "WHERE e.idEscritor = " + idEscritor;

            ResultSet cursor = smt.executeQuery(query);

            if (cursor.next()) {
                String idioma = cursor.getString("idioma");
                String dni = cursor.getString("Usuario_dni");
                String nombre = cursor.getString("nombre");
                int edad = cursor.getInt("edad");

                try{
                    escritor = new Escritor(nombre, dni, edad, idioma);
                }
                catch(DNIInvalidoException e){
                    System.out.println("El formato del DNI es incorrecto");
                }

            }
            desconectar(smt);
            return escritor;
       }

        /**
         * @brief Obtiene un objeto Cliente basado en el ID del cliente.
         * @param dni El DNI del cliente.
         * @return Un objeto Cliente si se encuentra, de lo contrario, null.
         * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
         */
        public static Cliente obtenerCliente(String dni) throws SQLException, DNIInvalidoException, TelefonoInvalidoException, EdadInvalidaException{
            Cliente cliente = null;

            Statement smt = conectar();
            String query = "select * from usuario where dni='" + dni + "'";
            
            ResultSet cursor = smt.executeQuery(query);

            if (cursor.next()) {
                String nombre = cursor.getString("nombre");
                int edad = cursor.getInt("edad");
                String telefono = cursor.getString("telefono");
                
                cliente = new Cliente(nombre, dni, edad, telefono);

            }
            desconectar(smt);
            return cliente;
        }

       /**
        * @brief Obtiene un objeto Libro basado en el ID del libro.
        * @param idLibro El ID del libro.
        * @return Un objeto Libro si se encuentra, de lo contrario, null.
        * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
        */
       public static Libro obtenerLibro(int idLibro) throws SQLException, EdadInvalidaException {
            Libro libro = null;

            Statement smt = conectar();
            String query = "SELECT libro.idLibro, libro.titulo, libro.editorial, libro.paginas, escritor.idEscritor, escritor.idioma, usuario.dni, usuario.nombre, usuario.edad " +
                            "FROM libro " +
                            "JOIN escritor ON libro.idEscritor = escritor.idEscritor " +
                            "JOIN usuario ON escritor.Usuario_dni = usuario.dni " +
                            "WHERE libro.idLibro = " + idLibro;

            ResultSet cursor = smt.executeQuery(query);

            if (cursor.next()) {
                String titulo = cursor.getString("titulo");
                String editorial = cursor.getString("editorial");
                int paginas = cursor.getInt("paginas");
                int idEscritor = cursor.getInt("idEscritor");

                Escritor escritor = obtenerEscritor(idEscritor);

                libro = new Libro(titulo, escritor, editorial, paginas);
            }
            desconectar(smt);
            return libro;
       }

       /**
        * @brief Consulta los libros disponibles en la biblioteca.
        * @return Una lista de objetos Libro que están disponibles en la biblioteca.
        * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
        */
       public static ArrayList<Libro> consultarLibrosDisponibles() throws SQLException, EdadInvalidaException{
            ArrayList<Libro> libros = new ArrayList<>();

            Statement smt = conectar();
            String query = "SELECT l.idLibro, l.titulo, l.editorial, l.paginas, l.idEscritor, ld.formato, ld.tamMB, lf.copias, lf.tapaDura " +
                           "FROM libro l " +
                           "LEFT JOIN librodigital ld ON l.idLibro = ld.idLibro " +
                           "LEFT JOIN librofisico lf ON l.idLibro = lf.idLibro";

            ResultSet cursor = smt.executeQuery(query);

            while (cursor.next()) {
                String titulo = cursor.getString("titulo");
                String editorial = cursor.getString("editorial");
                int paginas = cursor.getInt("paginas");
                int idEscritor = cursor.getInt("idEscritor");
                String formato = cursor.getString("formato");
                int tamMB = cursor.getInt("tamMB");
                int copias = cursor.getInt("copias");
                int tapaDura = cursor.getInt("tapaDura");

                Escritor escritor = obtenerEscritor(idEscritor);

                if (formato != null) {
                    // Es un libro digital
                    LibroDigital libroDigital = new LibroDigital(titulo, escritor, editorial, paginas, formato, tamMB);
                    libros.add(libroDigital);
                }
                if (copias > 0) {
                    // Es un libro físico
                    boolean esTapaDura = (tapaDura == 1);
                    LibroFisico libroFisico = new LibroFisico(titulo, escritor, editorial, paginas, copias, esTapaDura);
                    libros.add(libroFisico);
                }
            }
            desconectar(smt);
            return libros;
       }

       /**
        * @brief Consulta los clientes registrados en la biblioteca.
        * @return Una lista de objetos Cliente que representan a los clientes registrados en la biblioteca.
        * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
        */
        public static ArrayList<Cliente> consultarClientes() throws SQLException, DNIInvalidoException, EdadInvalidaException, TelefonoInvalidoException{
            ArrayList<Cliente> clientes = new ArrayList<>();
            Statement smt = conectar();
            String query = "SELECT dni FROM usuario WHERE dni NOT IN (SELECT Usuario_dni FROM escritor)";

            ResultSet cursor = smt.executeQuery(query);

            while(cursor.next()){
                String dni = cursor.getString("dni");
                Cliente cliente = obtenerCliente(dni);
                clientes.add(cliente);
            }
            desconectar(smt);
            return clientes;
       }

       /**
        * @brief Consulta los bibliotecarios registrados en la biblioteca.
        * @return Una lista de objetos Bibliotecario que representan a los bibliotecarios registrados en la biblioteca.
        * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
        */
       public static ArrayList<Bibliotecario> consultarBibliotecarios() throws SQLException, DNIInvalidoException, EdadInvalidaException, TelefonoInvalidoException {
            ArrayList<Bibliotecario> bibliotecarios = new ArrayList<>();

            Statement smt = conectar();
            String query = "SELECT bibliotecario.idBibliotecario, bibliotecario.horario, bibliotecario.sueldo, telefono, bibliotecario.Usuario_dni, usuario.nombre, usuario.edad FROM bibliotecario JOIN usuario ON bibliotecario.Usuario_dni = usuario.dni";

            ResultSet cursor = smt.executeQuery(query);

            while (cursor.next()) {
                String horario = cursor.getString("horario");
                int sueldo = cursor.getInt("sueldo");
                String telefono = cursor.getString("telefono");
                String dni = cursor.getString("Usuario_dni");
                String nombre = cursor.getString("nombre");
                int edad = cursor.getInt("edad");

                Bibliotecario bibliotecario = new Bibliotecario(nombre, dni, edad, horario, sueldo, telefono);
                
                bibliotecarios.add(bibliotecario);
            }
            desconectar(smt);
            return bibliotecarios;
       }

       /**
        * @brief Consulta los préstamos registrados en la biblioteca.
        * @return Una lista de objetos Prestamo que representan los préstamos registrados en la biblioteca.
        * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
        */
       public static ArrayList<Prestamo> consultarPrestamos() throws SQLException, DNIInvalidoException, TelefonoInvalidoException, EdadInvalidaException{
            ArrayList<Prestamo> prestamos = new ArrayList<>();

            Statement smt = conectar();
            String query = "SELECT fechaPrestamo, devuelto, idLibro, Usuario_dni FROM prestamo";

            ResultSet cursor = smt.executeQuery(query);

            while (cursor.next()) {
                Date fechaPrestamo = cursor.getDate("fechaPrestamo");
                LocalDate fechaPrestamoLocal = fechaPrestamo.toLocalDate();
                boolean devuelto = cursor.getBoolean("devuelto");
                int idLibro = cursor.getInt("idLibro");
                String dni = cursor.getString("Usuario_dni");

                Cliente cliente = obtenerCliente(dni);
                Libro libro = obtenerLibro(idLibro);

                Prestamo prestamo = new Prestamo(cliente, libro, fechaPrestamoLocal, devuelto);
                prestamos.add(prestamo);
            }
            desconectar(smt);
            return prestamos;
       }



}
