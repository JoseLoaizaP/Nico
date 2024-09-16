package structures;


import exceptions.PlantacionLlenaException;
import model.Cofre;
import model.Plantacion;

import java.util.Comparator;

public class SimpleLinkedListPlantación {
    private NodePlantacion first;
    private final int MAX_CULTIVO = 5;
    private int size;

    public SimpleLinkedListPlantación() {
        this.first = null;
    }

    public void add(String id,  Plantacion plantacion) {

        NodePlantacion node = new NodePlantacion(id, 0, plantacion);


        // Caso Base -> La lista esta vacia
        if (first == null) {
            first = node;
            this.size++;
        }

        // Caso Base -> La lista no esta vacia
        else {
            if (first.getNext() == null) {
                first.setNext(node);
                first.getNext().setIdx(1);
                this.size++;
            }
            // Caso Iterativo
            else {
                NodePlantacion current = first.getNext();
                while (current.getNext() != null) {
                    current = current.getNext();
                }
                current.setNext(node);
                this.size++;
                current.getNext().setIdx(size - 1);
            }
        }
    }



    public NodePlantacion search(int idx){
        NodePlantacion found = null;

        // Caso Base
        if(first.getIdx() == idx){
            found = first;
        }

        // Caso Iterativo
        else {
            NodePlantacion current = first;
            boolean isFound = false;

            while (current.getNext() != null && !isFound) {
                if (current.getIdx() == idx) {
                    found = current;
                    isFound = true;
                }
                current = current.getNext();
            }
        }
        return found;
    }

    public String listarPlantacion() {
        if (first == null) {
            return "La casilla está vacía.";
        }

        StringBuilder sb = new StringBuilder();
        NodePlantacion current = first;

        while (current != null) {
            sb.append(current.getIdx() + " " + current.getPlantacion().getPlantacionId());
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }

        return sb.toString();
    }

    public NodePlantacion getFirst() {
        return first;
    }

    public void sort(Comparator<Plantacion> comparator, SimpleLinkedListPlantación plantaciones) {
        if (first == null || first.getNext() == null) {
            return; // No es necesario ordenar si la lista está vacía o tiene un solo elemento
        }

        boolean swapped;
        do {
            swapped = false;
            NodePlantacion current = first;

            while (current != null && current.getNext() != null) {
                if (comparator.compare(current.getPlantacion(), current.getNext().getPlantacion()) > 0) {
                    // Intercambiar los datos entre los nodos
                    Plantacion temp = current.getPlantacion();
                    current.setPlantacion(current.getNext().getPlantacion()); // Asignar el valor del siguiente nodo al nodo actual
                    current.getNext().setPlantacion(temp);

                    swapped = true;
                }
                current = current.getNext();
            }
        } while (swapped);
    }


}
