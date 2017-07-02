package com.samd.dao;

import com.samd.modelo.Usuarios;
import com.samd.persistencia.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class UsuarioDaoImplementacion implements UsuarioDao {

    @Override
    public List listarUsuarios() {

        List usuarios = null;
        Session session = null;

        try {

            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Usuarios");
            usuarios = query.list();

        } catch (HibernateException he) {
            System.out.println(he.getMessage());

        } finally {
            if (session != null) {
                session.close();
            }

        }

        return usuarios;
    }

    @Override
    public void ingresarUsuario(Usuarios usuario) {

        Session session = null;

        try {

            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(usuario);
            session.getTransaction().commit();

        } catch (HibernateException he) {
            System.out.println(he.getMessage());
            session.getTransaction().rollback();

        } finally {
            if (session != null) {
                session.close();
            }

        }
    }

    @Override
    public void modificarUsuario(Usuarios usuario) {

        Session session = null;

        try {

            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(usuario);
            session.getTransaction().commit();

        } catch (HibernateException he) {
            System.out.println(he.getMessage());
            session.getTransaction().rollback();

        } finally {
            if (session != null) {
                session.close();
            }

        }

    }

    @Override
    public void eliminarUsuario(Usuarios usuario) {

        Session session = null;

        try {

            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(usuario);
            session.getTransaction().commit();

        } catch (HibernateException he) {
            System.out.println(he.getMessage());
            session.getTransaction().rollback();

        } finally {
            if (session != null) {
                session.close();
            }

        }

    }

    @Override
    public Usuarios validarUsuario(Usuarios usuario) {

        Usuarios usuarioValidado = null;
        Session session = null;
        String hql;
        Query query;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
    
            hql = "FROM Usuarios WHERE cedula ='" + usuario.getCedula() + "'and contrasenia ='" + usuario.getContrasenia() + "'";
            query = session.createQuery(hql);
           

            if (!query.list().isEmpty()) {
                usuarioValidado = (Usuarios) query.list().get(0);

            }
            

        } catch (HibernateException he) {

            System.out.println(he.getMessage());
            

        } finally {
              session.close();
        }

        return usuarioValidado;
    }

}
