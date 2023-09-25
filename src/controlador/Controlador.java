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

/**
 *
 * @author 2dam
 */
public class Controlador {

    private Dao daoBD = Factoria.getImplementacionBD();
    private Dao daoFich = Factoria.getImplementacionFich();

    public UnidadDidactica crearUnidadDidactica(UnidadDidactica UD) {
        daoBD.crearUnidadDidactica(UD);
        return UD;
    }

    public void crearConvocatoria(ConvocatoriaExamen CE) {
        daoFich.crearConvocatoria(CE);
    }

    public void crearEnunciado(Enunciado EN) {
        daoBD.crearEnunciado(EN);
    }

    public void consultarUnidadDidactica(int consul ) {
        daoBD.consultarUnidadDidactica(consul);
    }

    public void consultarEnunciado(int consul1) {
        daoBD.consultarEnunciado(consul1);
    }

    public void consultarConvocatoria(String idConvocatoria) {
        daoFich.consultarConvocatoria(idConvocatoria);
    }

    public void visualizarEnunciado() {

    }

    

}
