
package pkg_Formulario.Menu.subMenu.Cliente;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import pkg_MYSQL.Interfaces.IDistrito;
import pkg_MYSQL.Interfaces.IException;
import pkg_Modelo.Entidades.Distrito;

public class DistritoComboModel extends DefaultComboBoxModel<AdapterDistritoView>{
    
     private IDistrito Idistrito;
    private List<Distrito> lista_distrito;

    public DistritoComboModel(IDistrito Idistrito) {
        this.Idistrito = Idistrito;
        lista_distrito= new ArrayList<>();
    }
    
    public void updateCombo() throws IException
    {
        if(Idistrito!=null){
        lista_distrito =Idistrito.ObtenerTodos();
        removeAllElements();
        for(Distrito data_profe:lista_distrito)
        {
            addElement(new AdapterDistritoView(data_profe));
        }
        }
    }
}
