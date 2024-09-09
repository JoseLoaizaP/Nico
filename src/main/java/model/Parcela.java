package model;

import structures.SimpleLinkedListParcela;

public class Parcela {
    private int numParcela;
    private SimpleLinkedListParcela cultivos;

    public Parcela(int numParcela){
        this.numParcela = numParcela;

        cultivos = new SimpleLinkedListParcela();
    }

    public void addCultivoToParcela(String nombre, int diasCrecimiento, String estacion){
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

    public int getNumParcela() {
        return numParcela;
    }

    public void setNumParcela(int numParcela) {
        this.numParcela = numParcela;
    }
}
