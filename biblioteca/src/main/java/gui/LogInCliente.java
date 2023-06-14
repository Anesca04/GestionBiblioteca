/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author manbolq
 */
public class LogInCliente extends JPanel{
    private JTextField txDNI;
    
    public LogInCliente(Ventana v){
        setLayout(null);
        
        JLabel lbPrincipal = new JLabel("Log in para Cliente");
        lbPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
        lbPrincipal.setBounds(0, 20, v.WIDTH, 49);
        lbPrincipal.setAlignmentX(CENTER_ALIGNMENT);
        lbPrincipal.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(lbPrincipal);
        
        JLabel lbDNI = new JLabel("DNI: ");
        lbDNI.setVerticalAlignment(SwingConstants.CENTER);
        lbDNI.setAlignmentY(CENTER_ALIGNMENT);
        lbDNI.setFont(new Font("Tahoma", Font.BOLD, 25));
        lbDNI.setBounds(v.WIDTH/2 - 75, v.HEIGHT/4 + 50, 100, 40);
        add(lbDNI);
        
        txDNI = new JTextField();
        txDNI.setBounds(v.WIDTH/2, v.HEIGHT/4 + 56, 150, 30);
        add(txDNI);
        txDNI.setColumns(10);
        txDNI.setFont(new Font("Tahoma", Font.PLAIN, 23));
        
        final JButton btOK = new JButton("OK");
        btOK.setHorizontalAlignment(SwingConstants.CENTER);
        btOK.setAlignmentX(CENTER_ALIGNMENT);
        btOK.setBounds(v.WIDTH/2 + 35, v.HEIGHT/2, 70, 70);
        btOK.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(btOK);
        btOK.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                /*llamo al método v.cambiarPantalla para cambiar de panel*/
                v.cliente = v.biblioteca.clienteAPartirDNI(txDNI.getText());
                // System.out.println(v.cliente);
                v.cambiarPantalla(DashboardClientes.class);
            }
        });
        
        final JButton btVolver = new JButton("Volver");
        btVolver.setHorizontalAlignment(SwingConstants.CENTER);
        btVolver.setAlignmentX(CENTER_ALIGNMENT);
        btVolver.setBounds(v.WIDTH/2 - 135, v.HEIGHT/2, 130, 70);
        btVolver.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(btVolver);
        
        btVolver.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                /*llamo al método v.cambiarPantalla para cambiar de panel*/
                v.cambiarPantalla(OpcionesVentana.class);
            }
        });
    }
}
