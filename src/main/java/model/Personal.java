package model;

import service.InfoMostrable;
import service.Registrable;

public  class Personal implements Registrable, InfoMostrable {

    private final String nombreCompleto;
    private final String rut;
    private final String email;
    private final String puesto;

    public Personal(String nombreCompleto, String rut, String email,  String puesto) {
        this.nombreCompleto = nombreCompleto;
        this.rut = rut;
        this.email = email;
        this.puesto = puesto;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getRut() {
        return rut;
    }

    public String getEmail() {
        return email;
    }

    public void registrar(Personal personal) {
    }


    @Override
    public String registrar() {
        return "";
    }

    public String mostrarInformacion() {
        return "\uD83D\uDC69\uD83C\uDFFC\u200D\uD83D\uDCBC nombre completo: " + nombreCompleto + " | rut: " + rut + " | correo electronico: " + email + " | puesto de trabajo " + puesto;
    }

}
