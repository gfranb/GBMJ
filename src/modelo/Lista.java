package modelo;

import java.util.ArrayList;

public class Lista<T> {
    protected ArrayList<T> lista;

    public Lista() {
        lista = new ArrayList<>();
    }
    public int getSize() {
        return lista.size();
    }
    public void add(T t) {
// TO-BE-DONE
    }
    public void borrar(T t) {
// TO-BE-DONE
    }
    public T getAt(int position) {
        return lista.get(position);
    }
    public void clear() {
// TO-BE-DONE
    }
    public boolean isEmpty() {
        return lista.isEmpty();
    }
    public ArrayList<T> getArrayList() {
        ArrayList<T> arrlist = new ArrayList<>(lista);
        return arrlist;
    }

}
