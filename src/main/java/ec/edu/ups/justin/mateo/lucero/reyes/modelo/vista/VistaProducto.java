/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.justin.mateo.lucero.reyes.modelo.vista;

import ec.edu.ups.justin.mateo.lucero.reyes.modelo.Producto;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ESTUDIANTE
 */
public class VistaProducto {
    Scanner teclado = new Scanner(System.in);
    
    public Producto ingresarProducto(){
        System.out.println("Ingrese el codigo del producto: ");
        int codigo = teclado.nextInt();
        System.out.println("Ingerse el nombre del producto: ");
        String nombre = teclado.next();
        System.out.println("Ingrese la descripcion del producto: ");
        String descripcion = teclado.next();
        System.out.println("Ingrese el precio del producto: ");
        double precio = teclado.nextDouble();
        
        return new Producto(codigo, nombre, descripcion, precio);
    }
    
    public int buscarPorcodigo(){
        System.out.println("Ingrese el codigo del producto: ");
        int codigo = teclado.nextInt();
        
        return codigo;
    }
    
    public Producto eliminarProducto(){
        System.out.println("Ingrese el codigo del producto a eliminar: ");
        int coidgouno = teclado.nextInt();
        return new Producto(coidgouno, null, null, 0);
    }
    
    public void mostraProduto(Producto pro){
        System.out.println("\tEl producto ingresado es ");
        System.out.println(pro+"\n");
    }
    public void mostraProductos(List<Producto> lita){
        System.out.println("\t*****Datos Productos******");
        for (Producto producto : lita) {
            System.out.println(producto);
        }
        
    }
    public int eliminarProduct(){
        System.out.println("Ingrese el codigo del producto a eliminar ");
        int codigouno = teclado.nextInt();
        
        return codigouno;
    }
    
    public Producto actualizarProducto(int codigo1){
        System.out.println("Ingrese los datos del prodcuto: ");
        //int codigo1 = teclado.nextInt();
        System.out.println("Ingrese el nuevo nombre del prodcuto: ");
        String nombre1 = teclado.next();
        System.out.println("Ingrese la nueva descripcion del producto: ");
        String descripcion1 = teclado.next();
        System.out.println("Ingrese el nuevo precio del producto: ");
        double precio1 = teclado.nextDouble();
        
        return new Producto(codigo1, nombre1, descripcion1, precio1);
    }
}
