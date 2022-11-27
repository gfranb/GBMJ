package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelo.Datos;
import modelo.Pedido;

public class PedidoDAOImpl extends Conexion implements DAOPedido{

    public boolean registrarPedido(Pedido pedido) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = connection.prepareStatement("INSERT INTO PEDIDO(nPedido,Cantidad,fecha,codigo,email) VALUES(?,?,?,?,?)");
            st.setInt(1,pedido.getnPedido());
            st.setInt(2, pedido.getCantidad());
            st.setDate(3, pedido.getFecha());
            st.setString(4, pedido.getArticulo());
            st.setString(5, pedido.getCliente());
            st.executeUpdate();
            return true;
        }catch (Exception e){
            throw e;
        } finally {
            this.cerrar();
        }
    }

    public Pedido buscarpedido(int nPedido) throws Exception{

        try{
            this.conectar();
            PreparedStatement st= connection.prepareStatement("SELECT * FROM PEDIDO WHERE nPedido = ?");
            st.setInt(1,nPedido);
            ResultSet rs = st.executeQuery();
            Pedido p = new Pedido();
            while (rs.next()){
                if (rs.getInt(1) == (nPedido)){
                    p.setnPedido(rs.getInt(1));
                    p.setCantidad(rs.getInt(2));
                    p.getFecha(rs.getTimestamp(3));
                    p.setArticulo(rs.getString(4));
                    p.setCliente(rs.getString(6));
                    p.setPrecioP(rs.getDouble(5));
                }
            }
        }catch (Exception e){
            return null;
        }finally{
            this.cerrar();
        }
    }
    public Pedido buscarpedidocliente(String emil) throws Exception{
    try {
        this.conectar();
        PreparedStatement st = connection.prepareStatement("SELECT * FROM PEDIDO WHERE email=?");
        st.setString(1, email);
        ResultSet rs = st.executeQuery();
        Pedido pedido = new Pedido();
        while(rs.next()){// Mostrar pedido?
            if(rs.getString(1).equals(email){
                pedido.setnPedido(rs.getInt(1));
                pedido.setCantidad(rs.getInt(2));
                pedido.getFecha(rs.getTimestamp(3));
                pedido.setArticulo(rs.getString(4));
                pedido.setCliente(rs.getString(6));
            }
        }
        return pedido;
    }catch (Exception e){
        return null;
    } finally {
        this.cerrar();
    }

}

    public Pedido eliminarpedido (Pedido pedido) throws Exception{
        try{
            this.conectar();
            PreparedStatement st = connection.prepareStatement("DELETE FROM PEDIDO WHERE nPedido = ?");
            st.setString(1,nPedido);
            ResultSet rs = st.executeQuery();
        } catch (Exception e){
            return null;
        } finally {
            this.cerrar();
        }
    }
}
