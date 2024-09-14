package model;

import java.util.List;

public class CultivoMultiEstacional extends Cultivo {
    private List<String> estaciones;

    public CultivoMultiEstacional(String nombre, int diasCrecimiento, List<String> estaciones) {
        super(nombre, diasCrecimiento);
        this.estaciones = estaciones;
    }

    @Override
    public String getEstacion() {
        return String.join(", ", estaciones); // Ejemplo: "Primavera, Verano"
    }

    public List<String> getEstaciones() {
        return estaciones;
    }

    @Override
    public String toString() {
        return "Cultivo multiestacional" +
                "estaciones:" + estaciones +
                ", nombre: " + nombre +
                ", diasCrecimiento: " + diasCrecimiento ;
    }
}

