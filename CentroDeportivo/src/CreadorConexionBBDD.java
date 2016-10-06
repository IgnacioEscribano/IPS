import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Carla on 06/10/2016.
 */
public class CreadorConexionBBDD {

    private static String nombreBBDD = "";
    Connection conexion;

    public void crearConexionHypersonic() {
        try {
            StringBuilder url = new StringBuilder("jdbc:hsqldb:hsql://localhost/");
            url.append(nombreBBDD);
            conexion = DriverManager.getConnection(url.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConexion() {
        return conexion;
    }
}
