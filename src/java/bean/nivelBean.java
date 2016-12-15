
package bean;

import dao.NivelDao;
import dao.NivelDaoImpl;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import model.Nivel;

@Named(value = "nivelBean")
@RequestScoped
public class nivelBean {
    
    private List<Nivel> nivels;  
    private Nivel selectedNivel;  
    private List<SelectItem> selectOneItemsNivel;
   
    public nivelBean() {
        this.nivels = new ArrayList<Nivel>();
        this.selectedNivel = new Nivel();
    }

    public List<SelectItem> getSelectOneItemsNivel() {
        this.selectOneItemsNivel = new ArrayList<SelectItem>();
        NivelDao nivelDao = new NivelDaoImpl();
        List<Nivel> niveles= nivelDao.selecItems();
        for (Nivel nivel:niveles){
            SelectItem selectItem = new SelectItem(nivel.getIdNivel(),nivel.getTipo());
            this.selectOneItemsNivel.add(selectItem);
            
        }
        
        return selectOneItemsNivel;
    }
   
     public List<Nivel> getNivels() {
        NivelDao nivelDao = new NivelDaoImpl();
        this.nivels = nivelDao.findAll();
        return nivels;
    }
     
    public Nivel getSelectedNivel() {
        return selectedNivel;
    }

    public void setSelectedNivel(Nivel selectedNivel) {
        this.selectedNivel = selectedNivel;
    }
 
    public void btnCreateNivel(ActionEvent actionEvent){
       NivelDao nivelDao=new NivelDaoImpl();
       String msg;
      if (nivelDao.create(this.selectedNivel)){
           msg= "Se Creo correctamente el registro";
       } else{
           msg="Error al Crear el registro";
       }
       FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,msg,null);
       FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void btnUpdateNivel(ActionEvent actionEvent){
       NivelDao nivelDao=new NivelDaoImpl();
       String msg;
      if (nivelDao.update(this.selectedNivel)){
           msg= "Se Actualizo correctamente el registro";
       } else{
           msg="Error al actualizar el registro";
       }
       FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,msg,null);
       FacesContext.getCurrentInstance().addMessage(null, message);
      
    }
    public void btnDeleteNivel(ActionEvent actionEvent){
      NivelDao nivelDao=new NivelDaoImpl();
       String msg;
       System.out.println(this.selectedNivel.getIdNivel());
       if (nivelDao.delete(this.selectedNivel.getIdNivel())){
           msg= "Se Elimino correctamente el registro";
       } else{
           msg="El Nivel tiene Usuario/s asignado/s";
       }
       FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,msg,null);
       FacesContext.getCurrentInstance().addMessage(null, message);
        
    }
}
