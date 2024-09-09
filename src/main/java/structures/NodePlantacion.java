package structures;


import model.Plantacion;

public class NodePlantacion {
    private String id;
    private Plantacion plantacion;
    private NodePlantacion next;

    public NodePlantacion(String id, Plantacion plantacion) {
        this.id = id;
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
}
