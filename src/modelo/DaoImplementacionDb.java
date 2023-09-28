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
import clases.Dificultad;
import clases.Enunciado;
import clases.UnidadDidactica;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josu,egoitz,enekoo
 */
public class DaoImplementacionDb implements Dao {

    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;

    // UnidadDidactica
    private final String ALTAUD = "INSERT INTO unidad(id, acronimo, titulo, evaluacion, descripcion) values (?,?,?,?,?)";
    private final String EXISTEID = "SELECT COUNT(*) FROM unidad WHERE id = ?";
    //Enunciado
    private final String ALTAENUN = "INSERT INTO enunciado(id, descripcion, nivel, disponible,ruta) values (?,?,?,?,?)";
    private final String ALTAUNIEN = "INSERT INTO unidad_enunciado(unidads_id,enunciados_id) values (?,?)";
    private final String ENUNRUTA = "SELECT * FROM enunciado where id = ? ";
 

    // Convocatoria
    // private final String ALTACE = "INSERT INTO ConvocatoriaExamen(convocatoria,descripcion,fecha,curso) values (?,?,?,?)";
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

    public boolean verificarExistenciaUnidadDidactica(int idUnidadDidactica) {
        ResultSet rs = null;
        boolean existe = false;

        try {
            // Establecer la conexión a la base de datos (debes configurar esto según tu base de datos)
            this.openConnection();

            // Consulta SQL para verificar la existencia de la unidad didáctica
            stmt = con.prepareStatement(EXISTEID);

            // Preparar la declaración con el parámetro de la ID
            stmt.setInt(1, idUnidadDidactica);

            // Ejecutar la consulta y obtener el resultado
            rs = stmt.executeQuery();

            // Comprobar si existe una fila en el resultado (si el recuento es mayor que cero)
            if (rs.next() && rs.getInt(1) > 0) {
                existe = true; // La unidad didáctica existe en la base de datos
            }
        } catch (SQLException e) {
            // Manejar cualquier excepción de la base de datos aquí
            e.printStackTrace();
        } finally {
            try {
                // Cerrar recursos (ResultSet, PreparedStatement, Connection)
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DaoImplementacionDb.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return existe;
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

            stmt = con.prepareStatement(ALTAUNIEN);
            stmt.setInt(1, 1);
            stmt.setInt(2, EN.getIdEnunciado());

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
    public Enunciado consultarEnunciado(int idEnunciado) {

        Enunciado enun = new Enunciado();

        ResultSet rs = null;
        try {
            this.openConnection();
        } catch (Exception e) {
        }
        try {
            stmt = con.prepareStatement(ENUNRUTA);
            stmt.setInt(1, idEnunciado);

            rs = stmt.executeQuery();
            while (rs.next()) {

                enun.setIdEnunciado(rs.getInt("id"));
                enun.setDescipcion(rs.getString("descripcion"));

                enun.setDificultad(Dificultad.valueOf(rs.getString("nivel")));

                enun.setDisponible(rs.getBoolean("disponible"));
                enun.setRuta(rs.getString("ruta"));
                System.out.println(enun.toString());

            }
        } catch (Exception e) {

        }
        try {
            closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DaoImplementacionDb.class.getName()).log(Level.SEVERE, null, ex);
        }

        return enun;
    }

    @Override
    public void consultarConvocatoria(String idConvocatoria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UnidadDidactica consultarUnidadDidactica(String idUnidadDidactica) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean verificarExistenciaConvocatoria(String convocatoria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Enunciado visualizarEnunciado(Integer id) {

        Enunciado enun = new Enunciado();

        ResultSet rs = null;
        try {
            this.openConnection();
        } catch (Exception e) {
        }
        List<Enunciado> listEnum= new ArrayList<>();
        try {
            stmt = con.prepareStatement(ENUNRUTA);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();
            while (rs.next()) {

                enun.setIdEnunciado(rs.getInt("id"));
                enun.setDescipcion(rs.getString("descripcion"));

                enun.setDificultad(Dificultad.valueOf(rs.getString("nivel")));

                enun.setDisponible(rs.getBoolean("disponible"));
                enun.setRuta(rs.getString("ruta"));
                
                listEnum.add(enun);
                System.out.println(enun.toString());

            }
        } catch (Exception e) {

        }
        try {
            closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DaoImplementacionDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return enun;

       

    }

}
