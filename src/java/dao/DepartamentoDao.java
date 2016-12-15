package dao;

import java.util.List;
import model.Departamento;

public interface DepartamentoDao {
    public Departamento findByDepartamento(Departamento departamento);
    public List<Departamento> findAll();
    public List<Departamento> selecItems();
    public boolean create(Departamento departamento);
    public boolean update(Departamento departamento);
    public boolean delete(Integer id);
}
