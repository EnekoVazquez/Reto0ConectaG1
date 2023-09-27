/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import clases.ConvocatoriaExamen;
import clases.Enunciado;
import clases.UnidadDidactica;
import modelo.*;
import utilidades.Utilidades;

/**
 *
 * @author 2dam
 */
public class Controlador {

    private Dao daoBD = Factoria.getImplementacionBD();
    private Dao daoFich = Factoria.getImplementacionFich();

    public void crearUnidadDidactica(UnidadDidactica UD) {
        daoBD.crearUnidadDidactica(UD);
    }

    public void crearConvocatoria(ConvocatoriaExamen CE) {
        daoFich.crearConvocatoria(CE);
    }
    public void consultarUnidadDidactica() {

    }

    public void consultarEnunciado() {

    }

    public void consultarConvocatoria(String idConvocatoria) {
        daoFich.consultarConvocatoria(idConvocatoria);
    }

    public void visualizarEnunciado() {

    }
    public boolean verificarExistenciaUnidadDidactica(int idUnidadDidactica){
        
       return daoBD.verificarExistenciaUnidadDidactica(idUnidadDidactica);
    
    }
     public boolean verificarExistenciaConvocatoria(String convocatoria){
        
       return daoFich.verificarExistenciaConvocatoria(convocatoria);
    
    }

    public void crearEnunciado(Enunciado EN) {
       daoBD.crearEnunciado(EN);
    }

}
