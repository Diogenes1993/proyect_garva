package pkg_Modelo.Entidades;


import java.time.LocalDate;
import java.util.Date;

public class Detalle_Usuario {
    private Date fecha_salida;
    private IdDetalleUsuario id_detalle_usuario;
public class IdDetalleUsuario
{
    private Empleado id_empleado;
    private Date fecha_entrada;

        public IdDetalleUsuario() {
        }

        public IdDetalleUsuario(Empleado id_empleado, Date fecha_entrada) {
            this.id_empleado = id_empleado;
            this.fecha_entrada = fecha_entrada;
        }

        public Empleado getId_empleado() {
            return id_empleado;
        }

        public void setId_empleado(Empleado id_empleado) {
            this.id_empleado = id_empleado;
        }

        public Date getFecha_entrada() {
            return fecha_entrada;
        }

        public void setFecha_entrada(Date fecha_entrada) {
            this.fecha_entrada = fecha_entrada;
        }

    }

    public Detalle_Usuario(Date fecha_salida, IdDetalleUsuario id_detalle_usuario) {
        this.fecha_salida = fecha_salida;
        this.id_detalle_usuario = id_detalle_usuario;
    }

    public Detalle_Usuario() {
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public IdDetalleUsuario getId_detalle_usuario() {
        return id_detalle_usuario;
    }

    public void setId_detalle_usuario(IdDetalleUsuario id_detalle_usuario) {
        this.id_detalle_usuario = id_detalle_usuario;
    }
    

}
