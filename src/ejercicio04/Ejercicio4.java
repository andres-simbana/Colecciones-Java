package ejercicio04;

import java.util.Scanner;

// Ejercicio 4: operaciones con matrices de M x N
public class Ejercicio4 {

    // Los números aleatorios van del 0 hasta uno menos que este valor
    static final int RANGO_ALEATORIO = 10;

    // Scanner para leer los datos del teclado
    static Scanner teclado = new Scanner(System.in);

    // Método principal, aquí empieza el programa
    public static void main(String[] args) {
        // Pedimos el número de filas (mínimo 1)
        int m = leerPositivo("Número de filas (M): ");
        // Pedimos el número de columnas (mínimo 1)
        int n = leerPositivo("Número de columnas (N): ");

        // Generamos la matriz A con números aleatorios
        int[][] a = generar(m, n);
        // Generamos la matriz B del mismo tamaño
        int[][] b = generar(m, n);
        // Mostramos la matriz A
        imprimir("Matriz A", a);
        // Mostramos la matriz B
        imprimir("Matriz B", b);

        // Variable para la opción del menú
        int opcion;
        // Repetimos el menú hasta que elija salir
        do {
            // Mostramos las opciones
            System.out.println("\n1. Sumar  2. Restar  3. Multiplicar  4. Trasponer  0. Salir");
            // Pedimos la opción
            System.out.print("Opción: ");
            // Leemos la opción
            opcion = teclado.nextInt();

            // Hacemos la operación elegida
            switch (opcion) {
                // Opción 1: sumar
                case 1:
                    // Suma de A y B
                    imprimir("A + B", sumar(a, b));
                    // Salimos del switch
                    break;
                // Opción 2: restar
                case 2:
                    // Resta de A y B
                    imprimir("A - B", restar(a, b));
                    // Salimos del switch
                    break;
                // Opción 3: multiplicar
                case 3:
                    // Para multiplicar, C debe tener N filas; pedimos sus columnas
                    int p = leerPositivo("Columnas de la matriz C: ");
                    // Generamos C de N x P
                    int[][] c = generar(n, p);
                    // Mostramos C
                    imprimir("Matriz C", c);
                    // Multiplicamos A por C
                    imprimir("A x C", multiplicar(a, c));
                    // Salimos del switch
                    break;
                // Opción 4: trasponer
                case 4:
                    // Traspuesta de A
                    imprimir("Traspuesta de A", trasponer(a));
                    // Salimos del switch
                    break;
                // Opción 0: salir
                case 0:
                    // Mensaje de salida
                    System.out.println("Fin del programa");
                    // Salimos del switch
                    break;
                // Cualquier otro número
                default:
                    // Opción que no existe
                    System.out.println("Opción no válida");
            }
        } while (opcion != 0);

        // El usuario ya salió, cerramos el Scanner
        teclado.close();
    }

    // Función que pide un entero y lo vuelve a pedir hasta que sea mayor a 0
    public static int leerPositivo(String mensaje) {
        // Aquí guardamos lo que escriba el usuario
        int valor;
        // Repetimos mientras el número no sirva
        do {
            // Mostramos la pregunta
            System.out.print(mensaje);
            // Leemos el número
            valor = teclado.nextInt();
            // Si no sirve, le avisamos antes de volver a preguntar
            if (valor <= 0) {
                // Mensaje para que corrija el dato
                System.out.println("El valor debe ser mayor a 0");
            }
        } while (valor <= 0);
        // Devolvemos el número ya validado
        return valor;
    }

    // Función que crea una matriz con números aleatorios
    public static int[][] generar(int filas, int columnas) {
        // Creamos la matriz
        int[][] matriz = new int[filas][columnas];
        // Recorremos las filas
        for (int i = 0; i < filas; i++) {
            // Recorremos las columnas de cada fila
            for (int j = 0; j < columnas; j++) {
                // Asignamos un número aleatorio
                matriz[i][j] = (int) (Math.random() * RANGO_ALEATORIO);
            }
        }
        // Devolvemos la matriz
        return matriz;
    }

    // Procedimiento que imprime una matriz
    public static void imprimir(String titulo, int[][] matriz) {
        // Mostramos el título
        System.out.println("\n" + titulo + ":");
        // Recorremos las filas
        for (int i = 0; i < matriz.length; i++) {
            // Recorremos las columnas de la fila
            for (int j = 0; j < matriz[i].length; j++) {
                // Mostramos el valor separado con tabulación
                System.out.print(matriz[i][j] + "\t");
            }
            // Salto de línea al terminar la fila
            System.out.println();
        }
    }

    // Función que suma dos matrices
    public static int[][] sumar(int[][] a, int[][] b) {
        // Matriz resultado del mismo tamaño
        int[][] r = new int[a.length][a[0].length];
        // Recorremos las filas
        for (int i = 0; i < a.length; i++) {
            // Recorremos las columnas
            for (int j = 0; j < a[0].length; j++) {
                // Sumamos posición por posición
                r[i][j] = a[i][j] + b[i][j];
            }
        }
        // Devolvemos el resultado
        return r;
    }

    // Función que resta dos matrices
    public static int[][] restar(int[][] a, int[][] b) {
        // Matriz resultado del mismo tamaño
        int[][] r = new int[a.length][a[0].length];
        // Recorremos las filas
        for (int i = 0; i < a.length; i++) {
            // Recorremos las columnas
            for (int j = 0; j < a[0].length; j++) {
                // Restamos posición por posición
                r[i][j] = a[i][j] - b[i][j];
            }
        }
        // Devolvemos el resultado
        return r;
    }

    // Función que multiplica A (M x N) por C (N x P)
    public static int[][] multiplicar(int[][] a, int[][] c) {
        // El resultado es de M x P
        int[][] r = new int[a.length][c[0].length];
        // Recorremos las filas de A
        for (int i = 0; i < a.length; i++) {
            // Recorremos las columnas de C
            for (int j = 0; j < c[0].length; j++) {
                // Recorremos la fila de A y la columna de C a la vez
                for (int k = 0; k < c.length; k++) {
                    // Vamos sumando los productos
                    r[i][j] += a[i][k] * c[k][j];
                }
            }
        }
        // Devolvemos el resultado
        return r;
    }

    // Función que devuelve la traspuesta de una matriz
    public static int[][] trasponer(int[][] a) {
        // La traspuesta tiene las filas y columnas al revés
        int[][] r = new int[a[0].length][a.length];
        // Recorremos las filas
        for (int i = 0; i < a.length; i++) {
            // Recorremos las columnas
            for (int j = 0; j < a[0].length; j++) {
                // Pasamos cada valor de (i, j) a (j, i)
                r[j][i] = a[i][j];
            }
        }
        // Devolvemos la traspuesta
        return r;
    }
}
