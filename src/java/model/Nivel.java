package model;
// Generated 14/12/2016 11:35:20 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Nivel generated by hbm2java
 */
@Entity
@Table(name="nivel"
    ,catalog="museoplra"
)
public class Nivel  implements java.io.Serializable {


     private Integer idNivel;
     private String tipo;
     private Set usuarios = new HashSet(0);

    public Nivel() {
      this.idNivel=0;
    }

	
    public Nivel(String tipo) {
        this.tipo = tipo;
    }
    public Nivel(String tipo, Set usuarios) {
       this.tipo = tipo;
       this.usuarios = usuarios;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idNivel", unique=true, nullable=false)
    public Integer getIdNivel() {
        return this.idNivel;
    }
    
    public void setIdNivel(Integer idNivel) {
        this.idNivel = idNivel;
    }

    
    @Column(name="Tipo", nullable=false, length=45)
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="nivel")
    public Set getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set usuarios) {
        this.usuarios = usuarios;
    }




}


