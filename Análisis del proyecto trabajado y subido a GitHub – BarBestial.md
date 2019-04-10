# Análisis del proyecto trabajado y subido a GitHub -- BarBestial
## Alcance
El proyecto BarBestial, fue el proyecto realizado en la asignatura Ingeniería del Software de 2º de carrera en la Escuela de Ingeniería de Vitoria-Gasteiz. El proyecto fue realizado junto a dos compañeros (Joel Villalobos y Christian Hernández), fue un proyecto Maven, aunque el porfesor nos lo dió empezado así, por lo que el POM.XML no lo editamos nosotros.
El proyecto trata de un juego de mesa de cartas que existe en la vida real llamado "Bar Bestial" en el cual el usuario tras registrarse (base de datos SQLite), hace el log-in y empieza a jugar contra una "Inteligencia artificial" la cual solo juega cartas de manera aleatoria. Todas las "animaladas" (jugadas concurrentes) que necesitaban algun input del usuario (sobre que carta de la mesa realizarla, por ejemplo) también se usaba un valor aleatorio.
Tras finalizar la partida (los dos jugadores se quedan sin cartas en la mano) se guarda en la base de datos SQLite y muestra una ventana con el ranking de todos los jugadores que han participado históricamente.
## Mejoras realizadas
La mejora realizada a mi proyecto ha sido el añadirle la documentación, primero por JavaDoc y lueo mediante Doxygen, al haberla visto en clase.
Documenté todas las clases excepto los enumerados y las interfaces gráficas del usuario, ya que del enumerado poco hay que contar de lo que ya aparecer, y las interfaces gráficas son casi autogeneradas y la documentación no se iba a salir de "Crea la ventana, le ajusta las dimensiones, introduce la tabla y los botones..."
## Análisis de calidad respecto "Google Java Style Guide"
2. Source file basics 
2.1 File name **Si**
2.2 File encoding: UTF-8 **Si**
2.3 Special characters **No, alguna ñ**
3. Source file structure
3.1 License or copyright information, if present **Si**
3.2 Package statement **Si**
3.3 Import statements **Si**
3.4 Class declaration **Si**
4. Formatting
4.1 Braces **Si**
4.2 Block indentation: +2 spaces **No siempre**
4.3 One statement per line **Si**
4.4 Column limit: 100 **No**
4.5 Line-wrapping **No**
4.6 Whitespace **Si**
4.7 Grouping parentheses: recommended **No**
4.8 Specific constructs **Si, en su gran mayoría**
5. Naming
5.1 Rules common to all identifiers **Si**
5.2 Rules by identifier type **Si**
5.3 Camel case: defined **No**
6. Programming Practices
6.1 @Override: always used **Si**
6.2 Caught exceptions: not ignored **Si**
6.3 Static members: qualified using class **Si**
6.4 Finalizers: not used **Si**
7. Javadoc
7.1 Formatting **Si**
7.2 The summary fragment **No**
7.3 Where Javadoc is used **Si**
## Posibles mejoras futuras
Como posibles mejoras futuras, a parte de cumplir con todos los puntos anteriores, añadiría la mejora de los test JUnit, ya que creo que varios no comprueban del todo bien la funcionalidad de alguna animalada, ya que en algunas ejecuciones se me ha dado el caso de que uno de los jugadores tenga más cartas que el otro o que una carta no realice bien su animalada.
## Enlace a GitHub del proyecto
https://github.com/cs-ehu/ProyectoAritz
