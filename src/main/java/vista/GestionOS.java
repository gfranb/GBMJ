package vista;

import controlador.Controlador;
import javafx.scene.control.Button;

import java.util.Scanner;
public class GestionOS {
    private Controlador controlador;
    Scanner teclado = new Scanner(System.in);

    public GestionOS() throws Exception {
        controlador = new Controlador();
    }
    public void inicio() throws Exception {
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

    public void gestionArticulo() throws Exception {
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
    public void AnadirArticulo() throws Exception {
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
    public void gestionClientes() throws Exception {
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
                    break;
                case '0':
                    salir = true;
            }
        }
    }
    public void AnadirCliente() throws Exception {
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

        if(controlador.crearCliente(nombre,domicilio,nif,email,tipo)){
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
    public void gestionPedidos() throws Exception {
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
                    eliminarPedido();
                    break;
                case '0':
                    salir = true;
            }
        }while(!salir);
    }
    public void anadirPedido() throws Exception {
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
                    + "El pedido ha sido creado con el numero: " + nPedido + "\n"+ "-----------------------------------------------------------------");
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
                    break;
                case '0':
                    salir = true;
            }
        } while (!salir);
    }
    public void pedidosPendientes(){
        System.out.println("Quieres filtrar por cliente? S/N");
        char a = teclado.nextLine().charAt(0);
        if(a == 'S'||a == 's'){
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
        char a = teclado.nextLine().charAt(0);
        if( a == 'S' || a == 's'){
            System.out.println("Indica el email del cliente que deseas buscar");
            String email = teclado.nextLine();
            String pedido = controlador.mostrarPedidosEnviados(email);
            if(pedido == ""){
                System.out.println("-----------------------------------------------" + "\n" +"No se encuentra ningun pedido enviado para el cliente: "+ email +"\n" + "-----------------------------------------------");
            }else{
                System.out.println(pedido);
            }
        }else if(a == 'N' || a == 'n'){
            String pedido = controlador.mostrarPedidosEnviados();
            if(pedido == ""){
                System.out.println("-----------------------------------------------" + "\n" + "No se encuentra ningun pedido enviado" + "\n" + "-----------------------------------------------") ;
            }else{
                System.out.println(pedido);
            }
        }
    }
    public void eliminarPedido() throws Exception {
        System.out.println("Indica el numero de pedido que se quiere eliminar.");
        int nPedido = teclado.nextInt();
        if(controlador.eliminarPedido(nPedido)){
            System.out.println("-----------------------------------------------"+"\n" + "Pedido N: " + nPedido + " eliminado correctamente." + "\n" + "-----------------------------------------------");
        }else{
            System.out.println("-----------------------------------------------" + "\n" + "Pedido N: " + nPedido + " no existe." + "\n"+ "-----------------------------------------------");
        }

    }
    public String mostrarCatalogo() throws Exception {
        System.out.println(controlador.showCatalogo());
        System.out.println("Indica el codigo del producto");
        String id = teclado.nextLine();
        return id;
    }

    char pedirOpcion() {
        String resp;
        System.out.println("Elige una opción (1,2,3 o 0): ");

        System.out.println("Elige una opción (1,2,3 o 0):");

                resp = teclado.nextLine();
        if (resp.isEmpty()) {
            resp = " ";
        }
        return resp.charAt(0);
    }
}