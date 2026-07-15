package model;

import service.InfoMostrable;
import service.Registrable;

/**
 * Clase que hereda atributos de ServicioTuristico
 * agrega numeroDeParadas como atributo propio.
 */

public class RutaGastronomica extends ServicioTuristico implements InfoMostrable, Registrable {

    private final int numeroDeParadas;

    public RutaGastronomica(String nombre, int duracionHoras, int numeroDeParadas) {
        super(nombre,duracionHoras);
      this.numeroDeParadas= numeroDeParadas;

    }

    @Override
    public void registrar() {
        System.out.println("registrando ruta gastronómica");;
    }

    @Override
    public String mostrarInformacion() {
        return ("\uD83C\uDF74 Ruta Gastronómica --> " + " nombre de la actividad: " + nombre + " | Numero De Paradas: " + numeroDeParadas +  " | duración de la actividad: " + duracionHoras + "  horas.");


    }

}
