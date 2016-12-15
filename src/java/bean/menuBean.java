
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import model.Usuario;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@Named(value = "menuBean")
@RequestScoped
public class menuBean {

    private MenuModel model;
    private Usuario usuario;
    private Integer idNivel;

    public menuBean() {
        usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userLog");
        idNivel = usuario.getNivel().getIdNivel();

        model = new DefaultMenuModel();

        DefaultMenuItem item;
        //First submenu

        if (idNivel == 1) {

            DefaultSubMenu secondSubmenu = new DefaultSubMenu("Administrar");

            item = new DefaultMenuItem("Departamento");
            item.setIcon("ui-icon-folder-open");

            secondSubmenu.addElement(item);

            model.addElement(secondSubmenu);

            DefaultSubMenu cSubmenu = new DefaultSubMenu("Procesos");
            item = new DefaultMenuItem("Distrito");
            item.setIcon("ui-icon-folder-open");

            secondSubmenu.addElement(item);

            model.addElement(cSubmenu);

        }

        if (idNivel == 2) {

            DefaultSubMenu secondSubmenu = new DefaultSubMenu("Mantenimiento");

            item = new DefaultMenuItem("Departamento");
            item.setIcon("ui-icon-folder-open");
            secondSubmenu.addElement(item);

            model.addElement(secondSubmenu);

            DefaultSubMenu cSubmenu = new DefaultSubMenu("Procesos");

            model.addElement(cSubmenu);
        }

        if (idNivel == 3) {

            DefaultSubMenu cSubmenu = new DefaultSubMenu("Procesos");

            item = new DefaultMenuItem("Pedidos");
            item.setIcon("ui-icon-tag");
            cSubmenu.addElement(item);

            model.addElement(cSubmenu);
        }

    }

    public MenuModel getModel() {
        return model;
    }
}
