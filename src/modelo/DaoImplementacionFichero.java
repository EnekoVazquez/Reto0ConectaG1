/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.ConvocatoriaExamen;
import clases.Enunciado;
import clases.UnidadDidactica;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilidades.MiObjectOutputStream;
import utilidades.Utilidades;

/**
 *
 * @author 2dam
 */
public class DaoImplementacionFichero implements Dao {

    File fich = new File("convocatorias.dat");

    @Override
    public void crearUnidadDidactica(UnidadDidactica UD) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearConvocatoria(ConvocatoriaExamen CE) {

        // ConvocatoriaExamen Coe = null;
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        int rendimiento;

        try {

            if (fich.exists()) {
                oos = new MiObjectOutputStream(new FileOutputStream(fich, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(fich));
            }

            oos.writeObject(CE);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(DaoImplementacionFichero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DaoImplementacionFichero.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void crearEnunciado(Enunciado EN) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//vacias

    @Override
    public Enunciado consultarEnunciado(int consul1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void consultarConvocatoria(String idConvocatoria) {

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        ConvocatoriaExamen datos;
        int rendimiento;
        
        if (fich.exists()) {
            rendimiento=Utilidades.calculoFichero(fich);
            datos = new ConvocatoriaExamen();
            try {
                fis = new FileInputStream(fich);
                ois = new ObjectInputStream(fis);
                
                for (int i = 0; i < rendimiento; i++) {
                      if (idConvocatoria.equalsIgnoreCase(datos.getConvocatoria())) {
                        
                    }
                    datos = (ConvocatoriaExamen) ois.readObject();
                    System.out.println(datos.toString());
                }
                  

                
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                ois.close();
                fis.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    

    }

    @Override
    public UnidadDidactica consultarUnidadDidactica(int consul) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
