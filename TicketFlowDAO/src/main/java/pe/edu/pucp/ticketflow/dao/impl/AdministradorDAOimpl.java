package pe.edu.pucp.ticketflow.dao.impl;

import pe.edu.pucp.ticketflow.dao.AdministradorDAO;
import pe.edu.pucp.ticketflow.usuario.model.Administrador;
import pe.edu.pucp.ticketflow.dao.manager.DBManager;

import java.sql.*;

public class AdministradorDAOimpl implements AdministradorDAO {
    @Override
    public Administrador create(Administrador administrador){
        String sql = "<sql script>";

        try(Connection con = DBManager.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            //TODO

            int resultado = ps.executeUpdate();
            if(resultado>0){
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int newId = generatedKeys.getInt(1);
                        //administrador.setIdUsuario(newId);
                    }
                }
            }
            //return administrador;
        } catch (SQLException e){
            //throw new RuntimeException("No se puedo crear el Administrador", e);
        }
    }
    @Override
    public Administrador read(Integer id){
        //Administrador administrador= new Administrador();
        String sql = "<sql script>";

        try(Connection con = DBManager.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    //TODO

                    //return administrador;
                }
            }
        } catch (SQLException e){
            //throw new RuntimeException("No se pudo leer el Administrador", e);
        }
        return null;
    }
    @Override
    public Administrador update(Administrador administrador){
        String sql = "<sql script>";
        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){
            //TODO

            int affectedRows = ps.executeUpdate();
            if(affectedRows==0){
                //throw new RuntimeException("No se encontro el Administrador");
            }
            //return administrador;
        } catch (SQLException e){
            //throw new RuntimeException("No se pudo actualizar el Administrador", e);
        }
    }
    @Override
    public void delete(Integer id){
        String sql = "<sql script>";
        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);
            int affectedRows = ps.executeUpdate();
            if(affectedRows==0){
                //throw new RuntimeException("No se encontro el Administrador");
            }
        }catch (SQLException e){
            //throw new RuntimeException("No se pudo eliminar el Administrador", e);
        }
    }
}
