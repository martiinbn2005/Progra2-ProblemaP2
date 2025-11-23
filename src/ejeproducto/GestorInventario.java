package ejeproducto;

import java.util.*;
import java.time.LocalDate;

public class GestorInventario {

    public static void main(String[] args) {

        List<Producto> listado = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int opc;

        do {
            menu();
            opc = Integer.parseInt(sc.nextLine());

            switch (opc) {

                case 1: {
                    System.out.println("INGRESE PRODUCTO CON FECHA DE VENCIMIENTO");

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Costo unitario: ");
                    double costo = Double.parseDouble(sc.nextLine());

                    System.out.print("Stock: ");
                    int stock = Integer.parseInt(sc.nextLine());

                    System.out.print("Fecha de vencimiento (AAAA-MM-DD): ");
                    LocalDate fechaVencimiento = LocalDate.parse(sc.nextLine());

                    listado.add(new ProductoCaduco(nombre, costo, stock, fechaVencimiento));
                    System.out.println("Producto agregado correctamente\n");
                }
                break;

                case 2: {
                    System.out.println("INGRESE PRODUCTO SIN FECHA DE VENCIMIENTO");

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Costo unitario: ");
                    double costo = Double.parseDouble(sc.nextLine());

                    System.out.print("Stock: ");
                    int stock = Integer.parseInt(sc.nextLine());

                    listado.add(new ProductoAdicional(nombre, costo, stock));
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
