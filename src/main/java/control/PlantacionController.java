package control;


import exceptions.PlantacionLlenaException;
import model.Cultivo;
import model.Plantacion;
import structures.SimpleLinkedListPlantación;
import model.comparators.PlantacionIdComparator;


public class PlantacionController extends Throwable {
    private SimpleLinkedListPlantación plantaciones;
    private Plantacion plantacion;
    private PlantacionIdComparator comparator;



    public PlantacionController(){
         plantaciones = new SimpleLinkedListPlantación();
         comparator = new PlantacionIdComparator();
    }


    public void addPlantacion(String plantacionId){
        Plantacion plantacion = new Plantacion(plantacionId);
        plantaciones.add(plantacionId, plantacion);
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

    public void ordenarPlantaciones(SimpleLinkedListPlantación plantacionesDesordenadas){
        plantaciones.sort(comparator, plantacionesDesordenadas);
    }


}
