package com.sebastian.LiterAlura.model;

import com.sebastian.LiterAlura.dto.DatosLibro;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "autores")
public class Autor {
    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nombre;

    private Long fechaNacimiento;
    private Long fechaFallecimiento;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> listaLibros;

    //METODOS
    public Autor() {}

    public Autor(DatosLibro datosLibro) {
        this.nombre = datosLibro.listaDatosAutor().get(0).nombre();
        this.fechaNacimiento = datosLibro.listaDatosAutor().get(0).fechaNacimiento();
        this.fechaFallecimiento = datosLibro.listaDatosAutor().get(0).fechaFalleciemiento();
    }

    @Override
    public String toString() {
        List<String> nombreLibrosAutor = new ArrayList<>();

        for (Libro libroAutor : listaLibros) {
            nombreLibrosAutor.add(libroAutor.getTitulo());
        }

        return "---- \uD83D\uDCD6Datos autor: ----" + "\n" +
                "Nombre: " + nombre + "\n" +
                "Fecha nacimiento: " + fechaNacimiento + "\n" +
                "Fecha fallecimiento: " + fechaFallecimiento + "\n" +
                "Libros: " + nombreLibrosAutor + "\n";
    }

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Long fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public void setFechaFallecimiento(Long fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }

    public List<Libro> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(List<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }
}
