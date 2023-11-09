package pkg_Modelo.Entidades;

import java.util.Objects;


public class Detalle_Boleta_Menu {

private Long id=null;
private long id_menu;
private long id_boleta;
private double total;
private double resto;

    public Detalle_Boleta_Menu() {
    }

    public Detalle_Boleta_Menu(long id_menu, long id_boleta, double total, double resto) {
        this.id_menu = id_menu;
        this.id_boleta = id_boleta;
        this.total = total;
        this.resto = resto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getId_menu() {
        return id_menu;
    }

    public void setId_menu(long id_menu) {
        this.id_menu = id_menu;
    }

    public long getId_boleta() {
        return id_boleta;
    }

    public void setId_boleta(long id_boleta) {
        this.id_boleta = id_boleta;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getResto() {
        return resto;
    }

    public void setResto(double resto) {
        this.resto = resto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.id);
        hash = 61 * hash + (int) (this.id_menu ^ (this.id_menu >>> 32));
        hash = 61 * hash + (int) (this.id_boleta ^ (this.id_boleta >>> 32));
        hash = 61 * hash + (int) (Double.doubleToLongBits(this.total) ^ (Double.doubleToLongBits(this.total) >>> 32));
        hash = 61 * hash + (int) (Double.doubleToLongBits(this.resto) ^ (Double.doubleToLongBits(this.resto) >>> 32));
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
        final Detalle_Boleta_Menu other = (Detalle_Boleta_Menu) obj;
        if (this.id_menu != other.id_menu) {
            return false;
        }
        if (this.id_boleta != other.id_boleta) {
            return false;
        }
        if (Double.doubleToLongBits(this.total) != Double.doubleToLongBits(other.total)) {
            return false;
        }
        if (Double.doubleToLongBits(this.resto) != Double.doubleToLongBits(other.resto)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }


}
