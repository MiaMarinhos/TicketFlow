package pe.edu.pucp.ticketflow.dao.base;

public interface BaseDAO<T, ID> {
    T create(T t);        // INSERT
    T read(ID id);        // SELECT por ID
    T update(T t);        // UPDATE
    void delete(ID id);   // DELETE
}
