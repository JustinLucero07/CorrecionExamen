/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.justin.mateo.lucero.reyes.dao;

import ec.edu.ups.justin.mateo.lucero.reyes.idao.IClienteDAO;
import ec.edu.ups.justin.mateo.lucero.reyes.modelo.Cliente;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ESTUDIANTE
 */
public class ClienteDAO implements IClienteDAO{

    private List<Cliente> listaClientes;

    public ClienteDAO() {
        listaClientes = new ArrayList<>();
    }
    
    
    
    @Override
    public void create(Cliente cliente) {
        listaClientes.add(cliente);
    }

    @Override
    public Cliente read(String cedula) {
        for (Cliente cliente : listaClientes) {
            if(cliente.getCedula().equals(cedula)){
                return cliente;
            }
        }
        return null;
    }

    @Override
    public void update(Cliente cliente) {
        for (int i = 0; i < listaClientes.size(); i++) {
            Cliente c = listaClientes.get(i);
            if(c.getCedula().equals(cliente.getCedula())){
                listaClientes.set(i, cliente);
                break;
            }
        }
    }

    @Override
    public void delete(String cedula) {
        Iterator<Cliente> it = listaClientes.iterator();
        while(it.hasNext()){
            Cliente c = it.next();
            if(c.getCedula().equals(cedula)){
                it.remove();
            }
        }
    }

    @Override
    public List<Cliente> finAll() {
        return listaClientes;
    }
    
}
