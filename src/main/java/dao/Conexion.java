package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {

    protected Connection connection;
    private String uname = "root";
    private String url = "jdbc:mysql://localhost:3306/mysql";
    private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    public Conexion(){
        this.connection = null;
    }

    public void conectar() throws Exception {

        try {
            this.connection = DriverManager.getConnection(url);
            //Class.forName(JDBC_DRIVER);
            this.connection.setAutoCommit(true);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void cerrar() throws SQLException {
        if(connection != null){
            if(!connection.isClosed()){
                connection.close();
            }
        }
    }

}
