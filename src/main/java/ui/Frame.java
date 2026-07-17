package ui;
import data.DatosPorAgregar;
import data.GestorElementos;
import model.TipoServicio;
import service.Registrables;
import util.PersistenciaException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

import static java.lang.Integer.parseInt;

/**
 * Clase donde se crean los parámetros para la interfaz gráfica.
 */

    public class Frame extends JFrame {
     private GestorElementos gestor;
      private DefaultListModel<String> modeloLista;
     private JList<String> listaServicios;


    private JTextField campoNombre = new JTextField(15);
    private JTextField campoDuracion = new JTextField(15);

    private JTextField campoLugar = new JTextField(15);
    private JTextField campoMarca = new JTextField(15);
    private JTextField campoEmbarcacion = new JTextField(15);
    private JTextField campoModelo = new JTextField(15);
    private JTextField campoColor = new JTextField(15);
    private JTextField campoPatente = new JTextField(15);
    private JTextField campoRut = new JTextField(15);
    private JTextField campoEmail = new JTextField(15);
    private JTextField campoPuesto = new JTextField(15);
    private JTextField campoArea = new JTextField(15);
    private JTextField campoParadas = new JTextField(15);
    private JTextField campoServicio = new JTextField(15);

    public Frame() {
        gestor = new GestorElementos();
        gestor.cargarGestor();

        setTitle("Gestor de Servicios");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Modelo de lista
        modeloLista = new DefaultListModel<>();
        listaServicios = new JList<>(modeloLista);


        // Cargar datos iniciales
        for (Registrables r : gestor.obtenerLista()) {
            modeloLista.addElement(r.mostrarInformacion());


        }


        // Panel superior con botón de ver servicios
        JPanel panelSuperior = new JPanel(new FlowLayout());
        JButton botonVerlista = new JButton("Ver lista de servicios");
        botonVerlista.addActionListener(e -> actualizarLista());
        panelSuperior.add(botonVerlista);


        // Panel donde describimos los tipos de servicios
        JButton botonDescribirTipo = new JButton("Describir Tipo");
        botonDescribirTipo.addActionListener(e -> {
            modeloLista.clear();
            for (int i = 0; i < gestor.obtenerLista().size(); i++) {
                modeloLista.addElement(gestor.describirTipo(i));
            }
        });
        panelSuperior.add(botonDescribirTipo);

        //creamos el boton para eliminar datos
        JButton botonEliminar = new JButton("Eliminar por Nombre");
        botonEliminar.addActionListener(this::eliminarPorNombre);
        panelSuperior.add(botonEliminar);


        // Panel inferior para agregar servicios

        //metodo para listar distintos tipos de servicion en un panel seleccionable
        //llamamos el enum TipoServicio para evitar problemas de escritura entre el gestor y el frame
        JComboBox<TipoServicio> comboTipos = new JComboBox<>(TipoServicio.values());

        // Panel de campos
        JPanel panelCampos = new JPanel(new GridLayout(0, 2));
        panelCampos.add(new JLabel("Nombre:"));
        panelCampos.add(campoNombre);
        panelCampos.add(new JLabel("Duración:"));
        panelCampos.add(campoDuracion);

        comboTipos.addActionListener(e -> {
            panelCampos.removeAll();


            TipoServicio tipo = (TipoServicio) comboTipos.getSelectedItem();
            switch (tipo) {

                case SERVICIO_TURISTICO -> {
                    panelCampos.add(new JLabel("Nombre del destino:"));
                    panelCampos.add(campoNombre);
                    panelCampos.add(new JLabel("Duración:"));
                    panelCampos.add(campoDuracion);
                }

                case EXCURSION_CULTURAL -> {
                    panelCampos.add(new JLabel("Nombre del lugar historico:"));
                    panelCampos.add(campoLugar);
                    panelCampos.add(new JLabel("Nombre de la actividad:"));
                    panelCampos.add(campoNombre);
                    panelCampos.add(new JLabel("Duración:"));
                    panelCampos.add(campoDuracion);
                }
                case RUTA_GASTRONOMICA -> {
                    panelCampos.add(new JLabel("Restaurante:"));
                    panelCampos.add(campoNombre);
                    panelCampos.add(new JLabel("Numero de paradas"));
                    panelCampos.add(campoParadas);
                    panelCampos.add(new JLabel("Duración de la actividad"));
                    panelCampos.add(campoDuracion);
                }
                case PASEO_LACUSTRE -> {
                    panelCampos.add(new JLabel("Nombre de la actividad:"));
                    panelCampos.add(campoNombre);
                    panelCampos.add(new JLabel("Duración de la actividad:"));
                    panelCampos.add(campoDuracion);
                    panelCampos.add(new JLabel("Tipo de embarcación:"));
                    panelCampos.add(campoEmbarcacion);
                }
                case ACTIVOS_VEHICULOS -> {

                    panelCampos.add(new JLabel("Marca:"));
                    panelCampos.add(campoMarca);
                    panelCampos.add(new JLabel("Modelo:"));
                    panelCampos.add(campoModelo);
                    panelCampos.add(new JLabel("Color:"));
                    panelCampos.add(campoColor);
                    panelCampos.add(new JLabel("Patente:"));
                    panelCampos.add(campoPatente);
                }
                case COLABORADORES_EXTERNOS -> {
                    panelCampos.add(new JLabel("Nombre:"));
                    panelCampos.add(campoNombre);
                    panelCampos.add(new JLabel("RUT:"));
                    panelCampos.add(campoRut);
                    panelCampos.add(new JLabel("Email:"));
                    panelCampos.add(campoEmail);
                    panelCampos.add(new JLabel("Puesto:"));
                    panelCampos.add(campoPuesto);
                    panelCampos.add(new JLabel("Servicio:"));
                    panelCampos.add(campoServicio);
                }
                case GUIAS_TURISTICOS -> {
                    panelCampos.add(new JLabel("Nombre:"));
                    panelCampos.add(campoNombre);
                    panelCampos.add(new JLabel("RUT:"));
                    panelCampos.add(campoRut);
                    panelCampos.add(new JLabel("Email:"));
                    panelCampos.add(campoEmail);
                    panelCampos.add(new JLabel("Puesto:"));
                    panelCampos.add(campoPuesto);
                    panelCampos.add(new JLabel("Servicio:"));
                    panelCampos.add(campoArea);
                }
                case PERSONAL -> {
                    panelCampos.add(new JLabel("Nombre:"));
                    panelCampos.add(campoNombre);
                    panelCampos.add(new JLabel("RUT:"));
                    panelCampos.add(campoRut);
                    panelCampos.add(new JLabel("Email:"));
                    panelCampos.add(campoEmail);
                    panelCampos.add(new JLabel("Puesto:"));
                    panelCampos.add(campoPuesto);

                }
            }
            panelCampos.revalidate();
            panelCampos.repaint();
        });

        // Botón agregar
        JButton botonAgregar;
        botonAgregar = new JButton("Agregar Servicios, Personal, Activos");
        botonAgregar.addActionListener(e -> {
            try {
                TipoServicio tipo= (TipoServicio) comboTipos.getSelectedItem();

                int duracion = parsearEntero(campoDuracion.getText());
                int numeroParadas = parsearEntero(campoParadas.getText());


                DatosPorAgregar datos = new DatosPorAgregar()
                        .setNombre(campoNombre.getText())
                        .setDuracion(duracion)
                        .setLugar(campoLugar.getText())
                        .setMarca(campoMarca.getText())
                        .setEmbarcacion(campoEmbarcacion.getText())
                        .setModelo(campoModelo.getText())
                        .setColor(campoColor.getText())
                        .setPatente(campoPatente.getText())
                        .setRut(campoRut.getText())
                        .setEmail(campoEmail.getText())
                        .setPuesto(campoPuesto.getText())
                        .setArea(campoArea.getText())
                        .setServicio(campoServicio.getText())
                        .setNumeroParadas(numeroParadas);

                gestor.registrar(tipo, datos);
                gestor.guardar();
                actualizarLista();
                limpiarCampos();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "La duración y el número de paradas deben ser números enteros (ej. 3), sin letras ni símbolose", JOptionPane.ERROR_MESSAGE);
            } catch (PersistenciaException | IOException ex) {
               JOptionPane.showMessageDialog(this, ex.getMessage(),"no se pudo guardar", JOptionPane.ERROR_MESSAGE);
            }

        });



        JPanel panelInferior = new JPanel(new BorderLayout());
        panelInferior.add(comboTipos, BorderLayout.NORTH);
        panelInferior.add(panelCampos, BorderLayout.CENTER);
        panelInferior.add(botonAgregar, BorderLayout.SOUTH);

        add(panelInferior, BorderLayout.SOUTH);
        add(new JScrollPane(listaServicios), BorderLayout.CENTER);
        add(panelSuperior, BorderLayout.NORTH);


    }

    private int parsearEntero(String texto) {
        String limpio = texto == null ? "" : texto.trim();
        return limpio.isEmpty() ? 0 : Integer.parseInt(limpio);
    }


    private void actualizarLista() {
        modeloLista.clear();
        for (Registrables r : gestor.obtenerLista()) {
            modeloLista.addElement(r.mostrarInformacion());
        }

    }

    private void limpiarCampos() {
        campoNombre.setText("");
        campoDuracion.setText("");
        campoLugar.setText("");
        campoModelo.setText("");
        campoColor.setText("");
        campoPatente.setText("");
        campoRut.setText("");
        campoEmail.setText("");
        campoPuesto.setText("");
        campoArea.setText("");
        campoEmbarcacion.setText("");
        campoMarca.setText("");
        campoParadas.setText("");
        campoServicio.setText("");


    }


    public void eliminarPorNombre(ActionEvent e) {
        String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre a eliminar:");
        if (nombre != null && !nombre.isEmpty()) {
            boolean eliminado = gestor.eliminarPorNombre(nombre);
            if (eliminado) {
                JOptionPane.showMessageDialog(this, "Eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró el servicio.");
            }
            // actualizar lista
            actualizarLista();
        }
    }
}


