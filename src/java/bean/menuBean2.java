
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

@Named(value = "menuBean2")
@RequestScoped
public class menuBean2 {

    private MenuModel model;
    private Usuario usuario;
    private Integer idNivel;

    public menuBean2() {
        usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userLog");
        idNivel = usuario.getNivel().getIdNivel();
        model = new DefaultMenuModel();




        DefaultMenuItem item;
        //First submenu
        if (idNivel == 1) {


            DefaultSubMenu firstSubmenu = new DefaultSubMenu("Usuarios");
            firstSubmenu.setIcon(("ui-icon-wrench"));


            item = new DefaultMenuItem("Nivel");
            item.setOutcome("/vista/nivel/nivel");
            item.setIcon("ui-icon-wrench");
            firstSubmenu.addElement(item);

            item = new DefaultMenuItem("Usuario");
            item.setOutcome("/vista/usuario/usuario");
            item.setIcon("ui-icon-wrench");
            firstSubmenu.addElement(item);

            item = new DefaultMenuItem("Cambiar Contraseña");
            item.setOutcome("/vista/usuario/cambio_pass");
            item.setIcon("ui-icon-wrench");
            firstSubmenu.addElement(item);

            model.addElement(firstSubmenu);

        }else{

        

            DefaultSubMenu firstSubmenu = new DefaultSubMenu("Usuarios");
            firstSubmenu.setIcon(("ui-icon-wrench"));
            
            item = new DefaultMenuItem("Cambiar Contraseña");
            item.setOutcome("/vista/usuario/cambio_pass");
            item.setIcon("ui-icon-wrench");
            firstSubmenu.addElement(item);

            model.addElement(firstSubmenu);


        }
        
    }
    public MenuModel getModel() {
        return model;
    }
}