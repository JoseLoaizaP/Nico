package model;

public class CultivoPrimavera extends Cultivo {
    public CultivoPrimavera(String nombre, int diasCrecimiento) {
        super(nombre, diasCrecimiento);
    }

    @Override
    public String getEstacion() {
        return "Primavera";
    }

    @Override
    public String toString() {
        return "Cultivo de primavera " +
                "diasCrecimiento:" + diasCrecimiento +
                ", nombre:" + nombre ;
    }
}
