package modelo;

import java.util.ArrayList;

public class ListaClientes extends Lista<Cliente>{
    ArrayList<Cliente_Premium> clientesP;

    ArrayList<Cliente_Estandar> clientesE;

    ListaClientes(){

    }

    public ArrayList<Cliente_Estandar> getClientesE() {
        return clientesE;
    }

    public ArrayList<Cliente_Premium> getClientesP() {
        return clientesP;
    }

    public void setClientesE(ArrayList<Cliente_Estandar> clientesE) {
        this.clientesE = clientesE;
    }

    public void setClientesP(ArrayList<Cliente_Premium> clientesP) {
        this.clientesP = clientesP;
    }

    @Override
    public String toString() {
        return "Lista_Clientes{" +
                "clientesP=" + clientesP +
                ", clientesE=" + clientesE +
                '}';
    }
}
