
package pkg_Formulario.Menu.subMenu.ClassUtil;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import pkg_MYSQL.Interfaces.IException;
import pkg_MYSQL.Interfaces.IRol;
import pkg_Modelo.Entidades.Rol;

public class RolComboModel extends DefaultComboBoxModel<AdapterRolView>{
    
     private IRol Irol;
    private List<Rol> lista_rol;

    public RolComboModel(IRol Irol) {
        this.Irol = Irol;
        lista_rol= new ArrayList<>();
    }
    
    public void updateCombo() throws IException
    {
        if(Irol!=null){
        lista_rol =Irol.ObtenerTodos();
        removeAllElements();
        for(Rol data_rol:lista_rol)
        {
            addElement(new AdapterRolView(data_rol));
        }
        }
    }
    public List<AdapterRolView> getRoles() {
    List<AdapterRolView> rols = new ArrayList<>();
    int size = getSize();

    for (int i = 0; i < size; i++) {
        AdapterRolView rol = getElementAt(i);
       rols.add(rol);
    }

    return rols;
}
}
