package pkg_Modelo.Entidades;

import java.util.Date;
import java.util.Objects;

public class Boleta {
    
    private String id;
    private Date fecha;
    private double igv;
    private String id_cliente;
    private String id_empleado;
    private String id_pedido;
    private String id_menu;
    private double consumo;

    public Boleta() {
    }

    public Boleta(String id, Date fecha, double igv, String id_cliente, String id_empleado, String id_pedido, String id_menu, double consumo) {
        this.id = id;
        this.fecha = fecha;
        this.igv = igv;
        this.id_cliente = id_cliente;
        this.id_empleado = id_empleado;
        this.id_pedido = id_pedido;
        this.id_menu = id_menu;
        this.consumo = consumo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(String id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(String id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getId_menu() {
        return id_menu;
    }

    public void setId_menu(String id_menu) {
        this.id_menu = id_menu;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }
    
    
    
}