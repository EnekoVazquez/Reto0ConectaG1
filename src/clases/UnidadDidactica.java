/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import utilidades.Utilidades;
/**
 *
 * @author Eneko
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

    public String getAnonimo() {
        return acronimo;
    }

    public void setAnonimo(String anonimo) {
        this.acronimo = anonimo;
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
    public void setDatos(){
        idUnidadDidactica = Utilidades.leerInt("Dime la id de la unidad didactica");
        acronimo = Utilidades.introducirCadena("Dime el acronimo");
        titulo = Utilidades.introducirCadena("Dime el titulo");
        evaluacion = Utilidades.introducirCadena("Dime la evaluacion");
        descripcion = Utilidades.introducirCadena("Dime la descripcion");
    }
    
    
    
}
