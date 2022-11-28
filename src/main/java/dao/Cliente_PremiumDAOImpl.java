package dao;

import modelo.Cliente_Premium;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

public class Cliente_PremiumDAOImpl extends Conexion implements DAOCliente_Premium{

    @Override
    public boolean registrar(Cliente_Premium cp) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = connection.prepareStatement("INSERT INTO cliente_premium(nombre,domicilio,nif,email,descuento) VALUES(?,?,?,?,?)");

            st.setString(1, cp.getNombre());
            st.setString(2, cp.getDomicilio());
            st.setString(3, cp.getNif());
            st.setDouble(5, cp.getDescuento());
            st.setString(4, cp.getEmail());

            st.executeUpdate();

            return true;
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public Cliente_Premium buscar(String email) throws Exception {

        try {
            this.conectar();
            PreparedStatement st = connection.prepareStatement("SELECT * FROM cliente_premium WHERE email=?");
            st.setString(1, email);
            ResultSet rs = st.executeQuery();

            Cliente_Premium cp = new Cliente_Premium();

            while (rs.next()) {
                if (rs.getString(4).equals(email)) {
                    cp.setNombre(rs.getString(1));
                    cp.setDomicilio(rs.getString(2));
                    cp.setNif(rs.getString(3));
                    cp.setEmail(rs.getString(4));
                    cp.setDescuento(rs.getDouble(5));
                }
            }
            return cp;
        } catch (Exception e) {
            return null;
        } finally {
            this.cerrar();
        }
    }
}

