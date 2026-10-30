package ejercicio01;

import java.util.Scanner;

// Ejercicio 1: estudiantes que reprobaron Matemática, Inglés y ambas materias
public class Ejercicio1 {

    // Scanner para leer los datos del teclado
    static Scanner teclado = new Scanner(System.in);

    // Método principal, aquí empieza el programa
    public static void main(String[] args) {
        // Pedimos el tamaño de los arreglos (tiene que ser mayor a 0)
        int n = leerPositivo("Ingrese N: ");

        // Llenamos el arreglo de Matemática
        String[] matematica = leerCedulas("MATEMATICA", n);
        // Llenamos el arreglo de Inglés
        String[] ingles = leerCedulas("INGLES", n);
        // Formamos el tercer arreglo con los que reprobaron las dos
        String[] ambas = reprobaronAmbas(matematica, ingles);

        // Mostramos el primer arreglo
        imprimir("Reprobados en MATEMATICA", matematica);
        // Mostramos el segundo arreglo
        imprimir("Reprobados en INGLES", ingles);
        // Si nadie coincide, el tercer arreglo queda vacío y lo explicamos
        if (ambas.length == 0) {
            // Mensaje para que no se vea un listado en blanco
            System.out.println("\nNingún estudiante reprobó las dos materias");
        } else {
            // Mostramos el tercer arreglo
            imprimir("Reprobados en las DOS materias", ambas);
        }

        // Ya no vamos a leer nada más, así que cerramos el Scanner
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

    // Función que lee N cédulas y devuelve el arreglo lleno
    public static String[] leerCedulas(String materia, int n) {
        // Creamos el arreglo con N espacios
        String[] cedulas = new String[n];
        // Indicamos de qué materia son las cédulas
        System.out.println("\nCédulas de los que reprobaron " + materia);
        // Recorremos el arreglo para llenarlo
        for (int i = 0; i < n; i++) {
            // Una misma cédula no puede estar dos veces en la lista
            do {
                // Pedimos la cédula
                System.out.print("Cédula " + (i + 1) + ": ");
                // La guardamos como texto porque puede empezar con 0
                cedulas[i] = teclado.next();
                // Si ya la habían ingresado, avisamos
                if (yaIngresada(cedulas, i)) {
                    // Le avisamos que está repetida
                    System.out.println("Esa cédula ya fue ingresada");
                }
            } while (yaIngresada(cedulas, i));
        }
        // Devolvemos el arreglo
        return cedulas;
    }

    // Función que revisa si la cédula de la posición actual ya está antes en el arreglo
    public static boolean yaIngresada(String[] cedulas, int actual) {
        // Revisamos solo las posiciones anteriores
        for (int i = 0; i < actual; i++) {
            // Si coincide con alguna, ya estaba
            if (cedulas[i].equals(cedulas[actual])) {
                // La encontramos antes, así que está repetida
                return true;
            }
        }
        // No estaba repetida
        return false;
    }

    // Función que forma un arreglo con las cédulas que están en los dos arreglos
    public static String[] reprobaronAmbas(String[] a, String[] b) {
        // Primero contamos cuántas cédulas se repiten
        int contador = 0;
        // Recorremos el primer arreglo
        for (int i = 0; i < a.length; i++) {
            // Comparamos con cada cédula del segundo arreglo
            for (int j = 0; j < b.length; j++) {
                // Si son iguales, la contamos
                if (a[i].equals(b[j])) {
                    // Sumamos una coincidencia
                    contador++;
                    // Con encontrarla una vez basta, así no se cuenta dos veces
                    break;
                }
            }
        }

        // Creamos el tercer arreglo con el tamaño exacto
        String[] ambas = new String[contador];
        // Posición donde vamos guardando
        int k = 0;
        // Recorremos otra vez el primer arreglo
        for (int i = 0; i < a.length; i++) {
            // Y lo comparamos de nuevo con el segundo
            for (int j = 0; j < b.length; j++) {
                // Si la cédula está en los dos, la guardamos
                if (a[i].equals(b[j])) {
                    // Copiamos la cédula al tercer arreglo
                    ambas[k] = a[i];
                    // Pasamos a la siguiente posición
                    k++;
                    // Igual que arriba, no seguimos buscando la misma cédula
                    break;
                }
            }
        }
        // Devolvemos el tercer arreglo
        return ambas;
    }

    // Procedimiento que imprime un arreglo
    public static void imprimir(String titulo, String[] arreglo) {
        // Mostramos el título
        System.out.println("\n" + titulo + ":");
        // Recorremos el arreglo
        for (int i = 0; i < arreglo.length; i++) {
            // Mostramos la posición y la cédula que hay en ella
            System.out.println("[" + i + "] " + arreglo[i]);
        }
    }
}
