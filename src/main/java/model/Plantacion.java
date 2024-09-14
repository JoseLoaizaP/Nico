package model;


import control.PlantacionController;
import exceptions.CasillaLlenaException;
import exceptions.CultivoLlenoException;
import structures.SimpleLinkedListCultivos;
import structures.SimpleLinkedListPlantación;

public class Plantacion {
    private SimpleLinkedListCultivos cultivos;
    private String plantacionId;
    public Plantacion(String plantacionId){
        cultivos = new SimpleLinkedListCultivos();
        this.plantacionId = plantacionId;
    }


    public void addCultivoInPlantacion(String cultivoId, Cultivo cultivo){

        try{
            cultivos.add(cultivoId, cultivo);
        }
        catch (CultivoLlenoException e){
            System.out.println("Error al agregar cultivo: " + e.getMessage());
        }

    }

    public String getPlantacionId() {
        return plantacionId;
    }

    public void setPlantacionId(String plantacionId) {
        this.plantacionId = plantacionId;
    }

    public SimpleLinkedListCultivos getCultivos() {
        return cultivos;
    }

    public void setCultivos(SimpleLinkedListCultivos cultivos) {
        this.cultivos = cultivos;
    }
}
