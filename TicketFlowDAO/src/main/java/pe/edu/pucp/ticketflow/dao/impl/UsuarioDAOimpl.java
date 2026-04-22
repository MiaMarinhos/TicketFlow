package pe.edu.pucp.ticketflow.dao.impl;

import pe.edu.pucp.ticketflow.dao.UsuarioDAO;
import pe.edu.pucp.ticketflow.usuario.model.Usuario;
import pe.edu.pucp.ticketflow.dao.manager.DBManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOimpl implements UsuarioDAO {
    @Override
    public Usuario create(Usuario usuario){
        String sql = "INSERT INTO Usuario(dni, nombre, apellido_paterno, apellido_materno, telefono, correo_electronico, contrasena, fecha_registro, edad, tipo_usuario, idDistrito, idRegion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

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

            int affectedRows  = ps.executeUpdate();
            if(affectedRows >0){
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int newId = generatedKeys.getInt(1);
                        usuario.setIdUsuario(newId);
                    }
                }
            }
            return usuario;
        } catch (SQLException e) {
            throw new RuntimeException("No se puedo crear el Usuario", e);
        }
    }
    @Override
    public Usuario read(Integer id){
        Usuario usuario = new Usuario();
        String sql = "SELECT * FROM Usuario WHERE idUsuario=?";

        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
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

                    return usuario;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("No se pudo leer el Usuario", e);
        }
        return null;
    }
    @Override
    public Usuario update(Usuario usuario){
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

            int affectedRows = ps.executeUpdate();
            if(affectedRows==0){
                throw new RuntimeException("No se encontro el Usuario");
            }
            return usuario;
        } catch (SQLException e) {
            throw new RuntimeException("No se pudo actualizar el Usuario", e);
        }
    }
    @Override
    public void delete(Integer id){
        String sql = "DELETE FROM Usuario WHERE idUsuario=?";

        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int affectedRows = ps.executeUpdate();
            if(affectedRows==0){
                throw new RuntimeException("No se encontro el Usuario");
            }
        } catch (SQLException e) {
            throw new RuntimeException("No se pudo eliminar el Usuario", e);
        }
    }

    @Override
    public List<Usuario> listAll(){
        List<Usuario> listaUsuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuario";
        try(Connection con = DBManager.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql)){
            while(rs.next()){
                Usuario usuario = new Usuario();

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

                listaUsuarios.add(usuario);
            }
            return listaUsuarios;
        } catch (SQLException e){
            throw new RuntimeException("No se pudo listar Usuarios", e);
        }
    }
}
