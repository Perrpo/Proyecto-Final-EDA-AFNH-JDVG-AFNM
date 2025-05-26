/* 2. Búsqueda de Partes (Algoritmo de búsqueda): 
Implementar la búsqueda por nombre o código de producto (búsqueda lineal sobre el 
ArrayList). Si se decide mantener el ArrayList ordenado por nombre o código, se podría 
usar búsqueda binaria. 
Implementar la búsqueda por categoría o rango de precio (requerirá probablemente un 
recorrido lineal del ArrayList con filtros). */

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator; //importar la clase Comparator

public class TechPartsFunciones {
    private ArrayList<ParteHardware> catalogo; // ArrayList para almacenar el catálogo de partes
    private ListaEnlazada<RegistroCambio> historialCambios; // Lista para almacenar el historial de cambios

    // Constructor de la clase
    public TechPartsFunciones() {
        this.catalogo = new ArrayList<>(); // inicializar el ArrayList de catalogo
        this.historialCambios = new ListaEnlazada<>(); // inicializar la lista de historial de cambios
    }

    // Métodos para agregar partes al catálogo
    public void agregarParte(ParteHardware parte) {
        catalogo.add(parte);
        registrarCambio(parte, "Registro", parte.getStock());
    }

    // metodo para eliminar una parte del catalogo
    public void eliminarParte(ParteHardware parte) {
        catalogo.remove(parte);
        registrarCambio(parte, "Eliminación", parte.getStock());
    }

    // metodo para validar si una parte existe en el catalogo por el codigo de
    public boolean existeParte(int codigo) {
        for (ParteHardware parte : catalogo) {
            if (parte.getCodigoProducto() == codigo) {
                return true;
            }
        }
        return false;
    }
    // metodo para obtener el catalogo
    public ArrayList<ParteHardware> getCatalogo() {
        return catalogo;
    }

    // Búsqueda por nombre o código de producto (búsqueda lineal sobre el ArrayList)
    public ParteHardware buscarParte(String busqueda) {
        for (ParteHardware parte : catalogo) { // para cada objeto de tipo ParteHardware en el ArrayList catalogo haz lo
                                               // siguiente
            String codigo = String.valueOf(parte.getCodigoProducto());
            if (parte.getNombre().equalsIgnoreCase(busqueda) ||
                    codigo.equalsIgnoreCase(busqueda)) {
                return parte;
            }
        }
        return null;
    }

    /*
     * 3. Gestión del Inventario: Implementar métodos para actualizar la cantidad en
     * stock de
     * una parte específica.
     */

    // Métodos para actualizar la cantidad en stock de una parte específica
    public void actualizarStock(String nombreOcodigo, int cantidad) {
        ParteHardware parte = buscarParte(nombreOcodigo);
        if (parte != null) {
            int stockActual = parte.getStock();
            int stockNuevo = stockActual + cantidad;
            parte.setStock(stockNuevo);
            registrarCambio(parte, "Actualización", stockActual);
            System.out.println("Stock actualizado para " + nombreOcodigo + ": " + stockNuevo);
        } else {
            System.out.println("Parte no encontrado: " + nombreOcodigo);
        }
    }

    /*
     * 4. Ordenamiento del inventario (Algoritmo de ordenamiento): implementar
     * métodos
     * para ordenar el ArrayList de partes por nombre, precio o cantidad en stock
     * utilizando
     * un algoritmo de ordenamiento (ej: Merge Sort, Quick Sort, Insertion Sort).
     */

    // Método para ordenar por nombre usando QuickSort
    public void ordenarPorNombre() {
        quickSort(0, catalogo.size() - 1, Comparator.comparing(ParteHardware::getNombre));
    }

    // Método para ordenar por precio usando QuickSort
    public void ordenarPorPrecio() {
        quickSort(0, catalogo.size() - 1, Comparator.comparingDouble(ParteHardware::getPrecio));
    }

    // Método para ordenar por cantidad en stock usando QuickSort
    public void ordenarPorStock() {
        quickSort(0, catalogo.size() - 1, Comparator.comparingInt(ParteHardware::getStock));
    }

    // Implementación de QuickSort
    private void quickSort(int inicio, int fin, Comparator<ParteHardware> comparador) {
        if (inicio < fin) {
            int indicePivote = particionar(inicio, fin, comparador);
            quickSort(inicio, indicePivote - 1, comparador);
            quickSort(indicePivote + 1, fin, comparador);
        }
    }

    // Método de partición para QuickSort
    private int particionar(int inicio, int fin, Comparator<ParteHardware> comparador) {
        ParteHardware pivote = catalogo.get(fin);
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (comparador.compare(catalogo.get(j), pivote) <= 0) {
                i++;
                intercambiar(i, j);
            }
        }

        intercambiar(i + 1, fin);
        return i + 1;
    }

    // Método auxiliar para intercambiar elementos
    private void intercambiar(int i, int j) {
        ParteHardware temp = catalogo.get(i);
        catalogo.set(i, catalogo.get(j));
        catalogo.set(j, temp);
    }

    /*
     * 5. Selección de partes para ofertas (Algoritmo de selección): implementar una
     * funcionalidad para seleccionar los k productos con la menor cantidad en stock
     * del
     * ArrayList utilizando un algoritmo de selección o mediante ordenamiento
     * parcial.
     */

    // Método para seleccionar los k productos con la menor cantidad en stock
    public List<ParteHardware> seleccionarProductosBajoStock(int k) {
        ordenarPorStock();
        return catalogo.subList(0, Math.min(k, catalogo.size()));
    }

    // Método para registrar cambios en el historial
    private void registrarCambio(ParteHardware parte, String tipoCambio, int cantidadAnterior) {
        RegistroCambio registro = new RegistroCambio(parte, tipoCambio, cantidadAnterior);
        historialCambios.insertarAlInicio(registro);
    }

    // Método para obtener el historial de cambios
    public ListaEnlazada<RegistroCambio> getHistorialCambios() {
        return historialCambios;
    }

    // Método para obtener el catalogo
    public ArrayList<ParteHardware> getInventario() {
        return catalogo;
    }

}
