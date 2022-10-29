package vista;

import controlador.Controlador;
import java.util.Scanner;
<<<<<<<<< Temporary merge branch 1

=========
>>>>>>>>> Temporary merge branch 2
public class GestionOS {
    private Controlador controlador;
    Scanner teclado = new Scanner(System.in);

    public GestionOS() {
        controlador = new Controlador();
        controlador.cargar();
    }
    public void inicio() {
        boolean salir = false;
        char opcio;
        do {
            System.out.println("1. Gestión Articulos");
            System.out.println("2. Gestión Clientes");
            System.out.println("3. Gestión Pedidos");
            System.out.println("0. Salir");
            opcio = pedirOpcion();
            switch (opcio) {
                case '1':
                    gestionArticulo();
                    break;
                case '2':
                    gestionClientes();
                    break;
                case '3':
                    gestionPedidos();
                    break;
                case '0':
                    salir = true;
            }
        } while (!salir);
    }

    public void gestionArticulo(){
        boolean salir = false;
        char opcio;
        while(!salir){
            System.out.println("1. Anadir Articulos");
            System.out.println("2. Mostrar Articulo");
            System.out.println("0. Salir");
            opcio = pedirOpcion();
            switch (opcio) {
                case '1':
                    AnadirArticulo();
                    break;
                case '2':
                    MostrarArticulo();
                    break;
                case '0':
                    salir = true;
            }
        }
    }
    public void AnadirArticulo() {
        String codigo, descripcion;
        float precio, gEnvio;
        int pEnvio;

        Scanner teclado = new Scanner(System.in);

        System.out.println("Codigo:");
        codigo = teclado.nextLine();
        teclado = new Scanner(System.in);
        System.out.println("Descripcion:");
        descripcion = teclado.nextLine();
        teclado = new Scanner(System.in);
        System.out.println("Precio:");
        precio = teclado.nextFloat();
        System.out.println("Gastos de Envio:");
        gEnvio = teclado.nextFloat();
        teclado = new Scanner(System.in);
        System.out.println("Tiempo de preparacion:");
        pEnvio = teclado.nextInt();

                    char op;
                    boolean salir2= false;
                    do{
                        System.out.println("1. Mostrar Articulo");
                        System.out.println("2. Anadir Articulo");
                        op = pedirOpcion();
                        controlador.gestionarArticulos(op);
                    }while(salir2);
                    break;

                case '2':
                    controlador.gestionarClientes();
                    break;
                case '3':
                    controlador.gestionarPedidos();
>>>>>>>>> Temporary merge branch 2
                    break;
                case '0':
                    salir = true;
            }
        } while (!salir);
    }
    char pedirOpcion() {
        String resp;
<<<<<<<<< Temporary merge branch 1
        System.out.println("Elige una opción (1,2,3 o 0):");
=========
        System.out.println("Elige una opción (1,2,3 o 0): ");
>>>>>>>>> Temporary merge branch 2
                resp = teclado.nextLine();
        if (resp.isEmpty()) {
            resp = " ";
        }
        return resp.charAt(0);
    }
<<<<<<<<< Temporary merge branch 1
=========
}
>>>>>>>>> Temporary merge branch 2
