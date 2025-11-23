package ejeproducto;

import java.time.LocalDate;

public class ProductoAdicional extends Producto{
    public ProductoAdicional(String nombre, double costoUnitario, int stock) {
        super(nombre, costoUnitario, stock);
    }

    @Override
    public boolean esVendible() {
        return getStock() > 0;
    }

    @Override
    public String mostrarDatos() {
        return super.mostrarDatos() + "Vendible: " + (esVendible() ? "Sí" : "No");
    }
}
