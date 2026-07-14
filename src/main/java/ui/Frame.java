package ui;
import data.GestorElementos;
import model.*;
import service.Registrable;
import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Clase donde se crean los parámetros para la interfaz gráfica.
 */

    public class Frame extends JFrame {
        private GestorElementos gestor;
        private DefaultListModel<String> modeloLista;
        private JList<String> listaServicios;

        private JTextField campoNombre = new JTextField(15);
        private JTextField campoDuracion = new JTextField(5);

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
            add(new JScrollPane(listaServicios), BorderLayout.CENTER);

            // Cargar datos iniciales
            actualizarLista();

            // Panel superior con botón de refresco
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

            JButton botonEliminar = new JButton("Eliminar por Nombre");
            botonEliminar.addActionListener(e -> {
                String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre a eliminar:");
                if (nombre != null && !nombre.isEmpty()) {
                    boolean eliminado = gestor.eliminarPorNombre(nombre);
                    if (eliminado) {
                        JOptionPane.showMessageDialog(this, "Eliminado correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(this, "No se encontró el servicio.");
                    }
                    // refrescar la lista
                    modeloLista.clear();
                    for (Registrable r : gestor.obtenerLista()) {
                        modeloLista.addElement(r.mostrarInformacion());
                    }
                }
            });
            panelSuperior.add(botonEliminar);


            // Panel inferior para agregar servicios
            String[] tipos = {
                    "Servicio Turístico", "ExcursionCultural", "Ruta Gastronómica",
                    "Paseos lacustres", "Activos Vehículos", "Colaboradores Externos",
                    "Guias turisticos", "Personal"
            };
            JComboBox<String> comboTipos = new JComboBox<>(tipos);

            // Panel de campos
            JPanel panelCampos = new JPanel(new GridLayout(0, 2));
            panelCampos.add(new JLabel("Nombre:"));
            panelCampos.add(campoNombre);
            panelCampos.add(new JLabel("Duración:"));
            panelCampos.add(campoDuracion);

            comboTipos.addActionListener(e -> {
                panelCampos.removeAll();
                panelCampos.add(new JLabel("Nombre:"));
                panelCampos.add(campoNombre);
                panelCampos.add(new JLabel("Duración:"));
                panelCampos.add(campoDuracion);

                String tipo = (String) comboTipos.getSelectedItem();
                switch (tipo) {
                    case "ExcursionCultural" -> {
                        panelCampos.add(new JLabel("Lugar:"));
                        panelCampos.add(campoLugar);
                    }
                    case "Ruta Gastronómica" -> {
                        panelCampos.add(new JLabel("Restaurante:"));
                        panelCampos.add(campoLugar);
                    }
                    case "Paseos lacustres" -> {
                        panelCampos.add(new JLabel("Embarcación:"));
                        panelCampos.add(campoEmbarcacion);
                    }
                    case "Activos Vehículos" -> {

                        panelCampos.add(new JLabel("Modelo:"));
                        panelCampos.add(campoModelo);
                        panelCampos.add(new JLabel("Color:"));
                        panelCampos.add(campoColor);
                        panelCampos.add(new JLabel("Patente:"));
                        panelCampos.add(campoPatente);
                    }
                    case "Colaboradores Externos", "Personal" -> {
                        panelCampos.add(new JLabel("RUT:"));
                        panelCampos.add(campoRut);
                        panelCampos.add(new JLabel("Email:"));
                        panelCampos.add(campoEmail);
                        panelCampos.add(new JLabel("Puesto:"));
                        panelCampos.add(campoPuesto);
                    }
                    case "Guias turisticos" -> {
                        panelCampos.add(new JLabel("RUT:"));
                        panelCampos.add(campoRut);
                        panelCampos.add(new JLabel("Email:"));
                        panelCampos.add(campoEmail);
                        panelCampos.add(new JLabel("Puesto:"));
                        panelCampos.add(campoPuesto);
                        panelCampos.add(new JLabel("Área:"));
                        panelCampos.add(campoArea);
                    }
                }
                panelCampos.revalidate();
                panelCampos.repaint();
            });

            // Botón agregar
            JButton botonAgregar = new JButton("Agregar");
            botonAgregar.addActionListener(e -> {
                String tipo = (String) comboTipos.getSelectedItem();
                String nombre = campoNombre.getText();
                int duracion = campoDuracion.getText().isEmpty() ? 0 : Integer.parseInt(campoDuracion.getText());

                gestor.registrar(
                        tipo,
                        nombre,
                        duracion,
                        campoLugar.getText(),
                        campoMarca.getText(),
                        campoEmbarcacion.getText(),
                        campoModelo.getText(),
                        campoColor.getText(),
                        campoPatente.getText(),
                        campoRut.getText(),
                        campoEmail.getText(),
                        campoPuesto.getText(),
                        campoArea.getText()
                );

                actualizarLista();
                limpiarCampos();
            });
            JPanel panelInferior = new JPanel(new BorderLayout());
            panelInferior.add(comboTipos, BorderLayout.NORTH);
            panelInferior.add(panelCampos, BorderLayout.CENTER);
            panelInferior.add(botonAgregar, BorderLayout.SOUTH);

            add(panelInferior, BorderLayout.SOUTH);


            // Campo de filtro
            JTextField campoFiltro = new JTextField(15);
            JButton botonFiltrar = new JButton("Filtrar");
            botonFiltrar.addActionListener(e -> {
                String filtro = campoFiltro.getText().toLowerCase();
                List<Registrable> filtrados = gestor.obtenerLista().stream()
                        .filter(r -> r.mostrarInformacion().toLowerCase().contains(filtro))
                        .toList();
                actualizarLista();
            });
            panelSuperior.add(new JLabel("Filtro:"));
            panelSuperior.add(campoFiltro);
            panelSuperior.add(botonFiltrar);


            // Agregar componentes
            add(panelSuperior, BorderLayout.NORTH);
            add(new JScrollPane(listaServicios), BorderLayout.CENTER);
            add(panelSuperior, BorderLayout.NORTH);


        }


        private void actualizarLista() {
            modeloLista.clear();
            for (Registrable r : gestor.obtenerLista()) {
                modeloLista.addElement(r.mostrarInformacion());
            }
            return ;
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
        }


    }


