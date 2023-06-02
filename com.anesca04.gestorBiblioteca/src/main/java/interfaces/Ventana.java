package interfaces;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class Ventana extends JFrame {
	
	public Ventana() {
		this.setSize(600,500); //Tamaño de la ventana
		this.setTitle("Gestión de biblioteca");  //Título de la ventana
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Cierra la aplicación al darle a la X
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
		if (clase.equals(Usuarios.class)) { 
			this.setContentPane(new Usuarios(this));
		}		
		if (clase.equals(Bibliotecario.class)) { 
			this.setContentPane(new Bibliotecario(this));
		}		
		if (clase.equals(Clientes.class)) { 
			this.setContentPane(new Clientes(this));
		}		
		if (clase.equals(Escritor.class)) { 
			this.setContentPane(new Escritor(this));
		}		
		if (clase.equals(Libro.class)) { 
			this.setContentPane(new Libro(this));
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
