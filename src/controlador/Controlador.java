/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import clases.ConvocatoriaExamen;
import clases.UnidadDidactica;
import modelo.*;

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

    public void crearEnunciado() {

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

}
