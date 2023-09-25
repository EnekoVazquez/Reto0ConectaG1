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
    private final String SELUD = "SELECT * FROM unidad where id = ?";
    // Convocatoria
    // private final String ALTACE = "INSERT INTO ConvocatoriaExamen(convocatoria,descripcion,fecha,curso) values (?,?,?,?)";

    //Enunciado
    private final String ALTAENUN = "INSERT INTO enunciado(id, descripcion, nivel, disponible,ruta) values (?,?,?,?,?)";
    private final String SELEN = "SELECT * FROM unidad_enunciado where id = ?";

    private void openConnection() {

        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/examenbd?serverTimezone=Europe/Madrid&useSSL=false", "root",
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
            stmt.setString(2, UD.getAcronimo());
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
    public void crearEnunciado(Enunciado EN) {
        this.openConnection();

        try {

            stmt = con.prepareStatement(ALTAENUN);
            stmt.setInt(1, EN.getIdEnunciado());
            stmt.setString(2, EN.getDescipcion());
            stmt.setString(3, EN.getDificultad().toString());
            stmt.setBoolean(4, EN.isDisponible());
            stmt.setString(5, EN.getRuta());

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
 /*
    @Override
    public Enunciado consultarEnunciado(int consul1) {
        /*
        Enunciado enunciado = null;
        this.openConnection();
        try {
            stmt = con.prepareStatement(SELUD);
            stmt.setInt(1, consul1);
            rs = stmt.executeQuery();
            if (rs.next()) {
                enunciado = new Enunciado();
                enunciado.setIdUnidadDidactica(rs.getInt("id"));
                enunciado.setAcronimo(rs.getString("acronimo"));
                enunciado.setTitulo(rs.getString("titulo"));
                enunciado.setEvaluacion(rs.getString("evaluacion"));
                enunciado.setDescripcion(rs.getString("descripcion"));

            }
            System.out.println(unidadDidactica);
        } catch (Exception e) {
        }

        return unidadDidactica;
       
    }
*/

    @Override
    public void consultarConvocatoria(String idConvocatoria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UnidadDidactica consultarUnidadDidactica(int consul) {

        UnidadDidactica unidadDidactica = null;
        this.openConnection();
        try {
            stmt = con.prepareStatement(SELUD);
            stmt.setInt(1, consul);
            rs = stmt.executeQuery();
            if (rs.next()) {
                unidadDidactica = new UnidadDidactica();
                unidadDidactica.setIdUnidadDidactica(rs.getInt("id"));
                unidadDidactica.setAcronimo(rs.getString("acronimo"));
                unidadDidactica.setTitulo(rs.getString("titulo"));
                unidadDidactica.setEvaluacion(rs.getString("evaluacion"));
                unidadDidactica.setDescripcion(rs.getString("descripcion"));

            }
            System.out.println(unidadDidactica);
        } catch (Exception e) {
        }
        return unidadDidactica;
    }

    @Override
    public Enunciado consultarEnunciado(int consul1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
