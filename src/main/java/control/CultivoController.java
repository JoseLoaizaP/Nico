package control;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.*;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class CultivoController {

    private CultivoPrimavera Ajo;
    private CultivoPrimavera Allium_Azul;
    private CultivoPrimavera Arroz;
    private CultivoPrimavera Chirivia;
    private CultivoVerano Amapola;
    private CultivoVerano Arandano;
    private CultivoVerano Carambola;
    private CultivoVerano Chile;
    private CultivoOtoño Alcachofa;
    private CultivoOtoño Amaranto;
    private CultivoOtoño Baya_Gema_dulce;
    private CultivoOtoño Berenjena;
    private CultivoInvierno Melon;
    private CultivoMultiEstacional Fruta_Milenaria;

    private ArrayList<Cultivo> listaCultivos;
    private File data;
    private File listJsonCultivos;

    public CultivoController(){
        listaCultivos = new ArrayList<>();

        File projectDir = new File("C:\\Users\\josed\\Downloads\\APO\\Integradora_AMano");
        this.data = new File(projectDir+"\\src\\main\\data");
        this.listJsonCultivos = new File(data.getAbsoluteFile()+"\\cultivos.json");
    }

    public void createResources() throws IOException {
        if (!data.exists()){
            data.mkdir();
            if(!listJsonCultivos.exists()){
                listJsonCultivos.createNewFile();
            }
        }
    }

    // Asignar los cultivos a las variables de instancia
    public void cultivosIniciales() {
        Ajo = new CultivoPrimavera("Ajo", 28);
        Allium_Azul = new CultivoPrimavera("Allium azul", 28);
        Arroz = new CultivoPrimavera("Arroz sin moler", 28);
        Chirivia = new CultivoPrimavera("Chirivia", 28);
        Amapola = new CultivoVerano("Amapola", 27);
        Arandano = new CultivoVerano("Arándano", 27);
        Carambola = new CultivoVerano("Carambola", 27);
        Chile = new CultivoVerano("Chile", 27);
        Alcachofa = new CultivoOtoño("Alcachofa", 29);
        Amaranto = new CultivoOtoño("Amaranto", 29);
        Baya_Gema_dulce = new CultivoOtoño("Baya gema dulce", 29);
        Berenjena = new CultivoOtoño("Berenjena", 29);
        Melon = new CultivoInvierno("Melón de polvo", 30);

        List<String> estaciones = Arrays.asList("Primavera", "Verano");
        Fruta_Milenaria = new CultivoMultiEstacional("Fruta milenaria", 25, estaciones);
    }

    // Método para listar los cultivos
    public void listarCultivos() {
        if (Ajo == null) {
            System.out.println("Los cultivos no han sido inicializados.");
            return;
        }

        System.out.println(Ajo);
        System.out.println(Allium_Azul);
        System.out.println(Arroz);
        System.out.println(Chirivia);
        System.out.println(Amapola);
        System.out.println(Arandano);
        System.out.println(Carambola);
        System.out.println(Chile);
        System.out.println(Alcachofa);
        System.out.println(Amaranto);
        System.out.println(Baya_Gema_dulce);
        System.out.println(Berenjena);
        System.out.println(Melon);
        System.out.println(Fruta_Milenaria);
    }

    // Método para agregar todos los cultivos al ArrayList
    public ArrayList<Cultivo> agregarCultivosALista() {
        listaCultivos = new ArrayList<>();

        // Agregamos todos los cultivos a la lista
        listaCultivos.add(Ajo);
        listaCultivos.add(Allium_Azul);
        listaCultivos.add(Arroz);
        listaCultivos.add(Chirivia);
        listaCultivos.add(Amapola);
        listaCultivos.add(Arandano);
        listaCultivos.add(Carambola);
        listaCultivos.add(Chile);
        listaCultivos.add(Alcachofa);
        listaCultivos.add(Amaranto);
        listaCultivos.add(Baya_Gema_dulce);
        listaCultivos.add(Berenjena);
        listaCultivos.add(Melon);
        listaCultivos.add(Fruta_Milenaria);

        return listaCultivos;
    }

    // Método para obtener la lista de cultivos
    public ArrayList<Cultivo> getListaCultivos() {
        return listaCultivos;
    }

    public Cultivo buscarCultivoPorPosicion(int posicion) {
        // Verificamos si la posición es válida
        if (posicion + 1 >= 0 && posicion-1 < listaCultivos.size()) {
            return listaCultivos.get(posicion-1);
        } else {
            System.out.println("Posición no válida.");
            return null;  // Devolvemos null si la posición no es válida
        }
    }


    public String listarCultivosArray(ArrayList<Cultivo> listaCultivos){


        if (listaCultivos.isEmpty()) {

            return "Los cultivos no han sido inicializados.";
        }
        String str= "";
        int n = listaCultivos.size();
        for (int i = 0; i < listaCultivos.size(); i++) {
           str += i+1 + " " + listaCultivos.get(i).getName() + "\n";
        }
        return str;
    }

    public void saveCultivos(){
        // objeto que nos ayuda con la serealizacion
        Gson gson = new Gson();

        // formateamos la informacion (de un arraylist a un formato Json)
        String dataJson = gson.toJson(listaCultivos);
        System.out.println(dataJson);

        try {
            // inicializar los recursos
            createResources();

            // Enlazar la información con el archivo
            FileOutputStream fos = new FileOutputStream(this.listJsonCultivos);

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
    public void loadCultivos() {
        Gson gson = new Gson();
        try {
            FileInputStream fis = new FileInputStream(this.listJsonCultivos);

            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

            String line = "";
            String data = "";

            while ((line = reader.readLine()) != null) {
                data += line;
            }

            reader.close();

            Type listType = new TypeToken<ArrayList<Cultivo>>() {
            }.getType();

            listaCultivos = gson.fromJson(data, listType);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


