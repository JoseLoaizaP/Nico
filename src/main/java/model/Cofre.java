package model;

import exceptions.CasillaLlenaException;
import structures.NodeCasilla;
import structures.SimpleLinkedListCasillas;

public class Cofre {
    private final int max_casillas = 50;
    private SimpleLinkedListCasillas casilla;
    private String cofreId;

    public Cofre(String cofreId){
        casilla = new SimpleLinkedListCasillas();
        this.cofreId = cofreId;
    }

    public void addCultivoInCofre(String id, Cultivo cultivo){

        try{
            casilla.add(id, cultivo);
        }
        catch (CasillaLlenaException e){
            System.out.println("Error al agregar cultivo: " + e.getMessage());
        }

    }

    public String getCofreId() {
        return cofreId;
    }

    public SimpleLinkedListCasillas getCasilla() {
        return casilla;
    }

    public void setCasilla(SimpleLinkedListCasillas casilla) {
        this.casilla = casilla;
    }
}
