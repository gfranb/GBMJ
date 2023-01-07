package modelo;

import dao.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

public class Datos{

    DAOArticulo daoArticulo;
    DAOPedido daoPedido;
    DAOCliente_Premium daoCliente_premium;
    DAOCliente_Estandar daoCliente_estandar;

    public Datos() {

        daoPedido = new PedidoDAOImpl();
        daoArticulo = new ArticuloDAOImpl();
        daoCliente_premium = new Cliente_PremiumDAOImpl();
        daoCliente_estandar = new Cliente_EstandardDAOImpl();

    }
    public ArrayList<String> mostrarArticulos(String c) throws Exception {
        Articulo a = daoArticulo.buscar(c);
        ArrayList<String> datos = new ArrayList<>();
        if(a != null){
            datos.add(a.getDescripcion());
            datos.add(Float.toString(a.getPrecio()));
            datos.add(Float.toString(a.getgEnvio()));
            datos.add(Integer.toString(a.getpEnvio()));
            return datos;
        }else{
            return null;
        }
    }
    public boolean addArticulo(String c, String d, float p, float gE, int pE) throws Exception{
        Articulo a = new Articulo(c, d, p, gE, pE);
        try{
            return daoArticulo.registrar(a);
        }catch (Exception e){
            return false;
        }
    }
    public Cliente_Premium buscarClienteP(String email){

        try{

            Cliente_Premium C = daoCliente_premium.buscar(email);
            return C;

        }catch(Exception e){}
        Cliente_Premium C = new Cliente_Premium();
        return C;
    }
    public Cliente_Estandar buscarClienteE(String email){

        try{
            Cliente_Estandar C = daoCliente_estandar.buscar(email);
            return C;
            } catch (Exception ex) {}

        Cliente_Estandar C = new Cliente_Estandar();
        return C;
    }
    public Cliente buscarCliente(String email){
        Cliente_Premium Cp = buscarClienteP(email);
        Cliente_Estandar Ce = buscarClienteE(email);

        try{
            if(Ce.getEmail().equals(email)){
                return Ce;
            }
        }
        catch (Exception e){}

        try{
        if(Cp.getEmail().equals(email)) {
            return Cp;
        }}catch (Exception e){

        }
         return null;

        }
    public ArrayList<String> showCliente(String email){

        Cliente_Premium cp = buscarClienteP(email);
        Cliente_Estandar ce = buscarClienteE(email);
        try{
            if(cp.getEmail().equals(email)){
                ArrayList<String> datos = new ArrayList<>();
                datos.add(cp.getNombre());
                datos.add(cp.getEmail());
                datos.add(cp.getNif());
                datos.add(cp.getDomicilio());
                datos.add("Premium");
                return datos;
            }
        }catch(Exception e){

        }

        try{
            if(ce.getEmail().equals(email)){
                ArrayList<String> datos = new ArrayList<>();
                datos.add(ce.getNombre());
                datos.add(ce.getEmail());
                datos.add(ce.getNif());
                datos.add(ce.getDomicilio());
                datos.add("Estandard");
                return datos;
            }
        } catch (Exception e){
            return null;
        }
        return null;
    }
    public boolean addCliente(String nombre, String nif, String email, String domicilio, char tipo) throws Exception {
        switch (tipo){
            case '1':
                // Cliente Premium
                if(buscarClienteP(email) == null && buscarClienteE(email) == null){
                        Cliente_Premium _cp = new Cliente_Premium();
                        _cp.setDomicilio(domicilio);
                        _cp.setEmail(email);
                        _cp.setNif(nif);
                        _cp.setNombre(nombre);
                        _cp.setDescuento(0.20);
                    try {
                        daoCliente_premium.registrar(_cp);
                    }catch(Exception e){
                        return false;
                    }
                    return true;
                }else{
                    return false;
                }
            case '2':
                // Cliente Estandar
                if(buscarClienteP(email) == null  && buscarClienteE(email) == null){
                    Cliente_Estandar _cE = new Cliente_Estandar();
                    _cE.setDomicilio(domicilio);
                    _cE.setEmail(email);
                    _cE.setNif(nif);
                    _cE.setNombre(nombre);
                    try {
                        daoCliente_estandar.registrar(_cE);
                    }catch(Exception e){
                        return false;
                    }
                    return true;
                }else{
                    return false;
                }
        }
        return true;
    }
    public Pedido buscarPedido(int nPedido){
        try{
            Pedido p = daoPedido.buscar(nPedido);
            return p;
        }catch (Exception e){}
        return null;
    }
    public String catalogo() throws Exception {
        String c = "";
        ListaArticulos listaArticulos = new ListaArticulos(daoArticulo.mostrar());
        for (int i = 0; i < listaArticulos.getSize();i++) {
            c += i +" - " + " || Código: " + listaArticulos.getArticulos().get(i).getCodigo() + " || Descripción: " + listaArticulos.getArticulos().get(i).getDescripcion() +
                " || Gastos de envío: " +  listaArticulos.getArticulos().get(i).getgEnvio() + " || Precio: " + listaArticulos.getArticulos().get(i).getPrecio() +
                    " || Tiempo de preparación: " + listaArticulos.getArticulos().get(i).getpEnvio() + "\n";
        }
        return c;
    }
    public int generateNorder(){
        Random rand = new Random();
        int nPedido;
        do{
            nPedido = rand.nextInt(100);
        }while(buscarPedido(nPedido) != null);
        return nPedido;
    }
    public boolean eliminarPedido(int n) throws Exception {
        Pedido p = buscarPedido(n);
        if(p != null && !estadoPedido(p)){
            try {
                daoPedido.eliminarpedido(p);
            } catch (Exception e) {}
            return true;
        }else{
            return false;
        }
    }
    public int crearPedido(String email, String idArticulo, int cantidad) throws Exception {
        Cliente_Estandar Ce = buscarClienteE(email);
        Cliente_Premium Cp = buscarClienteP(email);

        if(Ce== null && Cp == null){
            return -1;
        }else{
            if(Ce!= null){
                    Articulo a = daoArticulo.buscar(idArticulo);
                    float p = a.getPrecio()*cantidad+a.getgEnvio();
                    Pedido pedido = new Pedido(Ce,a,generateNorder(),cantidad,p);
                    daoPedido.registrar(pedido);
                    return pedido.getnPedido();
            }
            if(Cp!= null){
                Articulo a = daoArticulo.buscar(idArticulo);
                double p = a.getPrecio()*cantidad+(a.getgEnvio()*0.20);
                Pedido pedido = new Pedido(Cp,a,generateNorder(),cantidad,p);
                daoPedido.registrar(pedido);
                return pedido.getnPedido();
            }
        }
        return 0;
    }
    public boolean estadoPedido(Pedido p) throws Exception {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,p.getFecha().getYear());
        calendar.set(Calendar.MONTH,p.getFecha().getMonthValue());
        calendar.set(Calendar.DAY_OF_MONTH,p.getFecha().getDayOfMonth());
        calendar.add(Calendar.MINUTE,daoArticulo.buscar(p.getArticulo()).getpEnvio());
        Date fechaPedido = calendar.getTime();

        ZoneId z = ZoneId.of( "Europe/Paris" );
        ZonedDateTime zdt = LocalDate.now().atStartOfDay(z);
        Instant instant = zdt.toInstant();
        Date fechaActual = Date.from(instant);

        if(fechaActual.compareTo(fechaPedido) > 0){
            return true;
        }
        return false;

    }
    public String buscarPPCliente(String email){
        String c = "";

        try {
           ListaPedidos listaPedidos = new ListaPedidos();
            listaPedidos = daoPedido.buscarpedidocliente(email);

            for(Pedido p : listaPedidos.getArrayList()) {
                    if (!estadoPedido(p)) {
                        c = c + "|| Cod: " + p.getnPedido() + " || Fecha: " + p.getFecha() + " || Art: " + p.getArticulo() + " || Cant: " + p.getCantidad() + " || Coste: "
                                + p.getPrecioP() + "\n";
                    }
            }
        } catch (Exception e) {}

        return c;
    }
    public String buscarPP(){
        String c = "";

        try {
            ListaPedidos listaPedidos = daoPedido.buscarpedidos();

        for(Pedido p : listaPedidos.getArrayList()) {
            if(!estadoPedido(p)){
                c = c + " || Cod: " + p.getnPedido() + " || Fecha: " + p.getFecha() + " || Art: "+  p.getArticulo() + " || Cant:  " + p.getCantidad() + " || Coste: "
                        +  p.getPrecioP()  + "\n";
            }
        }
            return c;
        } catch (Exception e) {}
        return c;
    }
    public String buscarPECliente(String email){
        String c = "";
        try {
            ListaPedidos listaPedidos = daoPedido.buscarpedidocliente(email);

            for(Pedido p : listaPedidos.getArrayList()) {

                if (estadoPedido(p)) {
                    c = c + "|| Cod: " + p.getnPedido() + " || Fecha: " + p.getFecha() + " || Art: " + p.getArticulo() + " || Cant: " + p.getCantidad() + " || Coste: "
                            + p.getPrecioP() + "\n";
                }
            }
        } catch (Exception e) {}

        return c;
    }
    public String buscarPE(){
        String c = "";

        try {
            ListaPedidos listaPedidos = daoPedido.buscarpedidos();

            for(Pedido p : listaPedidos.getArrayList()) {
                if(estadoPedido(p)){
                    c = c + " || Cod: " + p.getnPedido() + " || Fecha: " + p.getFecha() + " || Art: "+  p.getArticulo() + " || Cant:  " + p.getCantidad() + " || Coste: "
                            +  p.getPrecioP()  + "\n";
                }
            }
            return c;
        } catch (Exception e) {}
        return c;
    }

}