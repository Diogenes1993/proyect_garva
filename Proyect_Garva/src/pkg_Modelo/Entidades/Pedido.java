package pkg_Modelo.Entidades;

import java.util.Date;
import java.util.Objects;

public class Pedido {
   private Long id=null;
   private Date fecha;
   private int cantidad;
   private long id_menu;

    public Pedido(Date fecha) {
        this.fecha = fecha;
    }

    public Pedido(Date fecha, int cantidad, long id_menu) {
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.id_menu = id_menu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public long getId_menu() {
        return id_menu;
    }

    public void setId_menu(long id_menu) {
        this.id_menu = id_menu;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.fecha);
        hash = 17 * hash + this.cantidad;
        hash = 17 * hash + (int) (this.id_menu ^ (this.id_menu >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pedido other = (Pedido) obj;
        if (this.cantidad != other.cantidad) {
            return false;
        }
        if (this.id_menu != other.id_menu) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.fecha, other.fecha);
    }
   
   
}
