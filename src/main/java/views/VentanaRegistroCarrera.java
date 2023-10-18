package views;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class VentanaRegistroCarrera extends  JFrame{
    private JPanel panel;

    public VentanaRegistroCarrera(){
        setTitle("Registro Carrera");
        setBounds(50, 50, 460, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void iniciarComponentes(){
        generarPanel();
        registroCarrera();
    }

    public void generarPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);
        this.getContentPane().add(panel);
    }

    public JButton crearBoton(String texto, int x, int y, int ancho, int alto, String estiloTexto){
        JButton boton = new JButton();
        boton.setText(texto);
        boton.setBounds(x,y,ancho,alto);
        boton.setForeground(Color.black);
        boton.setFont(new Font(estiloTexto,1,(alto)));
        return boton;
    }

    public JLabel crearEtiqueta(String texto, int x, int y, int ancho, int alto,String estiloTexto){
        JLabel etiqueta = new JLabel();
        etiqueta.setText(texto);
        etiqueta.setBounds(x,y,ancho,alto);
        etiqueta.setHorizontalAlignment(SwingConstants.LEFT);
        etiqueta.setForeground(Color.BLACK);
        etiqueta.setFont(new Font(estiloTexto,1,alto));
        return etiqueta;
    }

    public JTextField crearCajaTexto(int x, int y, int ancho, int alto){
        JTextField cajaTexto = new JTextField();
        cajaTexto.setBounds(x,y,ancho,alto);
        return cajaTexto;
    }

    public void registroCarrera(){
        JLabel etiqueta1 = crearEtiqueta("Registro de Carrera Universitaria",70,20,400,23,"Calibri");
        panel.add(etiqueta1);

        JLabel etiqueta2 = crearEtiqueta("Nombre Carrera: ",10,70,200,16,"Calibri");
        panel.add(etiqueta2);

        JLabel etiqueta3 = crearEtiqueta("Código Carrera: ",10,110,200,16,"Calibri");
        panel.add(etiqueta3);

        JLabel etiqueta4 = crearEtiqueta("Cantidad de semestre: ",10,150,200,16,"Calibri");
        panel.add(etiqueta4);

        JTextField cajaTexto1 = crearCajaTexto(200,70,200,20);
        panel.add(cajaTexto1);

        JTextField cajaTexto2 = crearCajaTexto(200,110,200,20);
        panel.add(cajaTexto2);

        JTextField cajaTexto3 = crearCajaTexto(200,150,200,20);
        panel.add(cajaTexto3);

        JButton boton1 = crearBoton("Registrar Carrera",20,250,200,20,"Calibri");
        panel.add(boton1);

        JButton boton2 = crearBoton("Volver",230,250,200,20,"Calibri");
        panel.add(boton2);

        ActionListener eventoClik1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/intranet","root","");
                    PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO tu_tabla (nombreCarrera, codigoCarrera, cantidadSemestres) VALUES (?, ?, ?)");
                    preparedStatement.setString(1,cajaTexto1.getText().trim());
                    preparedStatement.setString(2,cajaTexto2.getText().trim());
                    preparedStatement.setString(3,cajaTexto3.getText().trim());
                    preparedStatement.executeUpdate();

                    cajaTexto1.setText("");
                    cajaTexto2.setText("");
                    cajaTexto3.setText("");
                    JOptionPane.showMessageDialog(null,"Registro existoso");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"No se pudo hacer coneccion");

                }
            }
        };
        boton1.addActionListener(eventoClik1);

        ActionListener eventoClick2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
                ventanaPrincipal.setVisible(true);
            }
        };
        boton2.addActionListener(eventoClick2);
    }
}