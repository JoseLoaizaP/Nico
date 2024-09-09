package structures;

import model.Cultivo;

public class NodeCultivo {

    private String id;
    private Cultivo cultivo;
    private NodeCultivo next;

    public NodeCultivo(String id, Cultivo cultivo) {
        this.id = id;
        this.cultivo = cultivo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cultivo getValueCultivo() {
        return cultivo;
    }

    public void setValueCultivo(Cultivo value) {
        this.cultivo = value;
    }

    public NodeCultivo getNext() {
        return next;
    }

    public void setNext(NodeCultivo next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "NodeCultivo{" +
                "id='" + id + '\'' +
                ", cultivo=" + cultivo +
                ", next=" + next +
                '}';
    }
}
