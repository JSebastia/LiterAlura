package com.sebastian.LiterAlura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
        @JsonAlias("title") String titulo,
        @JsonAlias("download_count") Long descargas,
        @JsonAlias("languages") List<String> lenguajes,
        @JsonAlias("authors") List<DatosAutor> listaDatosAutor) {
}
