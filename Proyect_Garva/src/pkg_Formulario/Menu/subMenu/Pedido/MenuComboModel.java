
package pkg_Formulario.Menu.subMenu.Pedido;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import pkg_MYSQL.Interfaces.IException;
import pkg_MYSQL.Interfaces.IMenu;
import pkg_MYSQL.Interfaces.IRol;
import pkg_Modelo.Entidades.Menu;
import pkg_Modelo.Entidades.Rol;

public class MenuComboModel extends DefaultComboBoxModel<AdapterMenuView>{
    
     private IMenu Imenu;  
    private List<Menu> lista_menu;

    public MenuComboModel(IMenu Imenu) {
        this.Imenu = Imenu;
        lista_menu= new ArrayList<>();
    }
    
    public void updateCombo() throws IException
    {
        if(Imenu!=null){
        lista_menu =Imenu.ObtenerTodos();
        removeAllElements();
        for(Menu data_menu:lista_menu)
        {
            addElement(new AdapterMenuView(data_menu));
        }
        }
    }
    public List<AdapterMenuView> getMenus() {
    List<AdapterMenuView> menus = new ArrayList<>();
    int size = getSize();

    for (int i = 0; i < size; i++) {
        AdapterMenuView menu = getElementAt(i);
       menus.add(menu);
    }

    return menus;
}
}
