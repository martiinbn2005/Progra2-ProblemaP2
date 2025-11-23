package ejeproducto;

import java.time.LocalDate;

public class ProductoCaduco extends Producto {
    private LocalDate fechaVencimiento;

    public ProductoCaduco(String nombre, double costoUnitario, int stock, LocalDate fechaVencimiento) {
        super(nombre, costoUnitario, stock);
        this.fechaVencimiento = fechaVencimiento;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public boolean esVendible() {
        return (LocalDate.now().isBefore(fechaVencimiento) || LocalDate.now().isEqual(fechaVencimiento)) && getStock() > 0;
    }

    @Override
    public String mostrarDatos() {
        return super.mostrarDatos() + "\nFecha de vencimiento: " + fechaVencimiento + "\nVendible: " + (esVendible() ? "Sí" : "No");
    }

}
