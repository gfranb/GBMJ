package dao;

import modelo.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClienteDAOImpl extends Conexion implements DAOCliente {



    @Override
    public Cliente buscar(String id) throws Exception {

        try {
            this.conectar();
            PreparedStatement st = connection.prepareStatement("SELECT * FROM cliente_premium INNER JOIN cliente_estandard ON cliente_estandard.email = cliente.email WHERE email =?");
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            Cliente cliente = new Cliente();
            while (rs.next()) {
                if (rs.getString(1).equals(id)) {
                    cliente.setEmail(rs.getString(4));
                    cliente.setNif(rs.getString(2));
                    cliente.setNombre(rs.getString(1));
                    cliente.setDomicilio(rs.getString(3));
                }
            }
            return cliente;
        } catch (Exception e) {
            return null;
        } finally {
            this.cerrar();
        }
    }

    public boolean registrar(Cliente cliente) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = connection.prepareStatement("INSERT INTO cliente(email,domicilio,nombre,nif) VALUES(?,?,?,?)");
            st.setString(1, cliente.getEmail());
            st.setString(2, cliente.getDomicilio());
            st.setString(3, cliente.getNombre());
            st.setString(4, cliente.getNif());

            st.executeUpdate();
            return true;
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
}


