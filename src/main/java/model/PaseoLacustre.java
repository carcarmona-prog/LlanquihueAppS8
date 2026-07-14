package model;

import service.InfoMostrable;
import service.Registrable;

/**
 * Clase que hereda atributos de ServicioTuristico.
 * agrega tipoDeEmbarcacion como atributo propio.
 */

public class PaseoLacustre extends ServicioTuristico implements InfoMostrable, Registrable {

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





    public String mostrarInformacion() {
     return "\uD83C\uDF0A Paseo Lacustre --> " + " Tipo De Embarcación: " + tipoDeEmbarcacion +  " | " + " nombre de la actividad: " + nombre + " | duración de la actividad: " +  duracionHoras + "  horas.";
    }


}
