package cl.testHibernate;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestEmpleados {

    public static void main(String[] args) {
        // <persistence-unit name="aplicacion"> --> persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("aplicacion");
        EntityManager manager = emf.createEntityManager();

        List<Empleado> empleados;
        empleados = (List<Empleado>) manager.createQuery("FROM Empleado").getResultList();

        System.out.println("Existen " + empleados.size() + " empleados");
    }
}
