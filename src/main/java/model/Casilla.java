package model;


import exceptions.CasillaLlenaException;
import exceptions.CultivoLlenoException;
import structures.SimpleLinkedListCultivos;

public class Casilla {

    private SimpleLinkedListCultivos cultivos;
    private Cultivo cultivo;

    public Casilla(Cultivo cultivo){

        this.cultivo = cultivo;

        cultivos = new SimpleLinkedListCultivos();
    }

    public void addCultivoToCasilla(Cultivo cultivo, String identificador){
        try{
            cultivos.add(identificador, cultivo);
        }
        catch(CultivoLlenoException e){
            System.out.println("Error al agregar cultivo: " + e.getMessage());
        }
    }

    public SimpleLinkedListCultivos getCultivos() {
        return cultivos;
    }

    public void setCultivos(SimpleLinkedListCultivos cultivos) {
        this.cultivos = cultivos;
    }

    public Cultivo getCultivo() {
        return cultivo;
    }

    public void setCultivo(Cultivo cultivo) {
        this.cultivo = cultivo;
    }
}
