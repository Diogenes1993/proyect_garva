
package pkg_Modelo.Entidades;

import java.util.Date;


public class Adelanto {
  
    private String id;
    private double monto;
    private Date fecha;
    private String id_cliente;
    private String id_empleado;

    public Adelanto() {
    }

    public Adelanto(String id, double monto, Date fecha, String id_cliente, String id_empleado) {
        this.id = id;
        this.monto = monto;
        this.fecha = fecha;
        this.id_cliente = id_cliente;
        this.id_empleado = id_empleado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
    
    

}