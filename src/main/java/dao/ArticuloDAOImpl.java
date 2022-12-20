package dao;

import modelo.Articulo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;

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
            /*
            this.conectar();
            PreparedStatement st = connection.prepareStatement("INSERT INTO articulo(codigo,descripcion,precio,gEnvio,pEnvio) VALUES(?,?,?,?,?)");
            st.setString(1, articulo.getCodigo());
            st.setString(2, articulo.getDescripcion());
            st.setFloat(3, articulo.getPrecio());
            st.setFloat(4, articulo.getgEnvio());
            st.setInt(5, articulo.getpEnvio());
            st.executeUpdate();*/
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
            /*
            this.conectar();
            PreparedStatement st = connection.prepareStatement("SELECT * FROM articulo WHERE codigo=?");
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            Articulo articulo = new Articulo();
            while(rs.next()){
                if(rs.getString(1).equals(id)){
                    articulo.setCodigo(rs.getString(1));
                    articulo.setDescripcion(rs.getString(2));
                    articulo.setPrecio(rs.getFloat(3));
                    articulo.setgEnvio(rs.getFloat(4));
                    articulo.setpEnvio(rs.getInt(5));
                }
            }
            return articulo;
            */
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
            /*this.conectar();
            PreparedStatement st = connection.prepareStatement("SELECT * FROM articulo");
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                    Articulo articulo = new Articulo();
                    articulo.setCodigo(rs.getString(1));
                    articulo.setDescripcion(rs.getString(2));
                    articulo.setPrecio(rs.getFloat(3));
                    articulo.setgEnvio(rs.getFloat(4));
                    articulo.setpEnvio(rs.getInt(5));
                    articulos.add(articulo);
            }
            */
            return articulos;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        } finally {
            this.cerrar();
        }
    }

}
