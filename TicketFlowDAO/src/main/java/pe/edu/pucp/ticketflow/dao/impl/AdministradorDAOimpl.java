package pe.edu.pucp.ticketflow.dao.impl;

import pe.edu.pucp.ticketflow.dao.AdministradorDAO;
import pe.edu.pucp.ticketflow.dao.manager.DBManager;
import pe.edu.pucp.ticketflow.usuario.model.Administrador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdministradorDAOimpl implements AdministradorDAO {
    @Override
    public List<Administrador> listAll(){
        List<Administrador> listaAdministradores = new ArrayList<>();
        String sql = "SELECT * FROM Administrador";
        try(Connection con = DBManager.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                Administrador administrador = new Administrador();
                administrador.setIdUsuario(rs.getInt("idAdministrador"));
                administrador.setCodigoAdmin(rs.getString("codigo"));

                listaAdministradores.add(administrador);
            }
            return listaAdministradores;
        } catch (SQLException e){
            throw new RuntimeException("No se pudo listar Administradores", e);
        }
    }
    @Override
    public Administrador create(Administrador administrador) {
        String sql = "INSERT INTO Administrador(idAdministrador, codigo) VALUES (?, ?)";

        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, administrador.getIdUsuario());
            ps.setString(2, String.valueOf(administrador.getCodigoAdmin()));

            int resultado = ps.executeUpdate();
            if (resultado > 0) {
                return administrador;
            }

        } catch (SQLException e) {
            throw new RuntimeException("No se pudo crear el Administrador", e);
        }
        return null;
    }

    @Override
    public Administrador read(Integer id) {
        Administrador administrador = new Administrador();
        String sql = "SELECT * FROM Administrador WHERE idAdministrador=?";

        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    administrador.setIdUsuario(rs.getInt("idAdministrador"));
                    administrador.setCodigoAdmin(rs.getString("codigo"));
                    return administrador;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("No se pudo leer el Administrador", e);
        }
        return null;
    }

    @Override
    public Administrador update(Administrador administrador) {
        String sql = "UPDATE Administrador SET codigo=? WHERE idAdministrador=?";

        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, String.valueOf(administrador.getCodigoAdmin()));
            ps.setInt(2, administrador.getIdUsuario());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new RuntimeException("No se encontró el Administrador");
            }
            return administrador;
        } catch (SQLException e) {
            throw new RuntimeException("No se pudo actualizar el Administrador", e);
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM Administrador WHERE idAdministrador=?";

        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new RuntimeException("No se encontró el Administrador");
            }
        } catch (SQLException e) {
            throw new RuntimeException("No se pudo eliminar el Administrador", e);
        }
    }
}