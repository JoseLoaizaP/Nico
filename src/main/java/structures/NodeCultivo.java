package structures;

import model.Cultivo;

public class NodeCultivo {

    private String id;
    private Cultivo cultivo;
    private int idx;
    private NodeCultivo next;

    public NodeCultivo(String id, int idx, Cultivo cultivo) {
        this.id = id;
        this.idx = idx;
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

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
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
