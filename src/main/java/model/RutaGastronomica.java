package model;

import service.InfoMostrable;
import service.Registrables;

/**
 * Clase que hereda atributos de ServicioTuristico
 * agrega numeroDeParadas como atributo propio.
 */

public class RutaGastronomica extends ServicioTuristico implements InfoMostrable, Registrables {

    private final int numeroDeParadas;

    public RutaGastronomica(String nombre, int duracionHoras, int numeroDeParadas) {
        super(nombre,duracionHoras);
      this.numeroDeParadas= numeroDeParadas;

    }

    public int getNumeroDeParadas() {
        return numeroDeParadas;
    }

    @Override
    public void registrar() {
        System.out.println("registrando ruta gastronómica");;
    }

    @Override
    public String mostrarInformacion() {
        return ("\uD83C\uDF74 Ruta Gastronómica --> " + " Nombre del Restaurante: " + nombre + " | Numero De Paradas: " + numeroDeParadas +  " | duración de la actividad: " + duracionHoras + "  horas.");


    }

}
