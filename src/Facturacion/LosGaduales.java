package Facturacion;

import java.util.Scanner;

public class LosGaduales {
    public static void main(String[] args) {
        ConjuntoResidencial conjunto = new ConjuntoResidencial();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            mostrarMenu();
            System.out.print("Elija una opcion: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Opción inválida. Elija una opción válida: ");
                scanner.next();
            }
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    conjunto.registrarConsumo();
                    break;
                case 2:
                    conjunto.consultarFactura();
                    break;
                case 3:
                    conjunto.generarReporte();
                    break;
                case 4:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (opcion != 4);

        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("\nLOS GUADUALES - CONTROL DE AGUA");
        System.out.println("1. Registrar consumo de un apartamento");
        System.out.println("2. Consultar factura de un apartamento");
        System.out.println("3. Ver reporte general del conjunto");
        System.out.println("4. Salir");
    }
}
