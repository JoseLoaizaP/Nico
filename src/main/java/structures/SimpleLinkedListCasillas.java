package structures;

import exceptions.CasillaLlenaException;
import model.Cultivo;

import java.util.Comparator;

public class SimpleLinkedListCasillas {
    private NodeCasilla first;
    private int size;
    private static final int MAX_CASILLAS = 25;

    public SimpleLinkedListCasillas() {
        this.first = null;
        this.size = 0;
    }

    public void add(Cultivo cultivo) throws CasillaLlenaException {
        NodeCasilla node = new NodeCasilla(0, cultivo);

        if (size >= MAX_CASILLAS) {
            throw new CasillaLlenaException("Capacidad máxima de casillas alcanzada " + MAX_CASILLAS + " casillas.");
        }

        if (first != null && !first.getCultivo().getClass().equals(cultivo.getClass())) {
            System.out.println("Se agrego el cultivo a la siguiente casilla");
        }

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
            sb.append(current.getIdx()+1+ " " + current.getCultivo());
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
            NodeCasilla current = first;

            while (current != null && current.getNext() != null) {
                if (comparator.compare(current.getCultivo(), current.getNext().getCultivo()) > 0) {
                    // Intercambiar los datos entre los nodos
                    Cultivo temp = current.getCultivo();
                    current.setCultivo(current.getNext().getCultivo()); // Asignar el valor del siguiente nodo al nodo actual
                    current.getNext().setCultivo(temp);

                    swapped = true;
                }
                current = current.getNext();
            }
        } while (swapped);
    }

}
