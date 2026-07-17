package data;


import java.util.ArrayList;
import java.util.List;

public class Gestor<T> {

 public   List<T> lista;

    public Gestor() {
        this.lista = new ArrayList<>();

    }

    public void agregar(T lista) {
        this.lista.add(lista);
    }

    public List<T> obtenerLista() {
        return this.lista;

    }


}
