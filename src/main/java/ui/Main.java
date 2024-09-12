package ui;

import control.PlantacionController;
import control.CofreController;
import control.CultivoController;
import java.util.Scanner;

public class Main {
    private Scanner reader;
    private CofreController cofController;
    private PlantacionController plantController;
    private CultivoController culController;
    private Main main;



    public static void main(String[] args){
      Main main = new Main();
      main.menu();
    }

    public Main(){
        reader = new Scanner(System.in);
        cofController = new CofreController();
        plantController = new PlantacionController();
        culController = new CultivoController();
        culController.cultivosIniciales();
    }

    public void menu (){
        boolean flag = true;
        do{

            System.out.println("\n===== Menú Principal =====");
            System.out.println("1. Ver lista de cultivos");
            System.out.println("2. Crear cofre");
            System.out.println("3. Crear plantación");
            System.out.println("4. Introducir cultivo a plantación");
            System.out.println("5. Introducir cultivo a cofre");
            System.out.println("6. Listar cofres");
            System.out.println("7. listar plantación");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            int option = reader.nextInt ();

            switch (option){
                case 1:
                    listaCultivos();
                    break;

                case 2:
                    crearCofre();
                    break;

                case 3:
                    crearPlantacion();
                    break;

                case 4:
                    cultivoEnPlantacion();
                    break;
                case 5:
                    cultivoEnCofre();
                    break;
                case 6:
                    listarCofres();
                    break;
                case 7:
                    listarPlantaciones();
                    break;

                case 0:
                    flag = false;
                    System.out.println ("Gracias por usar nuestros servicios");
                    break;

                default:
                    System.out.println ("Opcion invalida. Reintentar");
                    break;
            }
        }while (flag);
    }

    public void listaCultivos(){
        culController.listarCultivos();
    }

    public void crearCofre(){
        reader.nextLine();
        System.out.println("Digite el id que desee que tenga el cófre");
        String cofeId = reader.nextLine();
        cofController.addCofre(cofeId);
    }

    public void crearPlantacion(){
        reader.nextLine();
        System.out.println("Digite el id que desee que tenga la plantación");
        String plantId = reader.nextLine();
        cofController.addCofre(plantId);
    }

    public void cultivoEnPlantacion(){
        reader.nextLine();
        culController.agregarCultivosALista();
        System.out.println(culController.listarCultivosArray());
        System.out.println("\nDigite el indice del cultivo que desea añadir");
        int indice = reader.nextInt();
        System.out.println("Digite el identificador");
        reader.nextLine();
        String ident = reader.nextLine();
        cofController.addCultivotoCofre(culController.buscarCultivoPorPosicion(indice), ident);
    }

    public void cultivoEnCofre(){

    }

    public void listarCofres(){
        System.out.println(cofController.listarCofres());
    }

    public void listarPlantaciones(){

    }

}
