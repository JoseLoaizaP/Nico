package structures;

import exceptions.CultivoLlenoException;
import model.Cultivo;

public class SimpleLinkedListCultivos {
    private NodeCultivo first;
    private int size;
    private final int MAX_CULTIVOS = 25;

    public void add(String id, Cultivo cultivo ) throws CultivoLlenoException {
        NodeCultivo node = new NodeCultivo(id, 0, cultivo);

        if(this.size > MAX_CULTIVOS){
            throw new CultivoLlenoException ("cantidad maxima de cultivos alcanzada" + MAX_CULTIVOS);
        }

        if (this.size <= MAX_CULTIVOS){
            // Caso Base -> La lista esta vacia
            if(first == null){
                first = node;
                this.size++;
            }

            // Caso Base -> La lista no esta vacia
            else {
                if(first.getNext() == null){
                    first.setNext(node);
                    // se actualiza el indice y se aumenta el tamaño de la lista
                    first.getNext().setIdx(1);
                    this.size++;
                }
                // Caso Iterativo
                else {
                    // nodo actual
                    NodeCultivo current = first.getNext();
                    while (current.getNext() != null){
                        current = current.getNext();
                    }
                    current.setNext(node);
                    this.size++;
                    current.getNext().setIdx(size-1);
                }
            }
        }
    }

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
}
