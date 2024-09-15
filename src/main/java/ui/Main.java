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
            System.out.println("8. Buscar cofre");
            System.out.println("9. Buscar plantación");
            System.out.println("10. Ordenar Cofres por identificador");
            System.out.println("10. Ordenar Plantaciones por identificador");
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
                case 8:
                    buscarCofre();;
                    break;
                case 9:
                    buscarCultivo();
                    break;
                case 10:
                    ordenarCofres();
                    break;
                case 11:
                    ordenarPlantaciones();
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
        System.out.println(culController.listarCultivosArray(culController.agregarCultivosALista()));
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
        plantController.addPlantacion(plantId);
    }

    public void cultivoEnPlantacion(){

        reader.nextLine();
        listaCultivos();
        System.out.println("Digite el indice de la plantacion a la que quiere agregar el cultivo");
        int idx = reader.nextInt();
        System.out.println(plantController.buscarCultivo(idx).getCultivos());

        System.out.println("Digite el indice de la cual le quiera asignar el cultivo");
        int idx2 = reader.nextInt();

        System.out.println(culController.listarCultivosArray(culController.agregarCultivosALista()));
        System.out.println("\nDigite el identificador del cultivo que desea añadir");
        int indice = reader.nextInt();

        System.out.println("Digite el identinficador");
        reader.nextLine();
        String identificador = reader.nextLine();

        plantController.buscarCultivo(idx).addCultivoInPlantacion(identificador, culController.buscarCultivoPorPosicion(indice));
    }

    public void cultivoEnCofre(){
        reader.nextLine();
        listarCofres();
        System.out.println("Digite el indice del cofre al que quiere agregar el cultivo");
        int idx = reader.nextInt();
        System.out.println(cofController.buscarCofre(idx).getCasilla().listarCasillas());

        System.out.println(culController.listarCultivosArray(culController.agregarCultivosALista()));
        System.out.println("\nDigite el identificador del cultivo que desea añadir");
        int indice = reader.nextInt();

        System.out.println("Digite el identinficador");
        reader.nextLine();
        String identificador = reader.nextLine();

        cofController.buscarCofre(idx).addCultivoInCofre(identificador , culController.buscarCultivoPorPosicion(indice));


    }

    public void listarCofres(){
        System.out.println(cofController.listarCofres());
    }

    public void listarPlantaciones(){
        System.out.println(plantController.listarPlantaciones());
    }

    public void buscarCofre(){
        listarCofres();
        System.out.println("Digite el indice del cofre al que desea acceder");
        reader.nextLine();
        int idx = reader.nextInt();
        System.out.println(cofController.buscarCofre(idx).getCasilla().listarCasillas());
    }

    public void buscarCultivo(){
        listaCultivos();
        System.out.println("Digite el indice del cultivo al que desea acceder");
        reader.nextLine();
        int idx = reader.nextInt();
        plantController.buscarCultivo(idx).getCultivos().listarCultivos();
    }

    public void ordenarCofres(){
        cofController.ordenarCofre(cofController.getCofres());
        System.out.println(cofController.listarCofres());
    }

    public void ordenarPlantaciones(){
        plantController.ordenarPlantaciones(plantController.getPlantaciones());
        System.out.println(plantController.listarPlantaciones());
    }

}
