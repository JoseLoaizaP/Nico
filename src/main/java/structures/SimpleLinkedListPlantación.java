package structures;


import exceptions.PlantacionLlenaException;
import model.Plantacion;

public class SimpleLinkedListPlantación {
    private NodePlantacion first;
    private final int MAX_CULTIVO = 5;
    private int size;

    public SimpleLinkedListPlantación() {
        this.first = null;
        this.size = 0;
    }

    public void add(String id,  Plantacion plantacion) throws PlantacionLlenaException {

        NodePlantacion node = new NodePlantacion(id,0 ,plantacion);

        if (size >= MAX_CULTIVO) {
            throw new PlantacionLlenaException("La plantación ya contiene  la cantidad maxima de cultivos" + MAX_CULTIVO );
        }


        if(this.size <= MAX_CULTIVO) {
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
            this.size++;
        }
    }

    // buscar por nombre de persona | value = name
    public NodePlantacion search(String value){
        NodePlantacion found = null;

        // Caso Base
        if(first.getPlantacion().getPlantacionId().equals(value)){
            found = first;
        }

        // Caso Iterativo
        else {
            NodePlantacion current = first;
            boolean isFound = false;

            while (current.getNext() != null && !isFound) {
                if (current.getPlantacion().getPlantacionId().equals(value)) {
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
            sb.append(current.getPlantacion().getPlantacionId());
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
}
