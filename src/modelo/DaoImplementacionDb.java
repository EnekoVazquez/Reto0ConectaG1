/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import clases.ConvocatoriaExamen;
import clases.Enunciado;
import clases.UnidadDidactica;

/**
 *
 * @author 2dam
 */
public class DaoImplementacionDb implements Dao {

    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;

    // UnidadDidactica
    private final String ALTAUD = "INSERT INTO unidad(id, acronimo, titulo, evaluacion, descripcion) values (?,?,?,?,?)";

    // Convocatoria
   // private final String ALTACE = "INSERT INTO ConvocatoriaExamen(convocatoria,descripcion,fecha,curso) values (?,?,?,?)";

    private void openConnection() {

        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/examendb?serverTimezone=Europe/Madrid&useSSL=false", "root",
                    "abcd*1234");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void closeConnection() throws SQLException {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void crearUnidadDidactica(UnidadDidactica UD) {
        this.openConnection();

        try {

            stmt = con.prepareStatement(ALTAUD);
            stmt.setInt(1, UD.getIdUnidadDidactica());
            stmt.setString(2, UD.getAnonimo());
            stmt.setString(3, UD.getTitulo());
            stmt.setString(4, UD.getEvaluacion());
            stmt.setString(5, UD.getDescripcion());

            stmt.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            closeConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void crearConvocatoria(ConvocatoriaExamen CE) {
    /*
        this.openConnection();

        try {

            stmt = con.prepareStatement(ALTACE);
            stmt.setString(1, CE.getConvocatoria());
            stmt.setString(2, CE.getDescripcion());
            java.sql.Date sqlDate = java.sql.Date.valueOf(CE.getFecha());
            stmt.setDate(3, sqlDate);
            stmt.setString(4, CE.getCurso());

            stmt.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            closeConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        */
    }

    @Override
    public void crearEnunciado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Enunciado consultarEnunciado(String idEnunciado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void consultarConvocatoria(String idConvocatoria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UnidadDidactica consultarUnidadDidactica(String idUnidadDidactica) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
