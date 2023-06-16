package gui;

import exceptions.DNIInvalidoException;
import exceptions.EdadInvalidaException;
import exceptions.TelefonoInvalidoException;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class RegistroCliente extends JPanel{
    private JTextField txDNI;
    private JTextField txNombre;
    private JTextField txEdad;
    private JTextField txTelefono;

    public RegistroCliente(Ventana v) {
        setLayout(null);

        JLabel lbPrincipal = new JLabel("Registro de Cliente");
        lbPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
        lbPrincipal.setBounds(0, 20, v.WIDTH, 49);
        lbPrincipal.setAlignmentX(CENTER_ALIGNMENT);
        lbPrincipal.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(lbPrincipal);


        JLabel lbDni = new JLabel("DNI: ");
        lbDni.setBounds(20, 96, 100, 20);
        lbDni.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(lbDni);

        JLabel lbNombre = new JLabel("Nombre: ");
        lbNombre.setBounds(20, 137, 130, 20);
        lbNombre.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(lbNombre);

        JLabel lbEdad = new JLabel("Edad: ");
        lbEdad.setBounds(20, 181, 100, 20);
        lbEdad.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(lbEdad);

        JLabel lbTelefono = new JLabel("Telefono: ");
        lbTelefono.setBounds(20, 223, 150, 20);
        lbTelefono.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(lbTelefono);


        final JButton btOK = new JButton("Registrarse");
        btOK.setHorizontalAlignment(SwingConstants.CENTER);
        btOK.setAlignmentX(CENTER_ALIGNMENT);
        btOK.setBounds(v.WIDTH/2 + 15, v.HEIGHT/2, 180, 70);
        btOK.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(btOK);
        btOK.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (txNombre.getText().length() > 0 && txDNI.getText().length() > 0 && txEdad.getText().length() > 0 && txTelefono.getText().length() > 0){
                    
                    // si ya existe un cliente con ese DNI, muestro mensaje de error
                    if (v.biblioteca.clienteAPartirDNI(txDNI.getText()) != null){
                        JOptionPane.showMessageDialog(null, "Ya hay un cliente registrado con ese DNI.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        boolean error = false;
                        
                        try{
                            v.biblioteca.crearCliente(txNombre.getText(), txDNI.getText(), Integer.parseInt(txEdad.getText()), txTelefono.getText());
                        }
                        catch(EdadInvalidaException ex){
                            error = true;
                            JOptionPane.showMessageDialog(null, "La edad introducida no es correcta", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        catch(DNIInvalidoException ex){
                            error = true;
                            JOptionPane.showMessageDialog(null, "Formato de DNI incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        catch(NumberFormatException ex){
                            error = true;
                            JOptionPane.showMessageDialog(null, "Formato de edad incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        catch(TelefonoInvalidoException ex){
                            error = true;
                            JOptionPane.showMessageDialog(null, "Formato de telefono incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        
                        if (!error)
                            v.cambiarPantalla(LogInCliente.class);
                    }
                    
                }
                else{
                    String mensajeError = "Los datos introducidos son incorrectos:";

                    if (txNombre.getText().length() == 0) {
                        mensajeError += "\n- El campo 'Nombre' está vacío.";
                    }
                    if (txDNI.getText().length() == 0) {
                        mensajeError += "\n- El campo 'DNI' está vacío.";
                    }
                    if (txEdad.getText().length() == 0) {
                        mensajeError += "\n- El campo 'Edad' está vacío.";
                    }
                    if (txTelefono.getText().length() == 0) {
                        mensajeError += "\n- El campo 'Teléfono' está vacío.";
                    }
                                        
                    JOptionPane.showMessageDialog(null, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });

        final JButton btVolver = new JButton("Volver");
        btVolver.setHorizontalAlignment(SwingConstants.CENTER);
        btVolver.setAlignmentX(CENTER_ALIGNMENT);
        btVolver.setBounds(v.WIDTH/2 - 155, v.HEIGHT/2, 130, 70);
        btVolver.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(btVolver);

        btVolver.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                /*llamo al método v.cambiarPantalla para cambiar de panel*/
                v.cambiarPantalla(OpcionesVentana.class);
            }
        });

        txDNI = new JTextField();
        txDNI.setBounds(105, 93, 160, 30);
        add(txDNI);
        txDNI.setColumns(10);
        txDNI.setFont(new Font("Tahoma", Font.PLAIN, 23));

        txNombre = new JTextField();
        txNombre.setColumns(10);
        txNombre.setBounds(155, 134, 300, 30);
        add(txNombre);
        txNombre.setFont(new Font("Tahoma", Font.PLAIN, 23));

        txEdad = new JTextField();
        txEdad.setColumns(10);
        txEdad.setBounds(110, 178, 69, 30);
        add(txEdad);	
        txEdad.setFont(new Font("Tahoma", Font.PLAIN, 23));

        txTelefono = new JTextField();
        txTelefono.setColumns(10);
        txTelefono.setBounds(170, 220, 170, 30);
        add(txTelefono);	
        txTelefono.setFont(new Font("Tahoma", Font.PLAIN, 23));



    }


}
