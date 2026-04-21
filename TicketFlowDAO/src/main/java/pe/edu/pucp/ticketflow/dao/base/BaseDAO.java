package pe.edu.pucp.ticketflow.dao.base;

public interface BaseDAO<Tipo, ID> {
    int create(Tipo t);        // INSERT
    Tipo read(ID id);        // SELECT por ID
    int update(Tipo t);        // UPDATE
    int delete(ID id);   // DELETE
}
