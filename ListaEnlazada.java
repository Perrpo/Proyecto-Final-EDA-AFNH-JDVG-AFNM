//Implementar y utilizar una ListaEnlazada para optimizar alguna funcionalidad 
//específica, justificando su uso. 

//Lista enlazada: es una estructura de datos que almacena elementos en una secuencia lineal, 
//donde cada elemento apunta al siguiente elemento en la lista.

public class ListaEnlazada<T> {
    private Nodo<T> cabeza;
    private int tamaño;

    private static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;

        Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    public ListaEnlazada() {
        this.cabeza = null;
        this.tamaño = 0;
    }

    public void insertarAlInicio(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
        tamaño++;
    }

    public T obtenerPrimero() {
        if (cabeza == null) {
            return null;
        }
        return cabeza.dato;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void limpiar() {
        cabeza = null;
        tamaño = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Nodo<T> actual = cabeza;
        while (actual != null) {
            sb.append(actual.dato.toString()).append("\n");
            actual = actual.siguiente;
        }
        return sb.toString();
    }
}
