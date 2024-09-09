package structures;

import model.Cofre;

public class NodeCofre {
    private String id;
    private Cofre cofre;
    private NodeCofre next;

    public NodeCofre(String id, Cofre cofre) {
        this.id = id;
        this.cofre = cofre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cofre getCofre() {
        return cofre;
    }

    public void setCofre(Cofre cofre) {
        this.cofre = cofre;
    }

    public NodeCofre getNext() {
        return next;
    }

    public void setNext(NodeCofre next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "NodeCofre{" +
                "id='" + id + '\'' +
                ", cofre=" + cofre +
                ", next=" + next +
                '}';
    }
}
