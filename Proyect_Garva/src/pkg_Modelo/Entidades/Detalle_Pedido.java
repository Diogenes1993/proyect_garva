package pkg_Modelo.Entidades;

import java.util.Objects;


public class Detalle_Pedido {

private Pedido id_pedido;
private Menu id_menu;
private int cantidad;

    public Detalle_Pedido() {
    }

    public Detalle_Pedido(Pedido id_pedido, Menu id_menu, int cantidad) {
        this.id_pedido = id_pedido;
        this.id_menu = id_menu;
        this.cantidad = cantidad;
    }

    public Pedido getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Pedido id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Menu getId_menu() {
        return id_menu;
    }

    public void setId_menu(Menu id_menu) {
        this.id_menu = id_menu;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}