package Ejercicio2_SB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompraPasajes extends JFrame {
    private JTextField nombreField, documentoField, fechaViajeField;
    private JComboBox<String> origenCombo, destinoCombo;
    private JList<String> servicioList;
    private JCheckBox audifonosCheck, mantaCheck, revistasCheck;
    private JRadioButton piso1Radio, piso2Radio;
    private JButton resetButton, mostrarButton;

    public CompraPasajes() {
        super("Compra de Pasajes");

        setLayout(new FlowLayout());

        add(new JLabel("Nombre:"));
        nombreField = new JTextField(15);
        add(nombreField);

        add(new JLabel("DNI:"));
        documentoField = new JTextField(15);
        add(documentoField);

        add(new JLabel("Fecha de Viaje:"));
        fechaViajeField = new JTextField(15);
        add(fechaViajeField);

        add(new JLabel("Lugar de Origen:"));
        origenCombo = new JComboBox<>(new String[]{"Arequipa", "Lima", "Cusco"});
        add(origenCombo);

        add(new JLabel("Lugar de Destino:"));
        destinoCombo = new JComboBox<>(new String[]{"Arequipa", "Trujilo", "Puno"});
        add(destinoCombo);

        add(new JLabel("Calidad de Servicio:"));
        servicioList = new JList<>(new String[]{"Económico", "Standard", "VIP"});
        servicioList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(servicioList));

        audifonosCheck = new JCheckBox("Audífonos");
        mantaCheck = new JCheckBox("Manta");
        revistasCheck = new JCheckBox("Revistas");
        add(audifonosCheck);
        add(mantaCheck);
        add(revistasCheck);

        add(new JLabel("Piso del asiento:"));
        piso1Radio = new JRadioButton("1er Piso");
        piso2Radio = new JRadioButton("2do Piso");
        ButtonGroup pisoGroup = new ButtonGroup();
        pisoGroup.add(piso1Radio);
        pisoGroup.add(piso2Radio);
        add(piso1Radio);
        add(piso2Radio);

        resetButton = new JButton("Reiniciar");
        mostrarButton = new JButton("Mostrar Datos");
        add(resetButton);
        add(mostrarButton);

        resetButton.addActionListener(e -> {
            nombreField.setText("");
            documentoField.setText("");
            fechaViajeField.setText("");
            origenCombo.setSelectedIndex(0);
            destinoCombo.setSelectedIndex(0);
            servicioList.clearSelection();
            audifonosCheck.setSelected(false);
            mantaCheck.setSelected(false);
            revistasCheck.setSelected(false);
            pisoGroup.clearSelection();
        });

        mostrarButton.addActionListener(e -> mostrarResumen());

        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void mostrarResumen() {
        String nombre = nombreField.getText();
        String documento = documentoField.getText();
        String fechaViaje = fechaViajeField.getText();
        String origen = (String) origenCombo.getSelectedItem();
        String destino = (String) destinoCombo.getSelectedItem();
        String servicio = servicioList.getSelectedValue();
        String piso = piso1Radio.isSelected() ? "1er Piso" : "2do Piso";

        StringBuilder serviciosOpcionales = new StringBuilder();
        if (audifonosCheck.isSelected()) serviciosOpcionales.append("Audífonos ");
        if (mantaCheck.isSelected()) serviciosOpcionales.append("Manta ");
        if (revistasCheck.isSelected()) serviciosOpcionales.append("Revistas ");

        String mensaje = String.format(
                "Resumen de Compra:\nNombre: %s\nDocumento: %s\nFecha de Viaje: %s\n" +
                        "Origen: %s\nDestino: %s\nServicio: %s\nPiso: %s\nServicios Opcionales: %s",
                nombre, documento, fechaViaje, origen, destino, servicio, piso, serviciosOpcionales.toString().trim()
        );

        JOptionPane.showMessageDialog(this, mensaje, "Resumen", JOptionPane.INFORMATION_MESSAGE);
    }

}
