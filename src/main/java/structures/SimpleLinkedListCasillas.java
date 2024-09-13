package structures;

import exceptions.CasillaLlenaException;
import exceptions.CofreLlenoException;
import model.Cultivo;

public class SimpleLinkedListCasillas {
    private NodeCasilla first;
    private int size;
    private static final int MAX_CASILLAS = 25;

    public SimpleLinkedListCasillas() {
        this.first = null;
        this.size = 0;
    }

    public void add(String id,  Cultivo cultivo) throws CasillaLlenaException {

        if (size >= MAX_CASILLAS) {
            throw new CasillaLlenaException("Capacidad máxima de casillas alcanzada " + MAX_CASILLAS + " casillas.");
        }

        NodeCasilla node = new NodeCasilla(id, 0, cultivo);

        // Caso Base -> La lista esta vacia
        if(first == null){
            first = node;
            this.size++;
        }

        // Caso Base -> La lista no esta vacia
        else {
            if(first.getNext() == null){
                first.setNext(node);
                first.getNext().setIdx(1);
                this.size++;
            }
            // Caso Iterativo
            else {
                NodeCasilla current = first.getNext();
                while (current.getNext() != null){
                    current = current.getNext();
                }
                current.setNext(node);
                this.size++;
                current.getNext().setIdx(size - 1);
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

    public String listarCasillas() {
        if (first == null) {
            return "Las casillas están vacía.";
        }

        StringBuilder sb = new StringBuilder();
        NodeCasilla current = first;

        while (current != null) {
            sb.append(current.getIdx()+ " " + current.getCultivo());
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }

        return sb.toString();
    }

}
