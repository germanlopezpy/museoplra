
package dao;

import java.util.List;
import model.Departamento;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;


public class DepartamentoDaoImpl implements DepartamentoDao {

    

       @Override
    public Departamento findByDepartamento(Departamento departamento) {
        Departamento model = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String sql = "from Departamento where iddep = '" + departamento.getIdDep() + "'" ;
       Transaction tx = sesion.beginTransaction();
        try {
            model = (Departamento) sesion.createQuery(sql).uniqueResult();
            tx.commit();


        } catch (Exception e) {
            tx.rollback();
        }

        return model;
    }


    @Override
    public List<Departamento> selecItems() {
        List<Departamento> listado = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String sql = "from Departamento";
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
    public boolean create(Departamento departamento) {
        boolean flag ;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        try {
            
            sesion.save(departamento);
            tx.commit();
            flag= true;

        } catch (Exception e) {
            flag=false;
            tx.rollback();
        }

        return flag;
    }

    @Override
    public boolean update(Departamento departamento) {
        boolean flag ;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        try {
            
            sesion.update(departamento);
            tx.commit();
            flag= true;

        } catch (Exception e) {
            flag=false;
            tx.rollback();
        }

        return flag;
    }

    @Override
    public boolean delete(Integer idDep) {
        boolean flag ;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        try {
            
            Departamento departamento = (Departamento) sesion.load(Departamento.class,idDep);
            sesion.delete(departamento);
            tx.commit();
            flag= true;

        } catch (Exception e) {
            flag=false;
            tx.rollback();
        }

        return flag;

    }

   @Override
    public List<Departamento> findAll() {
        List<Departamento> listado = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String sql = "from Departamento";
        try {
            sesion.beginTransaction();
            listado = sesion.createQuery(sql).list();
            sesion.beginTransaction().commit();


        } catch (Exception e) {
            sesion.beginTransaction().rollback();
        }

        return listado;
    }

    
  

   
}
