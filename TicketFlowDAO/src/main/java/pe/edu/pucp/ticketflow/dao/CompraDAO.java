package pe.edu.pucp.ticketflow.dao;

import pe.edu.pucp.ticketflow.compra.model.Compra;
import pe.edu.pucp.ticketflow.dao.base.BaseDAO;

import java.util.List;

public interface CompraDAO extends BaseDAO<Compra, Integer> {
    List<Compra> listAll();
}
