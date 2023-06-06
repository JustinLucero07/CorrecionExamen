/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.justin.mateo.lucero.reyes.dao;

import ec.edu.ups.justin.mateo.lucero.reyes.idao.IProductoDAO;
import ec.edu.ups.justin.mateo.lucero.reyes.modelo.Producto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ESTUDIANTE
 */
public class ProductoDAO implements IProductoDAO{

    private List<Producto> listadeProductos;

    public ProductoDAO() {
        listadeProductos = new ArrayList<>();
    }
    
    
    
    @Override
    public void create(Producto producto) {
        listadeProductos.add(producto);
    }

    @Override
    public Producto read(int codigo) {
        for (Producto producto : listadeProductos) {
            if(producto.getCodigo() == codigo)
                return producto;
        }
        return null;
    }

    @Override
    public void update(Producto producto) {
        for (int i = 0; i < listadeProductos.size(); i++) {
            Producto p = listadeProductos.get(i);
            if(p.getCodigo()== producto.getCodigo()){
                listadeProductos.set(i, producto);
                break;
            }
        }
    }

    @Override
    public void delete(Producto producto) {
        Iterator<Producto> it = listadeProductos.iterator();
        while(it.hasNext()){
            Producto p = it.next();
            if(p.getCodigo() == producto.getCodigo()){
                it.remove();
            }
        }
    }

    @Override
    public List<Producto> finAll() {
       return listadeProductos;
    }
    
}
