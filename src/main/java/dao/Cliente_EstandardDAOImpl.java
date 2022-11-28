package dao;

import modelo.Cliente_Estandar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Cliente_EstandardDAOImpl extends Conexion implements DAOCliente_Estandar{

    @Override
    public boolean registrar(Cliente_Estandar ce) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = connection.prepareStatement("INSERT INTO cliente_estandard(nombre,domicilio,nif,email) VALUES(?,?,?,?)");
            st.setString(1, ce.getNombre());
            st.setString(2, ce.getDomicilio());
            st.setString(3, ce.getNif());
            st.setString(4, ce.getEmail());

            st.executeUpdate();
            return true;
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public Cliente_Estandar buscar(String email) throws Exception {

        try {
            this.conectar();
            PreparedStatement st = connection.prepareStatement("SELECT * FROM cliente_estandard WHERE email=?");
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            Cliente_Estandar ce = new Cliente_Estandar();
            while (rs.next()) {
                if (rs.getString(4).equals(email)) {
                    ce.setNombre(rs.getString(1));
                    ce.setDomicilio(rs.getString(2));
                    ce.setNif(rs.getString(3));
                    ce.setEmail(rs.getString(4));
                }
            }
            return ce;
        } catch (Exception e) {
            return null;
        } finally {
            this.cerrar();
        }
    }
}
