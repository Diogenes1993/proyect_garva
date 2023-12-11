package pkg_Formulario.Menu.subMenu.Pedido;

import java.util.Objects;
import pkg_Modelo.Entidades.Cliente;

public class AdapterClienteView {
       private Cliente cliente;

    public AdapterClienteView(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }



    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.cliente);
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
        final AdapterClienteView other = (AdapterClienteView) obj;
        return Objects.equals(this.cliente, other.cliente) ;
            
    }
    
    
    @Override
    public String toString() {
        return cliente.getNombre() ;
    }
    
    
}
