package model;

import service.InfoMostrable;
import service.Registrables;

/**
 * Superclase que hereda atributos relacionales a las demás subclases.
 */

public  class ServicioTuristico implements InfoMostrable, Registrables {

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

    public int getDuracionHoras() {
        return duracionHoras;
    }
    public void setDuracionHoras(int duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    public void registrar() {
       System.out.println("Registrando servicio turístico");
    }

    @Override
    public String mostrarInformacion() {
        return ( "\uD83D\uDCCC Servicio Turístico --> " + " | nombre de la actividad: " + nombre +  " | duración de la actividad: " + duracionHoras + "  horas.") ;


    }


}


