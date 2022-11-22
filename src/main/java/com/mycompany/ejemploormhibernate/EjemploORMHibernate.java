package com.mycompany.ejemploormhibernate;

import java.util.Iterator;
import java.util.List;

/**
 * Ejemplo de la utilizacion de un ORM, en este caso apoyandonos en Hibernate
 * Version de: https://www.h2kinfosys.com/blog/hibernate-program/
 * @author oscar
 */
public class EjemploORMHibernate {  
    
    public static void main(String[] args) {
        
//        Sentencia SQL de creacion de la tabla en la base de datos:
//        create table ejemploormhibernate.CLIENTE (
//        num_cliente INT NOT NULL auto_increment,
//        nombre_cliente VARCHAR(20) default NULL,
//        apellido_cliente  VARCHAR(20) default NULL,
//        email VARCHAR(20)  default NULL,
//        PRIMARY KEY (num_cliente));     
        
        ServicioCliente servicioCliente = new ServicioCliente();
        Integer IDcliente = servicioCliente.nuevoCliente("Amancio", "Ortega", "aortega@zara.com");
        System.out.println("Lista de clientes despues de la creacion del nuevo registro:");
        imprimeListaClientes(servicioCliente.listaClientes());

        servicioCliente.actualizaCliente(IDcliente, "aortega@zara.es");
        System.out.println("Lista de clientes despues de actualizar el registro creado:");
        imprimeListaClientes(servicioCliente.listaClientes());

        servicioCliente.borraCliente(IDcliente);
        System.out.println("Lista de clientes despues de borrar el registro creado:");       
        imprimeListaClientes(servicioCliente.listaClientes());
        
        // Podemos probar que si insertamos valores directamente en la base de datos, tambien se ven en el programa:
        //INSERT into ejemploormhibernate.cliente (nombre_cliente, apellido_cliente,email) values ('Jeff','Bezzos','jeff@amazon.com');
    }
    
    private static void imprimeListaClientes(List clientes) {
        if(!clientes.iterator().hasNext()) {
            System.out.println("La lista esta vacia!");
        }
        for (Iterator iterator = clientes.iterator(); iterator.hasNext();) {
            Cliente cliente = (Cliente) iterator.next();
            System.out.print("Nombre : " + cliente.getNombre());
            System.out.print(" Apellido: " + cliente.getApellido());
            System.out.println(" Email: " + cliente.getEmail());
        }
    }    
}
