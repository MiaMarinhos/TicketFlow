package pe.edu.pucp.ticketflow.dao.impl;

import pe.edu.pucp.ticketflow.dao.RegionDAO;
import pe.edu.pucp.ticketflow.dao.manager.DBManager;
import pe.edu.pucp.ticketflow.region.model.Region;

import java.sql.*;

public class RegionDAOimpl implements RegionDAO {
    @Override
    public Region create(Region region) {
        String sql = "INSERT INTO Region(nombre) VALUES (?)";

        try(Connection con = DBManager.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, region.getNombre());

            int resultado = ps.executeUpdate();
            if(resultado>0){
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int newId = generatedKeys.getInt(1);
                        region.setIdRegion(newId);
                    }
                }
            }
            return region;
        } catch (SQLException e){
            throw new RuntimeException("No se puedo crear la Region", e);
        }
    }

    @Override
    public Region read(Integer id) {

        Region region= new Region();
        String sql = "SELECT * FROM Region WHERE idRegion=?";

        try(Connection con = DBManager.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    region.setIdRegion(rs.getInt("idRegion"));
                    region.setNombre(rs.getString("nombre"));

                    return region;
                }
            }
        } catch (SQLException e){
            throw new RuntimeException("No se pudo leer la Region", e);
        }
        return null;
    }

    @Override
    public Region update(Region region) {
        String sql = "UPDATE Region SET nombre=?  WHERE idRegion=?";
        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, region.getNombre());
            ps.setInt(2, region.getIdRegion());

            int affectedRows = ps.executeUpdate();
            if(affectedRows==0){
                throw new RuntimeException("No se encontro la Region");
            }
            return region;
        } catch (SQLException e){
            throw new RuntimeException("No se pudo actualizar la Region", e);
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM Region WHERE idRegion=?";
        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
