import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TechPartsHubGUI extends JFrame {
    private JTable tablaInventario;
    private DefaultTableModel modeloInventario;
    private JTextField txtNombre, txtCodigo, txtDescripcion, txtFabricante, txtPrecio, txtStock, txtCategoria;
    private JTextArea txtHistorial;
    private TechPartsFunciones funciones;

    public TechPartsHubGUI() {
        funciones = new TechPartsFunciones();
        inicializarComponentes();
        configurarVentana();
    }

    private void inicializarComponentes() {
        // Panel principal con BorderLayout esto es para que los paneles se acomoden en
        // la ventana
        setLayout(new BorderLayout(10, 10));

        // Panel de entrada de datos (registro)
        JPanel panelEntrada = new JPanel(new GridLayout(7, 2, 5, 5));
        panelEntrada.setBorder(BorderFactory.createTitledBorder("Registro de Partes"));
        txtNombre = new JTextField();
        txtCodigo = new JTextField();
        txtDescripcion = new JTextField();
        txtFabricante = new JTextField();
        txtPrecio = new JTextField();
        txtStock = new JTextField();
        txtCategoria = new JTextField();
        panelEntrada.add(new JLabel("Nombre:"));
        panelEntrada.add(txtNombre);
        panelEntrada.add(new JLabel("Código:"));
        panelEntrada.add(txtCodigo);
        panelEntrada.add(new JLabel("Descripción:"));
        panelEntrada.add(txtDescripcion);
        panelEntrada.add(new JLabel("Fabricante:"));
        panelEntrada.add(txtFabricante);
        panelEntrada.add(new JLabel("Precio:"));
        panelEntrada.add(txtPrecio);
        panelEntrada.add(new JLabel("Stock:"));
        panelEntrada.add(txtStock);
        panelEntrada.add(new JLabel("Categoría:"));
        panelEntrada.add(txtCategoria);

        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        JButton btnRegistrar = new JButton("Registrar Parte");
        JButton btnBuscar = new JButton("Buscar");
        JButton btnEliminar = new JButton("Eliminar Parte");
        JButton btnActualizarStock = new JButton("Actualizar Stock");
        JButton btnOrdenarNombre = new JButton("Ordenar por Nombre");
        JButton btnOrdenarPrecio = new JButton("Ordenar por Precio");
        JButton btnOrdenarStock = new JButton("Ordenar por Stock");
        panelBotones.add(btnRegistrar);
        panelBotones.add(btnBuscar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnActualizarStock);
        panelBotones.add(btnOrdenarNombre);
        panelBotones.add(btnOrdenarPrecio);
        panelBotones.add(btnOrdenarStock);

        // Panel superior (registro + botones)
        JPanel panelSuperior = new JPanel(new BorderLayout(5, 5));
        panelSuperior.add(panelEntrada, BorderLayout.CENTER);
        panelSuperior.add(panelBotones, BorderLayout.SOUTH);

        // Tabla de inventario
        String[] columnas = { "Nombre", "Código", "Descripción", "Fabricante", "Precio", "Stock", "Categoría" };
        modeloInventario = new DefaultTableModel(columnas, 0);
        tablaInventario = new JTable(modeloInventario);
        JScrollPane scrollTabla = new JScrollPane(tablaInventario);
        scrollTabla.setBorder(BorderFactory.createTitledBorder("Inventario"));

        // Panel de historial
        txtHistorial = new JTextArea(15, 25);
        txtHistorial.setEditable(false);
        JScrollPane scrollHistorial = new JScrollPane(txtHistorial);
        scrollHistorial.setBorder(BorderFactory.createTitledBorder("Historial de Cambios"));

        // Agregar paneles al frame principal
        add(panelSuperior, BorderLayout.NORTH);
        add(scrollTabla, BorderLayout.CENTER);
        add(scrollHistorial, BorderLayout.EAST);

        // Acciones de los botones
        btnRegistrar.addActionListener(e -> registrarParte());
        btnBuscar.addActionListener(e -> buscarParte());
        btnEliminar.addActionListener(e -> eliminarParte());
        btnActualizarStock.addActionListener(e -> actualizarStockSeleccionado());
        btnOrdenarNombre.addActionListener(e -> ordenarPorNombre());
        btnOrdenarPrecio.addActionListener(e -> ordenarPorPrecio());
        btnOrdenarStock.addActionListener(e -> ordenarPorStock());
    }

    // boton registrar parte
    private void registrarParte() {
        try {
            String nombre = txtNombre.getText();
            int codigo = Integer.parseInt(txtCodigo.getText());
            String descripcion = txtDescripcion.getText();
            String fabricante = txtFabricante.getText();
            double precio = Double.parseDouble(txtPrecio.getText());
            int stock = Integer.parseInt(txtStock.getText());
            String categoria = txtCategoria.getText();
            // validaciones partinentes antes de registrar
            if (nombre.isEmpty() || codigo <= 0 || descripcion.isEmpty() || fabricante.isEmpty()
                    || categoria.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Error: Todos los campos son requeridos");
                return;
            }
            if (precio <= 0 || stock <= 0) {
                JOptionPane.showMessageDialog(this, "Error: El precio y el stock deben ser números positivos");
                return;
            }
            if (funciones.existeParte(codigo)) {
                JOptionPane.showMessageDialog(this, "Error: La parte ya existe");
                return;
            }
            ParteHardware parte = new ParteHardware(nombre, codigo, descripcion, fabricante, precio, stock, categoria);
            funciones.agregarParte(parte);
            actualizarTabla();
            actualizarHistorial();
            limpiarCampos();
            JOptionPane.showMessageDialog(this, "Parte registrado correctamente");

        } catch (NumberFormatException ex) {
        }
    }

    // boton buscar parte
    private void buscarParte() {
        String busqueda = JOptionPane.showInputDialog(this, "Ingrese el nombre o código a buscar:");
        if (busqueda == null || busqueda.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un nombre o código para buscar.");
            return;
        }
        ParteHardware parte = funciones.buscarParte(busqueda.trim());
        if (parte != null) {
            mostrarParte(parte);
            JOptionPane.showMessageDialog(this, "Parte encontrada");
        } else {
            JOptionPane.showMessageDialog(this, "Parte no encontrada");
        }
    }

    // boton mostrar parte
    private void mostrarParte(ParteHardware parte) {
        txtNombre.setText(parte.getNombre());
        txtCodigo.setText(String.valueOf(parte.getCodigoProducto()));
        txtDescripcion.setText(parte.getDescripcion());
        txtFabricante.setText(parte.getFabricante());
        txtPrecio.setText(String.valueOf(parte.getPrecio()));
        txtStock.setText(String.valueOf(parte.getStock()));
        txtCategoria.setText(parte.getCategoria());
    }

    // boton ordenar por nombre
    private void ordenarPorNombre() {
        funciones.ordenarPorNombre();
        actualizarTabla();
    }

    // boton ordenar por precio
    private void ordenarPorPrecio() {
        funciones.ordenarPorPrecio();
        actualizarTabla();
    }

    // boton ordenar por stock
    private void ordenarPorStock() {
        funciones.ordenarPorStock();
        actualizarTabla();
    }

    // boton actualizar tabla
    private void actualizarTabla() {
        modeloInventario.setRowCount(0);
        for (ParteHardware parte : funciones.getCatalogo()) {
            Object[] fila = {
                    parte.getNombre(),
                    parte.getCodigoProducto(),
                    parte.getDescripcion(),
                    parte.getFabricante(),
                    parte.getPrecio(),
                    parte.getStock(),
                    parte.getCategoria()
            };
            modeloInventario.addRow(fila);
        }
    }

    // boton actualizar historial
    private void actualizarHistorial() {
        txtHistorial.setText(funciones.getHistorialCambios().toString());

    }

    // boton limpiar campos
    private void limpiarCampos() {
        txtNombre.setText("");
        txtCodigo.setText("");
        txtDescripcion.setText("");
        txtFabricante.setText("");
        txtPrecio.setText("");
        txtStock.setText("");
        txtCategoria.setText("");
    }

    // boton eliminar parte
    private void eliminarParte() {
        int filaSeleccionada = tablaInventario.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una parte en la tabla para eliminar.");
            return;
        }
        int codigo = (int) modeloInventario.getValueAt(filaSeleccionada, 1);
        ParteHardware parte = funciones.buscarParte(String.valueOf(codigo));
        if (parte != null) {
            funciones.eliminarParte(parte);
            actualizarTabla();
            actualizarHistorial();
            limpiarCampos();
            JOptionPane.showMessageDialog(this, "Parte eliminada correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo encontrar la parte para eliminar.");
        }
    }

    // boton actualizar stock
    private void actualizarStockSeleccionado() {
        String busqueda = JOptionPane.showInputDialog(this, "Ingrese el nombre o código a buscar:");
        if (busqueda == null || busqueda.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un nombre o código para buscar.");
            return;
        }
        int stock = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el nuevo stock:"));
        if (stock <= 0) {
            JOptionPane.showMessageDialog(this, "El stock no puede ser negativo.");
            return;
        }
        funciones.actualizarStock(busqueda.trim(), stock);
        actualizarTabla();
        actualizarHistorial();
        JOptionPane.showMessageDialog(this, "Stock actualizado correctamente.");
    }

    // ventana
    private void configurarVentana() {
        setTitle("TechParts Hub - Sistema de Gestión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 600);
        setLocationRelativeTo(null);
    }
}