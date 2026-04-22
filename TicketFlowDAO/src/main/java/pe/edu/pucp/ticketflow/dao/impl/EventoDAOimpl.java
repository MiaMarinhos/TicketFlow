package pe.edu.pucp.ticketflow.dao.impl;

import pe.edu.pucp.ticketflow.dao.EventoDAO;
import pe.edu.pucp.ticketflow.dao.manager.DBManager;
import pe.edu.pucp.ticketflow.distrito.model.Distrito;
import pe.edu.pucp.ticketflow.evento.model.Categoria;
import pe.edu.pucp.ticketflow.evento.model.EstadoEvento;
import pe.edu.pucp.ticketflow.evento.model.EstadoPublicacion;
import pe.edu.pucp.ticketflow.evento.model.Evento;
import pe.edu.pucp.ticketflow.region.model.Region;
import pe.edu.pucp.ticketflow.usuario.model.Anfitrion;

import java.sql.*;
import java.util.List;

import static java.sql.Date.valueOf;

public class EventoDAOimpl implements EventoDAO {
    private List<Evento> eventos;

    @Override
    public List<Evento> ListAll(){
        return eventos;
    }

    public EventoDAOimpl(){

    }

    @Override
    public Evento create(Evento evento) {
        String sql = "<sql script>";

        try(Connection con = DBManager.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            //
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
            ps.setString(11, evento.getEstadoPublicacion().name());
            ps.setString(12,evento.getEstado().name());
            ps.setString(13, evento.getUrlPoster());
            ps.setDouble(14,evento.getPrecioEntrada());
            ps.setInt(15,evento.getEntradasAdquiridas());
            ps.setInt(16,evento.getCapacidadEntradas()-evento.getEntradasAdquiridas());
            ps.setDouble(17, evento.getTotalRecaudado());
            ps.setDouble(18,evento.getTotalReal());
            ps.setInt(19,evento.getDiscrito().getRegion().getIdRegion());
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
                    evento.setIdEvento(id);
                    evento.setNombreEvento(rs.getString("titulo"));
                    evento.setDescripcion(rs.getString("descripcion"));
                    evento.setCapacidadEntradas(rs.getInt("capacidad_entradas"));
                    evento.setCat(Categoria.valueOf(rs.getString("categoria")));
                    evento.setFecha((rs.getDate("fecha")).toLocalDate());
                    evento.setHoraInicio(rs.getTime("hora_inicio").toLocalTime());
                    evento.setHoraFin(rs.getTime("hora_fin").toLocalTime());
                    evento.setUbicacion(rs.getString("ubicacion"));
                    evento.setNombreEstablecimiento(rs.getString("nombre_establecimiento"));
                    evento.setEstadoPublicacion(EstadoPublicacion.valueOf(rs.getString("estado_publicacion")));
                    evento.setEstado(EstadoEvento.valueOf(rs.getString("estado_evento")));
                    evento.setUrlPoster(rs.getString("img"));
                    evento.setPrecioEntrada(rs.getDouble("precio"));
                    evento.setEntradasAdquiridas(rs.getInt("entradas_adquiridas"));
                    //entradas restantes es total - adquiridas
                    evento.setTotalRecaudado(rs.getDouble("total"));
                    evento.setTotalReal(rs.getDouble("total_real"));

                    Region AuxRegion=new Region();
                    AuxRegion.setIdRegion(rs.getInt("idRegion"));

                    Distrito AuxDistrito=new Distrito();
                    AuxDistrito.setRegion(AuxRegion);
                    AuxDistrito.setIdDistrito(rs.getInt("idDistrito"));

                    Anfitrion AuxAnfitrion=new Anfitrion();
                    AuxAnfitrion.setIdUsuario(rs.getInt("idAnfitrion"));

                    evento.setAnfi(AuxAnfitrion);
                    evento.setDistrito(AuxDistrito);
                    return evento;
                }
            }
        } catch (SQLException e){
            //throw new RuntimeException("No se pudo leer el Administrador", e);
        }
        return null;    }

    @Override
    public Evento update(Evento evento) {
        String sql = "UPDATE Distrito SET nombre=?, idRegion=?  WHERE idDistrito=?";
        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){

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
            ps.setString(11, evento.getEstadoPublicacion().name());
            ps.setString(12,evento.getEstado().name());
            ps.setString(13, evento.getUrlPoster());
            ps.setDouble(14,evento.getPrecioEntrada());
            ps.setInt(15,evento.getEntradasAdquiridas());
            ps.setInt(16,evento.getCapacidadEntradas()-evento.getEntradasAdquiridas());
            ps.setDouble(17, evento.getTotalRecaudado());
            ps.setDouble(18,evento.getTotalReal());
            ps.setInt(19,evento.getDiscrito().getRegion().getIdRegion());
            ps.setInt(20,evento.getDiscrito().getIdDistrito());
            ps.setInt(21,evento.getAnfi().getIdUsuario());

            int affectedRows = ps.executeUpdate();
            if(affectedRows==0){
                throw new RuntimeException("No se encontro el Distrito");
            }
            return evento;
        } catch (SQLException e){
            throw new RuntimeException("No se pudo actualizar el Distrito", e);
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM compras WHERE idCompras=?";
        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);
            int affectedRows = ps.executeUpdate();
            if(affectedRows==0){
                throw new RuntimeException("No se encontro la Compra");
            }
        }catch (SQLException e){
            throw new RuntimeException("No se pudo eliminar la Compra", e);
        }
    }

}
