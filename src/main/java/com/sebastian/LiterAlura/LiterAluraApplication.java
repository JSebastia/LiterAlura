package com.sebastian.LiterAlura;

import com.sebastian.LiterAlura.principal.Principal;
import com.sebastian.LiterAlura.repository.AutorRepository;
import com.sebastian.LiterAlura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {
	//ATRIBUTOS
	@Autowired
	private AutorRepository autorRepository;

	@Autowired
	private LibroRepository libroRepository;

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(autorRepository, libroRepository);
		principal.mostrarMenu();
//		String a = ConsultaAPI.consultarApi("https://gutendex.com/books/?search=quijote");
//		System.out.println(a);
//		ConvertirDatos convertirDatos = new ConvertirDatos();
//		DatosTotal datosTotal = convertirDatos.obtenerDatos(a, DatosTotal.class);
//
//		System.out.println(datosTotal);
//
//		System.out.println(new Libro(datosTotal.listaDatosLibros().get(0)));
//		System.out.println(new Autor(datosTotal.listaDatosLibros().get(0)));


	}
}
