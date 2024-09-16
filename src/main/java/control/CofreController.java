package control;

import model.Cofre;
import model.Cultivo;
import model.comparators.CofIdComparator;
import structures.SimpleLinkedListCofre;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;


public class CofreController {
    private SimpleLinkedListCofre cofres;
    private Cofre cofre;
    private CofIdComparator comparator;
    private File data;
    private File listJsonCofres;


    public CofreController() {
        cofres = new SimpleLinkedListCofre();
        comparator = new CofIdComparator();

        File projectDir = new File("C:\\Users\\josed\\Downloads\\APO\\Integradora_AMano");
        this.data = new File(projectDir+"\\src\\main\\data");
        this.listJsonCofres = new File(data.getAbsoluteFile()+"\\cofres.json");
    }

    public void createResources() throws IOException {
        if (!data.exists()){
            data.mkdir();
            if(!listJsonCofres.exists()){
                listJsonCofres.createNewFile();
            }
        }
    }

    public void addCofre(String cofreId) {
        Cofre cofre = new Cofre(cofreId);
        cofres.add(cofreId, cofre);
    }

    public void addCultivotoCofre(Cultivo cultivo, String identificador) {
        cofre.addCultivoInCofre(identificador, cultivo);
    }

    public SimpleLinkedListCofre getCofres() {
        return cofres;
    }

    public String listarCofres() {
        return getCofres().listarCofres();
    }

    public Cofre buscarCofre(int idx) {
        return cofres.search(idx).getCofre();
    }

    public void ordenarCofre(SimpleLinkedListCofre cofresDesordenados){
      cofres.sort(comparator, cofresDesordenados);
    }

    public void saveCofres(){
        // objeto que nos ayuda con la serealizacion
        Gson gson = new Gson();


        String dataJson = gson.toJson(cofres);
        System.out.println(dataJson);

        try {
            // inicializar los recursos
            createResources();

            // Enlazar la información con el archivo
            FileOutputStream fos = new FileOutputStream(this.listJsonCofres);

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

    public void loadCofres() {
        Gson gson = new Gson();
        try {
            FileInputStream fis = new FileInputStream(this.listJsonCofres);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

            StringBuilder data = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                data.append(line);
            }

            reader.close();

            // Definir el tipo de la lista de cofres
            Type listType = new TypeToken<SimpleLinkedListCofre>() {}.getType();

            // Deserializar el JSON a la lista de cofres
            cofres = gson.fromJson(data.toString(), listType);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
