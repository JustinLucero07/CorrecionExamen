/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.justin.mateo.lucero.reyes.controlador;

import ec.edu.ups.justin.mateo.lucero.reyes.dao.ClienteDAO;
import ec.edu.ups.justin.mateo.lucero.reyes.idao.IClienteDAO;
import ec.edu.ups.justin.mateo.lucero.reyes.modelo.Cliente;
import ec.edu.ups.justin.mateo.lucero.reyes.modelo.Producto;
import ec.edu.ups.justin.mateo.lucero.reyes.modelo.vista.VistaCliente;

/**
 *
 * @author ESTUDIANTE
 */
public class ControladorCliente {
    
    private IClienteDAO clientedao;
    private VistaCliente vistacliente;
    private Cliente cliente;

    public ControladorCliente(IClienteDAO clientedao, VistaCliente vistacliente, Cliente cliente) {
        this.clientedao = clientedao;
        this.vistacliente = vistacliente;
        this.cliente = cliente;
    }

    public void ingresarCliente(){
        cliente = vistacliente.ingresarCliente();
        clientedao.create(cliente);
    }
    
    public void mostraCleintes(){
        vistacliente.mostrClientes(clientedao.finAll());
    }
    
    public void actualizarCliente() {
        String cedula = vistacliente.buscarCliente();
        cliente = clientedao.read(cedula);
        if (cliente != null) {
            Cliente clienteActualizado = vistacliente.actualizarCliente(cliente.getCedula());
            clientedao.update(clienteActualizado);
            System.out.println("Cliente actualizado correctamente.");
        } else {
            System.out.println("El cliente no existe");
        }
    }
    
    public void eliminarCliente() {
        String cedula = vistacliente.eliminarCliente();
        cliente = clientedao.read(cedula);
        if(cliente != null){
            clientedao.delete(cedula);  
        }else{
            System.out.println("El cliente no existe");
        }
    }
    
    public void buscarCliente(){
        String cedula = vistacliente.buscarCliente();
        cliente= clientedao.read(cedula);
        if (cliente!=null) {
            vistacliente.mostrarCliente(cliente);
        }else {
            System.out.println("El cliente no existe");
        }
    }
}
