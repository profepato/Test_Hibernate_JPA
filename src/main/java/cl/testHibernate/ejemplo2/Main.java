package cl.testHibernate.ejemplo2;

import cl.testHibernate.ejemplo1.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("aplicacion");
        
        crearDatos();
        imprimirTodo();
    }
    private static void crearDatos(){
        EntityManager manager = emf.createEntityManager();
        
        manager.getTransaction().begin();
        
        Autor autor1 = new Autor(1L, "Autor 1", "Nacionalidad 1");
        Autor autor2 = new Autor(2L, "Autor 2", "Nacionalidad 2");
        Autor autor3 = new Autor(3L, "Autor 3", "Nacionalidad 3");
        
        manager.persist(autor1);
        manager.persist(autor2);
        manager.persist(autor3);
        
        manager.persist(new Libro(1L, "1er Libro de autor1", autor1));
        manager.persist(new Libro(2L, "2do Libro de autor1", autor1));
        manager.persist(new Libro(3L, "1er Libro de autor2", autor2));
        manager.persist(new Libro(4L, "2do Libro de autor2", autor2));
        manager.persist(new Libro(5L, "1er Libro de autor3", autor3));
        
        manager.getTransaction().commit();
        
        manager.close();
    }
    
    private static void imprimirTodo() {
        EntityManager manager = emf.createEntityManager();
        
        Autor autor2 = manager.find(Autor.class, 2L);   
        List<Libro> libros = autor2.getLibros();
        
        System.out.println("Libros del autor 2");
        for (Libro libro : libros) {
            System.out.println(libro);
        }
        
        System.out.println("Todos los autores");
        // FROM Autor, es porque la clase se llama asi
        List<Autor> autores = manager.createQuery("FROM Autor").getResultList();
        
        for (Autor autor : autores) {
            System.out.println(autor);
        }
        
        manager.close();
    }
}
