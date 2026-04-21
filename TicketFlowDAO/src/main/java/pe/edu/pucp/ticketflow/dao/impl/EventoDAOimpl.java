package pe.edu.pucp.ticketflow.dao.impl;

import pe.edu.pucp.ticketflow.dao.EventoDAO;
import pe.edu.pucp.ticketflow.dao.manager.DBManager;
import pe.edu.pucp.ticketflow.evento.model.Evento;

import java.sql.*;
import java.util.List;

public class EventoDAOimpl implements EventoDAO {
    private List<Evento> eventos;

    @Override
    public List<Evento> ListAll(){
        return eventos;
    }

    @Override
    public Evento create(Evento evento) {
        String sql = "<sql script>";

        try(Connection con = DBManager.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            //TODO
            
            int resultado = ps.executeUpdate();
            if(resultado>0){
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int newId = generatedKeys.getInt(1);
                        evento.setIdEvento(newId);
                    }
                }
            }
            return evento;
        } catch (SQLException e){
            throw new RuntimeException("No se puedo crear el evento", e);
        }
    }

    @Override
    public Evento read(Integer id) {
        Evento evento= new Evento();
        String sql = "<sql script>";

        try(Connection con = DBManager.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    //TODO

                    return administrador;
                }
            }
        } catch (SQLException e){
            //throw new RuntimeException("No se pudo leer el Administrador", e);
        }
        return null;    }

    @Override
    public Evento update(Evento t) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }
}
