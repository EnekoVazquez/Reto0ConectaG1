/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import clases.ConvocatoriaExamen;
import clases.Enunciado;
import clases.UnidadDidactica;
import java.awt.Desktop;
import java.io.File;
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

    public void consultarEnunciado(int id ) {
        daoBD.consultarEnunciado(id);
        
    }

    public void consultarConvocatoria(String idConvocatoria) {
        daoFich.consultarConvocatoria(idConvocatoria);
    }

    public void visualizarEnunciado(int id ) {
        Enunciado en = new Enunciado();
        en=daoBD.visualizarEnunciado(id);
        try {
            File file = new File(en.getRuta());
            Desktop.getDesktop().open(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

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
