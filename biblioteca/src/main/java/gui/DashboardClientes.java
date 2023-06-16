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

public class DashboardClientes extends JPanel{
    private JTextField txCodigo;
    private JTextField textField;

    public DashboardClientes(Ventana v) {
        setLayout(null);
        
        JLabel lbPrincipal = new JLabel("Bienvenid@, " + v.cliente.getNombre() + "!");
        lbPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
        lbPrincipal.setBounds(0, 20, v.WIDTH, 49);
        lbPrincipal.setAlignmentX(CENTER_ALIGNMENT);
        lbPrincipal.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(lbPrincipal);
        
        JButton btLogOut = new JButton("Cerrar sesión");
        btLogOut.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                /*llamo al método ventana.cambiarPantalla para cambiar de panel*/
                v.cliente = null;
                v.cambiarPantalla(OpcionesVentana.class);
            }
        });
        btLogOut.setFont(new Font("Tahoma", Font.BOLD, 20));
        btLogOut.setHorizontalAlignment(SwingConstants.CENTER);
        btLogOut.setAlignmentX(CENTER_ALIGNMENT);
        btLogOut.setBounds(v.WIDTH - 230, 20, 200, 50);
        btLogOut.setBackground(Color.red);
        add(btLogOut);
        
        // ver libros
        // ver informacion personal
        // editar informacion personal
        
        
        JButton btVerLibros = new JButton("Ver libros");
        btVerLibros.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                /*llamo al método ventana.cambiarPantalla para cambiar de panel*/
                v.cambiarPantalla(VerLibros.class);
            }
        });
        btVerLibros.setFont(new Font("Tahoma", Font.BOLD, 20));
        btVerLibros.setHorizontalAlignment(SwingConstants.CENTER);
        btVerLibros.setAlignmentX(CENTER_ALIGNMENT);
        btVerLibros.setBounds(v.WIDTH/4, 150, v.WIDTH/2+30, 50);
        add(btVerLibros);
        
        
        JButton btVerInfo = new JButton("Ver libros prestados");
        btVerInfo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                /*llamo al método ventana.cambiarPantalla para cambiar de panel*/
                v.cambiarPantalla(VerLibrosPrestados.class);
            }
        });
        btVerInfo.setFont(new Font("Tahoma", Font.BOLD, 20));
        btVerInfo.setHorizontalAlignment(SwingConstants.CENTER);
        btVerInfo.setAlignmentX(CENTER_ALIGNMENT);
        btVerInfo.setBounds(v.WIDTH/4, 300, v.WIDTH/2+30, 50);
        add(btVerInfo);


        JButton btEditarInfo = new JButton("Editar información personal");
        btEditarInfo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                /*llamo al método ventana.cambiarPantalla para cambiar de panel*/
                v.cambiarPantalla(EditarInfoCliente.class);
            }
        });
        btEditarInfo.setFont(new Font("Tahoma", Font.BOLD, 20));
        btEditarInfo.setHorizontalAlignment(SwingConstants.CENTER);
        btEditarInfo.setAlignmentX(CENTER_ALIGNMENT);
        btEditarInfo.setBounds(v.WIDTH/4, 450, v.WIDTH/2+30, 50);
        add(btEditarInfo);
        

    }
}
