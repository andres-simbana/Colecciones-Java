![UISRAEL](img/logo-uisrael.png)

# Tarea1 S2 - Colecciones

Materia: Fundamentos de la Especialidad I
Carrera: Ingeniería Informática - UISRAEL
Integrantes: José Franco - Sebastián Simbaña

Ejercicios de la tarea hechos en Java, usando métodos, arreglos y matrices.
Cada ejercicio está en su propio paquete dentro de la carpeta src (ejercicio01 a ejercicio10).

Para ejecutarlos se abre la carpeta en VS Code y se da Run en el main de cada ejercicio.

## Ejercicio 1: reprobados en Matemática e Inglés

Elabore un programa que forme dos arreglos de N dimensiones (N se ingresa por teclado). El primero contiene los números de cédula de estudiantes que reprobaron la asignatura de "MATEMATICA" y el segundo contiene los números de cédula de estudiantes que reprobaron la asignatura de "INGLES". Partiendo de los dos vectores, se debe formar un tercero que contenga el código de estudiantes que reprobaron las dos materias. Al finalizar se debe imprimir los tres vectores.

## Ejercicio 2: vector de 20 números aleatorios

Se tiene un vector de 20 elementos con valores numéricos enteros (aleatorios). Se debe realizar:

- a. Leer por teclado un número y buscar en qué posición del vector se encuentra.
- b. Crear un segundo vector con los elementos de las posiciones del índice impar del vector original e imprima el vector resultante.
- c. Busque en el segundo vector cuantos elementos son mayores a 20 y muestre el resultado.

## Ejercicio 3: búsqueda de empleados por código

Una empresa requiere un programa que permita ingresar los códigos y nombres de N empleados (N se ingresa por teclado). Al finalizar, debe solicitar ingresar un código y se debe imprimir el nombre del empleado que corresponda.

## Ejercicio 4: operaciones con matrices

Implementar un programa que permita realizar operaciones sobre matrices de M x N y lleno con elementos enteros generados de manera aleatoria. Se debe permitir al usuario seleccionar alguna de las siguientes operaciones: Sumar, restar, multiplicar y trasponer matrices.

## Ejercicio 5: ventas por artículo y sucursal

Una fábrica produce N artículos diferentes y los distribuye a través de M sucursales. El precio de venta de cada artículo puede variar dependiendo de la sucursal donde se comercializa. Para ello, la fábrica dispone de una tabla donde se registra el precio de cada artículo en cada sucursal.

Al finalizar cada periodo, cada sucursal reporta a la fábrica la cantidad vendida de cada artículo, generándose así una segunda tabla con esta información.

Se solicita elaborar un programa que permita calcular:

- El total de ventas por cada artículo
- El total de ventas por cada sucursal

## Ejercicio 6: ventas por vendedor y año

Elaborar un programa que consolide una matriz de N x M elementos. Cada elemento de la matriz representa las ventas atribuibles a cada uno de los N vendedores de una empresa, para cada uno de los M años de operaciones que ha tenido la misma. Se debe calcular:

- a. El total de ventas de cada vendedor de los M años.
- b. El total de ventas en cada año.
- c. El total de ventas de la empresa.

## Ejercicio 7: calificaciones de estudiantes

En una universidad, se tiene un grupo de N estudiantes; cada uno de ellos toma 8 materias; semestralmente el profesor de cada materia reporta a secretaría general el código del estudiante, el número de la materia y la calificación final. Elaborar un algoritmo que obtenga:

- a. El promedio de las calificaciones obtenidas por cada estudiante.
- b. El promedio de la calificación por cada materia.
- c. El estudiante con mayor promedio.
- d. El número de estudiantes aprobados (nota final >= 7 y <= 10) por cada materia.
- e. El número de estudiantes reprobados (nota final < 7) por cada materia.

## Ejercicio 8: eficiencia de operarios

Se desea obtener el grado de eficiencia de N operarios de una fábrica productora de pupitres, de acuerdo con las siguientes condiciones que se les impone para un periodo determinado:

- a. Ausencia del trabajo <= 3 horas
- b. Pupitres defectuosos < 300
- c. Pupitres producidos > 10000

Los grados de eficiencia del trabajador son asignados de la siguiente forma: si no cumple ninguna condición, grado 5; si sólo cumple la primera, grado 7; si sólo cumple la segunda, grado 8; si sólo cumple la tercera, grado 9; si cumple la primera y la segunda, grado 12; si cumple la primera y la tercera, grado 13; si cumple la segunda y la tercera, grado 15; y si cumple las tres, grado 20.

Por cada trabajador se tiene un registro con los siguientes datos: código del trabajador, horas de ausencia, pupitres defectuosos y pupitres producidos. Elaborar un programa que calcule para cada trabajador su correspondiente grado de eficiencia e imprima toda su información.

## Ejercicio 9: inventario de farmacia

Una farmacia necesita controlar el inventario de sus medicamentos. Por cada medicamento se debe registrar el nombre, stock actual, stock mínimo y precio unitario. Elabore un programa que permita:

- a. Registrar varios medicamentos en una lista.
- b. Mostrar los medicamentos cuyo stock esté por debajo del mínimo.
- c. Calcular el valor económico total del inventario.
- d. Actualizar el stock después de una venta.
- e. Mostrar un reporte general del inventario.

## Ejercicio 10: pedidos de restaurante

Un restaurante registra los pedidos realizados por sus clientes. Por cada pedido se debe ingresar el nombre del cliente, plato solicitado, cantidad y precio unitario. Elabore un programa que permita:

- a. Registrar pedidos en una lista.
- b. Calcular el total a pagar por cada pedido.
- c. Aplicar un descuento del 10% si el pedido supera los 50 USD.
- d. Calcular el ingreso total del restaurante.
- e. Mostrar el pedido de mayor valor.
