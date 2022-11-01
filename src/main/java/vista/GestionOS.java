package vista;

import controlador.Controlador;
import java.util.Scanner;
public class GestionOS {
    private Controlador controlador;
    Scanner teclado = new Scanner(System.in);

    public GestionOS() {
        controlador = new Controlador();
        System.out.println(controlador.cargar()); // Carga de datos preconfigurados
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
<<<<<<<<< Temporary merge branch 1

                    char op;
                    boolean salir2= false;
                    do{
                        System.out.println("1. Mostrar Articulo");
                        System.out.println("2. Anadir Articulo");
                        op = pedirOpcion();
                        controlador.gestionarArticulos(op);
                    }while(salir2);
=========
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

        if(controlador.anadirArticulo(codigo,descripcion, precio, gEnvio,pEnvio)){
            System.out.println("Articulo ha sido creado correctamente");
        }else{
            System.out.println("Articulo ya existe");
        }

    }
    public void MostrarArticulo() {
        String codigo;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Codigo:");
        codigo = teclado.nextLine();

        System.out.println(controlador.mostrarArticulo(codigo));

    }
    public void gestionClientes(){
        boolean salir = false;
        char opcio;
        while(!salir){
            System.out.println("1. Anadir Cliente");
            System.out.println("2. Mostrar Cliente");
            System.out.println("0. Salir");
            opcio = pedirOpcion();
            switch (opcio) {
                case '1':
                    AnadirCliente();
                    break;
                case '2':
                    MostrarCliente();
>>>>>>>>> Temporary merge branch 2
                    break;
                case '0':
                    salir = true;
            }
        }
    }
    public void AnadirCliente(){
        String nombre, email, domicilio,nif;
        char tipo;

        Scanner teclado = new Scanner(System.in);

        System.out.println("Nombre:");
        nombre = teclado.nextLine();
        teclado = new Scanner(System.in);
        System.out.println("Email:");
        email = teclado.nextLine();
        teclado = new Scanner(System.in);
        System.out.println("Domicilio:");
        domicilio = teclado.nextLine();
        teclado = new Scanner(System.in);
        System.out.println("NIF");
        nif = teclado.nextLine();
        teclado = new Scanner(System.in);
        System.out.println("Tipo de cliente: 1 Premium || 2 Estandart");
        tipo = teclado.next().charAt(0);

        if(controlador.crearCliente(nombre,email,domicilio,nif,tipo)){
            System.out.println("Cliente creado correctamente");
        }else{
            System.out.println("El cliente ya existe");
        };

    }
    public void MostrarCliente(){
        String email;

        Scanner teclado = new Scanner(System.in);

        System.out.println("Email:");
        email = teclado.nextLine();

        System.out.println(controlador.mostrarCliente(email));

    }
    public void gestionPedidos(){
        boolean salir = false;
        char opcio;
        do{
            System.out.println("1. Hacer nuevo pedido");
            System.out.println("2. Mostrar Pedidos");
            System.out.println("3. Eliminar Pedido");
            System.out.println("0. Salir");
            opcio = pedirOpcion();
            switch (opcio) {
                case '1':
                    anadirPedido();
                    break;
                case '2':
                    mostrarPedido();
                    break;
                case '3':
<<<<<<<<< Temporary merge branch 1
                    controlador.gestionarPedidos();
=========
                    eliminarPedido();
                    break;
                case '0':
                    salir = true;
            }
        }while(!salir);
    }
    public void anadirPedido(){

        System.out.println("Indica tu correo electronico");
        String email = teclado.nextLine();
        String idArticulo = mostrarCatalogo();
        System.out.println("Cantidad que se quiere pedir");
        int cantidadArticulo = teclado.nextInt();

        int nPedido = controlador.crearPedido(email,idArticulo,cantidadArticulo);
        if( nPedido ==-1){
                System.out.println("El cliente no existe, procedemos a crearlo");
                AnadirCliente();
        }else{
            System.out.println("-----------------------------------------------------------------"+ "\n"
                    + "El pedido a sido creado con el numero: " + nPedido + "\n"+ "-----------------------------------------------------------------");
        }
    }
    public void mostrarPedido(){
        boolean salir = false;
        char opcio;
        do {
            System.out.println("1. Mostrar Pedido Pendientes");
            System.out.println("2. Mostrar pedidos Enviados");
            System.out.println("0. Salir");
            opcio = pedirOpcion();
            switch (opcio) {
                case '1':
                    pedidosPendientes();
                    break;
                case '2':
                    pedidosEnviados();
>>>>>>>>> Temporary merge branch 2
                    break;
                case '0':
                    salir = true;
            }
        } while (!salir);
    }
    public void pedidosPendientes(){
        System.out.println("Quieres filtrar por cliente? S/N");
        if(teclado.nextLine().charAt(0) == 'S'){
            System.out.println("Indica el email del cliente que deseas buscar");
            String email = teclado.nextLine();
            String pedido = controlador.mostrarPedidosPendientes(email);
            if(pedido == ""){
                System.out.println("No se encuentra ningún pedido pendiente para el cliente: "+ email);
            }else{
                System.out.println(pedido);
            }
        }else{
            String pedido = controlador.mostrarPedidosPendientes();
            if(pedido == ""){
                System.out.println("No se encuentra ningún pedido pendiente");
            }else{
                System.out.println(pedido);
            }
        }
    }
    public void pedidosEnviados(){
        System.out.println("Quieres filtrar por cliente? S/N");
        if(teclado.nextLine().charAt(0) == 'S'){
            System.out.println("Indica el email del cliente que deseas buscar");
            String email = teclado.nextLine();
            String pedido = controlador.mostrarPedidosEnviados(email);
            if(pedido == ""){
                System.out.println("-----------------------------------------------" + "\n" +"No se encuentra ningun pedido enviado para el cliente: "+ email +"\n" + "-----------------------------------------------");
            }else{
                System.out.println(pedido);
            }
        }else{
            String pedido = controlador.mostrarPedidosEnviados();
            if(pedido == ""){
                System.out.println("-----------------------------------------------" + "\n" + "No se encuentra ningun pedido enviado" + "\n" + "-----------------------------------------------") ;
            }else{
                System.out.println(pedido);
            }
        }
    }
    public void eliminarPedido(){
        System.out.println("Indica el numero de pedido que se quiere eliminar.");
        int nPedido = teclado.nextInt();
        if(controlador.eliminarPedido(nPedido)){
            System.out.println("-----------------------------------------------"+"\n" + "Pedido N: " + nPedido + " eliminado correctamente." + "\n" + "-----------------------------------------------");
        }else{
            System.out.println("-----------------------------------------------" + "\n" + "Pedido N: " + nPedido + " no existe." + "\n"+ "-----------------------------------------------");
        }

    }
    public String mostrarCatalogo(){
        System.out.println(controlador.showCatalogo());
        System.out.println("Indica el ID de pedido");
        String id = teclado.nextLine();
        return id;
    }

    char pedirOpcion() {
        String resp;
        System.out.println("Elige una opción (1,2,3 o 0): ");
<<<<<<<<< Temporary merge branch 1
<<<<<<<<< Temporary merge branch 1
=========
        System.out.println("Elige una opción (1,2,3 o 0):");
>>>>>>>>> Temporary merge branch 2
=========
>>>>>>>>> Temporary merge branch 2
                resp = teclado.nextLine();
        if (resp.isEmpty()) {
            resp = " ";
        }
        return resp.charAt(0);
    }
}
<<<<<<<<< Temporary merge branch 1
=========

>>>>>>>>> Temporary merge branch 2
