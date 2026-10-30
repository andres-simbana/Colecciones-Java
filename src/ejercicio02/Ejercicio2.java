package ejercicio02;

import java.util.Scanner;

// Ejercicio 2: vector de 20 números aleatorios
public class Ejercicio2 {

    // Tamaño del vector que pide el enunciado
    static final int TAMAÑO = 20;
    // Valor más alto que puede salir al azar
    static final int MAXIMO_ALEATORIO = 50;
    // Límite para contar los elementos mayores (literal c)
    static final int LIMITE = 20;

    // Scanner para leer los datos del teclado
    static Scanner teclado = new Scanner(System.in);

    // Método principal, aquí empieza el programa
    public static void main(String[] args) {
        // Creamos el vector y lo llenamos al azar
        int[] vector = generar(TAMAÑO);
        // Mostramos el vector original
        imprimir("Vector original", vector);

        // a) Pedimos el número a buscar
        System.out.print("\nIngrese el número a buscar: ");
        // Leemos el número
        int numero = teclado.nextInt();
        // Buscamos el número en el vector
        buscar(vector, numero);

        // b) Creamos el segundo vector con los índices impares
        int[] impares = indicesImpares(vector);
        // Mostramos el segundo vector con la posición que tenía en el original
        imprimirImpares("\nVector con los índices impares", impares);

        // c) Contamos los elementos mayores al límite
        int mayores = contarMayores(impares, LIMITE);
        // Mostramos el resultado
        System.out.println("\nElementos mayores a " + LIMITE + ": " + mayores);

        // Terminamos de leer datos, cerramos el Scanner
        teclado.close();
    }

    // Función que crea un vector con números aleatorios del 1 al máximo
    public static int[] generar(int tamaño) {
        // Creamos el vector vacío
        int[] v = new int[tamaño];
        // Recorremos cada posición
        for (int i = 0; i < v.length; i++) {
            // Guardamos un número al azar entre 1 y MAXIMO_ALEATORIO
            v[i] = (int) (Math.random() * MAXIMO_ALEATORIO) + 1;
        }
        // Devolvemos el vector lleno
        return v;
    }

    // Procedimiento que imprime un vector con sus posiciones
    public static void imprimir(String titulo, int[] v) {
        // Mostramos el título
        System.out.println(titulo + ":");
        // Recorremos el vector
        for (int i = 0; i < v.length; i++) {
            // Mostramos la posición y el valor
            System.out.print("[" + i + "]=" + v[i] + "  ");
        }
        // Salto de línea al final
        System.out.println();
    }

    // Procedimiento que imprime el vector de impares con la posición que tenía en el original
    public static void imprimirImpares(String titulo, int[] v) {
        // Mostramos el título
        System.out.println(titulo + ":");
        // Recorremos el vector
        for (int i = 0; i < v.length; i++) {
            // La posición original es 1, 3, 5... o sea 2 * i + 1
            int posicionOriginal = 2 * i + 1;
            // Mostramos la posición original y el valor
            System.out.print("[" + posicionOriginal + "]=" + v[i] + "  ");
        }
        // Salto de línea al final
        System.out.println();
    }

    // Procedimiento que muestra en qué posiciones está el número
    public static void buscar(int[] v, int numero) {
        // Variable para saber si lo encontramos
        boolean encontrado = false;
        // Recorremos todo el vector
        for (int i = 0; i < v.length; i++) {
            // Si el valor es igual al número buscado
            if (v[i] == numero) {
                // Mostramos la posición
                System.out.println("El número está en la posición " + i);
                // Marcamos que sí se encontró
                encontrado = true;
            }
        }
        // Si no apareció en ninguna posición, lo indicamos
        if (!encontrado) {
            // Mensaje cuando no hubo coincidencias
            System.out.println("El número no está en el vector");
        }
    }

    // Función que devuelve un vector con los elementos de índice impar
    public static int[] indicesImpares(int[] v) {
        // La mitad de las posiciones son impares
        int[] nuevo = new int[v.length / 2];
        // Posición del nuevo vector
        int k = 0;
        // Empezamos en 1 y avanzamos de 2 en 2
        for (int i = 1; i < v.length; i += 2) {
            // Copiamos el valor
            nuevo[k] = v[i];
            // Pasamos a la siguiente posición
            k++;
        }
        // Devolvemos el nuevo vector
        return nuevo;
    }

    // Función que cuenta los elementos mayores a un límite
    public static int contarMayores(int[] v, int limite) {
        // Contador en cero
        int contador = 0;
        // Recorremos el vector
        for (int i = 0; i < v.length; i++) {
            // Si el valor es mayor al límite, lo contamos
            if (v[i] > limite) {
                // Sumamos uno al contador
                contador++;
            }
        }
        // Devolvemos el conteo
        return contador;
    }
}
