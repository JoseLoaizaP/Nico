package control;

import model.Cofre;
import model.Cultivo;
import structures.SimpleLinkedListCofre;
import structures.SimpleLinkedListCultivos;
import structures.SimpleLinkedListPlantación;

import java.util.Comparator;


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

    public Cofre buscarCofre(int idx){
        return cofres.search(idx).getCofre();
    }

}
