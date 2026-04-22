package pe.edu.pucp.ticketflow.dao;

import pe.edu.pucp.ticketflow.dao.base.BaseDAO;
import pe.edu.pucp.ticketflow.pago.model.Pago;

import java.util.List;

public interface PagoDAO extends BaseDAO<Pago, Integer> {
    List<Pago> listAll();
}
