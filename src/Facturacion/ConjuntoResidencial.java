package Facturacion;

import java.util.Scanner;

public class ConjuntoResidencial {
    private Apartamento[] apartamentos;

    public ConjuntoResidencial() {
        apartamentos = new Apartamento[6];
        for (int i = 0; i < apartamentos.length; i++) {
            apartamentos[i] = new Apartamento(i + 1);
        }
    }

    public void registrarConsumo() {
        Scanner scanner = new Scanner(System.in);
        int numeroApto = 0;

        System.out.print("Ingrese el número de apartamento (1 a 6): ");
        while (true) {
            if (scanner.hasNextInt()) {
                numeroApto = scanner.nextInt();
                if (numeroApto >= 1 && numeroApto <= 6) {
                    break;
                }
            } else {
                scanner.next();
            }
            System.out.print("Número de apartamento inválido. Ingrese un valor entre 1 y 6: ");
        }

        double valorConsumo = 0;
        System.out.print("Ingrese el consumo en m³ (mayor que 0): ");
        while (true) {
            if (scanner.hasNextDouble()) {
                valorConsumo = scanner.nextDouble();
                if (valorConsumo > 0) {
                    break;
                }
            } else {
                scanner.next();
            }
            System.out.print("Consumo inválido. Debe ser mayor a 0 m³. Intente nuevamente: ");
        }

        apartamentos[numeroApto - 1].setConsumo(valorConsumo);
        System.out.println("¡Consumo registrado con éxito para el apartamento " + numeroApto + "!");
    }

    public void consultarFactura() {
        Scanner scanner = new Scanner(System.in);
        int numeroApto = 0;

        System.out.print("Ingrese el número de apartamento a consultar (1 a 6): ");
        while (true) {
            if (scanner.hasNextInt()) {
                numeroApto = scanner.nextInt();
                if (numeroApto >= 1 && numeroApto <= 6) {
                    break;
                }
            } else {
                scanner.next();
            }
            System.out.print("Número de apartamento inválido. Ingrese un valor entre 1 y 6: ");
        }

        Apartamento apto = apartamentos[numeroApto - 1];

        if (!apto.isTieneRegistro()) {
            System.out.println("El apartamento " + numeroApto + " no tiene consumo registrado");
        } else {
            apto.imprimirFactura();
        }
    }

    public void generarReporte() {
        int registrados = 0;
        double consumoTotal = 0;
        double maxConsumo = -1;
        int aptoMax = -1;
        int sinRegistrar = 0;
        int excesivos = 0;

        for (Apartamento apto : apartamentos) {
            if (!apto.isTieneRegistro()) {
                sinRegistrar++;
            } else {
                registrados++;
                double consumoActual = apto.getConsumo();
                consumoTotal += consumoActual;

                if (consumoActual > maxConsumo) {
                    maxConsumo = consumoActual;
                    aptoMax = apto.getNumero();
                }

                if (consumoActual > 25) {
                    excesivos++;
                }
            }
        }

        if (registrados == 0) {
            System.out.println("Aún no hay consumos registrados");
            return;
        }

        double consumoPromedio = consumoTotal / registrados;

        System.out.println("\n===== REPORTE GENERAL - CONJUNTO LOS GUADUALES =====");
        System.out.println("Consumo total del conjunto: " + consumoTotal + " m³");
        System.out.println("Consumo promedio (apartamentos registrados): " + consumoPromedio + " m³");
        System.out.println("Apartamento con mayor consumo: Apartamento " + aptoMax + " (" + maxConsumo + " m³)");
        System.out.println("Cantidad de apartamentos sin registro: " + sinRegistrar);
        System.out.println("Cantidad de apartamentos con consumo excesivo (> 25 m³): " + excesivos);
        System.out.println("=====================================================");
    }
}