package pe.edu.pucp.ticketflow.dao.impl;

import pe.edu.pucp.ticketflow.dao.PuntosBonusDAO;
import pe.edu.pucp.ticketflow.puntos_bonus.model.PuntosBonus;
import pe.edu.pucp.ticketflow.dao.manager.DBManager;

import java.sql.*;

public class PuntosBonusDAOimpl implements PuntosBonusDAO {

    @Override
    public PuntosBonus create(PuntosBonus puntosBonus) {
        String sql = "INSERT INTO PuntosBonus(puntos_canjeables, descuento) VALUES (?, ?)";

        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, puntosBonus.getPuntosCanjeables());
            ps.setInt(2, puntosBonus.getDescuento());

            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        // Asignamos el ID autoincremental generado
                        puntosBonus.setIdPuntosBonus(generatedKeys.getInt(1));
                    }
                }
            }
            return puntosBonus;
        } catch (SQLException e) {
            throw new RuntimeException("No se pudo crear el registro de PuntosBonus", e);
        }
    }

    @Override
    public PuntosBonus read(Integer id) {
        String sql = "SELECT * FROM PuntosBonus WHERE id_puntos_bonus = ?";

        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    PuntosBonus pb = new PuntosBonus();
                    pb.setIdPuntosBonus(rs.getInt("idPuntos_bonus"));
                    pb.setPuntosCanjeables(rs.getInt("puntos_canjeables"));
                    pb.setDescuento(rs.getInt("descuento"));
                    return pb;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("No se pudo leer el registro de PuntosBonus", e);
        }
        return null;
    }

    @Override
    public PuntosBonus update(PuntosBonus puntosBonus) {
        String sql = "UPDATE PuntosBonus SET puntos_canjeables = ?, descuento = ? WHERE idPuntos_bonus = ?";

        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, puntosBonus.getPuntosCanjeables());
            ps.setInt(2, puntosBonus.getDescuento());
            ps.setInt(3, puntosBonus.getIdPuntosBonus());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new RuntimeException("No se encontró el registro de PuntosBonus para actualizar");
            }
            return puntosBonus;
        } catch (SQLException e) {
            throw new RuntimeException("No se pudo actualizar el registro de PuntosBonus", e);
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM PuntosBonus WHERE idPuntos_bonus = ?";

        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new RuntimeException("No se encontró el registro de PuntosBonus para eliminar");
            }
        } catch (SQLException e) {
            throw new RuntimeException("No se pudo eliminar el registro de PuntosBonus", e);
        }
    }
}