package model;
// Generated 14/12/2016 11:35:20 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Personas generated by hbm2java
 */
@Entity
@Table(name="personas"
    ,catalog="museoplra"
)
public class Personas  implements java.io.Serializable {


     private Integer idPers;
     private Barrio barrio;
     private String nombre;
     private String apellido;
     private String ci;
     private Date fechanac;
     private String direccion;
     private String profesion;
     private String genero;
     private String telefono;
     private String internas;
     private String general;
     private String tipo;

    public Personas() {
    }

	
    public Personas(Barrio barrio, String nombre, String apellido, String ci, Date fechanac, String direccion, String genero, String telefono, String tipo) {
        this.barrio = barrio;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ci = ci;
        this.fechanac = fechanac;
        this.direccion = direccion;
        this.genero = genero;
        this.telefono = telefono;
        this.tipo = tipo;
    }
    public Personas(Barrio barrio, String nombre, String apellido, String ci, Date fechanac, String direccion, String profesion, String genero, String telefono, String internas, String general, String tipo) {
       this.barrio = barrio;
       this.nombre = nombre;
       this.apellido = apellido;
       this.ci = ci;
       this.fechanac = fechanac;
       this.direccion = direccion;
       this.profesion = profesion;
       this.genero = genero;
       this.telefono = telefono;
       this.internas = internas;
       this.general = general;
       this.tipo = tipo;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idPers", unique=true, nullable=false)
    public Integer getIdPers() {
        return this.idPers;
    }
    
    public void setIdPers(Integer idPers) {
        this.idPers = idPers;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Barrio_idBarrio", nullable=false)
    public Barrio getBarrio() {
        return this.barrio;
    }
    
    public void setBarrio(Barrio barrio) {
        this.barrio = barrio;
    }

    
    @Column(name="nombre", nullable=false, length=45)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="apellido", nullable=false, length=45)
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    
    @Column(name="ci", nullable=false, length=45)
    public String getCi() {
        return this.ci;
    }
    
    public void setCi(String ci) {
        this.ci = ci;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fechanac", nullable=false, length=10)
    public Date getFechanac() {
        return this.fechanac;
    }
    
    public void setFechanac(Date fechanac) {
        this.fechanac = fechanac;
    }

    
    @Column(name="direccion", nullable=false, length=45)
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
    @Column(name="profesion", length=45)
    public String getProfesion() {
        return this.profesion;
    }
    
    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    
    @Column(name="genero", nullable=false, length=45)
    public String getGenero() {
        return this.genero;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }

    
    @Column(name="telefono", nullable=false, length=45)
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
    @Column(name="internas", length=45)
    public String getInternas() {
        return this.internas;
    }
    
    public void setInternas(String internas) {
        this.internas = internas;
    }

    
    @Column(name="general", length=45)
    public String getGeneral() {
        return this.general;
    }
    
    public void setGeneral(String general) {
        this.general = general;
    }

    
    @Column(name="tipo", nullable=false, length=45)
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }




}


