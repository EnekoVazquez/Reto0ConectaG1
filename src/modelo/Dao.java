/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.ConvocatoriaExamen;
import clases.Enunciado;
import clases.UnidadDidactica;

/**
 *
 * @author 2dam
 */
public interface Dao {

    public void crearUnidadDidactica(UnidadDidactica UD);

    public void crearConvocatoria(ConvocatoriaExamen CE);

    public void crearEnunciado(Enunciado EN);

    public Enunciado consultarEnunciado(String idEnunciado);

    public void consultarConvocatoria(String idConvocatoria);

    public UnidadDidactica consultarUnidadDidactica(String idUnidadDidactica);
    
    public boolean verificarExistenciaUnidadDidactica(int idUnidadDidactica);

    public boolean verificarExistenciaConvocatoria(String convocatoria);

}
