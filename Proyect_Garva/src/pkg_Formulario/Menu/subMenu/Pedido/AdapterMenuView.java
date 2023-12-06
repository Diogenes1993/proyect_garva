package pkg_Formulario.Menu.subMenu.Pedido;

import java.util.Objects;
import pkg_Modelo.Entidades.Menu;


public class AdapterMenuView {
    private Menu menu;

    public AdapterMenuView(Menu menu) {
        this.menu = menu;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.menu);
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
        final AdapterMenuView other = (AdapterMenuView) obj;
        return Objects.equals(this.menu, other.menu);
    }

    @Override
    public String toString() {
        return menu.getNombre();
    }
    
    
    
}
