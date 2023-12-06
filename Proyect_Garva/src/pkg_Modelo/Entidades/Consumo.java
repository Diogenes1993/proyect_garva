
package pkg_Modelo.Entidades;

import java.util.Date;
import java.util.Objects;

public class Consumo {
    private double monto;
    private IdConsumo id_consumo;
    
    
    public class IdConsumo{
    private String id_pedido;
    private String id_adelanto;
    private Date fecha;

        public IdConsumo(String id_pedido, String id_adelanto, Date fecha) {
            this.id_pedido = id_pedido;
            this.id_adelanto = id_adelanto;
            this.fecha = fecha;
        }

        public IdConsumo() {
        }

        public String getId_pedido() {
            return id_pedido;
        }

        public void setId_pedido(String id_pedido) {
            this.id_pedido = id_pedido;
        }

        public String getId_adelanto() {
            return id_adelanto;
        }

        public void setId_adelanto(String id_adelanto) {
            this.id_adelanto = id_adelanto;
        }

        public Date getFecha() {
            return fecha;
        }

        public void setFecha(Date fecha) {
            this.fecha = fecha;
        }
    }

    public Consumo(double monto, IdConsumo id_consumo) {
        this.monto = monto;
        this.id_consumo = id_consumo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public IdConsumo getId_consumo() {
        return id_consumo;
    }

    public void setId_consumo(IdConsumo id_consumo) {
        this.id_consumo = id_consumo;
    }
    
     
    
    
    
    
}