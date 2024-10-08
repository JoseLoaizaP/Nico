package structures;

import exceptions.ParcelaLlenaException;
import model.Cultivo;

public class SimpleLinkedListParcela {
    private NodeCultivo first;
    private int size;
    private static final int MAX_CULTIVOS = 25;


    public SimpleLinkedListParcela() {
        this.first = null;
        this.size = 0;
    }

    public void add(String id,  Cultivo cultivo) throws ParcelaLlenaException {

        if (size >= MAX_CULTIVOS) {
            throw new ParcelaLlenaException("La casilla ya está llena y no puede almacenar más de " + MAX_CULTIVOS + " cultivos.");
        }

        NodeCultivo node = new NodeCultivo(id, cultivo);


        if(first == null){
            first = node;
        }

        // Caso Base -> La lista no esta vacia
        else {
            if (first.getNext() == null) {
                first.setNext(node);
            }
            // Caso Iterativo
            else {
                NodeCultivo current = first.getNext();
                while (current.getNext() != null) {
                    current = current.getNext();
                }
                current.setNext(node);
            }
        }
        size++;
    }
    // buscar por nombre de persona | value = name
    public NodeCultivo search(String value){
        NodeCultivo found = null;

        // Caso Base
        if(first.getValueCultivo().getName().equals(value)){
            found = first;
        }

        // Caso Iterativo
        else {
            NodeCultivo current = first;
            boolean isFound = false;

            while (current.getNext() != null && !isFound) {
                if (current.getValueCultivo().getName().equals(value)) {
                    found = current;
                    isFound = true;
                }
                current = current.getNext();
            }
        }
        return found;
    }

    public NodeCultivo getFirst() {
        return first;
    }

}
