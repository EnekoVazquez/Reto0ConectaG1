/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import clases.ConvocatoriaExamen;
import controlador.Controlador;
import modelo.Dao;
import java.time.format.DateTimeFormatter;
import clases.UnidadDidactica;
import java.time.LocalDate;
import utilidades.Utilidades;

/**
 *
 * @author 2dam
 */
public class VistaUsuario {

    private UnidadDidactica UD;
    private ConvocatoriaExamen CE;

    public static void menu(Controlador controlador) {
        int opc;

        do {
            System.out.println("1.-Crear unidad didactica");
            System.out.println("2.-Crear una convocatoria");
            System.out.println("3.-Crear un enunciado");
            System.out.println("4.-Consultar una unidad didactica");
            System.out.println("5.-Consultar un Enunciado");
            System.out.println("6.-Consultar una convocatoria");
            System.out.println("7.-Visualizar un Enunciado");
            System.out.println("8.-Salir de la aplicacion");
            opc = Utilidades.leerInt("Seleccione el numero de la opcion que desea ejecutar");

            switch (opc) {
                case 1:
                    crearUnidadDidactica(controlador);
                    break;
                case 2:
                    crearConvocatoria(controlador);
                    break;
                case 3:
                    crearEnunciado(controlador);
                    break;
                case 4:
                    consultarUnidadDidactica(controlador);
                    break;
                case 5:
                    consultarEnunciado(controlador);
                    break;
                case 6:
                    consultarConvocatoria(controlador);
                    break;
                case 7:
                    visualizarEnunciado(controlador);
                case 8:
                    System.out.println("Salir de aqui");
                    break;
                default:
                    break;
            }
        } while (opc != 8);
    }

    private static void crearUnidadDidactica(Controlador controlador) {

        // TODO Auto-generated method stub
        //pasamos lo que ha escrito para hacer el alta
        UnidadDidactica UD = new UnidadDidactica();
        UD.setIdUnidadDidactica(Utilidades.leerInt("Dime la id de la unidad didactica"));
        UD.setAnonimo(Utilidades.introducirCadena("Dime el acronimo"));
        UD.setTitulo(Utilidades.introducirCadena("Dime el titulo"));
        UD.setEvaluacion(Utilidades.introducirCadena("Dime la evaluacion"));
        UD.setDescripcion(Utilidades.introducirCadena("Dime la descripcion"));
        controlador.crearUnidadDidactica(UD);

    }

    private static void crearConvocatoria(Controlador controlador) {
        ConvocatoriaExamen CE = new ConvocatoriaExamen();
        CE.setConvocatoria(Utilidades.introducirCadena("Introduce la convocatoria del examen "));
        CE.setDescripcion(Utilidades.introducirCadena("Dime la descripcion"));
        CE.setCurso(Utilidades.introducirCadena("Dime el curso"));
        CE.setFecha(Utilidades.pidoFechaDMA("Dime la fecha de la convocatoria"));
        controlador.crearConvocatoria(CE);
    }

    private static void crearEnunciado(Controlador controlador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void consultarUnidadDidactica(Controlador controlador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void consultarEnunciado(Controlador controlador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void consultarConvocatoria(Controlador controlador) {
        String idConvocatoria;
        idConvocatoria=Utilidades.introducirCadena("Dime la convocatoria que quieres consultar");
        
        controlador.consultarConvocatoria(idConvocatoria);
    }

    private static void visualizarEnunciado(Controlador controlador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
