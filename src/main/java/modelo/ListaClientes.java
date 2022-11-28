package modelo;

import java.util.ArrayList;

public class ListaClientes extends Lista<Cliente>{
    ArrayList<Cliente_Premium> clientesP;

    ArrayList<Cliente_Estandar> clientesE;

    ListaClientes(){
        this.clientesP = new ArrayList<Cliente_Premium>();
        this.clientesE = new ArrayList<Cliente_Estandar>();
    }

    public ArrayList<Cliente_Estandar> getClientesE() {
        return clientesE;
    }

    public ArrayList<Cliente_Premium> getClientesP() {
        return clientesP;

    }
}
