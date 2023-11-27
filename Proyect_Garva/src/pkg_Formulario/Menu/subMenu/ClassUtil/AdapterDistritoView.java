
package pkg_Formulario.Menu.subMenu.ClassUtil;

import java.util.Objects;
import pkg_Modelo.Entidades.Distrito;


public class AdapterDistritoView {
    private Distrito distrito;

    public AdapterDistritoView(Distrito distrito) {
        this.distrito = distrito;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.distrito);
        return hash;
    }

  @Override
public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
        return false;
    }
    AdapterDistritoView other = (AdapterDistritoView) obj;
    return Objects.equals(distrito, other.distrito);
}

    @Override
    public String toString() {
        return distrito.getNombre();
    }
    
  
    
}
