package model;

import exceptions.CasillaLlenaException;
import exceptions.ParcelaLlenaException;
import structures.SimpleLinkedListParcela;

public class Plantacion {
    private SimpleLinkedListParcela parcela;
    private String plantacionId;
    public Plantacion(String plantacionId){
        parcela = new SimpleLinkedListParcela();
        this.plantacionId = plantacionId;
    }


    public void addCultivoInPlantacion(String nombre, int diasCrecimiento, String estacion,String identificador){

        if(estacion.equals("Primavera")){
            CultivoPrimavera cultivo = new CultivoPrimavera(nombre, diasCrecimiento);
            try{
                parcela.add(identificador, cultivo);
            }catch(ParcelaLlenaException e){
                System.out.println("Error al agregar cultivo: " + e.getMessage());

            }

        } else if (estacion.equals("Verano")) {
            CultivoVerano cultivo = new CultivoVerano(nombre, diasCrecimiento);
            try{
                parcela.add(identificador, cultivo);
            }catch(ParcelaLlenaException e){
                System.out.println("Error al agregar cultivo: " + e.getMessage());

            }
        }else if (estacion.equals("Otoño")) {
            CultivoOtoño cultivo = new CultivoOtoño(nombre, diasCrecimiento);
            try{
                parcela.add(identificador, cultivo);
            }catch(ParcelaLlenaException e){
                System.out.println("Error al agregar cultivo: " + e.getMessage());

            }
        }else if (estacion.equals("Invierno")) {
            CultivoInvierno cultivo = new CultivoInvierno(nombre, diasCrecimiento);
            try{
                parcela.add(identificador, cultivo);
            }catch(ParcelaLlenaException e){
                System.out.println("Error al agregar cultivo: " + e.getMessage());

            }
        }

    }

    public String getPlantacionId() {
        return plantacionId;
    }

    public void setPlantacionId(String plantacionId) {
        this.plantacionId = plantacionId;
    }
}
