package cl.testHibernate.ejemplo1;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    private static EntityManagerFactory emf;
    private static EntityManager manager;

    public static void main(String[] args) {
        // <persistence-unit name="aplicacion"> --> persistence.xml
        emf = Persistence.createEntityManagerFactory("aplicacion");
        manager = emf.createEntityManager();

        Empleado empleado_1 = new Empleado(
                1L,
                "Pato",
                "Pérez Pinto",
                LocalDate.of(1988, Month.SEPTEMBER, 7)
        );
        
        Empleado empleado_2 = new Empleado(
                2L,
                "Julia",
                "Muñoz Ampuero",
                LocalDate.of(1987, Month.MAY, 25)
        );
        
        
        /*
        Como añadí esto @OneToOne(cascade = CascadeType.ALL) al atributo direccion
        de Empleado, no es necesario crear las direcciones antes del empleado
        */
//        Direccion direccion_1 = new Direccion(1L, "Calle falsa 123", "Springfield", "Springfield", "EEUU");
//        Direccion direccion_2 = new Direccion(2L, "Villa Florencia", "Rancagua", "Rancagua", "Chile");
//        
//        crear(direccion_1);
//        crear(direccion_2);
//        empleado_1.setDireccion(direccion_1);
//        empleado_1.setDireccion(direccion_2);
        
        empleado_1.setDireccion(new Direccion(1L, "Calle falsa 123", "Springfield", "Springfield", "EEUU"));
        empleado_2.setDireccion(new Direccion(2L, "Villa Florencia", "Rancagua", "Rancagua", "Chile"));

        crear(empleado_1);
        crear(empleado_2);
        
        imprimirTodo();
        
//        // encuentra un empleado por identificador
//        // si no lo encuentra es null
//        Empleado e = manager.find(Empleado.class, 1L);
//        // el apellido se cambia inmediatamente porque 
//        // esa entidad es managed
//        e.setApellidos("Otro");
//        imprimirTodo();
        
//        eliminar(1L);
//        
//        imprimirTodo();
//        
        
        manager.close();
    }
    
    private static void eliminar(Long id){
        manager.getTransaction().begin();
        
        Empleado e = manager.find(Empleado.class, id);
        manager.remove(e);
        
        manager.getTransaction().commit();
    }

    private static void crear(Object o){
        manager.getTransaction().begin();
        manager.persist(o);
        // Cambia el apellido de la entidad, incluso despues de persistirlo
        // ya que es una entidad "managed"
//        empleado.setApellidos("Otro apellido");
        manager.getTransaction().commit();
    }
    
    private static void imprimirTodo() {
        List<Empleado> empleados;
        empleados = (List<Empleado>) manager.createQuery("FROM Empleado").getResultList();

        System.out.println("Existen " + empleados.size() + " empleados");
        empleados.forEach((empleado) -> {
            System.out.println(empleado);
        });
    }
}
