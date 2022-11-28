package dao;

import modelo.Cliente_Estandar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Cliente_EstandardDAOImpl extends Conexion implements DAOCliente_Estandar{

    @Override
    public boolean registrar(Cliente_Estandar cliente_estandar) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = connection.prepareStatement("INSERT INTO cliente_estandard(email) VALUES(?)");
            st.setString(1, cliente_estandar.getEmail());

            st.executeUpdate();
            return true;
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public Cliente_Estandar buscar(String id) throws Exception {

        try {
            this.conectar();
            PreparedStatement st = connection.prepareStatement("SELECT * FROM cliente_estandard WHERE email=?");
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            Cliente_Estandar cliente_estandar = new Cliente_Estandar();
            while (rs.next()) {
                if (rs.getString(1).equals(id)) {
                    cliente_estandar.setEmail(rs.getString(1));
                }
            }
            return cliente_estandar;
        } catch (Exception e) {
            return null;
        } finally {
            this.cerrar();
        }
    }
}
