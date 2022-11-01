package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Datos{
    private ListaArticulos listaArticulos;
    private ListaClientes listaClientes;
    private ListaPedidos listaPedidos;
    public Datos() {
        listaArticulos = new ListaArticulos();
        listaClientes = new ListaClientes();
        listaPedidos = new ListaPedidos();
    }
    public String mostrarArticulos(String c) {
        for (Articulo a : listaArticulos.lista) {
            if(a.getCodigo().equals(c)){
                return "----------------------------------------------------" + "\n" + " || " + "Código: "+ a.getCodigo() + " || " + "Descripción: "+ a.getDescripcion() +
                        " || " + "Precio: "+ a.getPrecio() + " || "+ " Precio de envío: " + a.getgEnvio() + " || " + " Tiempo de preparación: " + a.getpEnvio() + " || "+ "\n";
            }
        }
        return null;
    }
    public Articulo getArticulo(String idCodigo) {
        int cont = 0;
        Articulo sArticulo = new Articulo();
        for (Articulo articulo : listaArticulos.lista) {
            if (articulo.getCodigo().equals(idCodigo)) {
                return listaArticulos.getAt(cont);
            }
            cont++;
        }
        return sArticulo;
    }
    public boolean addArticulo(String c, String d, float p, float gE, int pE) {
        Articulo a = new Articulo(c, d, p, gE, pE);
        if (listaArticulos.getArrayList().contains(a)) {
            return false; //El articulo ya existe.
        } else {
            listaArticulos.add(a);
        }
        return true;//El articulo ha sido anadido correctamente.
    }
    public Cliente_Premium buscarClienteP(String email){

        try{
            for(Cliente_Premium C : listaClientes.getClientesP()){
                if(C.getEmail().equals(email)){
                    return C;
                }
            }
        }catch(Exception e){}
        Cliente_Premium C = new Cliente_Premium();
        return C;
    }
    public Cliente_Estandar buscarClienteE(String email){

        try{
            for(Cliente_Estandar C : listaClientes.getClientesE()){
                if(C.getEmail().equals(email)){
                    return C;
                }
            }
        }catch (Exception e){}

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


    public String showCliente(String email){

        Cliente_Premium cp = buscarClienteP(email);
        Cliente_Estandar ce = buscarClienteE(email);
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
    public boolean addCliente(String nombre, String domicilio, String nif, String email, char tipo){
        switch (tipo){
            case '1':
                // Cliente Premium
                Cliente_Premium cP = buscarClienteP(email);
                Cliente_Estandar _cE = buscarClienteE(email);

                if(cP.getEmail() == null && _cE.getEmail() == null){
                    cP.setDomicilio(domicilio);
                    cP.setEmail(email);
                    cP.setNif(nif);
                    cP.setNombre(nombre);
                    cP.setDescuento(0.20);
                    listaClientes.getClientesP().add(cP);
                    return true;
                }else{
                    return false;
                }

            case '2':
                // Cliente Estandar
                Cliente_Premium _cP = buscarClienteP(email);
                Cliente_Estandar cE = buscarClienteE(email);
                if(cE.getEmail() == null && _cP.getEmail() == null){
                    cE.setDomicilio(domicilio);
                    cE.setEmail(email);
                    cE.setNif(nif);
                    cE.setNombre(nombre);
                    listaClientes.clientesE.add(cE);
                    return true;

                }else{
                    return false;
                }
        }
        return true;
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
    public int crearPedido(String email, String idArticulo, int cantidad){
        Cliente_Estandar Ce = buscarClienteE(email);
        Cliente_Premium Cp = buscarClienteP(email);

        if(Ce.getEmail() == null && Cp.getEmail() == null){
            return -1;
        }else{
            if(Ce.getEmail() != null){
                    float p = getArticulo(idArticulo).getPrecio()*cantidad+getArticulo(idArticulo).getgEnvio();
                    Pedido pedido = new Pedido(Ce,getArticulo(idArticulo),generateNorder(),cantidad,p);
                    listaPedidos.add(pedido);
                    return pedido.getnPedido();
            }
            if(Cp.getEmail() != null){
                double p = getArticulo(idArticulo).getPrecio()*cantidad+(getArticulo(idArticulo).getgEnvio()*0.20);
                Pedido pedido = new Pedido(Cp,getArticulo(idArticulo),generateNorder(),cantidad,p);
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

        if(fechaActual.compareTo(fechaActual) > 0){
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