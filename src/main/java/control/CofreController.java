package control;

import model.Cofre;
import model.Cultivo;
import structures.SimpleLinkedListCofre;
import structures.SimpleLinkedListPlantación;


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

    public void addCultivotoCofre(Cultivo cultivo, String identificador){
        cofre.addCultivoInCofre(identificador, cultivo);
    }

    public SimpleLinkedListCofre getCofres() {
        return cofres;
    }

    public String listarCofres(){
        return getCofres().listarCofres();
    }


}
