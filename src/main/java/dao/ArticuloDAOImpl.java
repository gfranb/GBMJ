package dao;

import modelo.Articulo;

import java.sql.PreparedStatement;
import java.util.List;

public class ArticuloDAOImpl extends Conexion implements DAOArticulo{

    @Override
    public boolean registrar(Articulo articulo) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = connection.prepareStatement("INSERT INTO articulo(codigo,descripcion,precio,gEnvio,pEnvio) VALUES(?,?,?,?,?)");
            st.setString(1, articulo.getCodigo());
            st.setString(2, articulo.getDescripcion());
            st.setFloat(3, articulo.getPrecio());
            st.setFloat(4, articulo.getgEnvio());
            st.setInt(5, articulo.getpEnvio());
            st.executeUpdate();
            return true;
        }catch (Exception e){
            return false;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void mostrar(Articulo articulo) throws Exception {

    }

}
