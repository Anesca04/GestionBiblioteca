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

public class Escritor extends JPanel{
	private JTextField txCodigo;
	private JTextField txIdioma;
	
	public Escritor(Ventana v) {
		setLayout(null);
		
		JLabel lbCodigo = new JLabel("Código:");
		lbCodigo.setBounds(20, 56, 69, 14);
		add(lbCodigo);
		
		JLabel lbNombre = new JLabel("Nombre: ");
		lbNombre.setBounds(20, 97, 56, 14);
		add(lbNombre);
		
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
		
		txCodigo = new JTextField();
		txCodigo.setBounds(75, 53, 86, 20);
		add(txCodigo);
		txCodigo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("FICHA ESCRITORES");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 578, 14);
		add(lblNewLabel);	
		
		JComboBox cbNombre = new JComboBox();
		cbNombre.setBounds(75, 93, 222, 22);
		add(cbNombre);
		
		JLabel lbIdioma = new JLabel("Idioma: ");
		lbIdioma.setBounds(20, 141, 46, 14);
		add(lbIdioma);
		
		txIdioma = new JTextField();
		txIdioma.setColumns(10);
		txIdioma.setBounds(75, 138, 86, 20);
		add(txIdioma);
		
		
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
