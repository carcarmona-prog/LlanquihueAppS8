package model;

import service.InfoMostrable;
import service.Registrable;

public class ColaboradoresExternos extends Personal implements Registrable, InfoMostrable {

    private final String servicio;

    public ColaboradoresExternos(String nombreCompleto, String rut, String email, String puesto, String servicio) {
        super(nombreCompleto, rut, email, puesto);
        this.servicio = servicio;
    }

    public String getServicio() {
        return servicio;
    }



    @Override
    public String mostrarInformacion() {
        return "\uD83D\uDC77\uD83C\uDFFC Nombre del Colaborador Externo: " + getNombreCompleto() + " | rut: " + getRut() + " | email: " + getEmail() +  " | servicio: " + getServicio() ;
    }




}
