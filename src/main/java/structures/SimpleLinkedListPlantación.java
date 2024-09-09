package structures;


import model.Plantacion;

public class SimpleLinkedListPlantación {
    private NodePlantacion first;
    public void add(String id,  Plantacion plantacion){
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
