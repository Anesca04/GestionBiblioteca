package gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaLogin extends JPanel{
	private JTextField txUsuario;
	private JTextField txClave;
	private Ventana ventana;
	
	public PantallaLogin(Ventana v) {
		this.ventana=v;
		setLayout(null);
		
		JButton btRegistrar = new JButton("Regístrate");
		btRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*llamo al método ventana.cambiarPantalla para cambiar de panel*/
				ventana.cambiarPantalla(PantallaRegistro.class);
				/*Muestro por consola la información*/
				System.out.println("Pantalla Registro");
			}
		});
		
		btRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btRegistrar.setToolTipText("Pinchar para registrarte");
		btRegistrar.setBackground(new Color(0, 128, 128));
		btRegistrar.setBounds(75, 304, 139, 43);
		add(btRegistrar);
		
		JButton btIniciar = new JButton("Iniciar Sesión");
		btIniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*Recupero lo introducido en la caja txUsuario*/
				String usuario=txUsuario.getText();
				/*Muestro por consola la información*/
				System.out.println(usuario);
			}
		});
		
		btIniciar.setToolTipText("Pinchar para iniciar sesión");
		btIniciar.setBackground(new Color(0, 128, 128));
		btIniciar.setBounds(313, 304, 139, 43);
		add(btIniciar);
		
		txUsuario = new JTextField();
		txUsuario.setFont(new Font("Arial", Font.ITALIC, 12));
		txUsuario.setBounds(75, 56, 377, 43);
		add(txUsuario);
		txUsuario.setColumns(10);
		
		JLabel lbUsuario = new JLabel("Correo Electrónico");
		lbUsuario.setBounds(72, 39, 102, 14);
		add(lbUsuario);
		
		JLabel lbClave = new JLabel("Contraseña");
		lbClave.setBounds(75, 110, 102, 14);
		add(lbClave);
		
		txClave = new JTextField();
		txClave.setFont(new Font("Arial", Font.ITALIC, 12));
		txClave.setColumns(10);
		txClave.setBounds(78, 127, 377, 43);
		add(txClave);
	}
}
