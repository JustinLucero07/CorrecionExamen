/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.justin.mateo.lucero.reyes.controlador;

import ec.edu.ups.justin.mateo.lucero.reyes.dao.CarritoCompraDAO;
import ec.edu.ups.justin.mateo.lucero.reyes.dao.ClienteDAO;
import ec.edu.ups.justin.mateo.lucero.reyes.dao.ProductoDAO;
import ec.edu.ups.justin.mateo.lucero.reyes.idao.ICarritoCompraDAO;
import ec.edu.ups.justin.mateo.lucero.reyes.idao.IClienteDAO;
import ec.edu.ups.justin.mateo.lucero.reyes.idao.IProductoDAO;
import ec.edu.ups.justin.mateo.lucero.reyes.modelo.CarritoCompra;
import ec.edu.ups.justin.mateo.lucero.reyes.modelo.Cliente;
import ec.edu.ups.justin.mateo.lucero.reyes.modelo.Producto;
import ec.edu.ups.justin.mateo.lucero.reyes.modelo.vista.VistaCarrito;
import ec.edu.ups.justin.mateo.lucero.reyes.modelo.vista.VistaCliente;
import ec.edu.ups.justin.mateo.lucero.reyes.modelo.vista.VistaProducto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ESTUDIANTE
 */
public class ControladorCarrito {

    private IClienteDAO clientedao;
    private VistaCliente vistacliente;
    private Cliente cliente;
    private Producto producto;
    private IProductoDAO productodao;
    private VistaProducto vistaproducto;
    private CarritoCompra carrito;
    private ICarritoCompraDAO carritodao;
    private VistaCarrito vistacarrito;
    private List<Producto> prodcuto1;
    //private ControladorCliente controladorcli;

    public ControladorCarrito(IClienteDAO clientedao, VistaCliente vistacliente, Cliente cliente, Producto producto, IProductoDAO productodao, VistaProducto vistaproducto, CarritoCompra carrito, ICarritoCompraDAO carritodao, VistaCarrito vistacarrito) {
        this.clientedao = clientedao;
        this.vistacliente = vistacliente;
        this.cliente = cliente;
        this.producto = producto;
        this.productodao = productodao;
        this.vistaproducto = vistaproducto;
        this.carrito = carrito;
        this.carritodao = carritodao;
        this.vistacarrito = vistacarrito;
    }

    public void agregarClienteAlCarrito(){
        int carritoid = vistacarrito.buscarCarrito();
        carrito = carritodao.read(carritoid);
        String cedulita = vistacliente.buscarCliente();
        cliente = clientedao.read(cedulita);
        if(cliente != null && carrito != null){
            carrito.agregarCliente(cliente);
            carritodao.update(carrito);
        }
    }
    
    public void ingresarCarri(){
        carrito = vistacarrito.ingresarCarrito();
        carritodao.create(carrito);
    }
    public void mostrarListaCarr(){
        vistacarrito.mostraListCarr(carritodao.finAll());
    }
    
    public void agregarProductoAlCarrito() {
        int id = vistacarrito.buscarCarrito();
        carrito = carritodao.read(id);
        if (carrito != null){
            int n = vistacarrito.cantidadDeProductosaAgregar();
            List<Producto> pro = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int co = vistaproducto.buscarPorcodigo();
                Producto prt = productodao.read(co);
                if (prt!=null) {
                    pro.add(prt);
                }else{
                    System.out.println("No existe el carrito");
                }
            }
            carrito.agregarProdcuto(pro);
            carrito.calcularTotales();
            carritodao.update(carrito);
        }else{
            System.out.println("No existe");
        }
    }

    public void eliminarProductoDelCarrito() {
        int carritoId = vistacarrito.buscarCarrito();
        carrito = carritodao.read(carritoId);
        int productoCodigo = vistaproducto.buscarPorcodigo();
        producto = productodao.read(productoCodigo);
        if (carrito != null && producto != null) {
            carrito.eliminarProducto(productoCodigo);
            carritodao.update(carrito);
        }
    }

    public void listarProductosdelCarrito() {
        int carritoID = vistacarrito.buscarCarrito();
        carrito = carritodao.read(carritoID);
        if (carrito != null) {
            List<Producto> productos = carrito.getListaProducto();
            for (Producto producto : productos) {
                System.out.println(producto.getNombre() + " - " + producto.getPrecio());
            }
        }
    }
    
    public void calcularTotalesCarrito() {
        int carritocodigo = vistacarrito.buscarPorcodigo();
        carrito = carritodao.read(carritocodigo);
        if (carrito != null) {
            carrito.calcularTotales();
            carritodao.update(carrito);
        }
    }
    
    public void actualizarCarrito() {
        int cod = vistacarrito.buscarCarrito();
        carrito = carritodao.read(cod);
        if (carrito != null) {
            int cod1 = carrito.getCodigocompra();
            carrito = vistacarrito.actualizar(cod1);
            carritodao.update(carrito);
            System.out.println("Carrito actualizado correctamente");
        }else {
            System.out.println("El cliente no existe");
        }
    }

    public void eliminarCarrito() {
        int codigo1 = vistacarrito.eliminarCarrito();
        carrito = carritodao.read(codigo1);
        if(carrito != null){
            carritodao.delete(codigo1);  
        }else{
            System.out.println("El cliente no existe");
        }
    }
    
    public void buscarCarrito(){
        int coduno= vistacarrito.buscarCarrito();
        carrito = carritodao.read(coduno);
        if (carrito!=null) {
            vistacarrito.mostracar(carrito);
        }else {
            System.out.println("El cliente no existe");
        }
    }
    
    public void buscarClienteEnCarrito() {
        int id = vistacarrito.buscarCarrito();
        carrito = carritodao.read(id);
        if (carrito != null) {
            cliente = carrito.getCliente();
            if (cliente != null) {
                System.out.println("Cliente encontrado: " + cliente.getNombre());
            } else {
                System.out.println("El carrito no tiene cliente asociado.");
            }
        } else {
            System.out.println("El carrito no existe.");
        }
    }


    
    public void buscarProductoEnCarrito() {
        int carri = vistacarrito.buscarCarrito();
        carrito = carritodao.read(carri);
        if (carrito != null) {
            List<Producto> productosCarrito = carrito.getListaProducto();
            for (Producto producto : productosCarrito) {
                int codigoPro = vistaproducto.buscarPorcodigo();
                if (producto.getCodigo()== codigoPro) {
                    System.out.println("Producto encontrado: " + producto.getNombre());
                    return;
                }
            }
        }
        System.out.println("Producto no encontrado.");
    }
}