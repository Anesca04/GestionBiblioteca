package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;

public class PantallaBibliotecario extends JPanel{
	private JTextField txDNI;
	private JTextField txHorario;
	private JTextField txSueldo;
	private JTextField textField;
	
	public PantallaBibliotecario(Ventana v) {
		setLayout(null);
		
		JLabel lbCodigo = new JLabel("Código:");
		lbCodigo.setBounds(20, 56, 69, 14);
		add(lbCodigo);
		
		JLabel lbNombre = new JLabel("Nombre: ");
		lbNombre.setBounds(20, 97, 56, 14);
		add(lbNombre);
		
		JLabel lbHorario = new JLabel("Horario:");
		lbHorario.setBounds(20, 141, 46, 14);
		add(lbHorario);
		
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
		
		txHorario = new JTextField();
		txHorario.setColumns(10);
		txHorario.setBounds(75, 138, 222, 20);
		add(txHorario);
		
		JLabel lblNewLabel = new JLabel("FICHA BIBLIOTECARIOS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 578, 14);
		add(lblNewLabel);	
		
		JComboBox cbNombre = new JComboBox();
		cbNombre.setBounds(75, 93, 222, 22);
		add(cbNombre);
		
		JLabel lbSueldo = new JLabel("Sueldo: ");
		lbSueldo.setBounds(20, 181, 46, 14);
		add(lbSueldo);
		
		txSueldo = new JTextField();
		txSueldo.setColumns(10);
		txSueldo.setBounds(75, 178, 86, 20);
		add(txSueldo);
		
		JLabel lbTelefono = new JLabel("Teléfono:");
		lbTelefono.setBounds(20, 221, 46, 14);
		add(lbTelefono);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(75, 218, 86, 20);
		add(textField);
		
		
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
