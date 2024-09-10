package Control;

import model.Cofre;
import structures.SimpleLinkedListCofre;

public class CofreController {
    private SimpleLinkedListCofre cofres;
    private Cofre cofre;

    public CofreController(){
        cofres = new SimpleLinkedListCofre();
    }

    public void addCofre(String cofreId){
        Cofre cofre = new Cofre(cofreId);
        cofres.add(cofreId, cofre);
    }

    public void addCultivotoCofre(String nombre, int diasCrecimiento, String estacion,String identificador){
        cofre.addCultivoInCofre(nombre, diasCrecimiento, estacion, identificador);
    }


}
