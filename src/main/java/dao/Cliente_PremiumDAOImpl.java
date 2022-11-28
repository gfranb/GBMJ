package dao;

import modelo.Cliente_Premium;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

public class Cliente_PremiumDAOImpl extends Conexion implements DAOCliente_Premium{

    @Override
    public boolean registrar(Cliente_Premium cliente_premium) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = connection.prepareStatement("INSERT INTO cliente_premium(email) VALUES(?,?)");
            st.setString(2, cliente_premium.getEmail());

            st.executeUpdate();
            return true;
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public Cliente_Premium buscar(String id) throws Exception {

        try {
            this.conectar();
            PreparedStatement st = connection.prepareStatement("SELECT * FROM cliente_premium WHERE email=?");
            st.setString(2, id);
            ResultSet rs = st.executeQuery();
            Cliente_Premium cliente_premium = new Cliente_Premium();
            while (rs.next()) {
                if (rs.getString(2).equals(id)) {
                    cliente_premium.setEmail(rs.getString(2));
                    cliente_premium.setDescuento(rs.getDouble(1));
                }
            }
            return cliente_premium;
        } catch (Exception e) {
            return null;
        } finally {
            this.cerrar();
        }
    }
}

