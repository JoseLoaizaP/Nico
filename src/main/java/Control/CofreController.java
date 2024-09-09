package Control;

import model.Cofre;
import structures.SimpleLinkedListCofre;

public class CofreController {
    private SimpleLinkedListCofre cofres;

    public CofreController(){
        cofres = new SimpleLinkedListCofre();
    }

    public void addCofre(String cofreId){
        Cofre cofre = new Cofre(cofreId);
        cofres.add(cofreId, cofre);
    }
}
