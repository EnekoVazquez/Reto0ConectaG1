/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.List;

/**
 *
 * @author 2dam
 */
public class Enunciado {

    private int idEnunciado;
    private String descipcion;
    private Dificultad dificultad;
    private boolean disponible;
    private String ruta;
    private List<UnidadDidactica> unidades;

    public Enunciado() {
    }

    public Enunciado(int idEnunciado, String descipcion, Dificultad dificultad, boolean disponible, String ruta, List<UnidadDidactica> unidades) {
        this.idEnunciado = idEnunciado;
        this.descipcion = descipcion;
        this.dificultad = dificultad;
        this.disponible = disponible;
        this.ruta = ruta;
        this.unidades = unidades;
    }

    public int getIdEnunciado() {
        return idEnunciado;
    }

    public String getDescipcion() {
        return descipcion;
    }

    public Dificultad getDificultad() {
        return dificultad;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public String getRuta() {
        return ruta;
    }

    public List<UnidadDidactica> getUnidades() {
        return unidades;
    }

    public void setIdEnunciado(int idEnunciado) {
        this.idEnunciado = idEnunciado;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }

    public void setDificultad(Dificultad dificultad) {
        this.dificultad = dificultad;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public void setUnidades(List<UnidadDidactica> unidades) {
        this.unidades = unidades;
    }

    @Override
    public String toString() {
        return "Enunciado{" + "idEnunciado=" + idEnunciado + ", descipcion=" + descipcion + ", dificultad=" + dificultad + ", disponible=" + disponible + ", ruta=" + ruta + ", unidades=" + unidades + '}';
    }

}
