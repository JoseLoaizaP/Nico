package structures;

import exceptions.CultivoLlenoException;
import model.Cultivo;

import java.util.Comparator;

public class SimpleLinkedListCultivos {
    private NodeCultivo first;
    private int size;
    private final int MAX_CULTIVOS = 25;

    public void add(String id, Cultivo cultivo ) throws CultivoLlenoException {
        NodeCultivo node = new NodeCultivo(id, 0, cultivo);

        if(this.size > MAX_CULTIVOS){
            throw new CultivoLlenoException ("cantidad maxima de cultivos alcanzada" + MAX_CULTIVOS);
        }

        if (first != null && !first.getValueCultivo().getName().equals(cultivo.getName())) {
            System.out.println("Se agrego el cultivo a la siguiente casilla");
            if (this.size <= MAX_CULTIVOS){
                // Caso Base -> La lista esta vacia
                if(first == null){
                    first = node;
                    this.size++;
                }

                // Caso Base -> La lista no esta vacia
                else {
                    if(first.getNext() == null && first.getValueCultivo() == cultivo){
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

        if (this.size <= MAX_CULTIVOS){
            // Caso Base -> La lista esta vacia
            if(first == null){
                first = node;
                this.size++;
            }

            // Caso Base -> La lista no esta vacia
            else {
                if(first.getNext() == null && first.getValueCultivo() == cultivo){
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

    public String listarCultivos() {
        if (first == null) {
            return "el cultivo está vacío.";
        }

        StringBuilder sb = new StringBuilder();
        NodeCultivo current = first;

        while (current != null) {
            sb.append(current.getIdx() + " " + current.getValueCultivo().getName());
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }

        return sb.toString();
    }

    public void sort(Comparator<Cultivo> comparator) {
        if (first == null || first.getNext() == null) {
            return; // No es necesario ordenar si la lista está vacía o tiene un solo elemento
        }

        boolean swapped;
        do {
            swapped = false;
            NodeCultivo current = first;

            while (current != null && current.getNext() != null) {
                if (comparator.compare(current.getValueCultivo(), current.getNext().getValueCultivo()) > 0) {
                    // Intercambiar los datos entre los nodos
                    Cultivo temp = current.getValueCultivo();
                    current.setValueCultivo(current.getNext().getValueCultivo()); // Asignar el valor del siguiente nodo al nodo actual
                    current.getNext().setValueCultivo(temp);

                    swapped = true;
                }
                current = current.getNext();
            }
        } while (swapped);
    }
}
