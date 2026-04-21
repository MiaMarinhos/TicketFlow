package pe.edu.pucp.ticketflow.dao.impl;

import pe.edu.pucp.ticketflow.dao.ClienteDAO;
import pe.edu.pucp.ticketflow.dao.manager.DBManager;
import pe.edu.pucp.ticketflow.usuario.model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAOimpl implements ClienteDAO {

    @Override
    public Cliente create(Cliente cliente) {
        String sql = "INSERT INTO Cliente(idCliente, puntos_bonus) VALUES (?, ?)";

        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, cliente.getIdUsuario());
            ps.setInt(2, cliente.getPuntosBonus());

            int resultado = ps.executeUpdate();
            if (resultado > 0) {
                return cliente;
            }
        } catch (SQLException e) {
            throw new RuntimeException("No se pudo crear el Cliente", e);
        }
        return null;
    }

    @Override
    public Cliente read(Integer id) {
        Cliente cliente = new Cliente();
        String sql = "SELECT * FROM Cliente WHERE idCliente=?";

        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    cliente.setIdUsuario(rs.getInt("idCliente"));
                    cliente.setPuntosBonus(rs.getInt("puntos_bonus"));
                    return cliente;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("No se pudo leer el Cliente", e);
        }
        return null;
    }

    @Override
    public Cliente update(Cliente cliente) {
        String sql = "UPDATE Cliente SET puntos_bonus=? WHERE idCliente=?";

        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, cliente.getPuntosBonus());
            ps.setInt(2, cliente.getIdUsuario());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new RuntimeException("No se encontró el Cliente");
            }
            return cliente;
        } catch (SQLException e) {
            throw new RuntimeException("No se pudo actualizar el Cliente", e);
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM Cliente WHERE idCliente=?";

        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new RuntimeException("No se encontró el Cliente");
            }
        } catch (SQLException e) {
            throw new RuntimeException("No se pudo eliminar el Cliente", e);
        }
    }
}