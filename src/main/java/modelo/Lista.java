package modelo;

import java.util.ArrayList;

public class Lista<T> {
    protected ArrayList<T> lista;

    public Lista() {
        lista = new ArrayList<T>();
    }

    public Lista(ArrayList<T> a) {
        lista = a;
    }
    public int getSize() {
        return lista.size();
    }
    public void add(T t) {
        lista.add(t);
    }
    public void borrar(T t) {
        int i = lista.indexOf(t);
        lista.remove(i);
    }
    public T getAt(int position) {
        return lista.get(position);
    }
    public void addLista(ArrayList<T> a){
        lista = a;
    }
    public void clear() {
        lista.clear();
    }
    public boolean isEmpty() {
        return lista.isEmpty();
    }
    public ArrayList<T> getArrayList() {
        ArrayList<T> arrlist = new ArrayList<>(lista);
        return arrlist;
    }

}
