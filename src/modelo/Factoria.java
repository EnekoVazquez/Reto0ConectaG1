/**
 * La clase Factoria proporciona métodos estáticos para obtener implementaciones concretas de la interfaz Dao.
 * Puedes obtener implementaciones tanto para la gestión de base de datos como para la gestión de ficheros.
 * 
 * @author josu, eneko, egoitz
 * @version 1.0
 */
package modelo;

public class Factoria {

    /**
     * Obtiene una implementación de Dao para la gestión de base de datos.
     * 
     * @return Una implementación de Dao para la gestión de base de datos.
     */
    public static Dao getImplementacionBD() {
        return new DaoImplementacionDb();
    }

    /**
     * Obtiene una implementación de Dao para la gestión de ficheros.
     * 
     * @return Una implementación de Dao para la gestión de ficheros.
     */
    public static Dao getImplementacionFich() {
        return new DaoImplementacionFichero();
    }
}
