package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Usuarios extends JPanel{
	private JTextField txDNI;
	private JTextField txNombre;
	private JTextField txEdad;
	
	public Usuarios(Ventana v) {
		setLayout(null);
		
		JLabel lbDni = new JLabel("DNI: ");
		lbDni.setBounds(20, 56, 69, 14);
		add(lbDni);
		
		JLabel lbNombre = new JLabel("Nombre: ");
		lbNombre.setBounds(20, 97, 56, 14);
		add(lbNombre);
		
		JLabel lbEdad = new JLabel("Edad: ");
		lbEdad.setBounds(20, 141, 46, 14);
		add(lbEdad);
		
		final JButton btInsertar = new JButton("Insertar");
		btInsertar.setBounds(10, 295, 93, 23);
		add(btInsertar);
		
		final JButton btBuscar = new JButton("Buscar");
		btBuscar.setBounds(107, 295, 93, 23);
		add(btBuscar);
		
		final JButton btEditar = new JButton("Editar");
		btEditar.setBounds(204, 295, 93, 23);
		add(btEditar);
		btEditar.setEnabled(false);
		
		final JButton btEliminar = new JButton("Eliminar");
		btEliminar.setBounds(301, 295, 93, 23);
		add(btEliminar);
		btEliminar.setEnabled(false);
		
		final JButton btGuardar = new JButton("Guardar");
		btGuardar.setBounds(495, 295, 93, 23);
		add(btGuardar);
		btGuardar.setEnabled(false);
		
		final JButton btCancelar = new JButton("Cancelar");
		btCancelar.setBounds(398, 295, 93, 23);
		add(btCancelar);
		
		txDNI = new JTextField();
		txDNI.setBounds(75, 53, 86, 20);
		add(txDNI);
		txDNI.setColumns(10);
		
		txNombre = new JTextField();
		txNombre.setColumns(10);
		txNombre.setBounds(75, 94, 207, 20);
		add(txNombre);
		
		txEdad = new JTextField();
		txEdad.setColumns(10);
		txEdad.setBounds(75, 138, 69, 20);
		add(txEdad);
		
		JLabel lblNewLabel = new JLabel("FICHA DE USUARIOS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 531, 14);
		add(lblNewLabel);	
		
		
		btInsertar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btInsertar.setEnabled(false);
				btEditar.setEnabled(false);
				btGuardar.setEnabled(true);
			}
		});

		btBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btInsertar.setEnabled(false);
				btEditar.setEnabled(false);
				btGuardar.setEnabled(true);
			}
		});
		
	}
	
	
}
