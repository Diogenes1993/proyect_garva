package pkg_Modelo.Entidades;

import java.util.Objects;


public class Detalle_Pedido {

private Long id=null;
private long  id_gasto;
private long  id_pago;  
private double cuenta;

    public Detalle_Pedido() {
    }

    public Detalle_Pedido(long id_gasto, long id_pago, double cuenta) {
        this.id_gasto = id_gasto;
        this.id_pago = id_pago;
        this.cuenta = cuenta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getId_gasto() {
        return id_gasto;
    }

    public void setId_gasto(long id_gasto) {
        this.id_gasto = id_gasto;
    }

    public long getId_pago() {
        return id_pago;
    }

    public void setId_pago(long id_pago) {
        this.id_pago = id_pago;
    }

    public double getCuenta() {
        return cuenta;
    }

    public void setCuenta(double cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + (int) (this.id_gasto ^ (this.id_gasto >>> 32));
        hash = 67 * hash + (int) (this.id_pago ^ (this.id_pago >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.cuenta) ^ (Double.doubleToLongBits(this.cuenta) >>> 32));
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
        final Detalle_Pedido other = (Detalle_Pedido) obj;
        if (this.id_gasto != other.id_gasto) {
            return false;
        }
        if (this.id_pago != other.id_pago) {
            return false;
        }
        if (Double.doubleToLongBits(this.cuenta) != Double.doubleToLongBits(other.cuenta)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    

}
