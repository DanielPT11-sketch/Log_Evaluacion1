package Facturacion;

public class Apartamento {
    private int numero;
    private double consumo;
    private boolean tieneRegistro;

    public Apartamento(int numero) {
        this.numero = numero;
        this.consumo = 0.0;
        this.tieneRegistro = false;
    }

    public int getNumero() {
        return numero;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
        this.tieneRegistro = true;
    }

    public boolean isTieneRegistro() {
        return tieneRegistro;
    }

    public void imprimirFactura() {
        double cargoFijo = 12000;
        double tarifaPorM3 = 0;

        if (consumo <= 10) {
            tarifaPorM3 = 3000;
        } else if (consumo <= 20) {
            tarifaPorM3 = 4500;
        } else {
            tarifaPorM3 = 6000;
        }

        double valorConsumo = consumo * tarifaPorM3;
        double subtotal = cargoFijo + valorConsumo;
        double recargo = 0;

        System.out.println("\n--- FACTURA DE AGUA - APARTAMENTO " + numero + " ---");
        System.out.println("Consumo: " + consumo + " m³");
        System.out.println("Tarifa aplicada por m³: $" + tarifaPorM3);
        System.out.println("Valor del consumo: $" + valorConsumo);
        System.out.println("Cargo fijo: $" + cargoFijo);

        if (consumo > 25) {
            recargo = subtotal * 0.10;
            System.out.println("Recargo (10%): $" + recargo);
            System.out.println("ALERTA: consumo excesivo");
        }

        double totalPagar = subtotal + recargo;
        System.out.println("Total a pagar: $" + totalPagar);
        System.out.println("----------------------------------------------");
    }
}