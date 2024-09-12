package structures;

import model.Cofre;

public class SimpleLinkedListCofre {
    private NodeCofre first;
    private int size;


    public void add(String id,  Cofre cofre){
        NodeCofre node = new NodeCofre(id, 0, cofre);

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
                first.getNext().setIdx(1);
                this.size++;

            }
            // Caso Iterativo
            else {
                NodeCofre current = first.getNext();
                while (current.getNext() != null){
                    current = current.getNext();
                }
                current.setNext(node);
                this.size++;
                current.getNext().setIdx(size-1);
            }
        }
    }

    // buscar por nombre de persona | value = name
    public NodeCofre search(String value){
        NodeCofre found = null;

        // Caso Base
        if(first.getCofre().getCofreId().equals(value)){
            found = first;
        }

        // Caso Iterativo
        else {
            NodeCofre current = first;
            boolean isFound = false;

            while (current.getNext() != null && !isFound) {
                if (current.getCofre().getCofreId().equals(value)) {
                    found = current;
                    isFound = true;
                }
                current = current.getNext();

            }
        }
        return found;
    }

    public String listarCofres() {
        if (first == null) {
            return "La lista está vacía.";
        }

        StringBuilder sb = new StringBuilder();
        NodeCofre current = first;

        while (current != null) {
            sb.append(current.getIdx() + "-" +current.getCofre().getCofreId());  // Añadir el ID del cofre actual
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }

        return sb.toString();
    }

    public int getSize() {
        return size;
    }

    public NodeCofre getFirst() {
        return first;
    }
}
