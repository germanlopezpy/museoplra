package dao;

import java.util.List;
import model.Nivel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class NivelDaoImpl implements NivelDao {

    @Override
    public Nivel findByNivel(Nivel nivel) {
        Nivel model = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String sql = "from Nivel where tipo = '" + nivel.getTipo() + "'";
        Transaction tx = sesion.beginTransaction();
        try {
          
            model = (Nivel) sesion.createQuery(sql).uniqueResult();
            tx.commit();


        } catch (Exception e) {
            tx.rollback();
        }

        return model;
    }

   

    @Override
    public List<Nivel> findAll() {
        List<Nivel> listado = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String sql = "from Nivel order by idNivel desc ";
        Transaction tx = sesion.beginTransaction();
        try {
            
            listado = sesion.createQuery(sql).list();
            tx.commit();


        } catch (Exception e) {
            tx.rollback();
        }

        return listado;
    }

    @Override
    public List<Nivel> selecItems() {
        List<Nivel> listado = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String sql = "from Nivel";
        Transaction tx = sesion.beginTransaction();
        try {
            
            listado = sesion.createQuery(sql).list();
            tx.commit();


        } catch (Exception e) {
           tx.rollback();
        }

        return listado;
    }

    @Override
    public boolean create(Nivel nivel) {
        boolean flag;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        try {
            
            sesion.save(nivel);
            tx.commit();
            flag = true;

        } catch (Exception e) {
            flag = false;
            tx.rollback();
        }

        return flag;
    }

    @Override
    public boolean update(Nivel nivel) {
        boolean flag;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        try {
            
            sesion.update(nivel);
            tx.commit();
            flag = true;

        } catch (Exception e) {
            flag = false;
            tx.rollback();
        }

        return flag;
    }

    @Override
    public boolean delete(Integer idNivel) {
        boolean flag;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        try {
            
            Nivel nivel = (Nivel) sesion.load(Nivel.class, idNivel);
            sesion.delete(nivel);
            tx.commit();
            flag = true;

        } catch (Exception e) {
            flag = false;
            tx.rollback();
        }

        return flag;

    }
}
