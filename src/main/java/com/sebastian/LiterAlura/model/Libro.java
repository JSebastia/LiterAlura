package com.sebastian.LiterAlura.model;

import com.sebastian.LiterAlura.dto.DatosLibro;
import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {
    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;

    private Long descargas;
    private String lenguaje;

    @ManyToOne
    private Autor autor;

    //METODOS
    public Libro() {}

    public Libro(DatosLibro datosLibro){
        this.titulo = datosLibro.titulo();
        this.descargas = datosLibro.descargas();
        this.lenguaje = datosLibro.lenguajes().get(0);
    }

    @Override
    public String toString() {
        String informacion = """
                ******************
                📕Datos libro: 
                🔖Titulo: %s | Descargas: %d | Idioma: %s | Autor: %s
                ******************""".formatted(titulo, descargas, lenguaje, autor.getNombre());

        return informacion;
    }

    //Getters and Setters
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

    public Long getDescargas() {
        return descargas;
    }

    public void setDescargas(Long descargas) {
        this.descargas = descargas;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
