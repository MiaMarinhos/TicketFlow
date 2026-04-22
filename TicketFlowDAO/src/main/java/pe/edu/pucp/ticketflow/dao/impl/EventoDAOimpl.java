package pe.edu.pucp.ticketflow.dao.impl;

import pe.edu.pucp.ticketflow.dao.EventoDAO;
import pe.edu.pucp.ticketflow.dao.manager.DBManager;
import pe.edu.pucp.ticketflow.evento.model.Evento;

import java.sql.*;
import java.util.List;

import static java.sql.Date.valueOf;

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
            ps.setInt(1, evento.getIdEvento());
            ps.setString(2,evento.getNombreEvento());
            ps.setString(3,evento.getDescripcion());
            ps.setInt(4,evento.getCapacidadEntradas());
            ps.setString(5,evento.getCat().name());
            ps.setDate(6, valueOf(evento.getFecha()));
            ps.setTime(7, java.sql.Time.valueOf(evento.getHoraInicio()));
            ps.setTime(8,java.sql.Time.valueOf(evento.getHoraFin()));
            ps.setString(9, evento.getUbicacion());
            ps.setString(10,evento.getNombreEstablecimiento());
            ps.setString(11, evento.getEstado().name());
            ps.setString(12,evento.getEstado().name());
            ps.setString(13, evento.getUrlPoster());
            ps.setDouble(14,evento.getPrecioEntrada());
            ps.setInt(15,evento.getEntradasAdquiridas());
            ps.setInt(16,evento.getCapacidadEntradas()-evento.getEntradasAdquiridas());
            ps.setDouble(17, evento.getTotalRecaudado());
            ps.setDouble(18,evento.getTotalReal());
            ps.setInt(19,evento.getRegion().getIdRegion());
            ps.setInt(20,evento.getDiscrito().getIdDistrito());
            ps.setInt(21,evento.getAnfi().getIdUsuario());

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
