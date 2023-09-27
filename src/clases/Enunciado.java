/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import utilidades.Utilidades;

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
    private ArrayList<UnidadDidactica> unidades;


    public Enunciado() {
    }

    public Enunciado(int id, String descipcion, Dificultad dificultad, boolean disponible, String ruta) {
        this.idEnunciado = id;
        this.descipcion = descipcion;
        this.dificultad = dificultad;
        this.disponible = disponible;
        this.ruta = ruta;
        unidades = new ArrayList<UnidadDidactica>();
    }

    public int getIdEnunciado() {
        return idEnunciado;
    }

    public void setIdEnunciado(int idEnunciado) {
        this.idEnunciado = idEnunciado;
    }

    public String getDescipcion() {
        return descipcion;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }

    public Dificultad getDificultad() {
        return dificultad;
    }

    public void setDificultad(Dificultad dificultad) {
        this.dificultad = dificultad;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    @Override
    public String toString() {
        return "Enunciado{" + "idEnunciado=" + idEnunciado + ", descipcion=" + descipcion + ", dificultad=" + dificultad + ", disponible=" + disponible + ", ruta=" + ruta + ", unidades=" + unidades + '}';
    }

    
    public void insertarUnidades(){
        String respuesta;
        
        do {
            UnidadDidactica UD = new UnidadDidactica();
            UD.setDatos();
            unidades.add(UD);
            
            respuesta = Utilidades.introducirCadena("Quieres seguir introduciendo?");
        } while (respuesta.equalsIgnoreCase("S"));
    }
    
    
    
    
}
