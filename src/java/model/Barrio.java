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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Barrio generated by hbm2java
 */
@Entity
@Table(name="barrio"
    ,catalog="museoplra"
)
public class Barrio  implements java.io.Serializable {


     private Integer idBarrio;
     private Compania compania;
     private String nombrebarrio;
     private Set personases = new HashSet(0);

    public Barrio() {
    }

	
    public Barrio(Compania compania, String nombrebarrio) {
        this.compania = compania;
        this.nombrebarrio = nombrebarrio;
    }
    public Barrio(Compania compania, String nombrebarrio, Set personases) {
       this.compania = compania;
       this.nombrebarrio = nombrebarrio;
       this.personases = personases;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idBarrio", unique=true, nullable=false)
    public Integer getIdBarrio() {
        return this.idBarrio;
    }
    
    public void setIdBarrio(Integer idBarrio) {
        this.idBarrio = idBarrio;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Compania_idComp", nullable=false)
    public Compania getCompania() {
        return this.compania;
    }
    
    public void setCompania(Compania compania) {
        this.compania = compania;
    }

    
    @Column(name="nombrebarrio", nullable=false, length=45)
    public String getNombrebarrio() {
        return this.nombrebarrio;
    }
    
    public void setNombrebarrio(String nombrebarrio) {
        this.nombrebarrio = nombrebarrio;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="barrio")
    public Set getPersonases() {
        return this.personases;
    }
    
    public void setPersonases(Set personases) {
        this.personases = personases;
    }




}


