package com.sebastian.LiterAlura.repository;

import com.sebastian.LiterAlura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    @Query("SELECT l FROM Libro l WHERE l.lenguaje = :idioma")
    List<Libro> buscarLibroPorIdioma(String idioma);
}
