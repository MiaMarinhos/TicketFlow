package pe.edu.pucp.ticketflow.dao.impl;

import pe.edu.pucp.ticketflow.dao.PagoDAO;
import pe.edu.pucp.ticketflow.dao.manager.DBManager;
import pe.edu.pucp.ticketflow.evento.model.Evento;
import pe.edu.pucp.ticketflow.pago.model.EstadoPago;
import pe.edu.pucp.ticketflow.pago.model.Pago;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PagoDAOimpl implements PagoDAO {
    @Override
    public Pago create(Pago pago) {
        String sql = "INSERT INTO Pagos(idPagos, fecha_pago, fecha_limite_pago, estado, total_a_pagar, comprobante, idEvento) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try(Connection con = DBManager.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, pago.getIdPago());
            ps.setDate(2, Date.valueOf(pago.getFechaPago()));
            ps.setDate(3, Date.valueOf(pago.getFechaLimitePago()));
            ps.setString(4, pago.getEstado().name()); // ENUM
            ps.setDouble(5, pago.getTotalAPagar());
            ps.setString(6, pago.getComprobante());
            ps.setInt(7, pago.getEve().getIdEvento());

            int resultado = ps.executeUpdate();
            if (resultado == 0) {
                throw new RuntimeException("No se pudo crear el Pago");
            }
            return pago;
        } catch (SQLException e){
            throw new RuntimeException("No se puedo crear el Pago", e);
        }
    }

    @Override
    public Pago read(Integer id) {
        Pago pago= new Pago();
        String sql = "SELECT * FROM Pago WHERE idPagos=?";

        try(Connection con = DBManager.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    pago.setIdPago(rs.getInt("idPagos"));
                    pago.setFechaPago(rs.getDate("fecha_pago").toLocalDate());
                    pago.setFechaLimitePago(rs.getDate("fecha_limite_pago").toLocalDate());
                    pago.setEstado(EstadoPago.valueOf(rs.getString("estado")));
                    pago.setTotalAPagar(rs.getDouble("total_a_pagar"));
                    pago.setComprobante(rs.getString("comprobante"));

                    //Construimos Evento
                    Evento eve = new Evento();
                    eve.setIdEvento(rs.getInt("idEvento"));
                    pago.setEve(eve);

                    return pago;
                }
            }
        } catch (SQLException e){
            throw new RuntimeException("No se pudo leer el Pago", e);
        }
        return null;
    }

    @Override
    public Pago update(Pago pago) {
        String sql = "UPDATE Pagos SET fecha_pago=?, fecha_limite_pago=?, estado=?, total_a_pagar=?, comprobante=?, idEvento=? WHERE idPagos=?";
        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){

            ps.setDate(1, Date.valueOf(pago.getFechaPago()));
            ps.setDate(2, Date.valueOf(pago.getFechaLimitePago()));
            ps.setString(3, pago.getEstado().name());
            ps.setDouble(4, pago.getTotalAPagar());
            ps.setString(5, pago.getComprobante());
            ps.setInt(6, pago.getEve().getIdEvento());
            ps.setInt(7, pago.getIdPago()); // WHERE

            int affectedRows = ps.executeUpdate();
            if(affectedRows==0){
                throw new RuntimeException("No se encontro el Pago");
            }
            return pago;
        } catch (SQLException e){
            throw new RuntimeException("No se pudo actualizar el Pago", e);
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM Pagos WHERE idPagos=?";
        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Pago> listAll(){
        List<Pago> listaPagos = new ArrayList<>();
        String sql = "SELECT * FROM Pagos";
        try(Connection con = DBManager.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                Pago pago = new Pago();
                pago.setIdPago(rs.getInt("idPagos"));
                pago.setFechaPago(rs.getDate("fecha_pago").toLocalDate());
                pago.setFechaLimitePago(rs.getDate("fecha_limite_pago").toLocalDate());
                pago.setEstado(EstadoPago.valueOf(rs.getString("estado")));
                pago.setTotalAPagar(rs.getDouble("total_a_pagar"));
                pago.setComprobante(rs.getString("comprobante"));

                //Construimos Evento
                Evento eve = new Evento();
                eve.setIdEvento(rs.getInt("idEvento"));
                pago.setEve(eve);

                listaPagos.add(pago);
            }
            return listaPagos;
        } catch (SQLException e){
            throw new RuntimeException("No se pudo listar Pagos", e);
        }
    }
}
