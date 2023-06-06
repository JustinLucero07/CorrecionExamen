/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.justin.mateo.lucero.reyes.modelo;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author ESTUDIANTE
 */
public class CarritoCompra{
   
    private GregorianCalendar fechayhora;
    private List<Producto> listaProducto;
    private int codigocompra;
    private Cliente cliente;
    private double subtotal;
    private double total;
    private double iva;

    public CarritoCompra() {
        listaProducto = new ArrayList<>();
    }

    public CarritoCompra(GregorianCalendar fechayhora, int codigocompra) {
        this.fechayhora = fechayhora;
        this.codigocompra = codigocompra;
        listaProducto = new ArrayList<>();
    }

    
    public void agregarCliente(Cliente clientee){
        cliente = clientee;
    }
    
    public void agregarProdcuto(List<Producto> product){
        listaProducto = product;
    }
    
    public void eliminarCliente(){
        cliente = null;
    }
    
    public void modificarCliente(Cliente client){
        this.cliente = client;
    }
    
    public void eliminarProducto(int codigo){
        Producto productoAeliminar = null;
        for (Producto producto : listaProducto) {
            if(producto.getCodigo()==codigo){
                productoAeliminar = producto;
                break;
            }
        }
        if(productoAeliminar != null){
            listaProducto.remove(productoAeliminar);
            System.out.println("Producto eliminado correctamente");
        }else{
            System.out.println("El producto con el codigo espedicificado nose encontro");
        }
    }
    
    public void listarProdutos(){
        for (Producto producto : listaProducto) {
            System.out.println(producto);
        }
    }
    
    public void calcularTotales() {
        subtotal = 0;
        for (Producto producto : listaProducto) {
            subtotal += producto.getPrecio();
        }
        
        iva = subtotal * 0.12; 
        total = subtotal + iva;
    }
    
    public GregorianCalendar getFechayhora() {
        return fechayhora;
    }

    public void setFechayhora(GregorianCalendar fechayhora) {
        this.fechayhora = fechayhora;
    }

    public List<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }

    public int getCodigocompra() {
        return codigocompra;
    }

    public void setCodigocompra(int codigocompra) {
        this.codigocompra = codigocompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.codigocompra;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CarritoCompra other = (CarritoCompra) obj;
        if(this.codigocompra == other.codigocompra){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CarritoCompra{" + "Año:" + fechayhora.get(GregorianCalendar.YEAR) +"Mes" + (fechayhora.get(GregorianCalendar.MONTH) +1) + "Dia: " + fechayhora.get(GregorianCalendar.DAY_OF_MONTH) + "Hora: " + fechayhora.get(GregorianCalendar.HOUR_OF_DAY)+ "Minutos: " +fechayhora.get(GregorianCalendar.MINUTE)+ ", listaProducto=" + listaProducto + ", codigocompra=" + codigocompra + ", cliente=" + cliente + ", subtotal=" + subtotal + ", total=" + total + ", iva=" + iva + '}';
    }

}
