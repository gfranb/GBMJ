package dao;

import modelo.Cliente_Estandar;
import modelo.Cliente_Premium;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Cliente_PremiumDAOImpl extends Conexion implements DAOCliente_Premium{

    private static EntityManagerFactory emf;

    private static EntityManager manager;

    @Override
    public boolean registrar(Cliente_Premium cp) throws Exception {
        try {
            emf = Persistence.createEntityManagerFactory("Persistencia");
            manager = emf.createEntityManager();

            manager.getTransaction().begin();
            manager.persist(cp);
            manager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public Cliente_Premium buscar(String email) throws Exception {

        try {
            emf = Persistence.createEntityManagerFactory("Persistencia");
            manager = emf.createEntityManager();
            return manager.find(Cliente_Premium.class,email);

        } catch (Exception e) {
            return null;
        } finally {
            this.cerrar();
        }
    }
}