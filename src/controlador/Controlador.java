/**
 * La clase Controlador actúa como una interfaz entre la capa de presentación y la capa de datos.
 * Contiene métodos para gestionar las unidades didácticas, convocatorias de exámenes, enunciados,
 * y ofrece funcionalidades para consultar, crear y verificar la existencia de estos elementos.
 * 
 * @author josu, eneko, egoitz
 * @version 1.0
 */
package controlador;

import clases.ConvocatoriaExamen;
import clases.Enunciado;
import clases.UnidadDidactica;
import java.awt.Desktop;
import java.io.File;
import modelo.*;
import utilidades.Utilidades;

public class Controlador {

    // Atributos de la clase
    private Dao daoBD = Factoria.getImplementacionBD();
    private Dao daoFich = Factoria.getImplementacionFich();

    /**
     * Crea una nueva unidad didáctica en la base de datos.
     * 
     * @param UD La unidad didáctica a crear.
     */
    public void crearUnidadDidactica(UnidadDidactica UD) {
        daoBD.crearUnidadDidactica(UD);
    }

    /**
     * Crea una nueva convocatoria de examen en un fichero.
     * 
     * @param CE La convocatoria de examen a crear.
     */
    public void crearConvocatoria(ConvocatoriaExamen CE) {
        daoFich.crearConvocatoria(CE);
    }

    /**
     * Consulta una unidad didáctica en la base de datos.
     */
    public void consultarUnidadDidactica() {
        // Implementación de la consulta de unidad didáctica
    }

    /**
     * Consulta un enunciado por su ID en la base de datos.
     * 
     * @param id El ID del enunciado a consultar.
     */
    public void consultarEnunciado(int id) {
        daoBD.consultarEnunciado(id);
    }

    /**
     * Consulta una convocatoria de examen por su ID en un fichero.
     * 
     * @param idConvocatoria El ID de la convocatoria a consultar.
     */
    public void consultarConvocatoria(String idConvocatoria) {
        daoFich.consultarConvocatoria(idConvocatoria);
    }

    /**
     * Visualiza un enunciado por su ID en el sistema.
     * 
     * @param id El ID del enunciado a visualizar.
     */
    public void visualizarEnunciado(int id) {
        Enunciado en = new Enunciado();
        en = daoBD.visualizarEnunciado(id);
        try {
            File file = new File(en.getRuta());
            Desktop.getDesktop().open(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Verifica la existencia de una unidad didáctica en la base de datos.
     * 
     * @param idUnidadDidactica El ID de la unidad didáctica a verificar.
     * @return true si la unidad didáctica existe, false en caso contrario.
     */
    public boolean verificarExistenciaUnidadDidactica(int idUnidadDidactica) {
        return daoBD.verificarExistenciaUnidadDidactica(idUnidadDidactica);
    }

    /**
     * Verifica la existencia de una convocatoria de examen en un fichero.
     * 
     * @param convocatoria El nombre de la convocatoria a verificar.
     * @return true si la convocatoria existe, false en caso contrario.
     */
    public boolean verificarExistenciaConvocatoria(String convocatoria) {
        return daoFich.verificarExistenciaConvocatoria(convocatoria);
    }

    /**
     * Crea un nuevo enunciado en la base de datos.
     * 
     * @param EN El enunciado a crear.
     */
    public void crearEnunciado(Enunciado EN) {
        daoBD.crearEnunciado(EN);
    }
}
