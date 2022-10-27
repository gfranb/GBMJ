package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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
                return a.toString();
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

        for(Cliente_Premium C : listaClientes.getClientesP()){
            if(C.getEmail().equals(email)){
                return C;
            }
        }

        Cliente_Premium C = new Cliente_Premium();
        return C;
    }
    public Cliente_Estandar buscarClienteE(String email){

        for(Cliente_Estandar C : listaClientes.getClientesE()){
            if(C.getEmail().equals(email)){
                return C;
            }
        }
        Cliente_Estandar C = new Cliente_Estandar();
        return C;
    }
    public Cliente buscarCliente(String email){
        Cliente_Premium Cp = buscarClienteP(email);
        Cliente_Estandar Ce = buscarClienteE(email);

        if(Cp.getEmail().equals(email)){
            return Cp;
        }
        if(Ce.getEmail().equals(email)){
            return Ce;
        }
        return null;
    }
    public String showCliente(String email){
        try{
            Cliente c = buscarCliente(email);
            if(c.getNif().equals(email)){
                return c.toString();
            }
        }catch(Exception e){
            return "El cliente no existe";
        }
        return null;
    }
    public boolean addCliente(String nombre, String domicilio, String nif, String email, char tipo){
        switch (tipo){
            case '1':
                // Cliente Premium
                Cliente_Premium cP = buscarClienteP(email);

                if(cP.getEmail() == ""){
                    cP.setDomicilio(domicilio);
                    cP.setEmail(email);
                    cP.setNif(nif);
                    cP.setNombre(nombre);
                    cP.setDescuento(0.20);
                    listaClientes.add(cP);
                    return true;
                }else{
                    return false;
                }

            case '2':
                // Cliente Estandar
                Cliente_Estandar cE = buscarClienteE(email);
                if(cE.getEmail() == ""){
                    cE.setDomicilio(domicilio);
                    cE.setEmail(email);
                    cE.setNif(nif);
                    cE.setNombre(nombre);
                    listaClientes.add(cE);
                    return true;

                }else{
                    return false;
                }
        }
        return true;
    }
    public Pedido buscarPedido(int nPedido){
        for(Pedido p : listaPedidos.lista) {
            if (p.getnPedido() == nPedido) {
                listaPedidos.borrar(p);
                return p;// Se borra el pedido y devuelve true
            }
        }
        return null;
    }
    public String catalogo(){
        String c = "";
        for (int i = 0; i < listaArticulos.getSize();i++) {
            c += i +"- " + listaArticulos.getArticulos().get(i).toString() + "\n";
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

        if(Ce.getEmail().equals("") && Cp.getEmail().equals("")){
            return -1;
        }else{
            if(!Ce.getEmail().equals("")){
                    float p = getArticulo(idArticulo).getPrecio()*cantidad+getArticulo(idArticulo).getgEnvio();
                    Pedido pedido = new Pedido(Ce,getArticulo(idArticulo),generateNorder(),cantidad,p);
                    listaPedidos.add(pedido);
                    return pedido.getnPedido();
            }
            if(!Cp.getEmail().equals("")){
                double p = getArticulo(idArticulo).getPrecio()*cantidad+(getArticulo(idArticulo).getgEnvio()*0.20);
                Pedido pedido = new Pedido(Ce,getArticulo(idArticulo),generateNorder(),cantidad,p);
                listaPedidos.add(pedido);
                return pedido.getnPedido();
            }
        }
        return 0;
    }
    public boolean estadoPedido(Pedido p){
        if(ChronoUnit.MINUTES.between(p.getFecha(),LocalDate.now())>p.getArticulo().getpEnvio()){
            return true;
        }
        return false;
    }
    public String buscarPPCliente(String email){
        String c = "";
        for(Pedido p : listaPedidos.getArrayList()){
            if(p.getCliente().getEmail().equals(email)){
                if(!estadoPedido(p)){
                    c = c + p.toString() + "\n";
                }
            }
        }
        return c;
    }
    public String buscarPP(){
        String c = "";
        for(Pedido p : listaPedidos.getArrayList()){
            if(!estadoPedido(p)){
                c = c + p.toString() + "\n";
            }
        }
        return c;
    }
    public String buscarPECliente(String email){
        String c = "";
        for(Pedido p : listaPedidos.getArrayList()){
            if(p.getCliente().getEmail().equals(email)){
                if(estadoPedido(p)){
                    c = c + p.toString() + "\n";
                }
            }
        }
        return c;
    }
    public String buscarPE(){
        String c = "";
        for(Pedido p : listaPedidos.getArrayList()){
            if(estadoPedido(p)){
                c = c + p.toString() + "\n";
            }
        }
        return c;
    }

}