package data;

import model.*;
import service.Registrables;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GestorElementos {

   public final Gestor<Registrables>lista;


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

    public ArrayList<Registrables> obtenerLista(){
        return new ArrayList<>(lista.obtenerLista());
    }

    public String describirTipo(int indice){
        Registrables funcion = obtenerPorIndice(indice);

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


    public void tipos(TipoServicio tipo, String nombre, int duracion,
                          String lugar, String marca, String modelo, String color,
                          String patente, String rut, String email,
                          String puesto, String area, String servicio, String text, int numeroParadas, String tipoEmbarcacion)
    {


        switch (tipo) {
            case SERVICIO_TURISTICO ->
                    lista.agregar(new ServicioTuristico(nombre, duracion));
            case EXCURSION_CULTURAL ->
                    lista.agregar(new ExcursionCultural(nombre, duracion, lugar));
            case RUTA_GASTRONOMICA->
                    lista.agregar(new RutaGastronomica(nombre, duracion, numeroParadas));
            case PASEO_LACUSTRE ->
                    lista.agregar(new PaseoLacustre(nombre, duracion, tipoEmbarcacion));
            case ACTIVOS_VEHICULOS ->
                    lista.agregar(new ActivosVehiculos(marca, modelo, color, patente));
            case COLABORADORES_EXTERNOS ->
                    lista.agregar(new ColaboradoresExternos(nombre, rut, email, puesto, servicio ));
            case GUIAS_TURISTICOS ->
                    lista.agregar(new GuiasTuristicos(nombre, rut, email, puesto, area));
            case PERSONAL ->
                    lista.agregar(new Personal(nombre, rut, email, puesto));
        }

    }

    private static final String ARCHIVO_DATOS = "datos_llanquihue.csv";
    private static final String ENCABEZADO_CSV =
            "tipo;nombre;duracion;lugar;marca;embarcacion;modelo;color;patente;rut;email;puesto;area;servicio;numeroParadas";

    public void guardar() throws IOException {
        try{
            List<String> lineas = Files.readAllLines(Paths.get(ARCHIVO_DATOS));
        lineas.add(ENCABEZADO_CSV);
        for(Registrables r : lista.obtenerLista()){
            TipoServicio tipo = determinarTipo(r);
            if(tipo == null)continue;
            DatosPorAgregar datos = extraeDatos(r);
            lineas.add(PersistenciaCSV.unirCampos(
                    tipo.name(), datos.getNombre(), String.valueOf(datos.getDuracion()),
                    datos.getLugar(), datos.getMarca(), datos.getEmbarcacion(),
                    datos.getModelo(), datos.getColor(), datos.getPatente(),
                    datos.getRut(), datos.getEmail(), datos.getPuesto(),
                    datos.getArea(), datos.getServicio(), String.valueOf(datos.getNumeroParadas())
            ));
        }
        PersistenciaCSV.escribirLineas(ARCHIVO_DATOS, lineas);


        }catch(Exception e){
            System.out.println("Error al guardar lineas" +  e.getMessage());
        }
    }
    public void cargar(){
        cargar(ARCHIVO_DATOS);
    }

    public void cargar(String rutaArchivo) {
        try {
            for (String[] campos : PersistenciaCSV.leerFilas(rutaArchivo)) {
                if (campos.length < 15) continue; // fila corrupta, se ignora
                TipoServicio tipo = TipoServicio.valueOf(campos[0]);
                DatosPorAgregar datos = new DatosPorAgregar()
                        .setNombre(campos[1])
                        .setDuracion(parseEntero(campos[2]))
                        .setLugar(campos[3])
                        .setMarca(campos[4])
                        .setEmbarcacion(campos[5])
                        .setModelo(campos[6])
                        .setColor(campos[7])
                        .setPatente(campos[8])
                        .setRut(campos[9])
                        .setEmail(campos[10])
                        .setPuesto(campos[11])
                        .setArea(campos[12])
                        .setServicio(campos[13])
                        .setNumeroParadas(parseEntero(campos[14]));
                registrar(tipo, datos);
            }
        } catch (IOException e) {
            System.err.println("No se pudo cargar el archivo de datos: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("El archivo de datos tiene un tipo desconocido: " + e.getMessage());
        }
    }

    private int parseEntero(String texto) {
        try {
            return Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private TipoServicio determinarTipo(Registrables r) {
        if (r instanceof ActivosVehiculos) return TipoServicio.ACTIVOS_VEHICULOS;
        if (r instanceof RutaGastronomica) return TipoServicio.RUTA_GASTRONOMICA;
        if (r instanceof ExcursionCultural) return TipoServicio.EXCURSION_CULTURAL;
        if (r instanceof PaseoLacustre) return TipoServicio.PASEO_LACUSTRE;
        if (r instanceof ServicioTuristico) return TipoServicio.SERVICIO_TURISTICO;
        if (r instanceof ColaboradoresExternos) return TipoServicio.COLABORADORES_EXTERNOS;
        if (r instanceof GuiasTuristicos) return TipoServicio.GUIAS_TURISTICOS;
        if (r instanceof Personal) return TipoServicio.PERSONAL;
        return null;
    }



    private DatosPorAgregar extraeDatos(Registrables r) {
        DatosPorAgregar datos = new DatosPorAgregar();
        if (r instanceof ActivosVehiculos v) {
            datos.setMarca(v.getMarca()).setModelo(v.getModelo()).setColor(v.getColor()).setPatente(v.getPatente());
        } else if (r instanceof RutaGastronomica rg) {
            datos.setNombre(rg.getNombre()).setDuracion(rg.getDuracionHoras()).setNumeroParadas(rg.getNumeroDeParadas());
        } else if (r instanceof ExcursionCultural ex) {
            datos.setNombre(ex.getNombre()).setDuracion(ex.getDuracionHoras()).setLugar(ex.getLugarHistorico());
        } else if (r instanceof PaseoLacustre p) {
            datos.setNombre(p.getNombre()).setDuracion(p.getDuracionHoras()).setEmbarcacion(p.getTipoDeEmbarcacion());
        } else if (r instanceof ServicioTuristico s) {
            datos.setNombre(s.getNombre()).setDuracion(s.getDuracionHoras());
        } else if (r instanceof ColaboradoresExternos c) {
            datos.setNombre(c.getNombreCompleto()).setRut(c.getRut()).setEmail(c.getEmail()).setPuesto(c.getPuesto()).setServicio(c.getServicio());
        } else if (r instanceof GuiasTuristicos g) {
            datos.setNombre(g.getNombreCompleto()).setRut(g.getRut()).setEmail(g.getEmail()).setPuesto(g.getPuesto()).setArea(g.getEspecialidad());
        } else if (r instanceof Personal per) {
            datos.setNombre(per.getNombreCompleto()).setRut(per.getRut()).setEmail(per.getEmail()).setPuesto(per.getPuesto());
        }
        return datos;
    }


    public void mostrarTodo() {
        for (Registrables r : lista.obtenerLista()) {
            System.out.println((lista.obtenerLista().indexOf(r)));
        }
    }


    public Registrables obtenerPorIndice(int indice) {
        if (indice < 0 || indice >= lista.obtenerLista().size()) {
            throw new IllegalArgumentException("Indice fuera de rango: " + indice);
        }
        return lista.obtenerLista().get(indice);
    }


    public void registrar(TipoServicio tipo, DatosPorAgregar datos) {

    }
}
