package model;

import service.InfoMostrable;
import service.Registrables;

public class Personal implements Registrables, InfoMostrable {

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

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
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
