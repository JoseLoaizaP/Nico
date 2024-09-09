package structures;

import exceptions.CofreLlenoException;
import model.Cultivo;

public class SimpleLinkedListCasillas {
    private NodeCasilla first;
    private int size;
    private static final int MAX_CASILLAS = 50;

    public SimpleLinkedListCasillas() {
        this.first = null;
        this.size = 0;
    }

    public void add(String id,  Cultivo cultivo) throws CofreLlenoException {

        if (size >= MAX_CASILLAS) {
            throw new CofreLlenoException("El cofre ya contiene " + MAX_CASILLAS + " casillas.");
        }

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
