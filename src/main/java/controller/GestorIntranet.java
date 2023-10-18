package controller;

import data.GestorDatos;
import model.Carrera;
import model.Estudiante;

import javax.swing.*;
import java.util.ArrayList;

public class GestorIntranet {

    private GestorDatos gestorDatos;

    public GestorIntranet() {
        gestorDatos = new GestorDatos();
    }

    public void agregarCarrera(Carrera carrera) {
        ArrayList<Carrera> listaCarreras = gestorDatos.leerArchivoCarrera("Carreras.txt");

        if (validarNombreCarrera(carrera.getNombreCarrera())) {
            Carrera carreraExistente = buscarCarrera(listaCarreras, carrera.getNombreCarrera());

            if (carreraExistente == null) {
                listaCarreras.add(carrera);
                gestorDatos.registrarDatos(listaCarreras, "Carreras.txt");
                JOptionPane.showMessageDialog(null, "La carrera ha sido registrada correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "La carrera ya había sido registrada anteriormente");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El nombre de la carrera es inválido");
        }
    }

    public void agregarEstudiante(Estudiante estudiante) {
        ArrayList<Estudiante> listaEstudiantes = gestorDatos.leerArchivoEstudiante("Estudiantes.txt");

        listaEstudiantes.add(estudiante);
        gestorDatos.registrarDatos(listaEstudiantes, "Estudiantes.txt");
        JOptionPane.showMessageDialog(null, "El estudiante ha sido registrado correctamente");
    }

    public Estudiante buscarEstudiante(String rut) {
        ArrayList<Estudiante> listaEstudiantes = gestorDatos.leerArchivoEstudiante("Estudiantes.txt");

        for (Estudiante estudiante : listaEstudiantes) {
            if (estudiante.getRut().equals(rut)) {
                return estudiante;
            }
        }

        return null;
    }

    public Carrera buscarCarrera(ArrayList<Carrera> listaCarreras, String nombreCarrera) {
        for (Carrera carrera : listaCarreras) {
            if (carrera.getNombreCarrera().equals(nombreCarrera)) {
                return carrera;
            }
        }

        return null;
    }

    public boolean validarNombreCarrera(String nombre) {
        return !nombre.isEmpty();
    }
}
