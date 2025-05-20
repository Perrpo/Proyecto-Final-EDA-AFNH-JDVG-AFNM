import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TechPartsHubGUI extends JFrame {
    private JTable tablaInventario;
    private DefaultTableModel modeloInventario;
    private JTextField txtNombre, txtCodigo, txtDescripcion, txtFabricante, txtPrecio, txtStock, txtCategoria;
    private JTextArea txtHistorial;

    public TechPartsHubGUI() {
        inicializarComponentes();
        configurarVentana();
    }

    private void inicializarComponentes() {
        // Panel principal con BorderLayout esto es para que los paneles se acomoden en la ventana 
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
        JButton btnOrdenarNombre = new JButton("Ordenar por Nombre");
        JButton btnOrdenarPrecio = new JButton("Ordenar por Precio");
        JButton btnOrdenarStock = new JButton("Ordenar por Stock");
        panelBotones.add(btnRegistrar);
        panelBotones.add(btnBuscar);
        panelBotones.add(btnOrdenarNombre);
        panelBotones.add(btnOrdenarPrecio);
        panelBotones.add(btnOrdenarStock);

        // Panel superior (registro + botones)
        JPanel panelSuperior = new JPanel(new BorderLayout(5, 5));
        panelSuperior.add(panelEntrada, BorderLayout.CENTER);
        panelSuperior.add(panelBotones, BorderLayout.SOUTH);

        // Tabla de inventario
        String[] columnas = {"Nombre", "Código", "Descripción", "Fabricante", "Precio", "Stock", "Categoría"};
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
        btnOrdenarNombre.addActionListener(e -> ordenarPorNombre());
        btnOrdenarPrecio.addActionListener(e -> ordenarPorPrecio());
        btnOrdenarStock.addActionListener(e -> ordenarPorStock());
    }

    private void registrarParte() {
    }

    private void buscarParte() {
    }

    private void mostrarParte() {
        
    }

    private void ordenarPorNombre() {
    }

    private void ordenarPorPrecio() {
    }

    private void ordenarPorStock() {
    }

    private void actualizarTabla() {
    }

    private void actualizarHistorial() {
       
    }

    private void limpiarCampos() {
    }

    private void configurarVentana() {
        setTitle("TechParts Hub - Sistema de Gestión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 600);
        setLocationRelativeTo(null);
    }
} 