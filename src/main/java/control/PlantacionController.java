package control;


import exceptions.PlantacionLlenaException;
import model.Cofre;
import model.Cultivo;
import model.Plantacion;
import structures.SimpleLinkedListPlantación;


public class PlantacionController extends Throwable {
    private SimpleLinkedListPlantación plantaciones;
    private Plantacion plantacion;



    public PlantacionController(){
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

    public void addCultivoInPlantacion(Cultivo cultivo, String identificador){
        plantacion.addCultivoInPlantacion(identificador, cultivo);
    }

    public SimpleLinkedListPlantación getPlantaciones() {
        return plantaciones;
    }

    public String listarPlantaciones(){
        return getPlantaciones().listarPlantacion();
    }

    public Plantacion buscarCultivo(int idx){
        return plantaciones.search(idx).getPlantacion();
    }




}
