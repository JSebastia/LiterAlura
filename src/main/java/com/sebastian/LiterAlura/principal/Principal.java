package com.sebastian.LiterAlura.principal;

import com.sebastian.LiterAlura.dto.DatosLibro;
import com.sebastian.LiterAlura.dto.DatosTotal;
import com.sebastian.LiterAlura.model.Autor;
import com.sebastian.LiterAlura.model.Libro;
import com.sebastian.LiterAlura.repository.AutorRepository;
import com.sebastian.LiterAlura.repository.LibroRepository;
import com.sebastian.LiterAlura.service.ConsultaAPI;
import com.sebastian.LiterAlura.service.ConvertirDatos;

import java.util.*;

public class Principal {
    //ATRIBUTOS
    private final String URL_BASE;
    private Scanner teclado;
    private ConvertirDatos convertirDatos;
    private AutorRepository autorRepository;
    private LibroRepository libroRepository;
    private List<Autor> autoresRegistrados;
    private List<Libro> librosRegistrados;

    //METODOS
    public Principal(AutorRepository autorRepository, LibroRepository libroRepository) {
        this.URL_BASE = "https://gutendex.com/books/";
        this.teclado = new Scanner(System.in);
        this.convertirDatos = new ConvertirDatos();
        this.autorRepository = autorRepository;
        this.libroRepository = libroRepository;

    }

    public void mostrarMenu() {
        var opcion = -1;

        while (opcion != 0) {
            try {
                menu();
                System.out.println("👉 Elige una opción: ");
                opcion = teclado.nextInt();
                teclado.nextLine();

                switch (opcion) {
                    case 1:
                        buscarLibroPorTitulo();
                        break;
                    case 2:
                        mostrarLibrosRegistrados();
                        break;
                    case 3:
                        mostrarAutoresRegistrados();
                        break;
                    case 4:
                        mostrarAutoresAnioDeterminado();
                        break;
                    case 5:
                        mostrarLibrosPorIdioma();
                        break;
                    case 6:
                        top5LibrosDescargas();
                        break;
                    case 0:
                        System.out.println("👍 ¡Gracias por usar LiterAlura!");
                        break;
                    default:
                        System.out.println("La opción " + opcion + ", no fue encontrada...");
                }
            } catch (InputMismatchException e) {
                System.out.println("Información: ❌ Solo ingrese números...");
                teclado.nextLine();
            }
        }
    }

    private void buscarLibroPorTitulo() {
        DatosLibro datosLibroEncontrado = recibirDatosLibro();

        if (datosLibroEncontrado != null) {
            Libro libro;
            Autor nuevoAutor = new Autor(datosLibroEncontrado);
            Autor autorExistente = autorRepository.buscarAutorExistente(nuevoAutor.getNombre());

            if (autorExistente == null) {
                libro = new Libro(datosLibroEncontrado);
                libro.setAutor(nuevoAutor);
                autorRepository.save(nuevoAutor);
                System.out.println("Información: ✅¡Autor agregado exitozamente!");
            } else {
                libro = new Libro(datosLibroEncontrado);
                libro.setAutor(autorExistente);
            }
            try {
                libroRepository.save(libro);
                System.out.println(libro);
                System.out.println("Información: ✅¡Libro agregado exitozamente!");
            } catch (Exception e) {
                System.out.println("Información: ❌El libro con titulo -" + libro.getTitulo() + "-, ya existe en la Base de datos...");
            }
        }
    }

    private DatosLibro recibirDatosLibro() {
        System.out.println("👉 Ingrese el titulo del libro que decea buscar: ");
        var tituloLibro = teclado.nextLine();

        String json = ConsultaAPI.consultarApi(URL_BASE + "?search=" + tituloLibro.replace(" ", "+"));
        DatosTotal datosLibros = convertirDatos.obtenerDatos(json, DatosTotal.class);

        Optional<DatosLibro> datosLibroEncontrado = datosLibros.listaDatosLibros().stream()
                .filter(L -> L.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))
                .findFirst();

        if (datosLibroEncontrado.isPresent()) {
            System.out.println("Información: ✅Completado.");
            return datosLibroEncontrado.get();
        } else {
            System.out.println("Información: ❌El libro con titulo -" + tituloLibro + "-, no fue encontrado.");
            return null;
        }
    }

    private void mostrarLibrosRegistrados() {
        librosRegistrados = libroRepository.findAll();
        System.out.println("Información: ✅Completado.");
        System.out.println("---------- LIBROS REGISTRADOS: ----------");
        librosRegistrados.forEach(System.out::println);
    }

    private void mostrarAutoresRegistrados() {
        autoresRegistrados = autorRepository.findAll();
        System.out.println("Información: ✅Completado.");
        System.out.println("---------- AUTORES REGISTRADOS: ----------");
        autoresRegistrados.forEach(System.out::println);
    }

    private void mostrarAutoresAnioDeterminado() {
        System.out.println("Ingrese el año en el cual decea consultar Autores: ");
        var valorIngresado = teclado.nextLong();
        teclado.nextLine();

        autoresRegistrados = autorRepository.buscarAutoresAnioD(valorIngresado);

        if (autoresRegistrados.isEmpty()) {
            System.out.println("Información: ❌Busqueda fallida...");
        } else {
            System.out.println("Información: ✅Completado.");
            autoresRegistrados.forEach(System.out::println);
        }
    }

    private void mostrarLibrosPorIdioma() {
        System.out.println("Elige el idioma por el cual decea consultar: ");
        System.out.println("en - Ingles\nes - Español\nIngrese: ");
        var opcionIdioma = teclado.nextLine();

        librosRegistrados = libroRepository.buscarLibroPorIdioma(opcionIdioma);

        if (librosRegistrados.isEmpty()) {
            System.out.println("Información: ❌Busqueda fallida...");
        } else {
            System.out.println("Información: ✅Completado.");
            librosRegistrados.forEach(System.out::println);
        }
    }

    private void top5LibrosDescargas() {
        librosRegistrados = libroRepository.findAll();
        System.out.println("---------- TOP 5 LIBROS: ----------");

        librosRegistrados.stream()
                .sorted(Comparator.comparing(Libro::getDescargas).reversed())
                .limit(5)
                .forEach(System.out::println);
    }

    public void menu() {
        String menu = """
                ***************************************
                *  📖 -----🔖 LiterAlura 🔖----- 📖  *
                ***************************************
                *  1 - Buscar libro por titulo.       *
                *  2 - Mostrar libros registrados.    *
                *  3 - Mostrar autores registrados.   *
                *  4 - Mostrar autores en un          *
                *      determinado año.               *
                *  5 - Mostrar libros por idioma.     *
                *  6 - Top 5 libros mas decargados.   *
                *  0 - Salir.                         *
                ***************************************""";

        System.out.println(menu);
    }
}
