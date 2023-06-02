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
import javax.swing.JComboBox;

public class Libro extends JPanel{
	private JTextField txCodigo;
	private JTextField txTitulo;
	private JTextField txEditorial;
	private JTextField txPaginas;
	
	public Libro(Ventana v) {
		setLayout(null);
		
		JLabel lbCodigo = new JLabel("Código:");
		lbCodigo.setBounds(20, 56, 69, 14);
		add(lbCodigo);
		
		JLabel lbEscritor = new JLabel("Escritor:");
		lbEscritor.setBounds(20, 136, 56, 14);
		add(lbEscritor);
		
		JLabel lbTitulo = new JLabel("Título");
		lbTitulo.setBounds(20, 95, 46, 14);
		add(lbTitulo);
		
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
		
		txTitulo = new JTextField();
		txTitulo.setColumns(10);
		txTitulo.setBounds(75, 92, 222, 20);
		add(txTitulo);
		
		JLabel lblNewLabel = new JLabel("FICHA LIBROS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 578, 14);
		add(lblNewLabel);	
		
		JComboBox cbNombre = new JComboBox();
		cbNombre.setBounds(75, 132, 222, 22);
		add(cbNombre);
		
		JLabel lbEditorial = new JLabel("Editorial: ");
		lbEditorial.setBounds(20, 181, 46, 14);
		add(lbEditorial);
		
		txEditorial = new JTextField();
		txEditorial.setColumns(10);
		txEditorial.setBounds(75, 178, 86, 20);
		add(txEditorial);
		
		JLabel lbPaginas = new JLabel("Páginas:");
		lbPaginas.setBounds(20, 221, 46, 14);
		add(lbPaginas);
		
		txPaginas = new JTextField();
		txPaginas.setColumns(10);
		txPaginas.setBounds(75, 218, 86, 20);
		add(txPaginas);
		
		
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
