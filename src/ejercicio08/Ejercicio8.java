package ejercicio08;

import java.util.Scanner; // Importa la clase Scanner para leer datos desde el teclado

public class Ejercicio8 {

    public static void main(String[] args) {
        // Crea el objeto Scanner que leerá la entrada del usuario
        Scanner sc = new Scanner(System.in);

        // ===== LECTURA DEL NÚMERO DE OPERARIOS =====
        System.out.print("Ingrese el número de operarios (N): ");
        int n = sc.nextInt();

        // ===== ARREGLOS PARALELOS =====
        // Cada posición i de todos los arreglos corresponde al mismo operario
        String[] codigos = new String[n];        // Código de cada trabajador
        double[] horasAusencia = new double[n];  // Horas de ausencia de cada trabajador
        int[] defectuosos = new int[n];          // Pupitres defectuosos de cada trabajador
        int[] producidos = new int[n];           // Pupitres producidos de cada trabajador
        int[] grados = new int[n];               // Grado de eficiencia calculado de cada trabajador

        // ===== INGRESO DE LOS REGISTROS =====
        // Recorre cada operario y pide sus datos
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Operario " + (i + 1) + " ---");
            System.out.print("Código del trabajador: ");
            codigos[i] = sc.next();               // Lee el código (una palabra)
            System.out.print("Horas de ausencia: ");
            horasAusencia[i] = sc.nextDouble();   // Lee las horas de ausencia (puede tener decimales)
            System.out.print("Pupitres defectuosos: ");
            defectuosos[i] = sc.nextInt();        // Lee la cantidad de pupitres defectuosos
            System.out.print("Pupitres producidos: ");
            producidos[i] = sc.nextInt();         // Lee la cantidad de pupitres producidos

            // Calcula el grado de eficiencia del operario llamando al método calcularGrado
            grados[i] = calcularGrado(horasAusencia[i], defectuosos[i], producidos[i]);
        }

        // ===== IMPRESIÓN DEL REPORTE =====
        System.out.println("\n========================= REPORTE DE EFICIENCIA =========================");
        // Encabezados de la tabla; %-Ns alinea el texto a la izquierda en un ancho de N caracteres
        System.out.printf("%-10s %-15s %-15s %-15s %-8s%n",
                "Código", "H. ausencia", "Defectuosos", "Producidos", "Grado");
        // Imprime una fila por cada operario con sus datos y su grado
        for (int i = 0; i < n; i++) {
            // %-15.1f = decimal con 1 cifra, %-15d = entero, todos alineados a la izquierda
            System.out.printf("%-10s %-15.1f %-15d %-15d %-8d%n",
                    codigos[i], horasAusencia[i], defectuosos[i], producidos[i], grados[i]);
        }

        // Cierra el Scanner para liberar el recurso
        sc.close();
    }

    // ===== MÉTODO PARA CALCULAR EL GRADO DE EFICIENCIA =====
    // Recibe las horas de ausencia, los defectuosos y los producidos,
    // y devuelve el grado según las condiciones que cumpla el operario
    public static int calcularGrado(double horas, int defectuosos, int producidos) {
        // Se evalúa cada condición y se guarda como verdadero/falso
        boolean c1 = horas <= 3;           // Condición 1: no más de 3 horas de ausencia
        boolean c2 = defectuosos < 300;    // Condición 2: menos de 300 pupitres defectuosos
        boolean c3 = producidos > 10000;   // Condición 3: más de 10000 pupitres producidos

        // Se revisan las combinaciones de mayor a menor grado.
        // El orden es importante: el primer "if" que se cumpla devuelve el valor y sale del método
        if (c1 && c2 && c3) return 20;  // Cumple las tres condiciones
        if (c2 && c3) return 15;        // Cumple la 2 y la 3
        if (c1 && c3) return 13;        // Cumple la 1 y la 3
        if (c1 && c2) return 12;        // Cumple la 1 y la 2
        if (c3) return 9;               // Solo cumple la 3
        if (c2) return 8;               // Solo cumple la 2
        if (c1) return 7;               // Solo cumple la 1
        return 5;                       // No cumple ninguna condición
    }
}