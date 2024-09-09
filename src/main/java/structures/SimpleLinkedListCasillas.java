package structures;

import model.Casilla;
import model.Cultivo;


public class SimpleLinkedListCasillas {
    private NodeCasilla first;

    public void add(String id,  Cultivo cultivo) {
        NodeCasilla node = new NodeCasilla(id, cultivo);

        // Caso Base -> La lista esta vacia
        if(first == null){
            first = node;
        }

        // Caso Base -> La lista no esta vacia
        else {
            if(first.getNext() == null){
                first.setNext(node);
            }
            // Caso Iterativo
            else {
                NodeCasilla current = first.getNext();
                while (current.getNext() != null){
                    current = current.getNext();
                }
                current.setNext(node);
            }
        }
    }

    public NodeCasilla search(String value){
        NodeCasilla found = null;

        // Caso Base
        if(first.getCultivo().equals(value)){
            found = first;
        }

        // Caso Iterativo
        else {
            NodeCasilla current = first;
            boolean isFound = false;

            while (current.getNext() != null && !isFound) {
                if (current.getCultivo().equals(value)) {
                    found = current;
                    isFound = true;
                }
                current = current.getNext();
            }
        }
        return found;
    }
}
