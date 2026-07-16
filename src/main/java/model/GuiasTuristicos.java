package model;

import service.InfoMostrable;
import service.Registrable;

public  class GuiasTuristicos extends Personal implements Registrable, InfoMostrable {

    private final String especialidad;

    public GuiasTuristicos(String nombreCompleto, String rut, String email,String puesto, String especialidad) {
        super(nombreCompleto, rut, email, puesto);
        this.especialidad = especialidad;
    }



    @Override
    public String mostrarInformacion() {
        return (" \uD83C\uDFDE\uFE0F Nombre del guia turístico: " + getNombreCompleto() + "| rut: " + getRut() + "| correo electrónico: " + getEmail() + " | puesto: " + getPuesto() + "| especialidad: " + especialidad);

    }


}
