package gui;

import biblioteca.Biblioteca;
import biblioteca.Bibliotecario;
import biblioteca.Cliente;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class Ventana extends JFrame {
        final int WIDTH = 1200;
        final int HEIGHT = 600;
        
        Biblioteca biblioteca;
        Cliente cliente;
        Bibliotecario bibliotecario;
        
	
	public Ventana() {
            biblioteca = new Biblioteca();
            biblioteca.rellenarAPartirDeBD();       
            cliente = null;
            bibliotecario = null;
            
            
            this.setSize(WIDTH,HEIGHT); //Tamaño de la ventana
            this.setTitle("Gestión de biblioteca");  //Título de la ventana
            this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Cierra la aplicación al darle a la X
            this.setLocationRelativeTo(null); //Centrar en el monitor
            this.setContentPane(new OpcionesVentana(this));
            this.setVisible(true); //Muestra la ventana
	}

	/* Función para mostrar los paneles*/
	public void cambiarPantalla(Class<?> clase) {
            this.getContentPane().setVisible(false);  /*Deshabilito primero el panel activo*/

            if (clase.equals(OpcionesVentana.class)) {
                this.setContentPane(new OpcionesVentana(this));
            }
            if (clase.equals(RegistroCliente.class)) { 
                this.setContentPane(new RegistroCliente(this));
            }		
            if (clase.equals(PantallaBibliotecario.class)) { 
                this.setContentPane(new PantallaBibliotecario(this));
            }		
            if (clase.equals(DashboardClientes.class)) { 
                this.setContentPane(new DashboardClientes(this));
            }		
            if (clase.equals(Escritor.class)) { 
                this.setContentPane(new Escritor(this));
            }		
            if (clase.equals(VerLibros.class)) { 
                this.setContentPane(new VerLibros(this));
            }
            if (clase.equals(EditarInfoCliente.class)) {
                this.setContentPane(new EditarInfoCliente(this));
            }
            if (clase.equals(VerLibrosPrestados.class)) {
                this.setContentPane(new VerLibrosPrestados(this));
            }
            if (clase.equals(LogInCliente.class)) { 
                this.setContentPane(new LogInCliente(this));
            }
            
            if (clase.equals(LogInBibliotecario.class)) { 
                this.setContentPane(new LogInBibliotecario(this));
            }

            if (clase.equals(PantallaLogin.class)) { 
                this.setContentPane(new PantallaLogin(this));
            }
            if (clase.equals(PantallaRegistro.class)) {
                this.setContentPane(new PantallaRegistro(this));
            }
            /*Habilitar el nuevo panel*/
            this.getContentPane().setVisible(true);	
	}
	
}
