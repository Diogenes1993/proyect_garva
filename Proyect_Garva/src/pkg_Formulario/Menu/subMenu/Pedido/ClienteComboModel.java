package pkg_Formulario.Menu.subMenu.Pedido;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import pkg_MYSQL.Interfaces.ICliente;
import pkg_MYSQL.Interfaces.IException;
import pkg_Modelo.Entidades.Cliente;

public class ClienteComboModel extends DefaultComboBoxModel<AdapterClienteView>{
     
     private ICliente Icliente;  
    private List<Cliente> lista_cliente;

    public ClienteComboModel(ICliente Icliente) {
        this.Icliente = Icliente;
        lista_cliente= new ArrayList<>();
    }
    
    public void updateCombo() throws IException
    {
        if(Icliente!=null){
        lista_cliente =Icliente.ObtenerTodos();
        removeAllElements();
        for(Cliente data_cliente:lista_cliente)
        {
            addElement(new AdapterClienteView(data_cliente));
        }
        }
    }
    public List<AdapterClienteView> getClientes() {
    List<AdapterClienteView> clientes = new ArrayList<>();
    int size = getSize();

    for (int i = 0; i < size; i++) {
        AdapterClienteView cliente = getElementAt(i);
       clientes.add(cliente);
    }

    return clientes;
}
}
