/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.justin.mateo.lucero.reyes.dao;

import ec.edu.ups.justin.mateo.lucero.reyes.idao.ICarritoCompraDAO;
import ec.edu.ups.justin.mateo.lucero.reyes.modelo.CarritoCompra;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ESTUDIANTE
 */
public class CarritoCompraDAO implements ICarritoCompraDAO{
    
    private List<CarritoCompra> listaCarrito;

    public CarritoCompraDAO() {
        listaCarrito = new ArrayList<>();
    }
    
    

    @Override
    public void create(CarritoCompra carrito) {
        listaCarrito.add(carrito);
    }

    @Override
    public CarritoCompra read(int codigocompra) {
        for (CarritoCompra carritoCompra : listaCarrito) {
            if(carritoCompra.getCodigocompra() == codigocompra){
                return carritoCompra;
            }
        }
        return null;
    }

    @Override
    public void update(CarritoCompra carrito) {
        for (int i = 0; i < listaCarrito.size(); i++) {
            CarritoCompra ca = listaCarrito.get(i);
            if(ca.getCodigocompra() == carrito.getCodigocompra()){
                listaCarrito.set(i, carrito);
                break;
            }
        }
    }

    @Override
    public void delete(int codigocompra) {
        Iterator<CarritoCompra> it = listaCarrito.iterator();
        while(it.hasNext()){
            CarritoCompra ca = it.next();
            if(ca.getCodigocompra() == codigocompra){
                it.remove();
            }
        }
    }

    @Override
    public List<CarritoCompra> finAll() {
        return listaCarrito;
    }
    
}
