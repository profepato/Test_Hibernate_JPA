package cl.testHibernate.ejemplo1;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
    
    // Uno a Uno inverso, direccion es el nombre del atributo en la clase
    // Empleado
    // Fetch LAZY quiere decir que a menos que se llame a getEmpleado
    // no se llama a la base de datos
    @OneToOne(mappedBy = "direccion", fetch = FetchType.LAZY)
    private Empleado empleado;

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

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
        return "Direccion{" + "id=" + id + ", direccion=" + direccion + ", localidad=" + localidad + ", provincia=" + provincia + ", pais=" + pais + ", empleado=" + empleado.getCodigo() + '}';
    }
    
    
}
