
package pkg_Modelo.Entidades;

import java.util.Date;

public class Empleado {
    private String  id;
    private String nombre;
    private String apellido;
    private String distrito;
    private String direccion;
    private String telefono;
    private String email;
    private Date fecha_contrato;
    private String usuario;
    private String contra;
    private String estado;
    private Rol rol;

    public Empleado(String id, String nombre, String apellido, String distrito, String direccion, String telefono, String email, Date fecha_contrato, String usuario, String contra, String estado, Rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.distrito = distrito;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.fecha_contrato = fecha_contrato;
        this.usuario = usuario;
        this.contra = contra;
        this.estado = estado;
        this.rol = rol;
    }

    public Empleado() {
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFecha_contrato() {
        return fecha_contrato;
    }

    public void setFecha_contrato(Date fecha_contrato) {
        this.fecha_contrato = fecha_contrato;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    
}