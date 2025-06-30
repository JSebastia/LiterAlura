<h1 align="center">:books: LiterAlura :books:</h1>

![image](https://github.com/user-attachments/assets/48312fa2-8612-4ee3-af19-c95ea616b3d3)

<h2>¿Que es?</h2>
<h4>LiterAlura fue diseñada para que podamos consultar nuestros libros favoritos y autores favoritos. Sintese libre de buscar lo que decea y pruebe la magía de una APP DE CONSOLA hecha con cariño 🙂.</h4>

<h2>⚒️ ¿Cómo funciona?</h2>
<h4>La app de Consola se encarga de consultar los datos de los libros a la API de Gutendex. Trae aquellos datos y los guarda en una base datos relacional. Además con cada una de las opciones del menú, hacen de una experiencia exepcional al querer consultar.</h4>

- `1 - Buscar libro por titulo`: Permite ingresar el nombre del libro (un pedazo o completo). Se muestra al usuario el resultado de la busqueda y se guardan los datos en la base de datos. 🔨  Se realiza una consulta a la API (?search=nombre_libro). Se verifica que la respuesta no sea nula, que el libro exista y que el nombre del Autor exista en la base de datos. Se guardan los datos del Libro o los datos del Libro y Autor, según sea el caso. Ejemplo para un libro con un pedazo de nombre "A Pickle for the":      

![image](https://github.com/user-attachments/assets/6ce74b96-d4ff-4202-83ae-fe3844213024)

- `2 - Mostrar libros registrados`: Permite imprimir todos los libros registrados en la base de datos. 🔨 Se realiza la consulta a la base de datos por medio de LibroRepository y se obtiene los datos de los libros. Finalmente se imprime cada unos de los libros registrados. Ejemplo:

![image](https://github.com/user-attachments/assets/4ccf8b95-e5ff-4164-ba1f-588a321978c6)

- `3 - Mostrar autores registrados`: Imprime todos los autores registrados en la base de datos. 🔨 Se realiza la consulta a la base de datos por medio de AutorRepository y se obtiene los datos de los Autores. Finalmente se imprime cada unos de los Autores registrados. EJemplo: 

![image](https://github.com/user-attachments/assets/b0f9a578-3959-4985-a7d3-89365b780273)

- `4 - Mostrar autores en un determinado año`: Permite consultar los datos de los autores por medio de su fecha de fallecimiento es decir, los autores vivos en un limite de año ingresado por el Usuario. 🔨 Se pide al Usuario que ingrese un año limite y se valida en la base de datos mediante AutorRepository con JPQL. Se valida que si exitan los datos y se imprime, según sea el caso. Ejemplo para un año 1900: 

![image](https://github.com/user-attachments/assets/c5ae42de-4aa5-4960-8421-3ed16a8e4d0b)

- `5 - Mostrar libros por idioma`: Permite consultar libros según su Idioma. 🔨 Se da al usuario una serie de idiomas a escoger para la busqueda. Se recibe la opción escogida por el usuario y se verifica en LibroRepository con JPQL los libros correspondientes. Finalmente se muestra al usuario los resultados de busqueda. Ejemplo para "es":

![image](https://github.com/user-attachments/assets/b5779f4f-0c7f-4aa0-b44b-d177f5f08d5c)

- `6 - Top5 libros mas descargados`: Con esta opción podras ver un TOP5 de los libros más descargados (los 5 mejores libros). 🔨 Se hace una cosulta a la base de datos en LibroRepository con JPQL. Se verifican y se ordenan los libros de forma ascendente dependiento de su atributo "descargas". Finalmente se muestran los datos. Ejemplo:

![image](https://github.com/user-attachments/assets/27484629-11b1-42ba-8a09-f9f599102ae3)

<h2>👁️¿Como usar LiterAlura?</h2>
<h4>🥹Falta agregar...</h4>

