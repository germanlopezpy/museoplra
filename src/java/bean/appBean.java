/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;
import util.MyUtil;

/**
 *
 * @author KARL
 */
@Named(value = "appBean")
@ApplicationScoped
public class appBean {

    /**
     * Creates a new instance of appBean
     */
    public appBean() {
    }
    public String getBaseUrl(){
        return MyUtil.baseurl();
    }
     
    public String getBasePath(){
        return MyUtil.basepath();
    }       
}
