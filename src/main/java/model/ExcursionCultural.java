package model;

import service.InfoMostrable;
import service.Registrable;

/**
 * Clase que hereda atributos de ServiciosTuristicos.
 * agregando lugarHistorico como atributo.
 */

public class ExcursionCultural extends ServicioTuristico implements Registrable, InfoMostrable {

    private String lugarHistorico;


    public ExcursionCultural(String nombre, int duracionHoras, String lugarHistorico) {
        super(nombre, duracionHoras);
        this.lugarHistorico = lugarHistorico;
    }

    public String getLugarHistorico() {
        return lugarHistorico;
    }

    public void setLugarHistorico(String lugarHistorico) {
        this.lugarHistorico = lugarHistorico;
    }

    @Override
    public String mostrarInformacion() {
        return "\uD83C\uDFDE Excursion Cultural --> " + "Lugar Histórico: " + lugarHistorico +  " | " + " | nombre de la actividad " + nombre +" | duración de la actividad : " + duracionHoras + "  horas.";
    }



}
