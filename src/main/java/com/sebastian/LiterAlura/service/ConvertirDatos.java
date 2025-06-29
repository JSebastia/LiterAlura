package com.sebastian.LiterAlura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertirDatos implements IConvierteDatos{
    //ATRIBUTOS
    private ObjectMapper objectMapper;

    //METODOS
    public ConvertirDatos() {
        objectMapper = new ObjectMapper();
    }

    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
           return objectMapper.readValue(json, clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
