package modelo;

import dao.*;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Datos{

    DAOArticulo daoArticulo;
    DAOCliente daoCliente;
    DAOCliente_Estandar daoCliente_estandar;
    DAOCliente_Premium daoCliente_premium;

    public Datos() {
        daoArticulo = new ArticuloDAOImpl();
        daoCliente = new ClienteDAOImpl();
        daoCliente_estandar = new Cliente_EstandardDAOImpl();
        daoCliente_premium = new Cliente_PremiumDAOImpl();
    }

    public String mostrarArticulos(String c) throws Exception {
        Articulo a = daoArticulo.buscar(c);
                return "----------------------------------------------------" + "\n" + " || " + "Código: "+ a.getCodigo() + " || " + "Descripción: "+ a.getDescripcion() +
                        " || " + "Precio: "+ a.getPrecio() + " || "+ " Precio de envío: " + a.getgEnvio() + " || " + " Tiempo de preparación: " + a.getpEnvio() + " || "+ "\n";
    }
    public boolean addArticulo(String c, String d, float p, float gE, int pE) {
        Articulo a = new Articulo(c, d, p, gE, pE);
        try{
            daoArticulo.registrar(a);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public String buscarClienteP(String email) throws Exception {
        Cliente_Premium a = daoCliente_premium.buscar(email);
        return "----------------------------------------------------" + "\n" + " || " + "Email: "+ a.getEmail() + " || " + "Descuento: "+ a.getDescuento() + "\n";
    }

    public String buscarClienteE(String email) throws Exception {
        Cliente_Estandar a = daoCliente_estandar.buscar(email);
        return "----------------------------------------------------" + "\n" + " || " + " || " + "Email: "+ a.getEmail() + "\n";
    }

    public String showCliente(String email) throws Exception {

        Cliente_Premium cp = daoCliente_premium.buscar(email);
        Cliente_Estandar ce = daoCliente_estandar.buscar(email);
        try{
            if(cp.getEmail().equals(email)){
                return "DATOS: " + cp.getNombre() + " || " + cp.getEmail() + " || " + cp.getNif() + " || " + cp.getDomicilio() + "|| Tipo: Premium" + "\n";
            }
        }catch(Exception e){}

        try{
            if(ce.getEmail().equals(email)){
                return "DATOS: " + ce.getNombre() + " || " + ce.getEmail() + " || " + ce.getNif() + " || " + ce.getDomicilio() + "|| Tipo: Estándar"+"\n";
            }
        } catch (Exception e){
            return "-------------------------------" + "\n"+ " El Cliente no existe." + "\n" + "-------------------------------";
        }
        return null;
    }
    public boolean addCliente(String email, String domicilio, String nombre, String nif) {
        Cliente c = new Cliente(email, domicilio, nombre, nif);
        try {
            daoCliente.registrar(c);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Pedido buscarPedido(int nPedido){
        Pedido _p = new Pedido();
        try{
            for(Pedido p : listaPedidos.lista) {
                if (p.getnPedido() == nPedido) {
                    return p;//
                }
            }
        }catch (Exception e){}

        return _p;
    }
    public String catalogo(){
        String c = "";
        for (int i = 0; i < listaArticulos.getSize();i++) {
            c += i +" - " + " || Código: " + listaArticulos.getArticulos().get(i).getCodigo() + " || Descripción: " + listaArticulos.getArticulos().get(i).getDescripcion() +
                " || Gastos de envío: " +  listaArticulos.getArticulos().get(i).getgEnvio() + " || Precio: " + listaArticulos.getArticulos().get(i).getPrecio() +
                    " || Tiempo de preparación: " + listaArticulos.getArticulos().get(i).getpEnvio() + "\n";
        }
        return c;
    }
    private int generateNorder(){
        Random rand = new Random();
        int nPedido;
        do{
            nPedido = rand.nextInt(100);
        }while(buscarPedido(nPedido).getnPedido() == nPedido);
        return nPedido;
    }
    public boolean eliminarPedido(int n){
        Pedido p = buscarPedido(n);
        if(p != null && !estadoPedido(p)){
            listaPedidos.borrar(p);
            return true;
        }else{
            return false;
        }
    }
    public int crearPedido(String email, String idArticulo, int cantidad) throws Exception {
        Cliente_Estandar Ce = buscarClienteE(email);
        Cliente_Premium Cp = buscarClienteP(email);

        if(Ce.getEmail() == null && Cp.getEmail() == null){
            return -1;
        }else{
            if(Ce.getEmail() != null){
                    Articulo a = daoArticulo.buscar(idArticulo);
                    float p = a.getPrecio()*cantidad+a.getgEnvio();
                    Pedido pedido = new Pedido(Ce,a,generateNorder(),cantidad,p);
                    listaPedidos.add(pedido);
                    return pedido.getnPedido();
            }
            if(Cp.getEmail() != null){
                Articulo a = daoArticulo.buscar(idArticulo);
                double p = a.getPrecio()*cantidad+(a.getgEnvio()*0.20);
                Pedido pedido = new Pedido(Cp,a,generateNorder(),cantidad,p);
                listaPedidos.add(pedido);
                return pedido.getnPedido();
            }
        }
        return 0;
    }
    public boolean estadoPedido(Pedido p){

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,p.getFecha().getYear());
        calendar.set(Calendar.MONTH,p.getFecha().getMonthValue());
        calendar.set(Calendar.MONTH,p.getFecha().getDayOfMonth());
        calendar.add(Calendar.MINUTE,p.getArticulo().getpEnvio());
        Date fechaPedido = calendar.getTime();

        calendar.set(Calendar.YEAR,LocalDate.now().getYear());
        calendar.set(Calendar.MONTH,LocalDate.now().getYear());
        calendar.set(Calendar.MONTH,LocalDate.now().getYear());

        Date fechaActual = calendar.getTime();

        if(fechaActual.compareTo(fechaPedido) > 0){
            return true;
        }
        return false;

    }
    public String buscarPPCliente(String email){
        String c = "";
        for(Pedido p : listaPedidos.getArrayList()){
            if(p.getCliente().getEmail().equals(email)){
                if(!estadoPedido(p)){
                    c = c + " Cliente: " + p.getCliente().getEmail() + "\n "+ " Datos del pedido || Cod: " + p.getnPedido() + " || Fecha: " + p.getFecha() + " || Art: "+  p.getArticulo().getCodigo() +" || Cant: " + p.getCantidad() + " || Coste: "
                            +  p.getPrecioP()  + "\n";
                }
            }
        }
        return c;
    }
    public String buscarPP(){
        String c = "";
        for(Pedido p : listaPedidos.getArrayList()){
            if(!estadoPedido(p)){
                c = c + " || Cod: " + p.getnPedido() + " || Fecha: " + p.getFecha() + " || Art: "+  p.getArticulo().getCodigo() + " || Cant:  " + p.getCantidad() + " || Coste: "
                        +  p.getPrecioP()  + "\n";
            }
        }
        return c;
    }
    public String buscarPECliente(String email){
        String c = "";
        for(Pedido p : listaPedidos.getArrayList()){
            if(p.getCliente().getEmail().equals(email)){
                if(estadoPedido(p)){
                    c = c + " Cliente: " + p.getCliente().getEmail() + "\n "+ " Datos del pedido || Cod: " + p.getnPedido() + " || Fecha: " + p.getFecha() + " || Art: "+  p.getArticulo().getCodigo() + " || Cant: " + p.getCantidad() + " || Coste: "
                            +  p.getPrecioP()  + "\n";
                }
            }
        }
        return c;
    }
    public String buscarPE(){
        String c = "";
        for(Pedido p : listaPedidos.getArrayList()){
            if(estadoPedido(p)){
                c = c + " || Cod: " + p.getnPedido() + " || Fecha: " + p.getFecha() + " || Art: "+  p.getArticulo().getCodigo() + " || Cant:  " + p.getCantidad() + " || Coste: "
                        +  p.getPrecioP()  + "\n";
            }
        }
        return c;
    }

}