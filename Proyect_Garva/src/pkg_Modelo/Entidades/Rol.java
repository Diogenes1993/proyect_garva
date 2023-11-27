
package pkg_Modelo.Entidades;

public class Rol {
    private String id;
    private String rol;
    private String ruta;

    public Rol() {
    }

    public Rol(String id, String rol, String ruta) {
        this.id = id;
        this.rol = rol;
        this.ruta = ruta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    
    
    
}
