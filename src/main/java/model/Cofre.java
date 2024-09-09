package model;

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
            CultivoPrimavera cultivo = new CultivoPrimavera(nombre, diasCrecimiento);

        } else if (estacion.equals("Verano")) {
            CultivoVerano cultivo = new CultivoVerano(nombre, diasCrecimiento);
            casilla.add(identificador, cultivo);
        }else if (estacion.equals("Otoño")) {
            CultivoOtoño cultivo = new CultivoOtoño(nombre, diasCrecimiento);
            casilla.add(identificador, cultivo);
        }else if (estacion.equals("Invierno")) {
            CultivoInvierno cultivo = new CultivoInvierno(nombre, diasCrecimiento);
            casilla.add(identificador, cultivo);
        }

    }

    public String getCofreId() {
        return cofreId;
    }
}
