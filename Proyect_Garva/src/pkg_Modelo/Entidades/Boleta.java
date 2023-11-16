package pkg_Modelo.Entidades;

import java.util.Date;
import java.util.Objects;

public class Boleta {
    
    private Long id=null;
    private String boleta;
    private Date fecha;
    private double igv;
    private long id_cliente;
    private long id_empleado;
    private long id_pedido;

    public Boleta() {
    }

    public Boleta(String boleta, Date fecha, double igv, long id_cliente, long id_empleado, long id_pedido) {
        this.boleta = boleta;
        this.fecha = fecha;
        this.igv = igv;
        this.id_cliente = id_cliente;
        this.id_empleado = id_empleado;
        this.id_pedido = id_pedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBoleta() {
        return boleta;
    }

    public void setBoleta(String boleta) {
        this.boleta = boleta;
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

    public long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public long getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(long id_empleado) {
        this.id_empleado = id_empleado;
    }

    public long getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(long id_pedido) {
        this.id_pedido = id_pedido;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.boleta);
        hash = 17 * hash + Objects.hashCode(this.fecha);
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.igv) ^ (Double.doubleToLongBits(this.igv) >>> 32));
        hash = 17 * hash + (int) (this.id_cliente ^ (this.id_cliente >>> 32));
        hash = 17 * hash + (int) (this.id_empleado ^ (this.id_empleado >>> 32));
        hash = 17 * hash + (int) (this.id_pedido ^ (this.id_pedido >>> 32));
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
        final Boleta other = (Boleta) obj;
        if (Double.doubleToLongBits(this.igv) != Double.doubleToLongBits(other.igv)) {
            return false;
        }
        if (this.id_cliente != other.id_cliente) {
            return false;
        }
        if (this.id_empleado != other.id_empleado) {
            return false;
        }
        if (this.id_pedido != other.id_pedido) {
            return false;
        }
        if (!Objects.equals(this.boleta, other.boleta)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.fecha, other.fecha);
    }
    
    
    
    
}
