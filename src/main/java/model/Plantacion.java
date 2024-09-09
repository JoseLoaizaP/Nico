package model;

import structures.SimpleLinkedListParcela;

public class Plantacion {
    private SimpleLinkedListParcela parcela;
    private String plantacionId;
    public Plantacion(String plantacionId){
        parcela = new SimpleLinkedListParcela();
        this.plantacionId = plantacionId;
    }

    public void addCultivoInCofre(String nombre, int diasCrecimiento, String estacion,String identificador){

        if(estacion.equals("Primavera")){
            CultivoPrimavera cultivo = new CultivoPrimavera(nombre, diasCrecimiento);

        } else if (estacion.equals("Verano")) {
            CultivoVerano cultivo = new CultivoVerano(nombre, diasCrecimiento);
            parcela.add(identificador, cultivo);
        }else if (estacion.equals("Otoño")) {
            CultivoOtoño cultivo = new CultivoOtoño(nombre, diasCrecimiento);
            parcela.add(identificador, cultivo);
        }else if (estacion.equals("Invierno")) {
            CultivoInvierno cultivo = new CultivoInvierno(nombre, diasCrecimiento);
            parcela.add(identificador, cultivo);
        }

    }

    public String getPlantacionId() {
        return plantacionId;
    }

    public void setPlantacionId(String plantacionId) {
        this.plantacionId = plantacionId;
    }
}
