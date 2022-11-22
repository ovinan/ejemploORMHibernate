package com.mycompany.ejemploormhibernate;

//import com.fasterxml.classmate.AnnotationConfiguration; // Solo si utilizan anotaciones
import java.util.List;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author oscar
 */
public class ServicioCliente {
    private static SessionFactory factory;

    public ServicioCliente() {
        try {
            // De esta forma, Java busca el fichero de configuracion del mapeo:
            factory = new Configuration().configure().buildSessionFactory();
            // De esta forma, Java busca las anotaciones en la declaracion de la clase:
            //factory = new AnnotationConfiguration().configure().addAnnotatedClass(Cliente.class).buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Fallo al crear el objeto sessionFactory." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public Integer nuevoCliente(String nombre, String apellido, String email) {
        Session session = factory.openSession();
        Transaction transaction = null;
        Integer idCliente = null;

        try {
            transaction = session.beginTransaction();
            Cliente cliente = new Cliente(nombre, apellido, email);
            idCliente = (Integer) session.save(cliente);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return idCliente;
    }

    public List listaClientes() {
        Session session = factory.openSession();
        Transaction transaction = null;
        List clientes = null;
        try {
            transaction = session.beginTransaction();
            clientes = session.createQuery("FROM Cliente").list();
            transaction.commit();
            return clientes;
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return clientes;
    }

    public void actualizaCliente(Integer IDCliente, String email) {
        Session session = factory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Cliente cliente = (Cliente) session.get(Cliente.class, IDCliente);
            cliente.setEmail(email);
            session.update(cliente);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void borraCliente(Integer IDCliente) {
        Session session = factory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Cliente cliente = (Cliente) session.get(Cliente.class, IDCliente);
            session.delete(cliente);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }    
}
