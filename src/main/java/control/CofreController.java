package control;

import model.Cofre;
import model.Cultivo;
import model.comparators.CofIdComparator;
import structures.SimpleLinkedListCofre;
import model.comparators.CofIdComparator;

import java.util.Comparator;


public class CofreController {
    private SimpleLinkedListCofre cofres;
    private Cofre cofre;
    private CofIdComparator comparator;

    public CofreController() {
        cofres = new SimpleLinkedListCofre();
        comparator = new CofIdComparator();
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
}
