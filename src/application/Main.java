/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import controlador.Controlador;
import modelo.Dao;
import vista.VistaUsuario;

/**
 *
 * @author Josu
 */
public class Main {

    /**
     * esta clase sirve para ejecutar la aplicacion
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        VistaUsuario.menu(new Controlador());
        
    }
    
}
