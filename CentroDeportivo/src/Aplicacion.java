import java.sql.Connection;

/**
 * Created by Carla on 06/10/2016.
 */
public class Aplicacion {
    public static void main(String[] args) {
        CreadorConexionBBDD creadorConexionBBDD = new CreadorConexionBBDD();
        Connection conn = creadorConexionBBDD.getConexion();
    }
}
