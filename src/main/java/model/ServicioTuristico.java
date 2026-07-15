package model;

import service.InfoMostrable;
import service.Registrable;

/**
 * Superclase que hereda atributos relacionales a las demás subclases.
 */

public  class ServicioTuristico implements InfoMostrable, Registrable {

    protected String nombre;
    protected int duracionHoras;

    public ServicioTuristico(String nombre, int duracionHoras) {
        this.nombre = nombre;
        this.duracionHoras = duracionHoras;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


   public void registrar() {
       System.out.println("Registrando servicio turístico");
    }

    @Override
    public String mostrarInformacion() {
        return ( "\uD83D\uDCCC Servicio Turístico --> " + " | nombre de la actividad: " + nombre +  " | duración de la actividad: " + duracionHoras + "  horas.") ;


    }


}


