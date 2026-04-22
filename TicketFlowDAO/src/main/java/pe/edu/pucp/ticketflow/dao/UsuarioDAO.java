package pe.edu.pucp.ticketflow.dao;

import pe.edu.pucp.ticketflow.dao.base.BaseDAO;
import pe.edu.pucp.ticketflow.usuario.model.Usuario;

import java.util.List;

public interface UsuarioDAO extends BaseDAO<Usuario, Integer> {
    List<Usuario> listAll();
}
