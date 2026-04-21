package pe.edu.pucp.ticketflow.dao.base;

public interface BaseDAO<Tipo, ID> {
    Tipo create(Tipo t);        // INSERT
    Tipo read(ID id);        // SELECT por ID
    Tipo update(Tipo t);        // UPDATE
    void delete(ID id);   // DELETE
}
