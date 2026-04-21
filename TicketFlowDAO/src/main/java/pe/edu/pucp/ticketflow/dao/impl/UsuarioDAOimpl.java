package pe.edu.pucp.ticketflow.dao.impl;

import pe.edu.pucp.ticketflow.dao.UsuarioDAO;
import pe.edu.pucp.ticketflow.usuario.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAOimpl implements UsuarioDAO {
    @Override
    public void create(Usuario usuario){
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

        //return resultado;
    }
    @Override
    public Usuario read(Integer id){
        Usuario u = null;
        String sql = "SELECT * FROM Usuario WHERE idUsuario=?";

        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    u = new Usuario();
                    u.setIdUsuario(rs.getInt("idUsuario"));
                    u.setDni(rs.getString("dni"));
                    u.setNombre(rs.getString("nombre"));
                    u.setApellidoPaterno(rs.getString("apellido_paterno"));
                    u.setApellidoMaterno(rs.getString("apellido_materno"));
                    u.setTelefono(rs.getString("telefono"));
                    u.setCorreoElectronico(rs.getString("correo_electronico"));
                    u.setContrasena(rs.getString("contrasena"));
                    u.setFechaRegistro(rs.getDate("fecha_registro"));
                    u.setEdad(rs.getInt("edad"));
                    u.setTipoUsuario(rs.getString("tipo_usuario"));
                    u.setIdDistrito(rs.getInt("idDistrito"));
                    u.setIdRegion(rs.getInt("idRegion"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return u;
    }
    @Override
    public void update(Usuario u){
        int resultado = 0;
        String sql = "UPDATE Usuario SET dni=?, nombre=?, apellido_paterno=?, apellido_materno=?, telefono=?, correo_electronico=?, contrasena=?, fecha_registro=?, edad=?, tipo_usuario=?, idDistrito=?, idRegion=? WHERE idUsuario=?";

        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, u.getDni());
            ps.setString(2, u.getNombre());
            ps.setString(3, u.getApellidoPaterno());
            ps.setString(4, u.getApellidoMaterno());
            ps.setString(5, u.getTelefono());
            ps.setString(6, u.getCorreoElectronico());
            ps.setString(7, u.getContrasena());
            ps.setDate(8, u.getFechaRegistro());
            ps.setInt(9, u.getEdad());
            ps.setString(10, u.getTipoUsuario());
            ps.setInt(11, u.getIdDistrito());
            ps.setInt(12, u.getIdRegion());
            ps.setInt(13, u.getIdUsuario());

            resultado = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //return resultado;
    }
    @Override
    public void delete(Integer id){
        int resultado = 0;
        String sql = "DELETE FROM Usuario WHERE idUsuario=?";

        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            resultado = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //return resultado;
    }
}
