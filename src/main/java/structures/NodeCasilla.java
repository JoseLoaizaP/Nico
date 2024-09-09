package structures;

import model.Casilla;
import model.Cultivo;

public class NodeCasilla {
    private String id;
    private Cultivo cultivo;
    private NodeCasilla next;

    public NodeCasilla(String id, Cultivo cultivo) {
        this.id = id;
        this.cultivo = cultivo;
    }

    public Cultivo getCultivo() {
        return cultivo;
    }

    public void setCultivo(Cultivo cultivo) {
        this.cultivo = cultivo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public NodeCasilla getNext() {
        return next;
    }

    public void setNext(NodeCasilla next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "NodeCasilla{" +
                "id='" + id + '\'' +
                ", cultivo=" + cultivo +
                ", next=" + next +
                '}';
    }
}
