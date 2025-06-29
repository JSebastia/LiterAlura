package com.sebastian.LiterAlura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DatosAutor(
        @JsonAlias("name") String nombre,
        @JsonAlias("birth_year") Long fechaNacimiento,
        @JsonAlias("death_year") Long fechaFalleciemiento
) { }
