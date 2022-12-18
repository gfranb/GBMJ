package dao;

import modelo.Cliente_Premium;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Cliente_PremiumDAOImpl extends Conexion implements DAOCliente_Premium{

    @Override
    public boolean registrar(Cliente_Premium cP) throws Exception {
        try {
            this.conectar();

            System.out.println(cP);
            PreparedStatement st = connection.prepareStatement("INSERT INTO CLIENTE(nombre,nif,domilicio,email) VALUES(?,?,?,?)");
            st.setString(1, cP.getNombre());
            st.setString(2, cP.getNif());
            st.setString(3, cP.getDomicilio());
            st.setString(4, cP.getEmail());
            st.executeUpdate();

            PreparedStatement _st = connection.prepareStatement("INSERT INTO CLIENTE_PREMIUM(descuento,email) VALUES(?,?)");
            _st.setDouble(1, cP.getDescuento());
            _st.setString(2, cP.getEmail());
            _st.executeUpdate();

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
            Cliente_Premium cP = new Cliente_Premium();

            while (rs.next()) {
                if (rs.getString(2).equals(email)) {

                    cP.setDescuento(rs.getDouble(1));
                    this.cerrar();
                    this.conectar();

                    PreparedStatement _st = connection.prepareStatement("SELECT * FROM cliente WHERE email=?");
                    _st.setString(1, email);
                    ResultSet _rs = _st.executeQuery();

                    while(_rs.next()){
                        cP.setNombre(_rs.getString(1));
                        cP.setNif(_rs.getString(2));
                        cP.setDomicilio(_rs.getString(3));
                        cP.setEmail(_rs.getString(4));
                        return cP;
                    }

                }
            }
            return cP;
        } catch (Exception e) {
            return null;
        } finally {
            this.cerrar();
        }
    }
}

