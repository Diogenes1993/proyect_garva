
package pkg_Modelo.Entidades;


public class Aplicacion_Users {
    private int id;
    private String usuario_nombre;
    private String contrasenia_usuario;
    private boolean activo;

    public Aplicacion_Users() {
    }

    public Aplicacion_Users(int id, String usuario_nombre, String contrasenia_usuario, boolean activo) {
        this.id = id;
        this.usuario_nombre = usuario_nombre;
        this.contrasenia_usuario = contrasenia_usuario;
        this.activo = activo;
    }

    public Aplicacion_Users(String usuario_nombre, String contrasenia_usuario, boolean activo) {
        this.usuario_nombre = usuario_nombre;
        this.contrasenia_usuario = contrasenia_usuario;
        this.activo = activo;
    }

    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario_nombre() {
        return usuario_nombre;
    }

    public void setUsuario_nombre(String usuario_nombre) {
        this.usuario_nombre = usuario_nombre;
    }

    public String getContrasenia_usuario() {
        return contrasenia_usuario;
    }

    public void setContrasenia_usuario(String contrasenia_usuario) {
        this.contrasenia_usuario = contrasenia_usuario;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
}
