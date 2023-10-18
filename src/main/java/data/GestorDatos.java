package data;

import model.Carrera;
import model.Estudiante;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GestorDatos {

    public static boolean registrarDatos(List objetos, String direccionArchivo) {
        try {
            FileWriter fw = new FileWriter(direccionArchivo, false); // Cambiado el modo de apertura para sobrescribir el archivo
            BufferedWriter bw = new BufferedWriter(fw);
            for (Object objeto : objetos) {
                bw.write(objeto.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList<Estudiante> leerArchivoEstudiante(String direccionArchivo) {
        ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();
        String textoArchivo = "";
        try {
            File archivo = new File(direccionArchivo);
            if (archivo.exists()) { // Comprobar si el archivo existe
                FileReader fr = new FileReader(archivo);
                BufferedReader br = new BufferedReader(fr);
                while ((textoArchivo = br.readLine()) != null) {
                    String[] data = textoArchivo.split(",");
                    listaEstudiantes.add(new Estudiante(data[0], data[1], data[2], data[3]));
                }
                br.close();
                fr.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Documento no disponible, favor contactar con administrador");
        }
        return listaEstudiantes;
    }

    public static ArrayList<Carrera> leerArchivoCarrera(String direccionArchivo) {
        ArrayList<Carrera> listaCarreras = new ArrayList<>();
        String textoArchivo = "";
        try {
            File archivo = new File(direccionArchivo);
            if (archivo.exists()) {
                FileReader fr = new FileReader(archivo);
                BufferedReader br = new BufferedReader(fr);
                while ((textoArchivo = br.readLine()) != null) {
                    String[] data = textoArchivo.split(",");
                    listaCarreras.add(new Carrera(data[0], data[1], Integer.parseInt(data[2])));
                }
                br.close();
                fr.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Documento no disponible, favor contactar con administrador");
        }
        return listaCarreras;
    }
}
