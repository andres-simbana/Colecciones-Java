import java.util.Scanner; // Importa la clase Scanner para leer datos desde el teclado

public class Ejercicio6 {

    public static void main(String[] args) {
        // Crea el objeto Scanner que leerá la entrada del usuario
        Scanner sc = new Scanner(System.in);

        // ===== LECTURA DE DIMENSIONES =====
        // Pide el número de vendedores (filas de la matriz)
        System.out.print("Ingrese el número de vendedores (N): ");
        int n = sc.nextInt();
        // Pide el número de años (columnas de la matriz)
        System.out.print("Ingrese el número de años (M): ");
        int m = sc.nextInt();

        // Crea la matriz de ventas: n filas (vendedores) x m columnas (años)
        double[][] ventas = new double[n][m];

        // ===== LLENADO DE LA MATRIZ =====
        // Recorre cada vendedor (fila)
        for (int i = 0; i < n; i++) {
            // Recorre cada año (columna) de ese vendedor
            for (int j = 0; j < m; j++) {
                // Se suma 1 a los índices para mostrar desde 1 y no desde 0
                System.out.print("Ventas del vendedor " + (i + 1) + " en el año " + (j + 1) + ": ");
                ventas[i][j] = sc.nextDouble(); // Guarda la venta en la posición [vendedor][año]
            }
        }

        // ===== IMPRESIÓN DE LA MATRIZ =====
        System.out.println("\n--- MATRIZ DE VENTAS ---");

        // Imprime la fila de encabezados (Año 1, Año 2, ...)
        System.out.print("Vendedor\t");
        for (int j = 0; j < m; j++) {
            System.out.print("Año " + (j + 1) + "\t\t");
        }
        System.out.println(); // Salto de línea al terminar los encabezados

        // Imprime cada fila de la matriz
        for (int i = 0; i < n; i++) {
            System.out.print("V" + (i + 1) + "\t\t"); // Etiqueta del vendedor (V1, V2, ...)
            for (int j = 0; j < m; j++) {
                // Muestra cada venta con 2 decimales, separada por tabulaciones
                System.out.printf("%.2f\t\t", ventas[i][j]);
            }
            System.out.println(); // Salto de línea al terminar la fila del vendedor
        }

        // ===== a) TOTAL DE VENTAS POR VENDEDOR =====
        // Se suma cada FILA de la matriz
        System.out.println("\na) TOTAL DE VENTAS POR VENDEDOR");
        for (int i = 0; i < n; i++) {
            double totalVendedor = 0; // Se reinicia el acumulador para cada vendedor
            for (int j = 0; j < m; j++) {
                totalVendedor += ventas[i][j]; // Acumula las ventas de todos los años del vendedor i
            }
            System.out.printf("Vendedor %d: $%.2f%n", (i + 1), totalVendedor);
        }

        // ===== b) TOTAL DE VENTAS POR AÑO =====
        // Se suma cada COLUMNA de la matriz (por eso el bucle externo recorre j)
        System.out.println("\nb) TOTAL DE VENTAS POR AÑO");
        for (int j = 0; j < m; j++) {
            double totalAnio = 0; // Se reinicia el acumulador para cada año
            for (int i = 0; i < n; i++) {
                totalAnio += ventas[i][j]; // Acumula las ventas de todos los vendedores en el año j
            }
            System.out.printf("Año %d: $%.2f%n", (j + 1), totalAnio);
        }

        // ===== c) TOTAL DE VENTAS DE LA EMPRESA =====
        // Se suman TODOS los elementos de la matriz
        double totalEmpresa = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                totalEmpresa += ventas[i][j];
            }
        }
        System.out.printf("%nc) TOTAL DE VENTAS DE LA EMPRESA: $%.2f%n", totalEmpresa);

        // Cierra el Scanner para liberar el recurso
        sc.close();
    }
}