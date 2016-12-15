/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import model.Nivel;
import java.util.List;
import model.Departamento;
import model.Usuario;

/**
 *
 * @author GERMAN
 */
public interface UsuarioDao {
    public Usuario findByUsuario(Usuario usuario);
    public Usuario login(Usuario usuario);
    public List<Usuario> findAll();
    public List<Usuario> selecItems(Integer codigo);
    public boolean create(Usuario usuario);
    public boolean update(Usuario usuario);
    public boolean delete(Integer id);

    
}
