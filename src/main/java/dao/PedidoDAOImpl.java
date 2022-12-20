package dao;

import modelo.*;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PedidoDAOImpl extends Conexion implements DAOPedido {

    private static EntityManagerFactory emf;
    private static EntityManager manager;

    DAOArticulo daoArticulo = new ArticuloDAOImpl();
    DAOCliente_Premium daoCliente_premium = new Cliente_PremiumDAOImpl();
    DAOCliente_Estandar daoCliente_estandar = new Cliente_EstandardDAOImpl();

    @Override
    public boolean registrar(Pedido pedido) throws Exception {

        try {
            emf = Persistence.createEntityManagerFactory("Persistencia");
            manager = emf.createEntityManager();
            manager.getTransaction().begin();
            manager.persist(pedido);
            manager.getTransaction().commit();
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
        }catch (Exception e){
            e.printStackTrace();
            return null;
        } finally {
            this.cerrar();
        }
    }
}