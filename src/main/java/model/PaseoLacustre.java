package model;

import service.InfoMostrable;
import service.Registrables;

/**
 * Clase que hereda atributos de ServicioTuristico.
 * agrega tipoDeEmbarcacion como atributo propio.
 */

public class PaseoLacustre extends ServicioTuristico implements InfoMostrable, Registrables {

    private String tipoDeEmbarcacion;

    public PaseoLacustre(String nombre, int duracionHoras, String tipoDeEmbarcacion) {
        super(nombre, duracionHoras);
        this.tipoDeEmbarcacion = tipoDeEmbarcacion;
    }

    public String getTipoDeEmbarcacion() {
        return tipoDeEmbarcacion;
    }

    public void setTipoDeEmbarcacion(String tipoDeEmbarcacion) {
        this.tipoDeEmbarcacion = tipoDeEmbarcacion;
    }

    @Override
    public void registrar() {
        System.out.println("nuevo paseo registrado");
    }

    @Override
    public String mostrarInformacion() {
        return ( "\uD83C\uDF0A Paseo Lacustre --> " + " | " + " nombre de la actividad: " + nombre + " | duración de la actividad: " +  duracionHoras + "  horas." + "  tipo de embarcación: " + tipoDeEmbarcacion );


    }


}
