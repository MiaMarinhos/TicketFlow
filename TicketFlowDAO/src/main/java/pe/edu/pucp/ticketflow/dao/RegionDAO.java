package pe.edu.pucp.ticketflow.dao;

import pe.edu.pucp.ticketflow.dao.base.BaseDAO;
import pe.edu.pucp.ticketflow.region.model.Region;

import java.util.List;

public interface RegionDAO extends BaseDAO<Region, Integer> {
    List<Region> listAll();
}
