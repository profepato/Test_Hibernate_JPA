package cl.testHibernate;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLEADO")
public class Empleado implements Serializable{
    
    @Id
    @Column(name = "COD_EMPLEADO")
    private Long codigo;
    
    @Column(name = "NOMBRE")
    private String nombre;
    
    @Column(name = "APELLIDOS")
    private String apellidos;
    
    @Column(name = "FECHA_NACIMIENTO")
    private LocalDate fechaNacimiento;
    
    // cascade = CascadeType.ALL, para que cuando se cree una direccion
    // se cree inmediatamente sin necesidad de crearla por separado.
    // o sea si llamo a setDireccion(new Direccion...), JPA persiste por mi
    // el objeto Direccion
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_DIRECCION")
    private Direccion direccion;
    
    public Empleado(){}

    public Empleado(Long codigo, String nombre, String apellidos, LocalDate fechaNacimiento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    
    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Empleado{" + "codigo=" + codigo + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento=" + fechaNacimiento + ", direccion=" + direccion + '}';
    }
}
