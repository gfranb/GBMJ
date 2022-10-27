package modelo;

public class Datos {
    private ListaArticulos listaArticulos;
    private ListaClientes listaClientes;
    private ListaPedidos listaPedidos;

    public Datos() {
        listaArticulos = new ListaArticulos();
        listaClientes = new ListaClientes();
        listaPedidos = new ListaPedidos();
    }

    public void mostrarArticulos() {
        for (Articulo a : listaArticulos.lista) {
            a.toString();
        }
    }

    public Articulo showArticulo(String idCodigo) {
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
        if (listaArticulos.getArticulos().contains(a)) {
            return false; //El articulo ya existe.
        } else {
            listaArticulos.add(a);
        }
        return true;//El articulo ha sido anadido correctamente.
    }

    public Cliente buscarCliente(String email){

        for(Cliente C : listaClientes.getClientesE()){
            if(C.getNif().equals(email)){
                return C;
            }
        }
        for(Cliente C : listaClientes.getClientesP()){
            if(C.getNif().equals(email)){
                return C;
            }
        }
        Cliente C = new Cliente_Estandar();
        return C;
    }

    public void showCliente(String email){
        Cliente c = buscarCliente(email);
        if(c.getNif().equals(email)){
            c.toString();
        }
    }

    public boolean addCliente(String nombre, String domicilio, String nif, String email, int tipo){
        switch (tipo){
            case 1:
                // Cliente Premium
                Cliente _cP = buscarCliente(email);

                if(_cP.getNif() == ""){
                    Cliente c = new Cliente_Premium();
                    c.setDomicilio(domicilio);
                    c.setEmail(email);
                    c.setNif(nif);
                    c.setNombre(nombre);
                    listaClientes.add(c);
                    return true;
                }else{
                    return false;
                }

            case 2:
                // Cliente Estandar
                Cliente _cE = buscarCliente(email);
                if(_cE.getNif() == ""){

                    Cliente cE = new Cliente_Estandar();
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

    public void addPedido(Cliente C, Articulo A, int cantidad, int nPedido){
        Pedido p = new Pedido(C,A,cantidad,nPedido);
        listaPedidos.add(p);
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
    public boolean removerPedido(int nPedido){
        try{
            listaPedidos.borrar(buscarPedido((nPedido)));
            return true;
        }catch (Exception e){
            return false;
        }
    }

}