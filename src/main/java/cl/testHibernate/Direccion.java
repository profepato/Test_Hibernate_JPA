package cl.testHibernate;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DIRECCION")
public class Direccion implements Serializable{
    @Id
    @Column(name = "ID_DIRECCION")
    private Long id;
    
    @Column(name = "DIRECCION")
    private String direccion;
    
    @Column(name = "LOCALIDAD")
    private String localidad;
    
    @Column(name = "PROVINCIA")
    private String provincia;
    
    @Column(name = "PAIS")
    private String pais;

    public Direccion() {
    }

    public Direccion(Long id, String direccion, String localidad, String provincia, String pais) {
        this.id = id;
        this.direccion = direccion;
        this.localidad = localidad;
        this.provincia = provincia;
        this.pais = pais;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Direccion{" + "id=" + id + ", direccion=" + direccion + ", localidad=" + localidad + ", provincia=" + provincia + ", pais=" + pais + '}';
    }
    
    
}
