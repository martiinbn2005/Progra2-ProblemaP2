package ejeproducto;

public abstract class Producto {
    private String nombre;
    private double costoUnitario;
    private int stock;

    public Producto(String nombre, double costoUnitario, int stock) {
        this.nombre = nombre;
        setCostoUnitario(costoUnitario);
        setStock(stock);
    }

    public String getNombre() {
        return nombre;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public int getStock() {
        return stock;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCostoUnitario(double costoUnitario) {
        if (costoUnitario > 0.00)
            this.costoUnitario = costoUnitario;
    }

    public void setStock(int stock) {
        if (stock >= 0)
            this.stock = stock;
    }

    public abstract boolean esVendible();

    public String mostrarDatos() {
        return "\nNombre: " + nombre + "\nCosto Unitario: " + costoUnitario + "\nStock: " + stock;
    }

}
