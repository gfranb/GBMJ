package dao;

import modelo.*;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

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
            Pedido p = manager.find(Pedido.class,nPedido);
            return p;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public ListaPedidos buscarpedidocliente(String email) throws Exception {

        try {
            emf = Persistence.createEntityManagerFactory("Persistencia");
            manager = emf.createEntityManager();
            List<Pedido> sa = (List<Pedido>) manager.createQuery("FROM pedido").getResultList();
            ListaPedidos pedidos = new ListaPedidos();
            for(Pedido p : sa){
                if(p.getCliente().equals(email)){
                    pedidos.add(p);
                }
            }
            return pedidos;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public boolean eliminarpedido(Pedido p) throws Exception {
        try {
            emf = Persistence.createEntityManagerFactory("Persistencia");
            manager = emf.createEntityManager();
            Pedido _p = manager.find(Pedido.class,p.getnPedido());
            manager.getTransaction().begin();
            manager.remove(_p);
            manager.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ListaPedidos buscarpedidos() throws Exception {
        try {
            emf = Persistence.createEntityManagerFactory("Persistencia");
            manager = emf.createEntityManager();
            ListaPedidos listaPedidos = new ListaPedidos();
            List<Pedido> sa = (List<Pedido>) manager.createQuery("FROM pedido").getResultList();
            ListaPedidos pedidos = new ListaPedidos();
            for(Pedido p : sa){
                    pedidos.add(p);
            }
            return pedidos;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        } finally {
            this.cerrar();
        }
    }
}