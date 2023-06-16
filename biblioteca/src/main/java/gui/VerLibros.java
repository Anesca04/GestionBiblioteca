package gui;

import biblioteca.Libro;
import java.awt.BorderLayout;
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
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VerLibros extends JPanel{
    private JTextField txCodigo;
    private JTextField txTitulo;
    private JTextField txEditorial;
    private JTextField txPaginas;

    public VerLibros(Ventana v) {
        setLayout(null);

        JLabel lbPrincipal = new JLabel("Libros disponibles");
        lbPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
        lbPrincipal.setBounds(0, 20, v.WIDTH, 49);
        lbPrincipal.setAlignmentX(CENTER_ALIGNMENT);
        lbPrincipal.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(lbPrincipal);
        
        final JButton btVolver = new JButton("Volver");
        btVolver.setHorizontalAlignment(SwingConstants.CENTER);
        btVolver.setAlignmentX(CENTER_ALIGNMENT);
        btVolver.setBounds(v.WIDTH/2 - 65, v.HEIGHT - 150, 130, 70);
        btVolver.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(btVolver);
        
        btVolver.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                /*llamo al método v.cambiarPantalla para cambiar de panel*/
                v.cambiarPantalla(DashboardClientes.class);
            }
        });
        
        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
        int numLibros = v.biblioteca.getLibrosDisponibles().size();
        
        textArea.append("\n");
        for (int i = 0; i < numLibros; i++){
            textArea.append(" " + (i+1) + ". " + v.biblioteca.getLibrosDisponibles().get(i).toString() + "\n");
        }
        
        textArea.setEditable(false);
 
        JScrollPane scroll = new JScrollPane(textArea);
 
        // JFrame frame = new JFrame("Ejemplo JScrollPane");
        add(scroll, BorderLayout.CENTER);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scroll.setBounds(20, 80, v.WIDTH-40, v.HEIGHT - 300);
        // fsetLocationRelativeTo(null);
        scroll.setVisible(true);
        
        
        
        

    }
}
