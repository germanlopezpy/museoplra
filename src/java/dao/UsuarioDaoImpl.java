package dao;

import java.util.List;
import model.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class UsuarioDaoImpl implements UsuarioDao {

    @Override
    public Usuario findByUsuario(Usuario usuario) {
        Usuario model = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String sql = "from Usuario u left join fetch u.nivel where u.usuario = '" + usuario.getUsuario() + "'";
        Transaction tx = sesion.beginTransaction();
        try {
            model = (Usuario) sesion.createQuery(sql).uniqueResult();
            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        }

        return model;
    }

    @Override
    public Usuario login(Usuario usuario) {
        Usuario model = this.findByUsuario(usuario);
        if (model != null) {
            if (usuario.getPassword().equals(model.getPassword())) {
                return model;
            } else {
                return null;
            }
        }
        return model;

    }

    @Override
    public List<Usuario> selecItems(Integer codigo) {
        List<Usuario> listado = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String sql;
        Transaction tx = sesion.beginTransaction();
        

        if (codigo == 0) {
            sql = "from Usuario";

        } else {
            sql = "from Usuario u left join fetch u.nivel n where n.IdNivel = " + codigo;
        }
            
        try {
            
            listado = sesion.createQuery(sql).list();
            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        }
        
        return listado;
    }

    @Override
    public List<Usuario> findAll() {
        List<Usuario> listado = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String sql = "from Usuario u left join fetch u.nivel";
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
    public boolean create(Usuario usuario) {
        boolean flag;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        try {
            sesion.save(usuario);
            tx.commit();
            flag = true;

        } catch (Exception e) {
            flag = false;
            tx.rollback();
        }

        return flag;
    }

    @Override
    public boolean update(Usuario usuario) {
        boolean flag;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        try {
            Usuario usuariodb = (Usuario) sesion.load(Usuario.class, usuario.getIdUsuario());
            usuariodb.setTitular(usuario.getTitular());
            usuariodb.setPassword(usuario.getPassword());
            usuariodb.setNivel(usuario.getNivel());
            sesion.update(usuariodb);
            tx.commit();
            flag = true;

        } catch (Exception e) {
            flag = false;
            tx.rollback();
        }

        return flag;
    }

    @Override
    public boolean delete(Integer id) {
        boolean flag;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        try {
            Usuario usuario = (Usuario) sesion.load(Usuario.class, id);
            sesion.delete(usuario);
            tx.commit();
            flag = true;

        } catch (Exception e) {
            flag = false;
            tx.rollback();
        }

        return flag;

    }

}
