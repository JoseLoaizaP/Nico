package structures;


import model.Plantacion;

public class NodePlantacion {
    private String id;
    private Plantacion plantacion;
    private NodePlantacion next;
    private int idx;

    public NodePlantacion(String id, int idx,Plantacion plantacion) {
        this.id = id;
        this.idx = idx;
        this.plantacion = plantacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Plantacion getPlantacion() {
        return plantacion;
    }

    public void setPlantacion(Plantacion plantacion) {
        this.plantacion = plantacion;
    }

    public NodePlantacion getNext() {
        return next;
    }

    public void setNext(NodePlantacion next) {
        this.next = next;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }
}
