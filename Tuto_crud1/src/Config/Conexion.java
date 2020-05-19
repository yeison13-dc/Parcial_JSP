package Config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    String mensaje = "";
    Connection con;
    String driver = "org.postgresql.Driver";
    String url = "jdbc:postgresql//localhost:5432/Banco";
    String usuario = "postgres";
    String clave = "12345";

    /*procedimiento de la conexion*/
    public Conexion() {

        try {
            Class.forName(driver);
            con = DriverManager.getConnection("url", "usuario", "clave");

        } catch (
                Exception ex) {
            mensaje = ex.toString();
        }
    }
        public Connection getConnection(){
        return con;
        }
}

