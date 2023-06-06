/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.justin.mateo.lucero.reyes.modelo.vista;

import ec.edu.ups.justin.mateo.lucero.reyes.modelo.CarritoCompra;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ESTUDIANTE
 */
public class VistaCarrito {
    Scanner teclado = new Scanner(System.in);
    
    public CarritoCompra ingresarCarrito(){
        System.out.println("Ingrese el codigo de compra: ");
        int codigocompra = teclado.nextInt();
        System.out.println("Ingrese el anio: ");
        int anio = teclado.nextInt();
        System.out.println("Ingrese el mes: ");
        int mes = teclado.nextInt();
        System.out.println("Ingrese el dia: ");
        int dia = teclado.nextInt();
        System.out.println("Ingrese la hora: ");
        int hora = teclado.nextInt();
        System.out.println("Ingrese los minutos: ");
        int minuto = teclado.nextInt();
        return new CarritoCompra(new GregorianCalendar(anio, mes, dia, hora, minuto), codigocompra);
    }
    
    public void mostracar(CarritoCompra car ){
        System.out.println(car);
        
    }
    public void mostraListCarr(List<CarritoCompra> lita){
        for (CarritoCompra carritoCompras : lita) {
            System.out.println(carritoCompras);
        }
        
    }
    
    public int buscarPorcodigo(){
        System.out.println("Ingrese el codigo del producto: ");
        int codigo = teclado.nextInt();
        
        return codigo;
    }
    
    public CarritoCompra actualizar(int codigocompra){
        System.out.println("Ingrese Carrito ");
        System.out.println("Ingrese el anio: ");
        int anio1 = teclado.nextInt();
        System.out.println("Ingrese el mes: ");
        int mes1 = teclado.nextInt();
        System.out.println("Ingrese el dia: ");
        int dia1 = teclado.nextInt();
        System.out.println("Ingrese la hora: ");
        int hora1 = teclado.nextInt();
        System.out.println("Ingrese los minutos: ");
        int minuto1 = teclado.nextInt();
        return new CarritoCompra(new GregorianCalendar(anio1, mes1, dia1, hora1, minuto1), codigocompra);
    }
    
    public int buscarCodigo1(){
        System.out.println("Ingrese el codigo del carrito: ");
        int coidigoc = teclado.nextInt();
        return coidigoc;
    }
    
    public int buscarCarrito(){
        System.out.println("Ingrese el codigo del carrito a buscar: ");
        int cod = teclado.nextInt();
        return cod;
    }
    
    public int eliminarCarrito(){
        System.out.println("Ingrese el codigo del carrito a eliminar: ");
        int coduno = teclado.nextInt();
        return coduno;
    }
    
    public int cantidadDeProductosaAgregar(){
        System.out.println("Ingrese la cantidad de productos a agregar: ");
        int n = teclado.nextInt();
        return n;
    }
}
