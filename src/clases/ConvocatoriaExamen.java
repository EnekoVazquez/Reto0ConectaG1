/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import java.time.LocalDate;
import utilidades.Utilidades;

/**
 *
 * @author 2dam
 */
public class ConvocatoriaExamen implements Serializable {

    private String convocatoria;
    private String descripcion;
    private LocalDate fecha;
    private String curso;
    private int enunciado;

    public String getConvocatoria() {
        return convocatoria;
    }

    public void setConvocatoria(String convocatoria) {
        this.convocatoria = convocatoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(int enunciado) {
        this.enunciado = enunciado;
    }
    

    public ConvocatoriaExamen(String convocatoria, String descripcion, LocalDate fecha, String curso, int enunciado) {
        this.convocatoria = convocatoria;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.curso = curso;
        this.enunciado = enunciado;
    }

    public ConvocatoriaExamen() {

    }


    @Override
    public String toString() {
        return "ConvocatoriaExamen{" + "convocatoria=" + convocatoria + ", descripcion=" + descripcion + ", fecha=" + fecha + ", curso=" + curso + '}';

    }

}
