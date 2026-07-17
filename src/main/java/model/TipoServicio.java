package model;

/**
 * Representa cada tipo de elemento que se puede registrar en el sistema
 */

public enum TipoServicio {

    SERVICIO_TURISTICO( "Servicio Turístico"),
    EXCURSION_CULTURAL("Excursión Cultural"),
    RUTA_GASTRONOMICA("Ruta Gastronómica"),
    PASEO_LACUSTRE("Paseo Lacustre"),
    ACTIVOS_VEHICULOS("Activos Vehículos"),
    COLABORADORES_EXTERNOS("Colaboradores Externos"),
    GUIAS_TURISTICOS("Guías Turísticos"),
    PERSONAL("Personal");

    private final String etiqueta;

    TipoServicio(String etiqueta) {
        this.etiqueta = etiqueta;
    }


    public String getEtiqueta() {
        return etiqueta;
    }


    /**
     * Se usa para que el JComboBox muestre la etiqueta legible
     * en vez del nombre técnico de la constante (ej. "Ruta Gastronómica"
     * en vez de "RUTA_GASTRONOMICA").
     */

    @Override
    public String toString() {
        return  etiqueta;
    }
}
