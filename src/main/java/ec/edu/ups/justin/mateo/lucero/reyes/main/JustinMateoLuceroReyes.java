/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.ups.justin.mateo.lucero.reyes.main;

import ec.edu.ups.justin.mateo.lucero.reyes.controlador.ControladorCarrito;
import ec.edu.ups.justin.mateo.lucero.reyes.controlador.ControladorCliente;
import ec.edu.ups.justin.mateo.lucero.reyes.controlador.ControladorProdcuto;
import ec.edu.ups.justin.mateo.lucero.reyes.dao.CarritoCompraDAO;
import ec.edu.ups.justin.mateo.lucero.reyes.dao.ClienteDAO;
import ec.edu.ups.justin.mateo.lucero.reyes.dao.ProductoDAO;
import ec.edu.ups.justin.mateo.lucero.reyes.modelo.CarritoCompra;
import ec.edu.ups.justin.mateo.lucero.reyes.modelo.Cliente;
import ec.edu.ups.justin.mateo.lucero.reyes.modelo.Producto;
import ec.edu.ups.justin.mateo.lucero.reyes.modelo.vista.VistaCarrito;
import ec.edu.ups.justin.mateo.lucero.reyes.modelo.vista.VistaCliente;
import ec.edu.ups.justin.mateo.lucero.reyes.modelo.vista.VistaProducto;
import java.util.Scanner;

/**
 *
 * @author ESTUDIANTE
 */
public class JustinMateoLuceroReyes {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        VistaCliente vista = new VistaCliente();
        ClienteDAO clientedao = new ClienteDAO();
        Cliente client = new Cliente();
        ControladorCliente controladorcliente = new ControladorCliente(clientedao, vista, client);
        
        VistaProducto vistap = new VistaProducto();
        ProductoDAO productodao = new ProductoDAO();
        Producto producto = new Producto();
        ControladorProdcuto controladorproducto = new ControladorProdcuto(producto, productodao, vistap);
        
        VistaCarrito vistac = new VistaCarrito();
        CarritoCompraDAO carriotdao = new CarritoCompraDAO();
        CarritoCompra carrito = new CarritoCompra();
        ControladorCarrito controladorcarrito = new ControladorCarrito(clientedao, vista, client, producto, productodao, vistap, carrito, carriotdao, vistac);
        
        int opcion = 0 ;
        do{
            System.out.println("\t******MENU****** \n1.Ingresar Cliente \n2.Ingresar Producto\n3.Iniciar carrito\n4.Buscar\n5.Actualizar\n6.Imprimir\n7.Eliminar Producto del carrito. \n8.Buscar Producto del carrito.\n9.Buscar Cliente del carrito. \n10.Agregar Cliente al carrito. \n11.Agregar Producto al Carrito. \n12.Eliminar \n13.ListarProductos del carrito: \n0.Salir.");
            System.out.println("Ingrese una opcion: ");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("**********CLIENTE **********");
                    System.out.println("Ingrese el numero de clientes que desea ingresar: ");
                    int n = teclado.nextInt();
                    for (int i = 1; i <= n; i++) {
                        System.out.println("Ingrese los datos del cliente #"+ i + ":");
                        controladorcliente.ingresarCliente();
                    }
                    break;
                case 2 :
                    System.out.println("**********PRODUCTOS***********");
                    System.out.println("Ingrese el numero de prodcutos que desea ingresar: ");
                    int n1 = teclado.nextInt();
                    for (int i = 1; i <= n1; i++) {
                        System.out.println("Ingrese los datos del producto#"+ i + ":");
                        controladorproducto.ingresarProducto();
                    }
                    break;
                case 3 :
                    System.out.println("***********CARRITO**********");
                    System.out.println("Ingrese el numero de carritos a crear: ");
                    int n2 = teclado.nextInt();
                    for (int i = 0; i < n2; i++) {
                        System.out.println("Ingrese datos del carrito: ");
                        controladorcarrito.ingresarCarri();
                    }
                    break;
                case 4 :
                    System.out.println("----Que desea buscar cliente, producto o un carrito: ");
                    System.out.println("\n-Ingrese 1 si desea buscar cliente \n-Ingrese 2 si desea buscar producto \n-Ingrese 3 si desea buscar un carrito");
                    int ingrese1 = teclado.nextInt();
                    while (ingrese1 != 1 && ingrese1 != 2 && ingrese1 != 3) {
                        System.out.println("Opción inválida. Inténtelo nuevamente:");
                        ingrese1 = teclado.nextInt();
                    }

                    System.out.println("Opción válida ingresada: " + ingrese1);

                    if (ingrese1 == 1) {
                        controladorcliente.buscarCliente();
                    
                    } else if (ingrese1 == 2) {
                        controladorproducto.buscarProducto();
                    } else if(ingrese1 ==3){
                        controladorcarrito.buscarCarrito();
                    }
                    break;
                case 5 :
                    System.out.println("----Que desea actualizar cliente, producto o un carrito: ");
                    System.out.println("\n-Ingrese 1 si desea actualizar cliente \n-Ingrese 2 si desea actualizar un prodcuto \n-Ingrese 3 si desea actualizar un carrito");
                    int ingrese2 = teclado.nextInt();
                    while (ingrese2 != 1 && ingrese2!=2 && ingrese2 != 3) {
                        System.out.println("Opción inválida. Inténtelo nuevamente:");
                        ingrese2 = teclado.nextInt();
                    }

                    System.out.println("Opción válida ingresada: " + ingrese2);

                    if (ingrese2 == 1) {
                        controladorcliente.actualizarCliente();
                    } else if (ingrese2 == 2) {
                        controladorproducto.actualizarProducto();
                    } else if (ingrese2 == 3){
                        controladorcarrito.actualizarCarrito();
                    }
                    break;
                case 6 :
                    System.out.println("*******LISTA CLIENTES***********");
                    controladorcliente.mostraCleintes();
                    System.out.println("*******LISTA PRODCUTOS**********");
                    controladorproducto.mostrarProductos();
                    System.out.println("*******CARRITO*********");
                    controladorcarrito.mostrarListaCarr();
                    break;
                case 7 :
                    controladorcarrito.eliminarProductoDelCarrito();
                    break;
                case 8 :
                    controladorcarrito.buscarProductoEnCarrito();
                    break;
                case 9 :
                    controladorcarrito.buscarClienteEnCarrito();
                    break;
                case 10:
                    System.out.println("Ingrese el numero de clientes que desea ingresar: ");
                    int n3 = teclado.nextInt();
                    for (int i = 0; i < n3; i++) {
                        controladorcarrito.agregarClienteAlCarrito();
                    }
                    break;
                case 11:
                    controladorcarrito.agregarProductoAlCarrito();
                    
                    break;
                case 12:
                    System.out.println("----Que desea eliminar cliente, producto o un carrito: ");
                    System.out.println("\n-Ingrese 1 si desea eliminar cliente \n-Ingrese 2 si desea eliminar un prodcuto \n-Ingrese 3 si desea eliminar un carrito");
                    int ingrese5 = teclado.nextInt();
                    while (ingrese5 != 1 && ingrese5!=2 && ingrese5 != 3) {
                        System.out.println("Opción inválida. Inténtelo nuevamente:");
                        ingrese5 = teclado.nextInt();
                    }

                    System.out.println("Opción válida ingresada: " + ingrese5);

                    if (ingrese5 == 1) {
                        controladorcliente.eliminarCliente();
                    } else if (ingrese5 == 2) {
                        controladorproducto.eliminarProducto();
                    } else if (ingrese5 == 3){
                        controladorcarrito.eliminarCarrito();
                    }
                    break;
                case 13:
                    controladorcarrito.listarProductosdelCarrito();
                    break;
            }
            
        }while(opcion!=0);
    }
}
