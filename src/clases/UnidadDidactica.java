/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author 2dam
 */
public class UnidadDidactica {
    
    private int idUnidadDidactica;
    private String acronimo;
    private String titulo;
    private String evaluacion;
    private String descripcion;

    public UnidadDidactica(int id, String anonimo, String titulo, String evaluacion, String descripcion) {
        this.idUnidadDidactica = id;
        this.acronimo = anonimo;
        this.titulo = titulo;
        this.evaluacion = evaluacion;
        this.descripcion = descripcion;
    }

    public UnidadDidactica() {
    }

    public int getIdUnidadDidactica() {
        return idUnidadDidactica;
    }

    public void setIdUnidadDidactica(int idUnidadDidactica) {
        this.idUnidadDidactica = idUnidadDidactica;
    }

    public String getAcronimo() {
        return acronimo;
    }

    public void setAcronimo(String acronimo) {
        this.acronimo = acronimo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(String evaluacion) {
        this.evaluacion = evaluacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "UnidadDidactica{" + "id=" + idUnidadDidactica + ", acronimo=" + acronimo + ", titulo=" + titulo + ", evaluacion=" + evaluacion + ", descripcion=" + descripcion + '}';
    }
    
    
    
}
