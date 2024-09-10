package structures;


import exceptions.PlantacionLlenaException;
import model.Plantacion;

public class SimpleLinkedListPlantación {
    private NodePlantacion first;
    private final int MAX_PARCELA = 5;
    private int size;

    public SimpleLinkedListPlantación() {
        this.first = null;
        this.size = 0;
    }

    public void add(String id,  Plantacion plantacion) throws PlantacionLlenaException {

        if (size >= MAX_PARCELA) {
            throw new PlantacionLlenaException("La plantación ya contiene " + MAX_PARCELA + " parcelas.");
        }

        NodePlantacion node = new NodePlantacion(id, plantacion);

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
                NodePlantacion current = first.getNext();
                while (current.getNext() != null){
                    current = current.getNext();
                }
                current.setNext(node);
            }
        }
        size++;
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

    public NodePlantacion getFirst() {
        return first;
    }
}
