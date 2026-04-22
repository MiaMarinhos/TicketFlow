package pe.edu.pucp.ticketflow.dao;

import pe.edu.pucp.ticketflow.dao.base.BaseDAO;
import pe.edu.pucp.ticketflow.usuario.model.Anfitrion;

import java.util.List;

public interface AnfitrionDAO extends BaseDAO<Anfitrion, Integer> {
    List<Anfitrion> listAll();
}
