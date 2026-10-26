# 🎮 Guía práctica: Adivina el Número en Java

¡Bienvenido/a! En este proyecto aprenderás a ejecutar un programa Java y
a entender, paso a paso, cómo funciona un pequeño juego.

## 🎯 1. ¿Qué hace el programa?

La computadora elige un número secreto entre **1 y 10**. Tu misión es
adivinarlo.

-   Tienes **3 intentos válidos**.
-   Si escribes un número incorrecto, el programa te da una pista.
-   Si escribes un valor que no es entero o está fuera del rango, puedes
    intentarlo otra vez sin perder un intento válido.
-   Si ganas, el programa te felicita.
-   Si no ganas, al final te muestra el número secreto.

## 🧰 2. Antes de comenzar

Necesitas:

-   **Java JDK**, para compilar y ejecutar el programa.
-   **Visual Studio Code**, para escribir y guardar el código.
-   La extensión **Extension Pack for Java** en VS Code es recomendable,
    aunque también puedes trabajar desde la terminal.

### Comprueba que Java esté instalado

1.  Abre Visual Studio Code.
2.  En el menú, selecciona **Terminal → Nueva terminal**.
3.  Escribe estos comandos, uno por uno, y presiona Enter después de
    cada uno:

``` powershell
java -version
javac -version
```

Si aparecen números de versión, Java está disponible. Si aparece que el
comando no se reconoce, puede que debas instalar el JDK o configurar el
`PATH`.

## 📁 3. Prepara la carpeta del proyecto

1.  Crea o abre una carpeta para tu proyecto. Por ejemplo:
    `M1 Nataly clon`.
2.  Dentro de esa carpeta, crea un archivo llamado exactamente
    **`AdivinaNumero.java`**.
3.  Copia y pega tu código Java dentro de ese archivo.
4.  Presiona **Ctrl + S** para guardarlo.

Tu carpeta puede verse así:

``` text
M1 Nataly clon/
├── AdivinaNumero.java
└── README.md
```

> **Ojo:** el archivo debe llamarse `AdivinaNumero.java`, porque el
> código contiene `public class AdivinaNumero`. Revisa que Windows no lo
> haya guardado como `AdivinaNumero.java.txt`.

## ▶️ 4. Ejecuta el juego paso a paso

### Paso 1: abre la terminal de VS Code

En el menú superior, elige **Terminal → Nueva terminal**.

### Paso 2: comprueba que estás en la carpeta correcta

Escribe:

``` powershell
dir
```

Este comando muestra los archivos de la carpeta actual. Busca
`AdivinaNumero.java` en la lista.

Si no aparece, debes entrar a la carpeta correcta con `cd`. Por ejemplo:

``` powershell
cd "C:\Users\David\Downloads\M1 Nataly clon"
```

Utiliza la ruta donde realmente guardaste tu archivo. Las comillas son
importantes cuando el nombre de una carpeta contiene espacios.

### Paso 3: compila el programa

Escribe:

``` powershell
javac AdivinaNumero.java
```

**¿Qué hace `javac`?** Traduce el código que escribiste a un formato que
Java puede ejecutar. Si no aparecen errores, la compilación fue exitosa
y se crea el archivo `AdivinaNumero.class`.

### Paso 4: inicia el juego

Escribe:

``` powershell
java AdivinaNumero
```

Presiona Enter. ¡Ya puedes jugar! Al ejecutar, escribe el nombre de la
clase sin `.java` ni `.class`.

## 🕹️ 5. ¿Cómo se juega?

Imagina que la computadora eligió el número secreto **7**. Tú no sabes
cuál es.

1.  El programa te pide un número.
2.  Escribes `4` y presionas Enter.
3.  Como 4 es menor que 7, aparece una pista: **el número secreto es
    MAYOR**.
4.  Pruebas con `8`.
5.  Como 8 es mayor que 7, aparece la pista: **el número secreto es
    MENOR**.
6.  Pruebas con `7`.
7.  ¡Adivinaste! El programa te felicita y muestra cuántos intentos
    utilizaste.

El número secreto real cambia aleatoriamente en cada ejecución; el
ejemplo anterior solo sirve para entender la dinámica.

## 🔍 6. Tu código explicado con palabras sencillas

### A. Importar herramientas

``` java
import java.util.Random;
import java.util.Scanner;
```

Piensa en estas líneas como herramientas que el programa necesita:

-   `Random`: sirve para elegir el número secreto al azar.
-   `Scanner`: sirve para leer lo que escribes con el teclado.

### B. Preparar las herramientas

``` java
Scanner scanner = new Scanner(System.in);
Random random = new Random();
```

Aquí creas los objetos que usarás durante el juego. `scanner` escucha el
teclado y `random` ayuda a generar el número aleatorio.

### C. Establecer las reglas del juego

``` java
final int MAX_INTENTOS = 3;
final int NUMERO_MINIMO = 1;
final int NUMERO_MAXIMO = 10;
```

Estas constantes guardan las reglas:

-   `MAX_INTENTOS`: el jugador tiene 3 intentos válidos.
-   `NUMERO_MINIMO`: el menor número permitido es 1.
-   `NUMERO_MAXIMO`: el mayor número permitido es 10.

La palabra `final` significa que esos valores no se reasignan después.

### D. Elegir el número secreto

``` java
int numeroSecreto = random.nextInt(
    NUMERO_MAXIMO - NUMERO_MINIMO + 1
) + NUMERO_MINIMO;
```

Esta instrucción genera el número que el jugador intentará adivinar. El
cálculo permite obtener cualquier número del 1 al 10, incluidos ambos
extremos.

### E. Recordar si el jugador ganó

``` java
boolean adivinado = false;
```

Esta variable funciona como una marca:

-   `false`: todavía no ha adivinado el número.
-   `true`: ya lo adivinó.

Al inicio es `false`, porque el juego apenas comienza.

### F. Repetir la oportunidad de adivinar

``` java
for (int intento = 1; intento <= MAX_INTENTOS; intento++) {
    // Aquí se pide y revisa el número.
}
```

El ciclo `for` repite el proceso de pedir una respuesta. La variable
`intento` empieza en 1 y avanza hasta 3.

### G. Evitar que se escriban letras

``` java
if (!scanner.hasNextInt()) {
    System.out.println("Debes ingresar un numero entero.");
    scanner.nextLine();
    intento--;
    continue;
}
```

¿Qué sucede aquí?

1.  `hasNextInt()` comprueba si lo escrito es un número entero.
2.  Si escribes algo como `hola`, el programa muestra un mensaje.
3.  `nextLine()` descarta lo que escribiste para poder pedir una nueva
    entrada.
4.  `intento--` evita que esa entrada inválida cuente como intento.
5.  `continue` vuelve al principio del ciclo para pedir otro valor.

### H. Comprobar que el número esté entre 1 y 10

``` java
if (numeroUsuario < NUMERO_MINIMO ||
        numeroUsuario > NUMERO_MAXIMO) {
    System.out.println("El numero debe estar entre 1 y 10.");
    intento--;
    continue;
}
```

El símbolo `||` significa **"o"**. Si el número es menor que 1 **o**
mayor que 10, no se acepta y se vuelve a pedir una respuesta.

### I. Comparar el número que escribiste

``` java
if (numeroUsuario == numeroSecreto) {
    // ¡Ganaste!
} else if (numeroUsuario < numeroSecreto) {
    // El secreto es mayor.
} else {
    // El secreto es menor.
}
```

El programa compara tu respuesta con el número secreto:

-   `==` pregunta si los dos números son iguales.
-   `<` pregunta si tu número es menor.
-   Si no se cumple ninguna de las dos condiciones anteriores, tu número
    es mayor.

Si aciertas, el programa cambia `adivinado` a `true` y usa `break` para
salir del ciclo porque ya no necesitas más intentos.

### J. Mostrar cuántos intentos quedan

``` java
System.out.println(
    "Intentos restantes: " + (MAX_INTENTOS - intento)
);
```

Cuando la respuesta es incorrecta y válida, el programa calcula los
intentos restantes restando el intento actual al máximo permitido.

### K. Mostrar el resultado si no ganaste

``` java
if (!adivinado) {
    System.out.println("Agotaste tus 3 intentos.");
    System.out.println("El numero secreto era: " + numeroSecreto);
}
```

El símbolo `!` significa **"no"**. Por eso, `!adivinado` significa "si
no adivinó". En ese caso, el programa avisa que terminó el juego y
revela el número secreto.

### L. Cerrar Scanner

``` java
scanner.close();
```

Al terminar, el programa cierra el lector del teclado porque ya no
necesita recibir más datos.

## 🧪 7. Ejemplo de partida

Esta es una partida inventada para mostrar el formato de la consola. El
número secreto puede ser diferente cuando ejecutes el juego.

``` text
=== ADIVINA NUMERO ===
Adivina un numero entre 1 y 10.
Tienes 3 intentos.

Intento 1 de 3
Ingresa tu numero: 4
Pista: el numero secreto es MAYOR.
Intentos restantes: 2

Intento 2 de 3
Ingresa tu numero: 8
Pista: el numero secreto es MENOR.
Intentos restantes: 1

Intento 3 de 3
Ingresa tu numero: 7
¡Felicidades!
Adivinaste el numero secreto.
Lo lograste en 3 intento(s).
```

## 🛠️ 8. ¿Qué hago si aparece un error?

### `error: file not found: AdivinaNumero.java`

Significa que la terminal no encuentra el archivo en la carpeta actual.

1.  Escribe `dir` y presiona Enter.
2.  Comprueba si aparece `AdivinaNumero.java`.
3.  Si no aparece, entra en la carpeta correcta con `cd`.
4.  Comprueba que el nombre del archivo sea exactamente
    `AdivinaNumero.java`.

### `javac` no se reconoce como comando

Es posible que Java JDK no esté instalado o que Windows no encuentre su
carpeta `bin`. Comprueba la instalación y la configuración de `PATH`;
luego abre una terminal nueva y ejecuta `javac -version`.

### `Could not find or load main class AdivinaNumero`

Primero compila con `javac AdivinaNumero.java`. Después ejecuta
`java AdivinaNumero` desde la carpeta donde se creó
`AdivinaNumero.class`.

## 🧠 9. Lo que practicaste con este proyecto

Al crear este juego practicaste:

-   **Variables y constantes:** guardar valores y reglas.
-   **Tipos de datos:** números enteros (`int`) y verdadero/falso
    (`boolean`).
-   **Entrada por teclado:** recibir la respuesta del usuario con
    `Scanner`.
-   **Números aleatorios:** elegir el número secreto con `Random`.
-   **Condicionales:** tomar decisiones con `if`, `else if` y `else`.
-   **Ciclos:** repetir acciones con `for`.
-   **Validación:** comprobar que la entrada sea válida.
-   **Control del ciclo:** usar `break` para salir y `continue` para
    volver a empezar.
-   **Terminal:** compilar y ejecutar un programa Java.

## ✅ 10. Lista de comprobación

Antes de entregar tu proyecto, verifica lo siguiente:

-   [ ] El archivo de código se llama `AdivinaNumero.java`.
-   [ ] La clase pública se llama `AdivinaNumero`.
-   [ ] Guardé los cambios con Ctrl + S.
-   [ ] `javac AdivinaNumero.java` compila sin errores.
-   [ ] `java AdivinaNumero` inicia el juego.
-   [ ] Probé una respuesta correcta y una incorrecta.
-   [ ] Comprobé qué ocurre al escribir letras o un número fuera del
    rango.
-   [ ] Guardé este documento como `README.md`.

------------------------------------------------------------------------

**¡Felicidades!** Con este proyecto practicaste la estructura básica de
un programa Java, desde escribir el código hasta ejecutarlo y probarlo.
