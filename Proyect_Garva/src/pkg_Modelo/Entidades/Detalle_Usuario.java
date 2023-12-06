package pkg_Modelo.Entidades;

import java.time.LocalDate;

public class Detalle_Usuario {
    private LocalDate fecha_salida;
    private IdDetalleUsuario id_detalle_usuario;
public class IdDetalleUsuario
{
    private String id_empleado;
    private LocalDate fecha_entrada;

        public IdDetalleUsuario() {
        }

        public IdDetalleUsuario(String id_empleado, LocalDate fecha_entrada) {
            this.id_empleado = id_empleado;
            this.fecha_entrada = fecha_entrada;
        }

        public String getId_empleado() {
            return id_empleado;
        }

        public void setId_empleado(String id_empleado) {
            this.id_empleado = id_empleado;
        }

        public LocalDate getFecha_entrada() {
            return fecha_entrada;
        }

        public void setFecha_entrada(LocalDate fecha_entrada) {
            this.fecha_entrada = fecha_entrada;
        }
    }

    public Detalle_Usuario(LocalDate fecha_salida, IdDetalleUsuario id_detalle_usuario) {
        this.fecha_salida = fecha_salida;
        this.id_detalle_usuario = id_detalle_usuario;
    }

    public Detalle_Usuario() {
    }

    public LocalDate getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(LocalDate fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public IdDetalleUsuario getId_detalle_usuario() {
        return id_detalle_usuario;
    }

    public void setId_detalle_usuario(IdDetalleUsuario id_detalle_usuario) {
        this.id_detalle_usuario = id_detalle_usuario;
    }
    

}
