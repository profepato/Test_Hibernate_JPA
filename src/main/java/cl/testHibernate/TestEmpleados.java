package cl.testHibernate;

import java.time.LocalDate;
import java.time.Month;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestEmpleados {

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

        crear(empleado_1);
        crear(empleado_2);
        
        imprimirTodo();
        
        // encuentra un empleado por identificador
        // si no lo encuentra es null
        Empleado e = manager.find(Empleado.class, 1L);
        // el apellido se cambia inmediatamente porque 
        // esa entidad es managed
        e.setApellidos("Otro");
        imprimirTodo();
        
        eliminar(1L);
        
        imprimirTodo();
        
        
        manager.close();
    }
    
    private static void eliminar(Long id){
        manager.getTransaction().begin();
        
        Empleado e = manager.find(Empleado.class, id);
        manager.remove(e);
        
        manager.getTransaction().commit();
    }

    private static void crear(Empleado empleado){
        manager.getTransaction().begin();
        manager.persist(empleado);
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
