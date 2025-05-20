/* 2. Búsqueda de Partes (Algoritmo de búsqueda): 
Implementar la búsqueda por nombre o código de producto (búsqueda lineal sobre el 
ArrayList). Si se decide mantener el ArrayList ordenado por nombre o código, se podría 
usar búsqueda binaria. 
Implementar la búsqueda por categoría o rango de precio (requerirá probablemente un 
recorrido lineal del ArrayList con filtros). */

import java.util.ArrayList;
import java.util.List;

public class TechPartsFunciones {
    private ArrayList<ParteHardware> catalogo; // ArrayList para almacenar el catálogo de partes

    // Constructor de la clase
    public TechPartsFunciones() {
        this.catalogo = new ArrayList<>();
    }

    // Métodos para agregar partes al catálogo
    public void agregarParte(ParteHardware parte) {
        catalogo.add(parte);
    }

    // Búsqueda por nombre o código de producto (búsqueda lineal sobre el ArrayList)
    public ParteHardware buscarParte(String busqueda) {
        for (ParteHardware parte : catalogo) { // para cada objeto de tipo ParteHardware en el ArrayList catalogo haz lo siguiente
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
            System.out.println("Stock actualizado para " + nombreOcodigo + ": " + stockNuevo);
        } else {
            System.out.println("Parte no encontrado: " + nombreOcodigo);
        }
    }

}
