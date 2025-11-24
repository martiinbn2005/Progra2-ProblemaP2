package ejeproducto;

import java.util.*;
import java.time.LocalDate;

public class GestorInventario {

    public static void main(String[] args) {

        List<Producto> listado = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int opc;

        // contadores para los limites
        int stockHelados = 0;      // máximo 500 unidades helados
        int stockOtros = 0;        // máximo 100 unidades de otros productos
        double totalCosto = 0;     // máximo 400 USD
        int tiposHelado = 0;       // máximo 5 tipos de helado

        do {
            menu();
            opc = Integer.parseInt(sc.nextLine());

            switch (opc) {

                case 1: {
                    System.out.println("INGRESE PRODUCTO HELADO");

                    // Validar límite de tipos de helado
                    if (tiposHelado >= 5) {
                        System.out.println("ERROR: Ya existen 5 tipos de helado registrados.\n");
                        break;
                    }

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Costo unitario: ");
                    double costoUnitario = Double.parseDouble(sc.nextLine());

                    System.out.print("Stock: ");
                    int stock = Integer.parseInt(sc.nextLine());

                    // Validar límite de cantidad total
                    if (stockHelados + stock > 500) {
                        System.out.println("ERROR: No se puede agregar. Se supera el máximo de 500 unidades.\n");
                        break;
                    }

                    // Validar límite de costo total
                    if (totalCosto + (costoUnitario * stock) > 400) {
                        System.out.println("ERROR: No se puede agregar. Se supera el costo total permitido (400 USD).\n");
                        break;
                    }

                    System.out.print("Fecha de vencimiento (AAAA-MM-DD): ");
                    LocalDate fechaVencimiento = LocalDate.parse(sc.nextLine());

                    listado.add(new ProductoCaduco(nombre, costoUnitario, stock, fechaVencimiento));

                    // Actualizar contadores
                    stockHelados += stock;
                    totalCosto += costoUnitario * stock;
                    tiposHelado++;

                    System.out.println("Producto agregado correctamente\n");
                }
                break;

                case 2: {
                    System.out.println("INGRESE PRODUCTO SIN FECHA DE VENCIMIENTO");

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Costo unitario: ");
                    double costoUnitario = Double.parseDouble(sc.nextLine());

                    System.out.print("Stock: ");
                    int stock = Integer.parseInt(sc.nextLine());

                    // Validar límite de cantidad total
                    if (stockOtros + stock > 100) {
                        System.out.println("ERROR: No se puede agregar. Se supera el máximo de 100 unidades.\n");
                        break;
                    }

                    // Validar límite de costo total
                    if (totalCosto + (costoUnitario * stock) > 400) {
                        System.out.println("ERROR: No se puede agregar. Se supera el costo total permitido (400 USD).\n");
                        break;
                    }

                    listado.add(new ProductoAdicional(nombre, costoUnitario, stock));

                    // Actualizar contadores
                    stockOtros += stock;
                    totalCosto += costoUnitario * stock;

                    System.out.println("Producto agregado correctamente\n");
                }
                break;

                case 3: {
                    System.out.println("LISTA DE PRODUCTOS");
                    if (listado.isEmpty()) {
                        System.out.println("No hay productos registrados\n");
                    } else {
                        for (Producto p : listado) {
                            System.out.println(p.mostrarDatos());
                            System.out.println("------------------------------");
                        }
                    }
                }
                break;

                case 4: {
                    System.out.println("Saliendo del programa...");
                }
                break;

                default:
                    System.out.println("ERROR: Opción no válida\n");
            }

        } while (opc != 4);
    }

    static void menu() {
        System.out.println("----- MENÚ DE INVENTARIO -----");
        System.out.println("1. Ingresar Producto con Vencimiento");
        System.out.println("2. Ingresar Producto sin Vencimiento");
        System.out.println("3. Mostrar Lista de Productos");
        System.out.println("4. Salir");
        System.out.print("Ingrese una opción: ");
    }
}
