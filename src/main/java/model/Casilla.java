package model;

import structures.SimpleLinkedListParcela;


public class Casilla {
    private int numCasilla;
    private SimpleLinkedListParcela cultivos;
    private Cultivo cultivo;

    public Casilla(int numParcela, Cultivo cultivo){
        this.numCasilla = numParcela;
        this.cultivo = cultivo;

        cultivos = new SimpleLinkedListParcela();
    }

    public void addCultivoToCasilla(String nombre, int diasCrecimiento, String estacion){
        if(estacion.equals("Primavera")){
            CultivoPrimavera cultivo = new CultivoPrimavera(nombre, diasCrecimiento);
        } else if (estacion.equals("Verano")) {
            CultivoVerano cultivo = new CultivoVerano(nombre, diasCrecimiento);
        }else if (estacion.equals("Otoño")) {
            CultivoOtoño cultivo = new CultivoOtoño(nombre, diasCrecimiento);
        }else if (estacion.equals("Invierno")) {
            CultivoInvierno cultivo = new CultivoInvierno(nombre, diasCrecimiento);
        }
    }

    public int getNumCasilla() {
        return numCasilla;
    }

    public void setNumCasilla(int numParcela) {
        this.numCasilla = numParcela;
    }
}
