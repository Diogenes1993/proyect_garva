
package pkg_Modelo.Entidades;

import java.util.Date;


public class Menu {
    private String id;
    private String nombre;
    private String detalle;
    private Date fecha;
    private int stock;
    private double precio;
    private String ruta;

    public Menu() {
    }

    public Menu(String id, String nombre, String detalle, Date fecha, int stock, double precio, String ruta) {
        this.id = id;
        this.nombre = nombre;
        this.detalle = detalle;
        this.fecha = fecha;
        this.stock = stock;
        this.precio = precio;
        this.ruta = ruta;
    }
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    
    
}