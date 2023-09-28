/**
 * La interfaz Dao define los métodos que deben ser implementados por las clases que gestionan
 * la persistencia de datos relacionados con unidades didácticas, convocatorias de exámenes y enunciados.
 * Estos métodos incluyen operaciones de creación, consulta y verificación de existencia de datos.
 * 
 * @author josu, egoitz, eneko
 * @version 1.0
 */
package modelo;

import clases.ConvocatoriaExamen;
import clases.Enunciado;
import clases.UnidadDidactica;
import java.util.List;

public interface Dao {

    /**
     * Crea una nueva unidad didáctica.
     * 
     * @param UD La unidad didáctica a crear.
     */
    public void crearUnidadDidactica(UnidadDidactica UD);

    /**
     * Crea una nueva convocatoria de examen.
     * 
     * @param CE La convocatoria de examen a crear.
     */
    public void crearConvocatoria(ConvocatoriaExamen CE);

    /**
     * Crea un nuevo enunciado.
     * 
     * @param EN El enunciado a crear.
     */
    public void crearEnunciado(Enunciado EN);

    /**
     * Consulta un enunciado por su ID.
     * 
     * @param idEnunciado El ID del enunciado a consultar.
     * @return El enunciado encontrado.
     */
    public Enunciado consultarEnunciado(int idEnunciado);

    /**
     * Consulta una convocatoria de examen por su ID.
     * 
     * @param idConvocatoria El ID de la convocatoria a consultar.
     */
    public void consultarConvocatoria(String idConvocatoria);
    
    /**
     * Visualiza un enunciado por su ID.
     * 
     * @param id El ID del enunciado a visualizar.
     * @return El enunciado visualizado.
     */
    public Enunciado visualizarEnunciado(Integer id );

    /**
     * Consulta una unidad didáctica por su ID.
     * 
     * @param idUnidadDidactica El ID de la unidad didáctica a consultar.
     * @return La unidad didáctica encontrada.
     */
    public UnidadDidactica consultarUnidadDidactica(String idUnidadDidactica);
    
    /**
     * Verifica la existencia de una unidad didáctica por su ID.
     * 
     * @param idUnidadDidactica El ID de la unidad didáctica a verificar.
     * @return true si la unidad didáctica existe, false en caso contrario.
     */
    public boolean verificarExistenciaUnidadDidactica(int idUnidadDidactica);

    /**
     * Verifica la existencia de una convocatoria de examen por su nombre.
     * 
     * @param convocatoria El nombre de la convocatoria a verificar.
     * @return true si la convocatoria existe, false en caso contrario.
     */
    public boolean verificarExistenciaConvocatoria(String convocatoria);
}
