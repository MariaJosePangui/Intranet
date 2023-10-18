package model;

public class Carrera {
    private String nombreCarrera;
    private String codigoCarrera;
    private int cantidadSemestres;

    public Carrera(String nombreCarrera, String codigoCarrera, int cantidadSemestres) {
        this.nombreCarrera = nombreCarrera;
        this.codigoCarrera = codigoCarrera;
        this.cantidadSemestres = cantidadSemestres;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public String getCodigoCarrera() {
        return codigoCarrera;
    }

    public void setCodigoCarrera(String codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }

    public int getCantidadSemestres() {
        return cantidadSemestres;
    }

    public void setCantidadSemestres(int cantidadSemestres) {
        this.cantidadSemestres = cantidadSemestres;
    }

    public String toString(){
        return nombreCarrera+","+codigoCarrera+","+cantidadSemestres;
    }
}