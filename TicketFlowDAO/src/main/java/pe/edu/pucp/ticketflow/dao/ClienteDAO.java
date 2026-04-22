package pe.edu.pucp.ticketflow.dao;

import pe.edu.pucp.ticketflow.dao.base.BaseDAO;
import pe.edu.pucp.ticketflow.usuario.model.Cliente;

import java.util.List;

public interface ClienteDAO extends BaseDAO<Cliente, Integer> {
    List<Cliente> listAll();
}
