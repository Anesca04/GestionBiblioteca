package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PantallaRegistro extends JPanel{
	private Ventana ventana;
	
	public PantallaRegistro(Ventana v) {
		this.ventana=v;
		setLayout(null);
		
		JLabel lbRegistro = new JLabel("REGISTRO");
		lbRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lbRegistro.setBounds(129, 121, 161, 49);
		lbRegistro.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lbRegistro);
	}

}
