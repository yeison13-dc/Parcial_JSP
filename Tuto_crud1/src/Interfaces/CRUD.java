package Interfaces;

import Modelo.Banco;
import java.util.List;

public interface CRUD {
    public List listar();
    public Banco List(String codigo);
    public boolean agregar(Banco ban);
    public boolean actualizar(Banco ban);
    public boolean eliminar(String  codigo);

}
