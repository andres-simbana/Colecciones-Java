package ejercicio03;

import java.util.Scanner;

// Ejercicio 3: buscar el nombre de un empleado por su código
public class Ejercicio3 {

    // Scanner para leer los datos del teclado
    static Scanner teclado = new Scanner(System.in);

    // Método principal, aquí empieza el programa
    public static void main(String[] args) {
        // Pedimos la cantidad de empleados (mínimo 1)
        int n = leerPositivo("Ingrese el número de empleados: ");
        // Limpiamos el salto de línea que deja nextInt
        teclado.nextLine();

        // Arreglo de códigos
        String[] codigos = new String[n];
        // Arreglo de nombres (misma posición = mismo empleado)
        String[] nombres = new String[n];
        // Registramos los empleados
        registrarEmpleados(codigos, nombres);

        // Pedimos el código a buscar
        System.out.print("\nIngrese el código a buscar: ");
        // Leemos el código
        String codigo = teclado.nextLine();
        // Mostramos el nombre que corresponde al código
        mostrarEmpleado(codigos, nombres, codigo);

        // Ya terminamos de leer, cerramos el Scanner
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

    // Procedimiento que llena los arreglos de códigos y nombres
    public static void registrarEmpleados(String[] codigos, String[] nombres) {
        // Recorremos cada posición
        for (int i = 0; i < codigos.length; i++) {
            // Indicamos el número de empleado
            System.out.println("\nEmpleado " + (i + 1));
            // Pedimos el código
            System.out.print("Código: ");
            // Guardamos el código
            codigos[i] = teclado.nextLine();
            // Pedimos el nombre
            System.out.print("Nombre: ");
            // Guardamos el nombre en la misma posición
            nombres[i] = teclado.nextLine();
        }
    }

    // Función que devuelve la posición del código o -1 si no está
    public static int buscar(String[] codigos, String codigo) {
        // Recorremos los códigos
        for (int i = 0; i < codigos.length; i++) {
            // Si es igual, devolvemos la posición
            if (codigos[i].equals(codigo)) {
                // Lo encontramos, devolvemos su posición
                return i;
            }
        }
        // Si no se encontró devolvemos -1
        return -1;
    }

    // Procedimiento que muestra el nombre del empleado buscado
    public static void mostrarEmpleado(String[] codigos, String[] nombres, String codigo) {
        // Buscamos la posición del código
        int posicion = buscar(codigos, codigo);
        // Si existe, mostramos el nombre
        if (posicion != -1) {
            // Mostramos el nombre del empleado
            System.out.println("El empleado es: " + nombres[posicion]);
        } else {
            // Si no existe, lo indicamos
            System.out.println("No existe un empleado con ese código");
        }
    }
}
