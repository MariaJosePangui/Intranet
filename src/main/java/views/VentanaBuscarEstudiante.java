package views;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class VentanaBuscarEstudiante extends JFrame{
    private JPanel panel;

    public VentanaBuscarEstudiante(){
        setTitle("Registro Carrera");
        setBounds(50, 50, 460, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void iniciarComponentes(){
        generarPanel();
        buscarEstudiante();
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

    public void buscarEstudiante(){
        JLabel etiqueta1 = crearEtiqueta("Nombre Estudiante: ",10,30,200,16,"Calibri");
        panel.add(etiqueta1);

        JLabel etiqueta2 = crearEtiqueta("Carrera: ",10,80,200,16,"Calibri");
        panel.add(etiqueta2);

        JTextField cajaTexto1 = crearCajaTexto(200,27,200,16);
        panel.add(cajaTexto1);

        String[] carreras = {};
        JComboBox listaDesplegable1 = new JComboBox(carreras);
        listaDesplegable1.setBounds(200,77,200,20);
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/intranet","root","");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from carrera");
            ResultSet set = preparedStatement.executeQuery();

            while (set.next()){
                listaDesplegable1.addItem(set.getString("nombre_carrera"));
            }
        } catch (SQLException e) {

        }
        panel.add(listaDesplegable1);

        JButton boton1 = crearBoton("Buscar Estudiante",20,200,190,20,"Calibri");
        panel.add(boton1);

        JButton boton2 = crearBoton("Volver",230,200,190,20,"Calibri");
        panel.add(boton2);

        ActionListener eventoClick1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VentanaMostrarTabla ventanaMostrarTabla = new VentanaMostrarTabla(cajaTexto1.getText(),(String)listaDesplegable1.getSelectedItem());

            }
        };
        boton1.addActionListener(eventoClick1);

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