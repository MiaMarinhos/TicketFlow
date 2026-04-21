package pe.edu.pucp.ticketflow.dao.base;

public interface BaseDAO<Tipo, ID> {
    void create(Tipo t);        // INSERT
    Tipo read(ID id);        // SELECT por ID
    void update(Tipo t);        // UPDATE
    void delete(ID id);   // DELETE
}
