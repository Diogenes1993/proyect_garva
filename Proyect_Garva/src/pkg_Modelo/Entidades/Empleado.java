
package pkg_Modelo.Entidades;

import java.util.Date;
import java.util.Objects;

public class Empleado {
    private Long id=null;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private Rol rol;
    private Date fecha_contrato;

    public Empleado() {
    }

    public Empleado(String nombre, String apellido, String direccion, String telefono, Rol rol, Date fecha_contrato) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.rol = rol;
        this.fecha_contrato = fecha_contrato;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Date getFecha_contrato() {
        return fecha_contrato;
    }

    public void setFecha_contrato(Date fecha_contrato) {
        this.fecha_contrato = fecha_contrato;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
        hash = 43 * hash + Objects.hashCode(this.nombre);
        hash = 43 * hash + Objects.hashCode(this.apellido);
        hash = 43 * hash + Objects.hashCode(this.direccion);
        hash = 43 * hash + Objects.hashCode(this.telefono);
        hash = 43 * hash + Objects.hashCode(this.rol);
        hash = 43 * hash + Objects.hashCode(this.fecha_contrato);
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
        final Empleado other = (Empleado) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.rol != other.rol) {
            return false;
        }
        return Objects.equals(this.fecha_contrato, other.fecha_contrato);
    }
    
    
    
            
}
