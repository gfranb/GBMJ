package dao;

import modelo.*;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;


public class PedidoDAOImpl extends Conexion implements DAOPedido {

    private static EntityManagerFactory emf;
    private static EntityManager manager;

    DAOArticulo daoArticulo = new ArticuloDAOImpl();
    DAOCliente_Premium daoCliente_premium = new Cliente_PremiumDAOImpl();
    DAOCliente_Estandar daoCliente_estandar = new Cliente_EstandardDAOImpl();

    @Override
    public boolean registrar(Pedido pedido) throws Exception {

        try {
            this.conectar();
            PreparedStatement st = connection.prepareStatement("INSERT INTO pedido VALUE (?,?,?,?,?,?)");
            st.setString(1, Integer.toString(pedido.getnPedido()));
            st.setInt(2, pedido.getCantidad());

            LocalDate locald = pedido.getFecha();
            Date date = Date.valueOf(locald); // Conversion a Date
            st.setDate(3, date);

            st.setString(4, pedido.getArticulo().getCodigo());
            st.setDouble(5, pedido.getPrecioP());
            st.setString(6, pedido.getCliente().getEmail());

            st.executeUpdate();

            return true;

        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public Pedido buscar(int nPedido) throws Exception {

        try {
            emf = Persistence.createEntityManagerFactory("Persistencia");
            manager = emf.createEntityManager();
            Pedido pedido = new Pedido();
            return manager.find(Pedido.class,nPedido);
            /*
            this.conectar();
            PreparedStatement st = connection.prepareStatement("SELECT * FROM PEDIDO WHERE nPedido = ?");
            st.setInt(1, nPedido);
            ResultSet rs = st.executeQuery();

            Pedido p = new Pedido();

            while (rs.next()) {
                if (rs.getInt(1) == (nPedido)) {

                    p.setnPedido(rs.getInt(1));

                    p.setCantidad(rs.getInt(2));

                    java.sql.Date sqlDate = rs.getDate(3);
                    LocalDate localDate = sqlDate.toLocalDate();

                    p.setFecha(localDate);

                    Articulo a = daoArticulo.buscar(rs.getString(4));
                    p.setArticulo(a);

                    Cliente_Estandar cE = daoCliente_estandar.buscar(rs.getString(6));
                    Cliente_Premium cP = daoCliente_premium.buscar(rs.getString(6));

                    if(cP.getEmail() == null){
                        p.setCliente(cE);
                    }else{
                        p.setCliente(cP);
                    }
                    p.setPrecioP(rs.getDouble(5));
                }
            }
            return p;
             */
        }catch (Exception e){
            e.printStackTrace();
            return null;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public Pedido buscarpedidocliente(String email) throws Exception {

            try {
                emf = Persistence.createEntityManagerFactory("Persistencia");
                manager = emf.createEntityManager();
                Pedido pedido = new Pedido();
                return manager.find(Pedido.class,email);
                /*
            this.conectar();
            PreparedStatement st = connection.prepareStatement("SELECT * FROM PEDIDO WHERE email=?");
            st.setString(1, email);
            ResultSet rs = st.executeQuery();


            ListaPedidos listap = new ListaPedidos();

            while (rs.next()) {// Mostrar pedido?
                Pedido p = new Pedido();
                if (rs.getString(6).equals(email)) {
                    p.setnPedido(rs.getInt(1));

                    p.setCantidad(rs.getInt(2));

                    java.sql.Date sqlDate = rs.getDate(3);
                    LocalDate localDate = sqlDate.toLocalDate();
                    p.setFecha(localDate);

                    Articulo a = daoArticulo.buscar(rs.getString(4));
                    p.setArticulo(a);

                    Cliente_Estandar cE = daoCliente_estandar.buscar(rs.getString(6));
                    Cliente_Premium cP = daoCliente_premium.buscar(rs.getString(6));

                    if(cP.getEmail() == null){
                        p.setCliente(cE);
                    }else{
                        p.setCliente(cP);
                    }
                    listap.add(p);
                }
            }
            return listap;
                 */
            }catch (Exception e){
                e.printStackTrace();
                return null;
            } finally {
                this.cerrar();
            }
        }

    @Override
    public boolean eliminarpedido(String nPedido) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = connection.prepareStatement("DELETE FROM PEDIDO WHERE nPedido = ?");
            st.setString(1, nPedido);
            ResultSet rs = st.executeQuery();
            return true;
        }catch (HibernateException e){
            e.printStackTrace();
            return false;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public ListaPedidos buscarpedidos() throws Exception {
        try {
                emf = Persistence.createEntityManagerFactory("Persistencia");
                manager = emf.createEntityManager();
                ListaPedidos listaPedidos = new ListaPedidos();
                return manager.find(ListaPedidos.class,listaPedidos);
                /*
            this.conectar();
            PreparedStatement st = connection.prepareStatement("SELECT * FROM PEDIDO");
            ResultSet rs = st.executeQuery();

            Pedido p = new Pedido();
            ListaPedidos listap = new ListaPedidos();

            while (rs.next()) {// Mostrar pedido?

                    p.setnPedido(rs.getInt(1));

                    p.setCantidad(rs.getInt(2));

                    java.sql.Date sqlDate = rs.getDate(3);
                    LocalDate localDate = sqlDate.toLocalDate();
                    p.setFecha(localDate);

                    Articulo a = daoArticulo.buscar(rs.getString(4));
                    p.setArticulo(a);

                    Cliente_Estandar cE = daoCliente_estandar.buscar(rs.getString(6));
                    Cliente_Premium cP = daoCliente_premium.buscar(rs.getString(6));

                    if(cP.equals(null)){
                        p.setCliente(cE);
                    }else{
                        p.setCliente(cP);
                    }
                    listap.add(p);

            }
            return listap;
                 */
        }catch (Exception e){
            e.printStackTrace();
            return null;
        } finally {
            this.cerrar();
        }
    }
}
