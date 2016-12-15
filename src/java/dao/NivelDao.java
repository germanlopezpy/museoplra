package dao;

import java.util.List;
import model.Nivel;

public interface NivelDao {
    public Nivel findByNivel(Nivel nivel);
    public List<Nivel> findAll();
    public List<Nivel> selecItems();
    public boolean create(Nivel nivel);
    public boolean update(Nivel nivel);
    public boolean delete(Integer id);

}
