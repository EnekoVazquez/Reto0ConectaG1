/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author 2dam
 */
public class Factoria {

    public static Dao getImplementacionBD() {
        return new DaoImplementacionDb();
    }

    public static Dao getImplementacionFich() {
        return new DaoImplementacionFichero();
    }

}
