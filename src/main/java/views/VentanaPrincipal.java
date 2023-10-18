package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {
    private JPanel panel;

    public VentanaPrincipal(){
        setTitle("Bienvenida Intranet");
        setBounds(50, 50, 300, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void iniciarComponentes(){
        generarPanel();
        bienvenida();
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

    public void bienvenida(){
        JButton boton1 = crearBoton("Registro Carrera",30,30,230,22,"Calibri");
        panel.add(boton1);

        JButton boton2 = crearBoton("Registro Estudiante",30,80,230,22,"Calibri");
        panel.add(boton2);

        JButton boton3 = crearBoton("Buscar Estudiante",30,130,230,22,"Calibri");
        panel.add(boton3);

        JButton boton4 = crearBoton("Salir",30,200,230,22,"Calibri");
        panel.add(boton4);

        ActionListener eventoClick1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VentanaRegistroCarrera ventanaRegistroCarrera = new VentanaRegistroCarrera();
                ventanaRegistroCarrera.setVisible(true);
            }
        };
        boton1.addActionListener(eventoClick1);

        ActionListener eventoClick2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VentanaRegistroEstudiante ventanaRegistroEstudiante = new VentanaRegistroEstudiante();
                ventanaRegistroEstudiante.setVisible(true);
            }
        };
        boton2.addActionListener(eventoClick2);

        ActionListener eventoClick3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VentanaBuscarEstudiante ventanaBuscarEstudiante = new VentanaBuscarEstudiante();
                ventanaBuscarEstudiante.setVisible(true);
            }
        };
        boton3.addActionListener(eventoClick3);

        ActionListener eventoClick4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        };
        boton4.addActionListener(eventoClick4);
    }
}