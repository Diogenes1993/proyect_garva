
package pkg_Modelo.Entidades;

import java.util.Objects;


public class Usuario {
    private String  id;
    private String usuario;
    private String contrasenia;
    private int estado;
    private String correo;

    public Usuario(String id, String usuario, String contrasenia, int estado, String correo) {
        this.id = id;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.estado = estado;
        this.correo = correo;
    }

    public Usuario() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
     
}