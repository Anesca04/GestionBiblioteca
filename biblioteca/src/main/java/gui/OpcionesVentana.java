package gui;

import java.awt.FlowLayout;
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
    // private JButton btUsuarios;

    public OpcionesVentana(Ventana v) {
        this.ventana=v;
        setLayout(null);

        JLabel lbPrincipal = new JLabel("Menú de opciones");
        lbPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
        lbPrincipal.setBounds(0, 20, v.WIDTH, 49);
        lbPrincipal.setAlignmentX(CENTER_ALIGNMENT);
        lbPrincipal.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(lbPrincipal);

        JButton btSoyCliente = new JButton("Soy cliente");
        btSoyCliente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                /*llamo al método ventana.cambiarPantalla para cambiar de panel*/
                ventana.cambiarPantalla(LogInCliente.class);
            }
        });
        btSoyCliente.setFont(new Font("Tahoma", Font.BOLD, 20));
        btSoyCliente.setHorizontalAlignment(SwingConstants.CENTER);
        btSoyCliente.setAlignmentX(CENTER_ALIGNMENT);
        btSoyCliente.setBounds(v.WIDTH/4, 150, v.WIDTH/2, 50);
        add(btSoyCliente);
        
        
        JButton quieroSerCliente = new JButton("Quiero ser cliente");
        quieroSerCliente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                /*llamo al método ventana.cambiarPantalla para cambiar de panel*/
                ventana.cambiarPantalla(RegistroCliente.class);
            }
        });
        quieroSerCliente.setFont(new Font("Tahoma", Font.BOLD, 20));
        quieroSerCliente.setHorizontalAlignment(SwingConstants.CENTER);
        quieroSerCliente.setAlignmentX(CENTER_ALIGNMENT);
        quieroSerCliente.setBounds(v.WIDTH/4, 300, v.WIDTH/2, 50);
        add(quieroSerCliente);


        JButton btSoyBibliotecario = new JButton("Soy bibliotecario");
        btSoyBibliotecario.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                /*llamo al método ventana.cambiarPantalla para cambiar de panel*/
                ventana.cambiarPantalla(LogInBibliotecario.class);
            }
        });
        btSoyBibliotecario.setFont(new Font("Tahoma", Font.BOLD, 20));
        btSoyBibliotecario.setHorizontalAlignment(SwingConstants.CENTER);
        btSoyBibliotecario.setAlignmentX(CENTER_ALIGNMENT);
        btSoyBibliotecario.setBounds(v.WIDTH/4, 450, v.WIDTH/2, 50);
        add(btSoyBibliotecario);

    }


}
