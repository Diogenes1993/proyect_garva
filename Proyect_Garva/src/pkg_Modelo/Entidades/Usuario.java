
package pkg_Modelo.Entidades;

import java.util.Objects;


public class Usuario {
    private Long id=null;
    private String usuario;
    private String contrasenia;
    private boolean estado;
    private boolean correo;

    public Usuario() {
    }

    public Usuario(String usuario, String contrasenia, boolean estado, boolean correo) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.estado = estado;
        this.correo = correo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isCorreo() {
        return correo;
    }

    public void setCorreo(boolean correo) {
        this.correo = correo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.usuario);
        hash = 17 * hash + Objects.hashCode(this.contrasenia);
        hash = 17 * hash + (this.estado ? 1 : 0);
        hash = 17 * hash + (this.correo ? 1 : 0);
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
        final Usuario other = (Usuario) obj;
        if (this.estado != other.estado) {
            return false;
        }
        if (this.correo != other.correo) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.contrasenia, other.contrasenia)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }
    
    
}
