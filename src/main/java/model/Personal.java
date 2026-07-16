package model;

import service.InfoMostrable;
import service.Registrable;

public class Personal implements Registrable, InfoMostrable {

    private String nombreCompleto;
    private  String rut;
    private  String email;
    private  String puesto;

    public Personal(String nombreCompleto, String rut, String email,  String puesto) {
        this.nombreCompleto = nombreCompleto;
        this.rut = rut;
        this.email = email;
        this.puesto = puesto;
    }

    public Personal() {

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
    public String getPuesto() {
        return puesto;
    }


    @Override
    public void registrar() {
        System.out.println("Registrando personal");
    }

    @Override
    public String mostrarInformacion() {
        return ( "\uD83D\uDC69\uD83C\uDFFC\u200D\uD83D\uDCBC Nombre completo: " + nombreCompleto + " | Rut: " + rut + " | Correo electrónico: " + email + " | Puesto de trabajo: " + puesto);


    }

}
