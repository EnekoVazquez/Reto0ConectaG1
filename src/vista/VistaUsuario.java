/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import clases.ConvocatoriaExamen;
import clases.Dificultad;
import clases.Enunciado;
import controlador.Controlador;
import modelo.Dao;
import java.time.format.DateTimeFormatter;
import clases.UnidadDidactica;
import java.time.LocalDate;
import modelo.DaoImplementacionDb;
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
        int idUnidadDidactica = Utilidades.leerInt("Dime la id de la unidad didactica que no exista");
        // Verificar si la unidad didáctica ya existe en la base de datos.
        if (controlador.verificarExistenciaUnidadDidactica(idUnidadDidactica)) {
            System.out.println("La unidad didáctica con esta ID ya existe en la base de datos.");
        } else {
            UnidadDidactica UD = new UnidadDidactica();
            UD.setIdUnidadDidactica(Utilidades.leerInt("Dime la id de la unidad didactica"));
            UD.setAnonimo(Utilidades.introducirCadena("Dime el acronimo"));
            UD.setTitulo(Utilidades.introducirCadena("Dime el titulo"));
            UD.setEvaluacion(Utilidades.introducirCadena("Dime la evaluacion"));
            UD.setDescripcion(Utilidades.introducirCadena("Dime la descripcion"));
            controlador.crearUnidadDidactica(UD);
        }

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

        Enunciado EN = new Enunciado();
        String dificultad;
        EN.setIdEnunciado(Utilidades.leerInt("Dime la id del enunciado"));
        EN.setDescipcion(Utilidades.introducirCadena("Dime la descripcion"));

        dificultad = Utilidades.introducirCadena("Introduce la dificultad del enunciado ALTA,BAJA,MEDIA");
        if (dificultad.equalsIgnoreCase(Dificultad.ALTA.toString())) {
            EN.setDificultad(Dificultad.ALTA);
            
        } else if (dificultad.equalsIgnoreCase(Dificultad.MEDIA.toString())) {
            EN.setDificultad(Dificultad.MEDIA);
        } else {
            EN.setDificultad(Dificultad.BAJA);
        }
        EN.setDisponible(Utilidades.leerRespuesta("Esta disponible?"));
        EN.setRuta(Utilidades.introducirCadena("Donde quieres guardar el enunciado"));
        //EN.insertarUnidades();

        controlador.crearEnunciado(EN);
    }

   

    private static void consultarEnunciado(Controlador controlador) {

        int id = Utilidades.leerInt("Introduceme el id ");
        controlador.consultarEnunciado(id);
        
    }

    private static void consultarConvocatoria(Controlador controlador) {
        String idConvocatoria;
        idConvocatoria = Utilidades.introducirCadena("Dime la convocatoria que quieres consultar");

        controlador.consultarConvocatoria(idConvocatoria);
    }

    private static void visualizarEnunciado(Controlador controlador) {
       int id = Utilidades.leerInt("introduce  el id ");
       controlador.visualizarEnunciado(id);
        
    }

}
