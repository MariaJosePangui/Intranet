package views;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class VentanaMostrarTabla extends JFrame {

    public VentanaMostrarTabla(String nombre, String carrera){
        setTitle("Tabla");
        setBounds(50, 50, 460, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        iniciarComponentes(nombre,carrera);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void iniciarComponentes(String nombre, String carrera){
        mostrarTabla(nombre,carrera);
    }

    public void mostrarTabla(String nombre, String carrera){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2,1));
        frame.setSize(400,300);
        frame.setLocationRelativeTo(null);
        JTable tabla = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("rut");
        model.addColumn("nombre");
        model.addColumn("matricula");
        model.addColumn("carrera");
        tabla.setModel(model);

        String[] datos = new String[4];
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/intranet","root","");
            PreparedStatement preparedStatement1 = connection.prepareStatement("select * from estudiante where nombre = ? and codigo_carrera = ?");
            preparedStatement1.setString(1,nombre);
            preparedStatement1.setString(2,carrera);
            ResultSet set1 = preparedStatement1.executeQuery();

            PreparedStatement preparedStatement2 = connection.prepareStatement("select * from estudiante where codigo_carrera = ?");
            preparedStatement2.setString(1,carrera);
            ResultSet set2 = preparedStatement2.executeQuery();

            if(set1.next()){
                while(set1.next()){
                    datos[0] = set1.getString(1);
                    datos[1] = set1.getString(2);
                    datos[2] = set1.getString(3);
                    datos[3] = set1.getString(4);
                    model.addRow(datos);
                }
            }else if(set2.next()){
                datos[0] = set2.getString(1);
                datos[1] = set2.getString(2);
                datos[2] = set2.getString(3);
                datos[3] = set2.getString(4);
                model.addRow(datos);

            }

        } catch (SQLException ex) {

        }
        JScrollPane scrollPane = new JScrollPane(tabla);
        frame.add(scrollPane,0,0);
        frame.setVisible(true);
    }
}