package com.sebastian.LiterAlura.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPI {
    //METODOS
    public static String consultarApi(String URL_COMPLETA) {
        System.out.println("Información:⌚Buscando...");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(URL_COMPLETA)).build();
        HttpResponse<String> response;

        try {
             response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Retorna un String con los datos en formato JSON.
        return response.body();
    }
}
