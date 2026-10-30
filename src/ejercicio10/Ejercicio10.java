package ejercicio10;

import java.util.ArrayList; // Importa ArrayList para guardar una lista dinámica de pedidos
import java.util.Scanner;   // Importa Scanner para leer datos desde el teclado

// ===== CLASE PEDIDO =====
// Representa un pedido del restaurante con sus datos y cálculos
class Pedido {
    // Atributos privados (encapsulamiento): solo se acceden mediante métodos
    private String cliente;         // Nombre del cliente
    private String plato;           // Plato solicitado
    private int cantidad;           // Cantidad de platos
    private double precioUnitario;  // Precio de un plato

    // Constructor: inicializa el pedido con los datos recibidos
    public Pedido(String cliente, String plato, int cantidad, double precioUnitario) {
        this.cliente = cliente;               // "this" diferencia el atributo del parámetro
        this.plato = plato;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    // Getters: permiten leer los atributos privados desde fuera de la clase
    public String getCliente() { return cliente; }
    public String getPlato() { return plato; }
    public int getCantidad() { return cantidad; }
    public double getPrecioUnitario() { return precioUnitario; }

    // Calcula el subtotal: cantidad * precio unitario
    public double getSubtotal() {
        return cantidad * precioUnitario;
    }

    // Calcula el descuento con un operador ternario:
    // si el subtotal supera $50 se aplica el 10%, si no el descuento es 0
    public double getDescuento() {
        return getSubtotal() > 50 ? getSubtotal() * 0.10 : 0;
    }

    // Calcula el total a pagar: subtotal menos descuento
    public double getTotal() {
        return getSubtotal() - getDescuento();
    }
}

// ===== CLASE PRINCIPAL =====
public class Ejercicio10 {

    public static void main(String[] args) {
        // Crea el Scanner para leer la entrada del usuario
        Scanner sc = new Scanner(System.in);
        // Lista donde se guardarán todos los pedidos
        ArrayList<Pedido> pedidos = new ArrayList<>();

        // ===== LECTURA DEL NÚMERO DE PEDIDOS =====
        System.out.print("¿Cuántos pedidos desea registrar? ");
        int n = sc.nextInt();
        sc.nextLine(); // Limpia el salto de línea que deja nextInt() en el buffer

        // ===== REGISTRO DE PEDIDOS =====
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Pedido " + (i + 1) + " ---");
            System.out.print("Nombre del cliente: ");
            String cliente = sc.nextLine();   // nextLine() permite nombres con espacios
            System.out.print("Plato solicitado: ");
            String plato = sc.nextLine();
            System.out.print("Cantidad: ");
            int cantidad = sc.nextInt();
            System.out.print("Precio unitario (USD): ");
            double precio = sc.nextDouble();
            sc.nextLine(); // Limpia el buffer para el siguiente nombre de cliente
            // Crea el objeto Pedido y lo agrega a la lista
            pedidos.add(new Pedido(cliente, plato, cantidad, precio));
        }

        // Si no se registró ningún pedido, avisa y termina el programa
        if (pedidos.isEmpty()) {
            System.out.println("No se registraron pedidos.");
            sc.close();
            return; // Sale del main
        }

        // ===== IMPRESIÓN DEL DETALLE DE PEDIDOS =====
        System.out.println("\n============================ DETALLE DE PEDIDOS ============================");
        // Encabezados de la tabla alineados a la izquierda con anchos fijos
        System.out.printf("%-15s %-18s %-6s %-10s %-11s %-10s %-10s%n",
                "Cliente", "Plato", "Cant.", "P. unit.", "Subtotal", "Descuento", "Total");

        double ingresoTotal = 0;        // Acumulador del ingreso total del restaurante
        Pedido mayor = pedidos.get(0);  // Se asume que el primer pedido es el de mayor valor

        // Recorre todos los pedidos con un for-each
        for (Pedido p : pedidos) {
            // Imprime una fila con los datos y cálculos del pedido
            System.out.printf("%-15s %-18s %-6d $%-9.2f $%-10.2f $%-9.2f $%-9.2f%n",
                    p.getCliente(), p.getPlato(), p.getCantidad(), p.getPrecioUnitario(),
                    p.getSubtotal(), p.getDescuento(), p.getTotal());

            ingresoTotal += p.getTotal(); // Suma el total del pedido al ingreso general

            // Si este pedido tiene un total mayor, pasa a ser el nuevo "mayor"
            if (p.getTotal() > mayor.getTotal()) {
                mayor = p;
            }
        }

        // ===== d) INGRESO TOTAL =====
        System.out.printf("%nd) INGRESO TOTAL DEL RESTAURANTE: $%.2f%n", ingresoTotal);

        // ===== e) PEDIDO DE MAYOR VALOR =====
        System.out.println("\ne) PEDIDO DE MAYOR VALOR");
        System.out.println("Cliente: " + mayor.getCliente());
        System.out.println("Plato: " + mayor.getPlato());
        System.out.println("Cantidad: " + mayor.getCantidad());
        System.out.printf("Total pagado: $%.2f%n", mayor.getTotal());

        // Cierra el Scanner para liberar el recurso
        sc.close();
    }
}