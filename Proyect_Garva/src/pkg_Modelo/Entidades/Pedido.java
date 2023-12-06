package pkg_Modelo.Entidades;

import java.util.Date;
import java.util.Objects;

public class Pedido {
   private String id;
   private Date fecha;
   private String estado;

    public Pedido(String id, Date fecha, String estado) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Pedido() {
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String id_estado) {
        this.estado = id_estado;
    }
           
}