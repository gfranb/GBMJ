package modelo;

import java.util.ArrayList;

public class Lista_Pedidos {

    private ArrayList <Pedido> pedidos;

    public Lista_Pedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
        pedidos = new ArrayList();
    }

    public Lista_Pedidos() {

    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }


}


