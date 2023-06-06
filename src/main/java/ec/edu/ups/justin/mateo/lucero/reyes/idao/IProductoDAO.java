/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.justin.mateo.lucero.reyes.idao;

import ec.edu.ups.justin.mateo.lucero.reyes.modelo.Producto;
import java.util.List;

/**
 *
 * @author ESTUDIANTE
 */
public interface IProductoDAO {
    public void create(Producto producto);
    public Producto read(int codigo);
    public void update(Producto producto);
    public void delete(Producto producto);
    public List<Producto> finAll();
}
