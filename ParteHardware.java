<<<<<<< HEAD
/*1. Representación de datos: 
Definir una clase ParteHardware con atributos para nombre, código de producto, 
descripción, fabricante, precio, cantidad en stock y categoría. 
Utilizar ArrayList<ParteHardware> para almacenar el catálogo principal de partes. 
Consultar e identificar un posible caso de uso para ListaEnlazada: Por ejemplo, podría 
ser para la gestión de una cola de pedidos pendientes (si se implementa esa 
funcionalidad), o podría ser para el historial de cambios en el stock de un producto si las 
inserciones al principio de la lista (nuevos registros) son frecuentes. Justificar su 
elección y explicar su uso. */

//Clase para representar una parte de hardware
public class ParteHardware {
    private String nombre;
    private int codigoProducto;
    private String descripcion;
    private String fabricante;
    private double precio;
    private int stock;
    private String categoria;

    //Constructor de la clase
    public ParteHardware(String nombre, int codigoProducto, String descripcion, String fabricante, double precio, int stock, String categoria) {
        this.nombre = nombre;
        this.codigoProducto = codigoProducto;
        this.descripcion = descripcion;
        this.fabricante = fabricante;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    //Getters (obtener)
    public String getNombre() {
        return nombre;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFabricante() { 
        return fabricante;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public String getCategoria() {
        return categoria;
    }

    //Setters (establecer)
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    //toString (convertir a cadena) esto es una funcion que se utiliza para imprimir el objeto
    //https://www.youtube.com/watch?v=7bEK_VpTzS4
    @Override
    public String toString() {
        return "ParteHardware [nombre=" + nombre + ", codigoProducto=" + codigoProducto + ", descripcion=" + descripcion + ", fabricante=" + fabricante + ", precio=" + precio + ", stock=" + stock + ", categoria=" + categoria + "]";
    }
    

    

=======
/*1. Representación de datos: 
Definir una clase ParteHardware con atributos para nombre, código de producto, 
descripción, fabricante, precio, cantidad en stock y categoría. 
Utilizar ArrayList<ParteHardware> para almacenar el catálogo principal de partes. 
Consultar e identificar un posible caso de uso para ListaEnlazada: Por ejemplo, podría 
ser para la gestión de una cola de pedidos pendientes (si se implementa esa 
funcionalidad), o podría ser para el historial de cambios en el stock de un producto si las 
inserciones al principio de la lista (nuevos registros) son frecuentes. Justificar su 
elección y explicar su uso. */

//Clase para representar una parte de hardware
public class ParteHardware {
    private String nombre;
    private int codigoProducto;
    private String descripcion;
    private String fabricante;
    private double precio;
    private int stock;
    private String categoria;

    //Constructor de la clase
    public ParteHardware(String nombre, int codigoProducto, String descripcion, String fabricante, double precio, int stock, String categoria) {
        this.nombre = nombre;
        this.codigoProducto = codigoProducto;
        this.descripcion = descripcion;
        this.fabricante = fabricante;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    //Getters (obtener)
    public String getNombre() {
        return nombre;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFabricante() { 
        return fabricante;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public String getCategoria() {
        return categoria;
    }

    //Setters (establecer)
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    //toString (convertir a cadena) esto es una funcion que se utiliza para imprimir el objeto
    //https://www.youtube.com/watch?v=7bEK_VpTzS4
    @Override
    public String toString() {
        return "ParteHardware [nombre=" + nombre + ", codigoProducto=" + codigoProducto + ", descripcion=" + descripcion + ", fabricante=" + fabricante + ", precio=" + precio + ", stock=" + stock + ", categoria=" + categoria + "]";
    }
    

    

>>>>>>> 3d1022727dfea657ee3c309edcae66244dcd45c7
}