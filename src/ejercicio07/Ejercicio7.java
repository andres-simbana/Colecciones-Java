import java.util.Scanner; // Importa la clase Scanner para leer datos desde el teclado

public class Ejercicio7 {

    // Constante con el número fijo de materias por estudiante
    static final int MATERIAS = 8;

    public static void main(String[] args) {
        // Crea el objeto Scanner que leerá la entrada del usuario
        Scanner sc = new Scanner(System.in);

        // ===== LECTURA DEL NÚMERO DE ESTUDIANTES =====
        System.out.print("Ingrese el número de estudiantes (N): ");
        int n = sc.nextInt();

        // Arreglo para guardar el código de cada estudiante
        String[] codigos = new String[n];
        // Matriz de notas: n filas (estudiantes) x 8 columnas (materias)
        double[][] notas = new double[n][MATERIAS];

        // ===== LLENADO DE CÓDIGOS Y NOTAS =====
        // Recorre cada estudiante (fila)
        for (int i = 0; i < n; i++) {
            System.out.print("\nCódigo del estudiante " + (i + 1) + ": ");
            codigos[i] = sc.next(); // Lee el código del estudiante (una palabra)

            // Recorre cada materia (columna) del estudiante
            for (int j = 0; j < MATERIAS; j++) {
                double nota;
                // Bucle do-while para validar que la nota esté entre 0 y 10
                do {
                    System.out.print("  Nota final de la materia " + (j + 1) + " (0-10): ");
                    nota = sc.nextDouble();
                    // Si la nota está fuera de rango, muestra un mensaje de error
                    if (nota < 0 || nota > 10) {
                        System.out.println("  Nota inválida, debe estar entre 0 y 10.");
                    }
                } while (nota < 0 || nota > 10); // Repite mientras la nota sea inválida
                notas[i][j] = nota; // Guarda la nota válida en la matriz
            }
        }

        // ===== a) PROMEDIO POR ESTUDIANTE =====
        // Arreglo para guardar el promedio de cada estudiante (se usa luego en el literal c)
        double[] promedioEstudiante = new double[n];
        System.out.println("\na) PROMEDIO POR ESTUDIANTE");
        // Se recorre cada FILA de la matriz
        for (int i = 0; i < n; i++) {
            double suma = 0; // Se reinicia el acumulador para cada estudiante
            for (int j = 0; j < MATERIAS; j++) {
                suma += notas[i][j]; // Suma las 8 notas del estudiante i
            }
            promedioEstudiante[i] = suma / MATERIAS; // Calcula y guarda el promedio
            System.out.printf("Estudiante %s: %.2f%n", codigos[i], promedioEstudiante[i]);
        }

        // ===== b) PROMEDIO POR MATERIA =====
        // Se recorre cada COLUMNA de la matriz (por eso el bucle externo recorre j)
        System.out.println("\nb) PROMEDIO POR MATERIA");
        for (int j = 0; j < MATERIAS; j++) {
            double suma = 0; // Se reinicia el acumulador para cada materia
            for (int i = 0; i < n; i++) {
                suma += notas[i][j]; // Suma las notas de todos los estudiantes en la materia j
            }
            System.out.printf("Materia %d: %.2f%n", (j + 1), suma / n); // Promedio = suma / número de estudiantes
        }

        // ===== c) ESTUDIANTE CON MAYOR PROMEDIO =====
        // Se asume que el primer estudiante (índice 0) es el mejor al inicio
        int mejor = 0;
        // Se compara con los demás estudiantes desde el índice 1
        for (int i = 1; i < n; i++) {
            // Si encuentra un promedio mayor, actualiza el índice del mejor
            if (promedioEstudiante[i] > promedioEstudiante[mejor]) {
                mejor = i;
            }
        }
        System.out.printf("%nc) ESTUDIANTE CON MAYOR PROMEDIO: %s con %.2f%n",
                codigos[mejor], promedioEstudiante[mejor]);

        // ===== d) y e) APROBADOS Y REPROBADOS POR MATERIA =====
        System.out.println("\nd) y e) APROBADOS Y REPROBADOS POR MATERIA");
        // Se recorre cada materia (columna)
        for (int j = 0; j < MATERIAS; j++) {
            int aprobados = 0;  // Contador de aprobados en la materia j
            int reprobados = 0; // Contador de reprobados en la materia j
            // Se revisa la nota de cada estudiante en esa materia
            for (int i = 0; i < n; i++) {
                // Aprueba si la nota está entre 7 y 10
                if (notas[i][j] >= 7 && notas[i][j] <= 10) {
                    aprobados++;
                // Reprueba si la nota es menor a 7
                } else if (notas[i][j] < 7) {
                    reprobados++;
                }
            }
            System.out.println("Materia " + (j + 1) + ": Aprobados = " + aprobados
                    + " | Reprobados = " + reprobados);
        }

        // Cierra el Scanner para liberar el recurso
        sc.close();
    }
}