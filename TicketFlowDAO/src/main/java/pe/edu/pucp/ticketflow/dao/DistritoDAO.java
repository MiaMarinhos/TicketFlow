package pe.edu.pucp.ticketflow.dao;

import pe.edu.pucp.ticketflow.dao.base.BaseDAO;
import pe.edu.pucp.ticketflow.distrito.model.Distrito;
import pe.edu.pucp.ticketflow.region.model.Region;

import java.util.List;

public interface DistritoDAO extends BaseDAO<Distrito, Integer> {
    List<Distrito> listAll();
}
