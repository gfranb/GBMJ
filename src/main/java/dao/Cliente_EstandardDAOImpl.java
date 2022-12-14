package dao;

import dao.modelo.Cliente_Estandar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Cliente_EstandardDAOImpl extends Conexion implements DAOCliente_Estandar{

    @Override
    public boolean registrar(Cliente_Estandar ce) throws Exception {
        try {
            this.conectar();

            PreparedStatement st = connection.prepareStatement("INSERT INTO cliente(nombre,nif,domilicio,email) VALUES(?,?,?,?)");
            st.setString(1, ce.getNombre());
            st.setString(2, ce.getNif());
            st.setString(3, ce.getDomicilio());
            st.setString(4, ce.getEmail());
            st.executeUpdate();

           PreparedStatement _st = connection.prepareStatement("INSERT INTO cliente_estandard(email) VALUES(?)");
            _st.setString(1, ce.getEmail());
            _st.executeUpdate();

            return true;
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    public Cliente_Estandar buscar(String email) throws Exception {

        try {
            this.conectar();
            PreparedStatement st = connection.prepareStatement("SELECT * FROM cliente_estandard WHERE email=?");
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            Cliente_Estandar ce = new Cliente_Estandar();

            while (rs.next()) {
                if (rs.getString(1).equals(email)) {
                    this.cerrar();
                    this.conectar();

                    PreparedStatement _st = connection.prepareStatement("SELECT * FROM cliente WHERE email=?");
                    _st.setString(1, email);
                    ResultSet _rs = _st.executeQuery();

                    while(_rs.next()){
                            ce.setNombre(_rs.getString(1));
                            ce.setNif(_rs.getString(2));
                            ce.setDomicilio(_rs.getString(3));
                            ce.setEmail(_rs.getString(4));
                            return ce;
                    }

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
