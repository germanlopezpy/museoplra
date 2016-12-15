/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.UsuarioDao;
import dao.UsuarioDaoImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;
import model.Usuario;
import org.primefaces.context.RequestContext;
import util.MyUtil;

/**
 *
 * @author KARL
 */
@Named(value = "loginBean")
@SessionScoped
public class loginBean implements Serializable {

    private Usuario usuario;
    private UsuarioDao usuarioDao;

    public loginBean() {
        this.usuarioDao = new UsuarioDaoImpl();
        if (this.usuario == null) {
            this.usuario = new Usuario();
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void login(ActionEvent actionEvent) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg;
        boolean loggedIn;
        String ruta = "";
        this.usuario = this.usuarioDao.login(this.usuario);
        if (this.usuario != null) {
            loggedIn = true;
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.usuario.getUsuario());
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            Map<String, Object> sessionMap = externalContext.getSessionMap();
            sessionMap.put("userLog", this.usuario);
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Bienvenido", this.usuario.getTitular());
            ruta = MyUtil.basepathlogin() + "inicio.xhtml";

        } else {
            loggedIn = false;
            this.usuario = new Usuario();
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Datos Incorrectos");
            if (this.usuario == null) {
                this.usuario = new Usuario();
            }

        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam("loggedIn", loggedIn);
        context.addCallbackParam("ruta", ruta);
    }

   
    public void logout() {
        String ruta = MyUtil.basepathlogin() + "login.xhtml";
        FacesContext facesContext = FacesContext.getCurrentInstance();
        RequestContext context = RequestContext.getCurrentInstance();

        HttpSession sesion = (HttpSession) facesContext.getExternalContext().getSession(false);
        sesion.invalidate();

        context.addCallbackParam("loggetOut", true);
        context.addCallbackParam("ruta", ruta);
    }
}
