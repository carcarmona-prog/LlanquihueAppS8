package ui;
import data.GestorElementos;
import service.Registrable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

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
            for (Registrable r : gestor.obtenerLista()) {
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
            String[] tipos = {
                    "Servicio Turístico", "Excursion Cultural", "Ruta Gastronómica",
                    "Paseos lacustres", "Activos Vehículos", "Colaboradores Externos",
                    "Guias turísticos", "Personal"
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


                String tipo = (String) comboTipos.getSelectedItem();
                switch (tipo) {

                    case "Servicio Turístico" ->{
                        panelCampos.add(new JLabel("Nombre del destino:"));
                        panelCampos.add(campoNombre);
                        panelCampos.add(new JLabel("Duración:"));
                        panelCampos.add(campoDuracion);
                    }

                    case "Excursion Cultural" -> {
                        panelCampos.add(new JLabel("Nombre del lugar historico:"));
                        panelCampos.add(campoLugar);
                        panelCampos.add(new JLabel("Nombre de la actividad:"));
                        panelCampos.add(campoNombre);
                        panelCampos.add(new JLabel("Duracion:"));
                        panelCampos.add(campoDuracion);
                    }
                    case "Ruta Gastronómica" -> {
                        panelCampos.add(new JLabel("Restaurante:"));
                        panelCampos.add(campoNombre);
                        panelCampos.add(new JLabel("Numero de paradas"));
                        panelCampos.add(campoParadas);
                        panelCampos.add(new JLabel("Duración de la actividad"));
                        panelCampos.add(campoDuracion);
                    }
                    case "Paseos lacustres" -> {
                        panelCampos.add(new JLabel("Nombre de la actividad:"));
                        panelCampos.add(campoNombre);
                        panelCampos.add(new JLabel("Duración de la actividad:"));
                        panelCampos.add(campoDuracion);
                        panelCampos.add(new JLabel("Tipo de embarcación:"));
                        panelCampos.add(campoEmbarcacion);
                    }
                    case "Activos Vehículos" -> {

                        panelCampos.add(new JLabel("Marca:"));
                        panelCampos.add(campoMarca);
                        panelCampos.add(new JLabel("Modelo:"));
                        panelCampos.add(campoModelo);
                        panelCampos.add(new JLabel("Color:"));
                        panelCampos.add(campoColor);
                        panelCampos.add(new JLabel("Patente:"));
                        panelCampos.add(campoPatente);
                    }
                    case "Colaboradores Externos" -> {
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
                    case "Guias turísticos" -> {
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
                    case  "Personal" -> {
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
            JButton botonAgregar = new JButton("Agregar");
            botonAgregar.addActionListener(e -> {
               try {
                   String tipo = (String) comboTipos.getSelectedItem();
                   String nombre = campoNombre.getText();
                   int duracion = campoDuracion.getText().isEmpty() ? 0 : Integer.parseInt(campoDuracion.getText());
                   int numeroParadas = campoParadas.getText().isEmpty() ? 0 : Integer.parseInt(campoParadas.getText());
                   String tipoEmbarcacion = campoEmbarcacion.getText();

                   gestor.mostrarInformacion(
                           tipo,
                           nombre,
                           duracion,
                           campoLugar.getText(),
                           campoMarca.getText(),
                           campoModelo.getText(),
                           campoColor.getText(),
                           campoPatente.getText(),
                           campoRut.getText(),
                           campoEmail.getText(),
                           campoPuesto.getText(),
                           campoArea.getText(),
                           campoServicio.getText(),
                           campoPatente.getText(),
                           numeroParadas,
                           tipoEmbarcacion);
                   actualizarLista();
                   limpiarCampos();

               }catch(NumberFormatException ex){
                   JOptionPane.showMessageDialog(null, ex.getMessage(), "Error de tipeo, ingrese el dato que se le pide", JOptionPane.ERROR_MESSAGE);
               }

            });
            JPanel panelInferior = new JPanel(new BorderLayout());
            panelInferior.add(comboTipos, BorderLayout.NORTH);
            panelInferior.add(panelCampos, BorderLayout.CENTER);
            panelInferior.add(botonAgregar, BorderLayout.SOUTH);

            add(panelInferior, BorderLayout.SOUTH);




            // Agregar componentes

            add(new JScrollPane(listaServicios), BorderLayout.CENTER);
            add(panelSuperior, BorderLayout.NORTH);



        }


        private void actualizarLista() {
            modeloLista.clear();
            for(Registrable r : gestor.obtenerLista()){
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


