import java.util.Random;
import java.util.Scanner;

public class AdivinaNumero {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Constantes
        final int MAX_INTENTOS = 3;
        final int NUMERO_MINIMO = 1;
        final int NUMERO_MAXIMO = 10;

        // Generar número secreto entre 1 y 10
        int numeroSecreto = random.nextInt(
                NUMERO_MAXIMO - NUMERO_MINIMO + 1
        ) + NUMERO_MINIMO;

        boolean adivinado = false;

        System.out.println("=== ADIVINA NUMERO ===");
        System.out.println("Adivina un numero entre 1 y 10.");
        System.out.println("Tienes 3 intentos.");

        // Ciclo de intentos
        for (int intento = 1; intento <= MAX_INTENTOS; intento++) {

            System.out.println("\nIntento " + intento
                    + " de " + MAX_INTENTOS);

            System.out.print("Ingresa tu numero: ");

            // Validar que el usuario escriba un entero
            if (!scanner.hasNextInt()) {

                System.out.println("Debes ingresar un numero entero.");
                scanner.nextLine();
                intento--;
                continue;
            }

            int numeroUsuario = scanner.nextInt();

            // Validar el rango permitido
            if (numeroUsuario < NUMERO_MINIMO ||
                    numeroUsuario > NUMERO_MAXIMO) {

                System.out.println(
                        "El numero debe estar entre 1 y 10.");
                intento--;
                continue;
            }

            // Comparar los números
            if (numeroUsuario == numeroSecreto) {

                System.out.println("¡Felicidades!");
                System.out.println(
                        "Adivinaste el numero secreto.");

                System.out.println(
                        "Lo lograste en " + intento + " intento(s).");

                adivinado = true;
                break;

            } else if (numeroUsuario < numeroSecreto) {

                System.out.println(
                        "Pista: el numero secreto es MAYOR.");

            } else {

                System.out.println(
                        "Pista: el numero secreto es MENOR.");
            }

            System.out.println(
                    "Intentos restantes: "
                    + (MAX_INTENTOS - intento));
        }

        // Resultado final
        if (!adivinado) {

            System.out.println("\n=== FIN DEL JUEGO ===");

            System.out.println(
                    "Agotaste tus 3 intentos.");

            System.out.println(
                    "El numero secreto era: " + numeroSecreto);
        }

        scanner.close();
    }
}