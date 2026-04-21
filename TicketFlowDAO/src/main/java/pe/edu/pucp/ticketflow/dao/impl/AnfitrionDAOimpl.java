package pe.edu.pucp.ticketflow.dao.impl;

import pe.edu.pucp.ticketflow.dao.AnfitrionDAO;
import pe.edu.pucp.ticketflow.dao.manager.DBManager;
import pe.edu.pucp.ticketflow.usuario.model.Anfitrion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnfitrionDAOimpl implements AnfitrionDAO {

    @Override
    public Anfitrion create(Anfitrion anfitrion) {
        String sql = "INSERT INTO Anfitrion(idAnfitrion, razon_social, ruc, cuenta_bancaria, banco) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, anfitrion.getIdUsuario());
            ps.setString(2, anfitrion.getRazonSocial());
            ps.setString(3, anfitrion.getRuc());
            ps.setString(4, anfitrion.getCuentaBancaria());
            ps.setString(5, anfitrion.getBank().name());

            int resultado = ps.executeUpdate();
            if (resultado > 0) {
                return anfitrion;
            }
        } catch (SQLException e) {
            throw new RuntimeException("No se pudo crear el Anfitrion", e);
        }
        return null;
    }

    @Override
    public Anfitrion read(Integer id) {
        String sql = "SELECT * FROM Anfitrion WHERE idAnfitrion=?";
        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Anfitrion a = new Anfitrion();
                    a.setIdUsuario(rs.getInt("idAnfitrion"));
                    a.setRazonSocial(rs.getString("razon_social"));
                    a.setRuc(rs.getString("ruc"));
                    a.setCuentaBancaria(rs.getString("cuenta_bancaria"));
                    a.setBank(Enum.valueOf(pe.edu.pucp.ticketflow.usuario.model.Banco.class, rs.getString("banco")));
                    return a;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("No se pudo leer el Anfitrion", e);
        }
        return null;
    }

    @Override
    public Anfitrion update(Anfitrion anfitrion) {
        String sql = "UPDATE Anfitrion SET razon_social=?, ruc=?, cuenta_bancaria=?, banco=? WHERE idAnfitrion=?";

        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, anfitrion.getRazonSocial());
            ps.setString(2, anfitrion.getRuc());
            ps.setString(3, anfitrion.getCuentaBancaria());
            ps.setString(4, anfitrion.getBank().name());
            ps.setInt(5, anfitrion.getIdUsuario());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new RuntimeException("No se encontró el Anfitrion");
            }
            return anfitrion;
        } catch (SQLException e) {
            throw new RuntimeException("No se pudo actualizar el Anfitrion", e);
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM Anfitrion WHERE idAnfitrion=?";

        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new RuntimeException("No se encontró el Anfitrion");
            }
        } catch (SQLException e) {
            throw new RuntimeException("No se pudo eliminar el Anfitrion", e);
        }
    }
}