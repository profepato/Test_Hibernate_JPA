package cl.testHibernate.ejemplo2;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LIBRO")
public class Libro implements Serializable{
    @Id
    @Column(name = "ID_LIBRO")
    private Long id;
    
    @Column(name = "TITULO")
    private String titulo;
    
    
    // en el ManyToOnce es necesario colocalr fecth lazy
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_AUTOR") // ese nombre se lo damos en la clase Autor: @Column(name = "ID_AUTOR")
    private Autor autor;

    public Libro() {
    }

    public Libro(Long id, String titulo, Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Libro{" + "id=" + id + ", titulo=" + titulo + ", autor=" + autor + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Libro other = (Libro) obj;
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.autor, other.autor)) {
            return false;
        }
        return true;
    }

    
}
