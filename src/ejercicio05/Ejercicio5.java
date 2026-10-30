package ejercicio05;

import java.util.Scanner;

// Ejercicio 5: ventas por artículo y por sucursal
public class Ejercicio5 {

    // Scanner para leer los datos del teclado
    static Scanner teclado = new Scanner(System.in);

    // Método principal, aquí empieza el programa
    public static void main(String[] args) {
        // Pedimos el número de artículos (mínimo 1)
        int n = leerPositivo("Número de artículos (N): ");
        // Pedimos el número de sucursales (mínimo 1)
        int m = leerPositivo("Número de sucursales (M): ");

        // Primera tabla: precio de cada artículo en cada sucursal
        double[][] precios = leerPrecios(n, m);
        // Segunda tabla: cantidad vendida de cada artículo en cada sucursal (unidades enteras)
        int[][] cantidades = leerCantidades(n, m);

        // Mostramos el total por artículo
        totalPorArticulo(precios, cantidades);
        // Mostramos el total por sucursal
        totalPorSucursal(precios, cantidades);

        // Ya tenemos los reportes, cerramos el Scanner
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

    // Función que lee la tabla de precios de N artículos x M sucursales
    public static double[][] leerPrecios(int n, int m) {
        // Creamos la tabla; los precios pueden tener decimales
        double[][] tabla = new double[n][m];
        // Mostramos el nombre de la tabla
        System.out.println("\nPRECIOS");
        // Recorremos los artículos (filas)
        for (int i = 0; i < n; i++) {
            // Recorremos las sucursales (columnas)
            for (int j = 0; j < m; j++) {
                // Pedimos el precio; no puede ser negativo
                do {
                    // Mostramos qué celda estamos llenando
                    System.out.print("Artículo " + (i + 1) + ", sucursal " + (j + 1) + ": ");
                    // Leemos el precio
                    tabla[i][j] = teclado.nextDouble();
                    // Si es negativo, avisamos y se vuelve a pedir
                    if (tabla[i][j] < 0) {
                        // Mensaje para que corrija el valor
                        System.out.println("El valor no puede ser negativo");
                    }
                } while (tabla[i][j] < 0);
            }
        }
        // Devolvemos la tabla
        return tabla;
    }

    // Función que lee la tabla de cantidades vendidas de N artículos x M sucursales
    public static int[][] leerCantidades(int n, int m) {
        // Creamos la tabla; las cantidades son unidades, por eso van enteras
        int[][] tabla = new int[n][m];
        // Mostramos el nombre de la tabla
        System.out.println("\nCANTIDADES VENDIDAS");
        // Recorremos los artículos (filas)
        for (int i = 0; i < n; i++) {
            // Recorremos las sucursales (columnas)
            for (int j = 0; j < m; j++) {
                // Pedimos la cantidad; no puede ser negativa
                do {
                    // Mostramos qué celda estamos llenando
                    System.out.print("Artículo " + (i + 1) + ", sucursal " + (j + 1) + ": ");
                    // Leemos la cantidad como entero
                    tabla[i][j] = teclado.nextInt();
                    // Si es negativa, avisamos y se vuelve a pedir
                    if (tabla[i][j] < 0) {
                        // Mensaje para que corrija el valor
                        System.out.println("El valor no puede ser negativo");
                    }
                } while (tabla[i][j] < 0);
            }
        }
        // Devolvemos la tabla
        return tabla;
    }

    // Procedimiento que muestra el total de ventas de cada artículo
    public static void totalPorArticulo(double[][] precios, int[][] cantidades) {
        // Título del reporte
        System.out.println("\nTOTAL DE VENTAS POR ARTÍCULO");
        // Recorremos cada artículo
        for (int i = 0; i < precios.length; i++) {
            // Acumulador del artículo
            double total = 0;
            // Recorremos las sucursales de ese artículo
            for (int j = 0; j < precios[0].length; j++) {
                // Sumamos precio por cantidad vendida en la sucursal
                total += precios[i][j] * cantidades[i][j];
            }
            // Mostramos el total del artículo con 2 decimales
            System.out.printf("Artículo %d: $%.2f%n", i + 1, total);
        }
    }

    // Procedimiento que muestra el total de ventas de cada sucursal
    public static void totalPorSucursal(double[][] precios, int[][] cantidades) {
        // Título del reporte
        System.out.println("\nTOTAL DE VENTAS POR SUCURSAL");
        // Recorremos cada sucursal
        for (int j = 0; j < precios[0].length; j++) {
            // Acumulador de la sucursal
            double total = 0;
            // Recorremos los artículos vendidos en esa sucursal
            for (int i = 0; i < precios.length; i++) {
                // Sumamos precio por cantidad del artículo
                total += precios[i][j] * cantidades[i][j];
            }
            // Mostramos el total de la sucursal con 2 decimales
            System.out.printf("Sucursal %d: $%.2f%n", j + 1, total);
        }
    }
}
