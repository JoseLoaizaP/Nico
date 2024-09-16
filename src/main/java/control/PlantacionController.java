package control;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import exceptions.PlantacionLlenaException;
import model.Cultivo;
import model.Plantacion;
import structures.SimpleLinkedListCofre;
import structures.SimpleLinkedListPlantación;
import model.comparators.PlantacionIdComparator;

import java.io.*;
import java.lang.reflect.Type;


public class PlantacionController extends Throwable {
    private SimpleLinkedListPlantación plantaciones;
    private Plantacion plantacion;
    private PlantacionIdComparator comparator;
    private File data;
    private File listJsonPlantaciones;


    public PlantacionController(){
         plantaciones = new SimpleLinkedListPlantación();
         comparator = new PlantacionIdComparator();

        File projectDir = new File("C:\\Users\\josed\\Downloads\\APO\\Integradora_AMano");
        this.data = new File(projectDir+"\\src\\main\\data");
        this.listJsonPlantaciones = new File(data.getAbsoluteFile()+"\\plantaciones.json");
    }

    public void createResources() throws IOException {
        if (!data.exists()){
            data.mkdir();
            if(!listJsonPlantaciones.exists()){
                listJsonPlantaciones.createNewFile();
            }
        }
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

    public void savePlantaciones(){
        // objeto que nos ayuda con la serealizacion
        Gson gson = new Gson();


        String dataJson = gson.toJson(plantaciones);
        System.out.println(dataJson);

        try {
            // inicializar los recursos
            createResources();

            // Enlazar la información con el archivo
            FileOutputStream fos = new FileOutputStream(this.listJsonPlantaciones);

            // Escritor de la información
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));

            // Escribir la información
            writer.write(dataJson);

            // Borrar la información
            writer.flush();

            // cerrar el buffer
            writer.close();


        }
        catch (FileNotFoundException e) {}
        catch (IOException e){}
    }

    public void loadPlantaciones() {
        Gson gson = new Gson();
        try {
            FileInputStream fis = new FileInputStream(this.listJsonPlantaciones);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

            StringBuilder data = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                data.append(line);
            }

            reader.close();

            // Definir el tipo de la lista de cofres
            Type listType = new TypeToken<SimpleLinkedListPlantación>() {}.getType();

            // Deserializar el JSON a la lista de cofres
            plantaciones = gson.fromJson(data.toString(), listType);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
