package pkg_MYSQL;

import java.sql.Connection;
import java.util.List;
import pkg_MYSQL.Interfaces.IPago_Guardado;
import pkg_Modelo.Entidades.Pago_Guardado;

public class MYSQLPago_Guardado implements IPago_Guardado {

    public MYSQLPago_Guardado(Connection connection) {
    }

    @Override
    public void Insertar(Pago_Guardado a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Actualizar(Pago_Guardado a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Eliminar(Pago_Guardado a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pago_Guardado> ObtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pago_Guardado ObtenerOne(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
