/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.justin.mateo.lucero.reyes.modelo.vista;

import ec.edu.ups.justin.mateo.lucero.reyes.modelo.Cliente;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ESTUDIANTE
 */
public class VistaCliente {
    Scanner teclado = new Scanner(System.in);
    
    public Cliente ingresarCliente(){
        System.out.println("Ingrese la cedula: ");
        String cedula = teclado.next();
        System.out.println("Ingrese el nombre: ");
        String nombre = teclado.next();
        System.out.println("Ingrese el apellido: ");
        String apellido = teclado.next();
        System.out.println("Ingrese la direccion: ");
        String direccion = teclado.next();
        System.out.println("Ingrese el telefono:");
        int telefono = teclado.nextInt();
        
        return new Cliente(cedula, nombre, apellido, direccion, telefono);
    }
    
    public void mostrarCliente(Cliente clie){
        System.out.println(clie);
    }
    public void mostrClientes(List<Cliente> lista){
        for (Cliente cliente : lista) {
            System.out.println(cliente);
        }
    }
    public Cliente actualizarCliente(String cedula1){
        System.out.println("Ingrese los nuevos datos del cliente: ");
        //String cedula1 = teclado.next();
        System.out.println("Ingrese el nuebo nombre: ");
        String nombre1 = teclado.next();
        System.out.println("Ingrese el nuevo apellido");
        String apellido1 = teclado.next();
        System.out.println("Ingrese la nueva direccion: ");
        String direccion1 = teclado.next();
        System.out.println("Ingrese el nuevo telefono: ");
        int telefono1 = teclado.nextInt();
        
        return new Cliente(cedula1, nombre1, apellido1, direccion1, telefono1);
    }
    
    public String buscarCliente(){
        System.out.println("Ingrese la cedula del cliente a buscar: ");
        String cedula = teclado.next();
        return cedula;
    }
    
    public String eliminarCliente(){
        System.out.println("Ingrese la cedula del cliente a eliminar: ");
        String cedulaUno = teclado.next();
        return cedulaUno;
    }
}
