package Control;


import exceptions.ParcelaLlenaException;
import exceptions.PlantacionLlenaException;
import model.Cofre;
import model.Plantacion;
import structures.SimpleLinkedListPlantación;


public class CultivoController {
    private SimpleLinkedListPlantación plantaciones;
    private Plantacion plantacion;

    public CultivoController(){
         plantaciones = new SimpleLinkedListPlantación();
    }

    public void addPlantacion(String plantacionId){
        Plantacion plantacion = new Plantacion(plantacionId);
        try{
            plantaciones.add(plantacionId, plantacion);
        } catch (PlantacionLlenaException e){
            System.out.println("Error al agregar cultivo, la plantación esta llena: " + e.getMessage());
        }
    }

    public void addCultivoInPlantacion(String nombre, int diasCrecimiento, String estacion,String identificador){
        plantacion.addCultivoInPlantacion(nombre, diasCrecimiento, estacion, identificador);
    }

}
