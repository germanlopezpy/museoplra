/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.NivelDao;
import dao.NivelDaoImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import model.Nivel;
import model.Usuario;

/**
 *
 * @author KARL
 */
@Named(value = "mostrarBean")
@SessionScoped
public class mostrarBean implements Serializable {

    private Usuario usuario;
    private List<Nivel> lista;
    private Boolean mostrarBotones;
    private Boolean mostrarMenuSgp;
    private Boolean mostrarMenuAdmin;
    private Integer idNivel;

    public mostrarBean() {
        
        usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userLog");
        idNivel = usuario.getNivel().getIdNivel();
        if (idNivel == 1) {
            mostrarBotones = true;
            mostrarMenuSgp = false;
            mostrarMenuAdmin = true;
           
        } else {
            mostrarBotones = true;
            mostrarMenuSgp = true;
            mostrarMenuAdmin = false;
            
        }
    }

    public List<Nivel> getLista() {
      this.lista = new ArrayList<Nivel>();
      NivelDao nivelDao = new NivelDaoImpl();
      List<Nivel> niveles= nivelDao.selecItems();
        for (Nivel nivel:niveles){
            SelectItem selectItem = new SelectItem(nivel.getTipo());
            this.lista.add(nivel);
        }
        
        return lista;
    }
        

    public void setLista(List<Nivel> lista) {
        this.lista = lista;
    }
    
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Boolean getMostrarBotones() {
        return mostrarBotones;
    }

    public Boolean getMostrarMenuSgp() {
        return mostrarMenuSgp;
    }

    public Boolean getMostrarMenuAdmin() {
        return mostrarMenuAdmin;
    }

    public void setMostrarBotones(Boolean mostrarBotones) {
        this.mostrarBotones = mostrarBotones;
    }

    public void setMostrarMenuSgp(Boolean mostrarMenuSgp) {
        this.mostrarMenuSgp = mostrarMenuSgp;
    }

    public void setMostrarMenuAdmin(Boolean mostrarMenuAdmin) {
        this.mostrarMenuAdmin = mostrarMenuAdmin;
    }

    public String bntMostrarAdmin() {
        this.mostrarMenuSgp = false;
        this.mostrarMenuAdmin = true;
        return "/inicio.xhtml";

    }

    public String bntMostrarSgp() {
        this.mostrarMenuSgp = true;
        this.mostrarMenuAdmin = false;
        return "/inicio.xhtml";
    }

   
}
