package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {

    protected Connection connection;
    private String uname = "root";
    private String password = "1234";
    private String url = "jdbc:mysql://localhost:3306/gbmj_db";
    private final String JDBC_DRIVER = "org.mysql.jdbc.Driver";

    public Conexion(){
        this.connection = null;
    }

    public void conectar() throws Exception {

        try {
            this.connection = DriverManager.getConnection(url,uname,password);
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
