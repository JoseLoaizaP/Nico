package model;


import structures.SimpleLinkedListCultivos;
import structures.SimpleLinkedListPlantación;

public class Plantacion {
    private SimpleLinkedListCultivos cultivos;
    private String plantacionId;
    public Plantacion(String plantacionId){
        cultivos = new SimpleLinkedListCultivos();
        this.plantacionId = plantacionId;
    }


    public void addCultivoToPlantacion(String nombre, int diasCrecimiento, String estacion){
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

    public String getPlantacionId() {
        return plantacionId;
    }

    public void setPlantacionId(String plantacionId) {
        this.plantacionId = plantacionId;
    }
}
