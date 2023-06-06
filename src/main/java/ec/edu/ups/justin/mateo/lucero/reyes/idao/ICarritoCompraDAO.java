/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.justin.mateo.lucero.reyes.idao;

import ec.edu.ups.justin.mateo.lucero.reyes.modelo.CarritoCompra;
import java.util.List;

/**
 *
 * @author ESTUDIANTE
 */
public interface ICarritoCompraDAO {
    public void create(CarritoCompra carrito);
    public CarritoCompra read(int codigocompra);
    public void update(CarritoCompra carrito);
    public void delete(int codigocompra);
    public List<CarritoCompra> finAll();
}
