package pe.edu.pucp.ticketflow.dao.impl;

import pe.edu.pucp.ticketflow.dao.UsuarioDAO;
import pe.edu.pucp.ticketflow.usuario.model.Usuario;
import pe.edu.pucp.ticketflow.dao.manager.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAOimpl implements UsuarioDAO {
    @Override
    public int create(Usuario usuario){
        int resultado = 0;
        String sql = "INSERT INTO Usuario(dni, nombre, apellido_paterno, apellido_materno, telefono, correo_electronico, contrasena, fecha_registro, edad, tipo_usuario, idDistrito, idRegion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usuario.getDni());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getApellidoPaterno());
            ps.setString(4, usuario.getApellidoMaterno());
            ps.setString(5, usuario.getTelefono());
            ps.setString(6, usuario.getCorreoElectronico());
            ps.setString(7, usuario.getContrasena());
            ps.setDate(8, usuario.getFechaRegistro());
            ps.setInt(9, usuario.getEdad());
            ps.setString(10, usuario.getTipoUsuario());
            ps.setInt(11, usuario.getIdDistrito());
            ps.setInt(12, usuario.getIdRegion());

            resultado = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }
    @Override
    public Usuario read(Integer id){
        Usuario usuario = null;
        String sql = "SELECT * FROM Usuario WHERE idUsuario=?";

        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setIdUsuario(rs.getInt("idUsuario"));
                    usuario.setDni(rs.getString("dni"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setApellidoPaterno(rs.getString("apellido_paterno"));
                    usuario.setApellidoMaterno(rs.getString("apellido_materno"));
                    usuario.setTelefono(rs.getString("telefono"));
                    usuario.setCorreoElectronico(rs.getString("correo_electronico"));
                    usuario.setContrasena(rs.getString("contrasena"));
                    usuario.setFechaRegistro(rs.getDate("fecha_registro"));
                    usuario.setEdad(rs.getInt("edad"));
                    usuario.setTipoUsuario(rs.getString("tipo_usuario"));
                    usuario.setIdDistrito(rs.getInt("idDistrito"));
                    usuario.setIdRegion(rs.getInt("idRegion"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return usuario;
    }
    @Override
    public int update(Usuario usuario){
        int resultado = 0;
        String sql = "UPDATE Usuario SET dni=?, nombre=?, apellido_paterno=?, apellido_materno=?, telefono=?, correo_electronico=?, contrasena=?, fecha_registro=?, edad=?, tipo_usuario=?, idDistrito=?, idRegion=? WHERE idUsuario=?";

        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usuario.getDni());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getApellidoPaterno());
            ps.setString(4, usuario.getApellidoMaterno());
            ps.setString(5, usuario.getTelefono());
            ps.setString(6, usuario.getCorreoElectronico());
            ps.setString(7, usuario.getContrasena());
            ps.setDate(8, usuario.getFechaRegistro());
            ps.setInt(9, usuario.getEdad());
            ps.setString(10, usuario.getTipoUsuario());
            ps.setInt(11, usuario.getIdDistrito());
            ps.setInt(12, usuario.getIdRegion());
            ps.setInt(13, usuario.getIdUsuario());

            resultado = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }
    @Override
    public int delete(Integer id){
        int resultado = 0;
        String sql = "DELETE FROM Usuario WHERE idUsuario=?";

        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            resultado = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }
}
