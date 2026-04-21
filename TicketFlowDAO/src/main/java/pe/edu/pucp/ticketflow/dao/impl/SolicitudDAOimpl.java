package pe.edu.pucp.ticketflow.dao.impl;

import pe.edu.pucp.ticketflow.dao.SolicitudDAO;
import pe.edu.pucp.ticketflow.solicitud.model.Solicitud;
import pe.edu.pucp.ticketflow.solicitud.model.EstadoSolicitud;
import pe.edu.pucp.ticketflow.dao.manager.DBManager;
import java.sql.*;

public class SolicitudDAOimpl implements SolicitudDAO {

    @Override
    public Solicitud create(Solicitud solicitud) {
        String sql = "INSERT INTO Solicitud(telefono_contacto, correo_contacto, motivo_solicitud, estado, idAdmin, idCliente) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, solicitud.getTelefonoContacto());
            ps.setString(2, solicitud.getCorreoContacto());
            ps.setString(3, solicitud.getMotivoSolicitud());
            ps.setString(4, solicitud.getEstado().name());

            // Manejo de nulo para Admin (puede no estar asignado al inicio)
            if (solicitud.getAdmin() != null) {
                ps.setInt(5, solicitud.getAdmin().getIdUsuario());
            } else {
                ps.setNull(5, Types.INTEGER);
            }

            // Manejo de nulo para Cliente
            if (solicitud.getCliente() != null) {
                ps.setInt(6, solicitud.getCliente().getIdUsuario());
            } else {
                ps.setNull(6, Types.INTEGER);
            }

            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        // Aquí asignamos el ID autoincremental generado por la BD
                        solicitud.setIdSolicitud(generatedKeys.getInt(1));
                    }
                }
            }
            return solicitud;
        } catch (SQLException e) {
            throw new RuntimeException("No se pudo crear la Solicitud", e);
        }
    }

    @Override
    public Solicitud read(Integer id) {
        String sql = "SELECT * FROM Solicitud WHERE id_solicitud = ?";

        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Solicitud solicitud = new Solicitud();
                    solicitud.setIdSolicitud(rs.getInt("idSolicitud"));
                    solicitud.setTelefonoContacto(rs.getString("telefono_contacto"));
                    solicitud.setCorreoContacto(rs.getString("correo_contacto"));
                    solicitud.setMotivoSolicitud(rs.getString("motivo_solicitud"));

                    String estadoStr = rs.getString("estado");
                    if (estadoStr != null) {
                        solicitud.setEstado(EstadoSolicitud.valueOf(estadoStr));
                    }

                    return solicitud;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("No se pudo leer la Solicitud", e);
        }
        return null;
    }

    @Override
    public Solicitud update(Solicitud solicitud) {
        String sql = "UPDATE Solicitud SET telefono_contacto=?, correo_contacto=?, motivo_solicitud=?, estado=?, idAdmin=?, idCliente=? WHERE idSolicitud=?";

        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, solicitud.getTelefonoContacto());
            ps.setString(2, solicitud.getCorreoContacto());
            ps.setString(3, solicitud.getMotivoSolicitud());
            ps.setString(4, solicitud.getEstado().name());

            if (solicitud.getAdmin() != null) {
                ps.setInt(5, solicitud.getAdmin().getIdUsuario());
            } else {
                ps.setNull(5, Types.INTEGER);
            }

            if (solicitud.getCliente() != null) {
                ps.setInt(6, solicitud.getCliente().getIdUsuario());
            } else {
                ps.setNull(6, Types.INTEGER);
            }

            ps.setInt(7, solicitud.getIdSolicitud());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new RuntimeException("No se encontró la Solicitud");
            }
            return solicitud;
        } catch (SQLException e) {
            throw new RuntimeException("No se pudo actualizar la Solicitud", e);
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM Solicitud WHERE id_solicitud = ?";

        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new RuntimeException("No se encontró la Solicitud");
            }
        } catch (SQLException e) {
            throw new RuntimeException("No se pudo eliminar la Solicitud", e);
        }
    }
}