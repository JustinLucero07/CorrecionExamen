/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.justin.mateo.lucero.reyes.idao;

import ec.edu.ups.justin.mateo.lucero.reyes.modelo.Cliente;
import java.util.List;

/**
 *
 * @author ESTUDIANTE
 */
public interface IClienteDAO {
    public void create(Cliente cliente);
    public Cliente read(String cedula);
    public void update(Cliente  cliente);
    public void delete(String cedula);
    public List<Cliente> finAll();
    
}
