package com.sebastian.LiterAlura.repository;

import com.sebastian.LiterAlura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    @Query("SELECT a FROM Autor a WHERE a.nombre = :nombreAutor")
    Autor buscarAutorExistente(String nombreAutor);

    @Query("SELECT a FROM Autor a WHERE a.fechaFallecimiento >= :anio")
    List<Autor> buscarAutoresAnioD(Long anio);
}
