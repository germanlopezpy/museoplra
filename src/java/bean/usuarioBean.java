/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.UsuarioDao;
import dao.UsuarioDaoImpl;
import dao.UsuarioDao;
import dao.UsuarioDaoImpl;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import model.Usuario;
import model.Usuario;

@Named(value = "usuarioBean")
@RequestScoped

public class usuarioBean {

    private List<Usuario> usuarios;
    private Usuario selectedUsuario;
    private List<SelectItem> selectOneItemsUsuario;
    private String contraActual;
    private String contra1;
    private String contra2;
    private List<Usuario> vendedores;
  

    public usuarioBean() {
        this.usuarios = new ArrayList<Usuario>();
        this.vendedores = new ArrayList<Usuario>();
        this.selectedUsuario = new Usuario();
        
    }

    public List<SelectItem> getSelectOneItemsUsuario(Integer codigo) {
        this.selectOneItemsUsuario = new ArrayList<SelectItem>();
        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        List<Usuario> usuarios = usuarioDao.selecItems(codigo);
        for (Usuario usuario : usuarios) {
            SelectItem selectItem = new SelectItem(usuario.getIdUsuario(), usuario.getTitular());
            this.selectOneItemsUsuario.add(selectItem);

        }

        return selectOneItemsUsuario;
    }
    

    public void setVendedores(List<Usuario> vendedores) {
        this.vendedores = vendedores;
    }

    public List<Usuario> getVendedores(Integer codigo) {
        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        this.vendedores = usuarioDao.selecItems(codigo);
        return vendedores;
    }

    public String getContraActual() {
        return contraActual;
    }

    public String getContra1() {
        return contra1;
    }

    public String getContra2() {
        return contra2;
    }

    public void setContraActual(String contraActual) {
        this.contraActual = contraActual;
    }

    public void setContra1(String contra1) {
        this.contra1 = contra1;
    }

    public void setContra2(String contra2) {
        this.contra2 = contra2;
    }

    public void btnCambiarContra(ActionEvent actionEvent) {

        FacesMessage msg;
        //cargamos el actual
        this.selectedUsuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userLog");
        //comparar en BD

        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        this.selectedUsuario.setPassword(this.contraActual);
        this.selectedUsuario = usuarioDao.login(this.selectedUsuario);

        if (this.selectedUsuario != null) {
            //comparar en aplicacion contra
            if (this.contraActual.equals(this.contra1)) {
                msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "La contaseña nueva no puede ser igual a la actual");
            } else {
                if (!this.contra1.equals(this.contra2)) {
                    msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Las contraseñas no coinciden");
                } else {
                    this.selectedUsuario.setPassword(this.contra1);
                    if (usuarioDao.update(this.selectedUsuario)) {
                        msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", "Contraseña cambiada");
                        this.contraActual = "";
                        this.contra1 = "";
                        this.contra2 = "";
                    } else {
                        msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al cambiar el registro");
                    }
                }
            }
        } else {

            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Contraseña actual incorrecta");

            if (this.selectedUsuario == null) {
                this.selectedUsuario = new Usuario();
            }
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public List<Usuario> getUsuarios() {
        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        this.usuarios = usuarioDao.findAll();
        return usuarios;
    }

    public Usuario getSelectedUsuario() {
        return selectedUsuario;
    }

    public void setSelectedUsuario(Usuario selectedUsuario) {
        this.selectedUsuario = selectedUsuario;
    }

    public void btnCreateUsuario(ActionEvent actionEvent) {
        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        String msg;
        String aux;
        String user;
        aux = this.selectedUsuario.getUsuario();
        user = "from Usuario ";
        //this.selectedUsuario.setContra(this.selectedUsuario.getUsuario());
        if (usuarioDao.create(this.selectedUsuario)) {
            msg = "Se Creo correctamente el registro";
        } else {
            msg = "Error al Crear el registro";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void btnUpdateUsuario(ActionEvent actionEvent) {
        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        String msg;
        if (usuarioDao.update(this.selectedUsuario)) {
            msg = "Se Actualizo correctamente el registro";
        } else {
            msg = "Error al Actualizar el registro";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
        FacesContext.getCurrentInstance().addMessage(null, message);

    }

    public void btnDeleteUsuario(ActionEvent actionEvent) {
        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        String msg;
        System.out.println(this.selectedUsuario.getIdUsuario().toString());
        if (usuarioDao.delete(this.selectedUsuario.getIdUsuario())) {
            msg = "Se Elimino correctamente el registro";
        } else {
            msg = "El Usuario posee transacciones";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
        FacesContext.getCurrentInstance().addMessage(null, message);

    }
}
