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
    //método para insertar un nuevo elemento al principio de la lista.
    public void insertarAlInicio(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
        tamaño++;
    }
    //método para obtener el primer elemento de la lista.
    public T obtenerPrimero() {
        if (cabeza == null) {
            return null;
        }
        return cabeza.dato;
    }
    //método para verificar si la lista está vacía.
    public boolean estaVacia() {
        return cabeza == null;
    }
    //método para obtener el tamaño de la lista.
    public int getTamaño() {
        return tamaño;
    }
    //método para limpiar la lista.
    public void limpiar() {
        cabeza = null;
        tamaño = 0;
    }
    //método para convertir la lista en una cadena de texto.
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
