package model;

public class CultivoOtoño extends Cultivo{
    public CultivoOtoño(String nombre, int diasCrecimiento) {
        super(nombre, diasCrecimiento);
    }
    @Override
    public String getEstacion() {
        return "Otoño";
    }

    @Override
    public String toString() {
        return "Cultivo de otoño " +
                "diasCrecimiento:" + diasCrecimiento +
                ", nombre:" + nombre;
    }
}