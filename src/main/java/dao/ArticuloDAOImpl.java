package dao;

import modelo.Articulo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class ArticuloDAOImpl extends Conexion implements DAOArticulo{

    private static EntityManagerFactory emf;
    private static EntityManager manager;
    @Override
    public boolean registrar(Articulo articulo) throws Exception {
        try {
            emf = Persistence.createEntityManagerFactory("Persistencia");
            manager = emf.createEntityManager();

            manager.getTransaction().begin();
            manager.persist(articulo);
            manager.getTransaction().commit();

            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        } finally {
            this.cerrar();
        }
    }
    @Override
    public Articulo buscar(String id) throws Exception {
        try {
            emf = Persistence.createEntityManagerFactory("Persistencia");
            manager = emf.createEntityManager();
            Articulo articulo = new Articulo();
            return manager.find(Articulo.class,id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public ArrayList<Articulo> mostrar() throws Exception {
        try {
            emf = Persistence.createEntityManagerFactory("Persistencia");
            manager = emf.createEntityManager();
            List<Articulo> sa = (List<Articulo>) manager.createQuery("FROM articulo").getResultList();
            ArrayList<Articulo> articulos = new ArrayList<>();
            for(Articulo a : sa){
                articulos.add(a);
            }
            return articulos;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        } finally {
            this.cerrar();
        }
    }

}
