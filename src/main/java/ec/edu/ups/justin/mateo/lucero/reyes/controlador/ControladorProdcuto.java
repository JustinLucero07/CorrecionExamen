/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.justin.mateo.lucero.reyes.controlador;

import ec.edu.ups.justin.mateo.lucero.reyes.dao.ProductoDAO;
import ec.edu.ups.justin.mateo.lucero.reyes.idao.IProductoDAO;
import ec.edu.ups.justin.mateo.lucero.reyes.modelo.Producto;
import ec.edu.ups.justin.mateo.lucero.reyes.modelo.vista.VistaProducto;
import java.util.List;

/**
 *
 * @author ESTUDIANTE
 */
public class ControladorProdcuto {
    private Producto producto;
    private IProductoDAO productodao;
    private VistaProducto vistaproducto;

    public ControladorProdcuto(Producto producto, IProductoDAO productodao, VistaProducto vistaproducto) {
        this.producto = producto;
        this.productodao = productodao;
        this.vistaproducto = vistaproducto;
    }

    
    public void ingresarProducto(){
        producto = vistaproducto.ingresarProducto();
        productodao.create(producto);
    }
    
    public void eliminar(){
        Producto pro = vistaproducto.eliminarProducto();
        productodao.update(pro);
    }

    public void listarProductos(){
        productodao.finAll();
    }
    
    public void mostrarProductos(){
        vistaproducto.mostraProductos(productodao.finAll());
    }
    
    public void buscarProducto(){
        int codigo = vistaproducto.buscarPorcodigo();
        Producto pro = productodao.read(codigo);
        if (pro!=null) {
            vistaproducto.mostraProduto(pro);
        }else {
            System.out.println("El prodcuto no existe");
        }
    }
    
    public void eliminarProducto(){
        int eli = vistaproducto.eliminarProduct();
        producto = productodao.read(eli);
        if (producto!=null) {
            productodao.delete(producto);
        }else {
            System.out.println("El producto no exite");
        }
    }
    
    public void verProducto(){
        int codigo = vistaproducto.buscarPorcodigo();
        producto = productodao.read(codigo);
        vistaproducto.mostraProduto(producto);
        
    }
    
    public void actualizarProducto() {
        int codigo = vistaproducto.buscarPorcodigo();
        producto = productodao.read(codigo);
        if (producto != null) {
            Producto productoActualizado = vistaproducto.actualizarProducto(producto.getCodigo());
            productodao.update(productoActualizado);
            System.out.println("Producto actualizado correctamente.");
        } else {
            System.out.println("El producto no existe");
        }
    }
}
