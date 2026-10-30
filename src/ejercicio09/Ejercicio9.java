package ejercicio09;

import java.util.ArrayList; // Importa ArrayList para guardar una lista dinámica de medicamentos
import java.util.Scanner;   // Importa Scanner para leer datos desde el teclado

// ===== CLASE MEDICAMENTO =====
// Representa un medicamento del inventario con sus datos y operaciones
class Medicamento {
    // Atributos privados (encapsulamiento): solo se acceden mediante métodos
    private String nombre;          // Nombre del medicamento
    private int stockActual;        // Cantidad disponible actualmente
    private int stockMinimo;        // Cantidad mínima que debería haber
    private double precioUnitario;  // Precio de una unidad

    // Constructor: inicializa el medicamento con los datos recibidos
    public Medicamento(String nombre, int stockActual, int stockMinimo, double precioUnitario) {
        this.nombre = nombre;               // "this" diferencia el atributo del parámetro
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
        this.precioUnitario = precioUnitario;
    }

    // Getters: permiten leer los atributos privados desde fuera de la clase
    public String getNombre() { return nombre; }
    public int getStockActual() { return stockActual; }
    public int getStockMinimo() { return stockMinimo; }
    public double getPrecioUnitario() { return precioUnitario; }

    // Devuelve true si el stock actual es menor que el mínimo (hay que reponer)
    public boolean estaBajoMinimo() {
        return stockActual < stockMinimo;
    }

    // Calcula el valor en dinero de este medicamento en el inventario
    public double valorInventario() {
        return stockActual * precioUnitario;
    }

    // Registra una venta: descuenta la cantidad del stock si es válida
    // Devuelve true si la venta se realizó, false si no
    public boolean vender(int cantidad) {
        // No se permite vender 0, cantidades negativas ni más de lo que hay en stock
        if (cantidad <= 0 || cantidad > stockActual) {
            return false;
        }
        stockActual -= cantidad; // Resta la cantidad vendida al stock
        return true;
    }
}

// ===== CLASE PRINCIPAL =====
public class Ejercicio9 {

    // Lista que almacena todos los medicamentos registrados (static para usarla en todos los métodos)
    static ArrayList<Medicamento> inventario = new ArrayList<>();
    // Scanner compartido por todos los métodos
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        // ===== MENÚ PRINCIPAL =====
        // El do-while muestra el menú al menos una vez y se repite hasta elegir 0
        do {
            System.out.println("\n======= FARMACIA - INVENTARIO =======");
            System.out.println("1. Registrar medicamento");
            System.out.println("2. Medicamentos bajo el stock mínimo");
            System.out.println("3. Valor total del inventario");
            System.out.println("4. Registrar una venta (actualizar stock)");
            System.out.println("5. Reporte general");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpia el salto de línea que deja nextInt() en el buffer

            // Ejecuta el método correspondiente a la opción elegida
            switch (opcion) {
                case 1: registrar(); break;
                case 2: bajoMinimo(); break;
                case 3: valorTotal(); break;
                case 4: venta(); break;
                case 5: reporte(); break;
                case 0: System.out.println("Fin del programa."); break;
                default: System.out.println("Opción no válida."); // Cualquier otro número
            }
        } while (opcion != 0); // Termina cuando el usuario elige 0
    }

    // ===== OPCIÓN 1: REGISTRAR MEDICAMENTOS =====
    static void registrar() {
        System.out.print("¿Cuántos medicamentos desea registrar? ");
        int cantidad = sc.nextInt();
        sc.nextLine(); // Limpia el buffer antes de leer texto con nextLine()
        // Pide los datos de cada medicamento
        for (int i = 0; i < cantidad; i++) {
            System.out.println("\nMedicamento " + (i + 1));
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();      // nextLine() permite nombres con espacios
            System.out.print("Stock actual: ");
            int stock = sc.nextInt();
            System.out.print("Stock mínimo: ");
            int minimo = sc.nextInt();
            System.out.print("Precio unitario: ");
            double precio = sc.nextDouble();
            sc.nextLine(); // Limpia el buffer para el siguiente nombre
            // Crea el objeto Medicamento y lo agrega a la lista
            inventario.add(new Medicamento(nombre, stock, minimo, precio));
        }
        System.out.println("Medicamentos registrados correctamente.");
    }

    // ===== OPCIÓN 2: MEDICAMENTOS BAJO EL STOCK MÍNIMO =====
    static void bajoMinimo() {
        System.out.println("\n--- MEDICAMENTOS BAJO EL STOCK MÍNIMO ---");
        boolean hay = false; // Bandera para saber si se encontró al menos uno
        // Recorre la lista con un for-each
        for (Medicamento m : inventario) {
            if (m.estaBajoMinimo()) {
                System.out.println(m.getNombre() + " | Stock: " + m.getStockActual()
                        + " | Mínimo: " + m.getStockMinimo());
                hay = true; // Se encontró al menos uno
            }
        }
        // Si no se encontró ninguno, muestra un mensaje
        if (!hay) {
            System.out.println("Todos los medicamentos tienen stock suficiente.");
        }
    }

    // ===== OPCIÓN 3: VALOR TOTAL DEL INVENTARIO =====
    static void valorTotal() {
        double total = 0; // Acumulador
        for (Medicamento m : inventario) {
            total += m.valorInventario(); // Suma stock * precio de cada medicamento
        }
        System.out.printf("Valor total del inventario: $%.2f%n", total);
    }

    // ===== OPCIÓN 4: REGISTRAR UNA VENTA =====
    static void venta() {
        System.out.print("Nombre del medicamento vendido: ");
        String nombre = sc.nextLine();
        Medicamento encontrado = buscar(nombre); // Busca el medicamento por su nombre
        // Si no existe, avisa y sale del método
        if (encontrado == null) {
            System.out.println("El medicamento no existe en el inventario.");
            return;
        }
        System.out.print("Cantidad vendida: ");
        int cantidad = sc.nextInt();
        sc.nextLine(); // Limpia el buffer
        // Intenta realizar la venta; vender() devuelve true si fue posible
        if (encontrado.vender(cantidad)) {
            System.out.println("Venta registrada. Nuevo stock: " + encontrado.getStockActual());
            // Después de vender, verifica si quedó por debajo del mínimo
            if (encontrado.estaBajoMinimo()) {
                System.out.println("¡Atención! El medicamento quedó por debajo del stock mínimo.");
            }
        } else {
            System.out.println("Cantidad no válida o stock insuficiente.");
        }
    }

    // ===== OPCIÓN 5: REPORTE GENERAL =====
    static void reporte() {
        // Si la lista está vacía, no hay nada que mostrar
        if (inventario.isEmpty()) {
            System.out.println("No hay medicamentos registrados.");
            return;
        }
        System.out.println("\n==================== REPORTE GENERAL ====================");
        // Encabezados de la tabla alineados a la izquierda con anchos fijos
        System.out.printf("%-20s %-8s %-8s %-10s %-12s %-10s%n",
                "Nombre", "Stock", "Mínimo", "Precio", "Valor", "Estado");
        double total = 0; // Acumulador del valor total
        for (Medicamento m : inventario) {
            // Operador ternario: si está bajo el mínimo muestra "REPONER", si no "OK"
            String estado = m.estaBajoMinimo() ? "REPONER" : "OK";
            // Imprime una fila por medicamento
            System.out.printf("%-20s %-8d %-8d $%-9.2f $%-11.2f %-10s%n",
                    m.getNombre(), m.getStockActual(), m.getStockMinimo(),
                    m.getPrecioUnitario(), m.valorInventario(), estado);
            total += m.valorInventario(); // Va sumando el valor de cada medicamento
        }
        System.out.printf("Valor total del inventario: $%.2f%n", total);
    }

    // ===== MÉTODO AUXILIAR: BUSCAR MEDICAMENTO POR NOMBRE =====
    // Devuelve el medicamento si lo encuentra, o null si no existe
    static Medicamento buscar(String nombre) {
        for (Medicamento m : inventario) {
            // equalsIgnoreCase compara sin importar mayúsculas/minúsculas
            if (m.getNombre().equalsIgnoreCase(nombre)) {
                return m;
            }
        }
        return null; // No se encontró
    }
}