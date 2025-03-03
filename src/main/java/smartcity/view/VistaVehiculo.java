package smartcity.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VistaVehiculo extends JFrame {
    private JComboBox<String> tiposVehiculos;
    private JButton encenderButton, apagarButton, moverButton, frenarButton, acelerarButton, desacelerarButton, mostrarSensorButton;
    private JTextArea txtArea;
    private JPanel panelPrincipal;
    private JButton cargarButton;
    private JButton pilotoAutomaticoButton;
    private JButton modoManualButton;
    private JButton apagarManualButton;

    public VistaVehiculo() {
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setTitle("Gestión de Transporte Inteligente");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        txtArea = new JTextArea(10, 30);
        txtArea.setEditable(false);

        add(new JScrollPane(txtArea));

        // Inicialmente ocultar botones que dependen del movimiento
        apagarButton.setVisible(false);  // No se puede apagar si no está encendido
        moverButton.setVisible(false);
        frenarButton.setVisible(false);
        acelerarButton.setVisible(false);
        desacelerarButton.setVisible(false);
        pilotoAutomaticoButton.setVisible(false);
        modoManualButton.setVisible(false);
        apagarManualButton.setVisible(false);


        setVisible(true);
    }

    public String getVehiculoSeleccionado() {
        return (String) tiposVehiculos.getSelectedItem();
    }

    public void mostrarMensaje(String mensaje) {
        txtArea.append(mensaje + "\n");
    }

    public void agregarEventoSeleccion(ActionListener listener) {
        tiposVehiculos.addActionListener(listener);
    }

    public void agregarEventoEncender(ActionListener listener) {
        encenderButton.addActionListener(listener);


    }

    public void agregarEventoApagar(ActionListener listener) {
        apagarButton.addActionListener(listener);
    }

    public void agregarEventoMover(ActionListener listener) {
        moverButton.addActionListener(listener);
    }

    public void agregarEventoFrenar(ActionListener listener) {
        frenarButton.addActionListener(listener);
    }

    public void agregarEventoAcelerar(ActionListener listener) {
        acelerarButton.addActionListener(listener);
    }

    public void agregarEventoDesacelerar(ActionListener listener) {
        desacelerarButton.addActionListener(listener);
    }

    public void agregarEventoMostrarEstado(ActionListener listener) {
        mostrarSensorButton.addActionListener(listener);
    }

    public void agregarEventoCargarBateria(ActionListener listener) {
        cargarButton.addActionListener(listener);
    }

    public void actualizarEstadoBotones(boolean encendido, boolean enMovimiento) {
        encenderButton.setVisible(!encendido);
        apagarButton.setVisible(encendido);
        moverButton.setVisible(!enMovimiento && encendido);
        frenarButton.setVisible(encendido && enMovimiento);
        acelerarButton.setVisible(enMovimiento);
        desacelerarButton.setVisible(enMovimiento);
        cargarButton.setVisible(!encendido);
        pilotoAutomaticoButton.setVisible(encendido);

    }

    public void agregarEventoPilotoAutomatico(ActionListener listener) {
        pilotoAutomaticoButton.addActionListener(listener);
    }

    public void agregarEventoApagarManual(ActionListener listener) {
        apagarManualButton.addActionListener(listener);
    }

    public void agregarEventoModoManual(ActionListener listener) {
        modoManualButton.addActionListener(listener);
    }

    public void activarModoManual(boolean activado) {
        modoManualButton.setVisible(activado);
        apagarManualButton.setVisible(!activado);

    }

    public void activarPilotoAutomatico(boolean activado) {
        pilotoAutomaticoButton.setVisible(activado);
    }


}
