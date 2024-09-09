package structures;
import model.Cultivo;

public class SimpleLinkedListParcela {
    private NodeCultivo first;

    public void add(String id,  Cultivo cultivo) {
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
