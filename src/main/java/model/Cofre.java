package model;

import exceptions.CasillaLlenaException;
import structures.SimpleLinkedListCasillas;

public class Cofre {
    private final int max_casillas = 50;
    private SimpleLinkedListCasillas casilla;
    private String cofreId;

    public Cofre(String cofreId){
        casilla = new SimpleLinkedListCasillas();
        this.cofreId = cofreId;
    }

    public void addCultivoInCofre(String nombre, int diasCrecimiento, String estacion,String identificador){

        if(estacion.equals("Primavera")){
            try {
                CultivoPrimavera cultivo = new CultivoPrimavera(nombre, diasCrecimiento);
                casilla.add(identificador, cultivo);
            }catch (CasillaLlenaException e){
                System.out.println("Error al agregar cultivo: " + e.getMessage());
            }

        } else if (estacion.equals("Verano")) {
            try {
                CultivoVerano cultivo = new CultivoVerano(nombre, diasCrecimiento);
                casilla.add(identificador, cultivo);
            }catch (CasillaLlenaException e){
                System.out.println("Error al agregar cultivo: " + e.getMessage());
            }
        }else if (estacion.equals("Otoño")) {
            try {
                CultivoVerano cultivo = new CultivoVerano(nombre, diasCrecimiento);
                casilla.add(identificador, cultivo);
            }catch (CasillaLlenaException e){
                System.out.println("Error al agregar cultivo: " + e.getMessage());
            }
        }else if (estacion.equals("Invierno")) {
            try {
                CultivoVerano cultivo = new CultivoVerano(nombre, diasCrecimiento);
                casilla.add(identificador, cultivo);
            }catch (CasillaLlenaException e){
                System.out.println("Error al agregar cultivo: " + e.getMessage());
            }
        }

    }

    public String getCofreId() {
        return cofreId;
    }
}
