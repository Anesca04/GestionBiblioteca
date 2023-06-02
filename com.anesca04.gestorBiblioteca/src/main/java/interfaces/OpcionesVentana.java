package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;


import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OpcionesVentana extends JPanel{
	private Ventana ventana;
	private JButton btUsuarios_1;
	private JButton btUsuarios;
	
	public OpcionesVentana(Ventana v) {
		this.ventana=v;
		setLayout(null);
		
		JLabel lbRegistro = new JLabel("Menú de opciones");
		lbRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lbRegistro.setBounds(10, 11, 430, 49);
		lbRegistro.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lbRegistro);
		
		btUsuarios = new JButton("Usuarios");
		btUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*llamo al método ventana.cambiarPantalla para cambiar de panel*/
				ventana.cambiarPantalla(Usuarios.class);
			}
		});
		btUsuarios.setFont(new Font("Tahoma", Font.BOLD, 14));
		btUsuarios.setBounds(10, 96, 130, 23);
		add(btUsuarios);
		
		JButton btBibliotecario = new JButton("Bibliotecarios");
		btBibliotecario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*llamo al método ventana.cambiarPantalla para cambiar de panel*/
				ventana.cambiarPantalla(Bibliotecario.class);				
			}
		});
		btBibliotecario.setFont(new Font("Tahoma", Font.BOLD, 14));
		btBibliotecario.setBounds(10, 140, 130, 23);
		add(btBibliotecario);
		
		JButton btClientes = new JButton("Clientes");
		btClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*llamo al método ventana.cambiarPantalla para cambiar de panel*/
				ventana.cambiarPantalla(Clientes.class);				
			}
		});
		btClientes.setFont(new Font("Tahoma", Font.BOLD, 14));
		btClientes.setBounds(10, 187, 130, 23);
		add(btClientes);
		
		JButton btEscritores = new JButton("Escritores");
		btEscritores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*llamo al método ventana.cambiarPantalla para cambiar de panel*/
				ventana.cambiarPantalla(Escritor.class);				
			}
		});
		btEscritores.setFont(new Font("Tahoma", Font.BOLD, 14));
		btEscritores.setBounds(10, 234, 130, 23);
		add(btEscritores);	
		
		JButton btLibros = new JButton("Libros");
		btLibros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*llamo al método ventana.cambiarPantalla para cambiar de panel*/
				ventana.cambiarPantalla(Libro.class);				
			}
		});
		btLibros.setFont(new Font("Tahoma", Font.BOLD, 14));
		btLibros.setBounds(310, 96, 130, 23);
		add(btLibros);

	}


}
