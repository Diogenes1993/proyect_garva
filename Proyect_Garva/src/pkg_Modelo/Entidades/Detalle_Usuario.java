package pkg_Modelo.Entidades;

import java.time.LocalDate;
import java.util.Objects;

public class Detalle_Usuario {
    
public class Id_Detalle_Usuario
{
    private long id_empleado;
    private long id_usuario;
    private LocalDate fecha_entrada;

        public Id_Detalle_Usuario(long id_empleado, long id_usuario, LocalDate fecha_entrada) {
            this.id_empleado = id_empleado;
            this.id_usuario = id_usuario;
            this.fecha_entrada = fecha_entrada;
        }

        public long getId_empleado() {
            return id_empleado;
        }

        public void setId_empleado(long id_empleado) {
            this.id_empleado = id_empleado;
        }

        public long getId_usuario() {
            return id_usuario;
        }

        public void setId_usuario(long id_usuario) {
            this.id_usuario = id_usuario;
        }

        public LocalDate getFecha_entrada() {
            return fecha_entrada;
        }

        public void setFecha_entrada(LocalDate fecha_entrada) {
            this.fecha_entrada = fecha_entrada;
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 47 * hash + (int) (this.id_empleado ^ (this.id_empleado >>> 32));
            hash = 47 * hash + (int) (this.id_usuario ^ (this.id_usuario >>> 32));
            hash = 47 * hash + Objects.hashCode(this.fecha_entrada);
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
            final Id_Detalle_Usuario other = (Id_Detalle_Usuario) obj;
            if (this.id_empleado != other.id_empleado) {
                return false;
            }
            if (this.id_usuario != other.id_usuario) {
                return false;
            }
            return Objects.equals(this.fecha_entrada, other.fecha_entrada);
        }

      
    
    
}    

private Id_Detalle_Usuario id;
private LocalDate fecha_salida;

    public Detalle_Usuario(Id_Detalle_Usuario id) {
        this.id=id;
    }
    
    public Detalle_Usuario(long id_empleado,long id_usuario,LocalDate fecha_entrada) {
        this.id=new Id_Detalle_Usuario(id_empleado,id_usuario,fecha_entrada);
    }

    public Id_Detalle_Usuario getId() {
        return id;
    }

    public void setId(Id_Detalle_Usuario id) {
        this.id = id;
    }

    public LocalDate getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(LocalDate fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.fecha_salida);
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
        final Detalle_Usuario other = (Detalle_Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.fecha_salida, other.fecha_salida);
    }
    


}
