package data;

import model.*;
import service.Registrable;

import java.util.ArrayList;

public class GestorElementos {

    private final Gestor<Registrable>lista;

    public GestorElementos() {
        this.lista = new Gestor<>();
    }

    public void cargarGestor() {

        if(!lista.obtenerLista().isEmpty()){
            return;
        }

        lista.agregar(new PaseoLacustre("rafting", 4, "lancha"));
        lista.agregar(new ServicioTuristico("paseo crazy", 4));
        lista.agregar(new ExcursionCultural("caminata eterna", 8, "parque viejo"));
        lista.agregar(new RutaGastronomica("restaurante elegante", 2, 3));
        lista.agregar(new ActivosVehiculos("ford", "focus", "blanco", "456-dps"));
        lista.agregar(new ColaboradoresExternos("jose melo", "25.365.452-5", "josemeloo@gmail.com", "chofer de botes", "externo"));
        lista.agregar(new Personal("daniela perez", "19.369.258-5", "danipe@gmail.com", "secretaria"));
        lista.agregar(new GuiasTuristicos("pepe veraz", "14.258.357-6", "pepeelchido@gmail.com", "guia experto", "trekking"));


    }

    public ArrayList<Registrable> obtenerLista(){
        return new ArrayList<>(lista.obtenerLista());
    }

    public String describirTipo(int indice){
        Registrable funcion = obtenerPorIndice(indice);

        if(funcion instanceof ServicioTuristico){
            return ((ServicioTuristico) funcion).getNombre()+ " -> es una servicio turístico";
        }
        if(funcion instanceof ExcursionCultural){
            return ((ExcursionCultural) funcion).getNombre()+ " -> es una excursion cultural";
        }
        if(funcion instanceof RutaGastronomica){
            return ((RutaGastronomica) funcion).getNombre()+ " -> es una ruta gastronomica";
        }
        if(funcion instanceof ColaboradoresExternos){
            return ((ColaboradoresExternos)funcion).getNombreCompleto()+ " -> es un colaborador de externo";
        }
        if(funcion instanceof ActivosVehiculos){
            return ((ActivosVehiculos)funcion).getModelo()+ " -> un vehiculo";
        }
        if(funcion instanceof GuiasTuristicos){
            return ((GuiasTuristicos)funcion).getNombreCompleto()+ " -> es un guia turistico";
        }
        if(funcion instanceof Personal){
            return ((Personal)funcion).getNombreCompleto()+ "-> es un trabajador directo o indirecto de Llanquihue tours";
        }
        return funcion + "no existe en el sistema";
    }

    public boolean eliminarPorNombre(String nombre) {
        return lista.obtenerLista().removeIf(r -> {
            if (r instanceof ServicioTuristico s) {
                return s.getNombre().equalsIgnoreCase(nombre);
            }
            if (r instanceof ExcursionCultural e) {
                return e.getNombre().equalsIgnoreCase(nombre);
            }
            if (r instanceof RutaGastronomica rg) {
                return rg.getNombre().equalsIgnoreCase(nombre);
            }
            if (r instanceof ColaboradoresExternos c) {
                return c.getNombreCompleto().equalsIgnoreCase(nombre);
            }
            if (r instanceof ActivosVehiculos v) {
                return v.getModelo().equalsIgnoreCase(nombre);
            }
            if (r instanceof GuiasTuristicos g) {
                return g.getNombreCompleto().equalsIgnoreCase(nombre);
            }
            if (r instanceof PaseoLacustre p) {
                return p.getNombre().equalsIgnoreCase(nombre);
            }
            if (r instanceof Personal per) {
                return per.getNombreCompleto().equalsIgnoreCase(nombre);
            }
            return false;
        });
    }


    public String mostrarInformacion(String tipo, String nombre, int duracion,
                          String lugar, String marca, String modelo, String color,
                          String patente, String rut, String email,
                          String puesto, String area, String servicio, String text, int numeroParadas, String tipoEmbarcacion)
    {


        switch (tipo) {
            case "Servicio Turístico" ->
                    lista.agregar(new ServicioTuristico(nombre, duracion));
            case "Excursion Cultural" ->
                    lista.agregar(new ExcursionCultural(nombre, duracion, lugar));
            case "Ruta Gastronómica" ->
                    lista.agregar(new RutaGastronomica(nombre, duracion, numeroParadas));
            case "Paseos lacustres" ->
                    lista.agregar(new PaseoLacustre(nombre, duracion, tipoEmbarcacion));
            case "Activos Vehículos" ->
                    lista.agregar(new ActivosVehiculos(marca, modelo, color, patente));
            case "Colaboradores Externos" ->
                    lista.agregar(new ColaboradoresExternos(nombre, rut, email, puesto, servicio ));
            case "Guias turísticos" ->
                    lista.agregar(new GuiasTuristicos(nombre, rut, email, puesto, area));
            case "Personal" ->
                    lista.agregar(new Personal(nombre, rut, email, puesto));
        }
        return "error al agregar";
    }

    public void mostrarTodo() {
        for (Registrable r : lista.obtenerLista()) {
            System.out.println((lista.obtenerLista().indexOf(r)));
        }
    }


    public Registrable obtenerPorIndice(int indice) {
        if (indice < 0 || indice >= lista.obtenerLista().size()) {
            throw new IllegalArgumentException("Indice fuera de rango: " + indice);
        }
        return lista.obtenerLista().get(indice);
    }






}
