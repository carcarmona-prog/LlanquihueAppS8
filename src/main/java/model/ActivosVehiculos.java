package model;

import service.InfoMostrable;
import service.Registrables;

public class ActivosVehiculos  implements Registrables, InfoMostrable {

    private final String marca;
    private final String modelo;
    private final String color;
    private final String patente;



    public ActivosVehiculos(String marca, String modelo, String color, String patente) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.patente = patente;



    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public String getPatente() {
        return patente;
    }


    @Override
    public void registrar() {
        System.out.println("registrando vehiculo");
    }

    @Override
    public String mostrarInformacion() {
        return ("\uD83D\uDE97 auto móvil disponible: " + " marca: "  + marca + " | modelo; " + modelo + " | color: " + color + " | patente: " + patente);


    }

}
