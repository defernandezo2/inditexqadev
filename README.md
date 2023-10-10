# inditexqadev
El repositorio incluye la solucion de la prueba tecnica para la aplicacion a K-lagan con el cliente inditex. Esta documentacion presentara la solucion. Pero primero... Clonar el codigo

## Clonar el Repositorio

```bash
git clone git@github.com:defernandezo2/inditexqadev.git
gradle test
```

## Ejercicio 2: Automatización de una web

Para este caso establecimos una pequeña base utilizando selenium y el model pagina-objeto que nos permite abstraer a cada pagina como objetos de java.
La base incluye:
-un archivo de configuracion: [Configurations.java](/src/test/java/configurations/Configurations.java) El cual referencia las propiedades que ponemos en un archivo en la carpeta de recursos: [configurations.properties](src/test/resources/configuration.properties)
- un paquete que incluye todos las paginas como objetos de java [pages](src/test/src/pages). en el cual se encuentra tambien una clase base abstracta [BasePage](src/test/java/pages/BasePage.java) que contiene metodos base que utilizan todas las paginas y guarda el webdriver ademas que lo solicita por defecto en el constructor para que asi todas las paginas creadas lo requieran, ademas solicita un metodo cargar que se requiere construir en cada pagina.
- un paquete que incluye todos los test [features](src/test/src/features) en el que se incluye una clase base que contiene el metodo de setup que abre el driver y que se comparte entre todas las clases de test.
- La solucion principal se encuentra en [searchSampleTest](https://github.com/defernandezo2/inditexqadev/blob/2a763c54e2032c736681ce2c8b374884b388f926/src/test/java/features/WikipediaTest.java#L28C37-L28C37).
- la solucion tambien inluye un reporte de allure por si se rquiere el cual se tiene que generar utilizando comandos de allure.


## Ejercicio 3: Tratamiento de datos en APIs

Se utilizo la misma base para generar el codigo para correr Rest asured el cual esta incluido en la clase [ApiTest.java](src/test/java/features/ApiTest.java) con el siguiente orden:
-codigo que crea y obtiene un usuario y verifica el [getUserAssertionRa]([src/test/java/features/ApiTest.java](https://github.com/defernandezo2/inditexqadev/blob/2a763c54e2032c736681ce2c8b374884b388f926/src/test/java/features/ApiTest.java#L43)https://github.com/defernandezo2/inditexqadev/blob/2a763c54e2032c736681ce2c8b374884b388f926/src/test/java/features/ApiTest.java#L43)
-codigo que obtiene el reultado de findByStatus y retorna la tupla con los mascotas vendidas con nombre igual [FindPetsByStatus.java](src/test/java/features/FindPetsByStatus.java).

