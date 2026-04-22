package pe.edu.pucp.ticketflow.dao.impl;

import pe.edu.pucp.ticketflow.dao.DistritoDAO;
import pe.edu.pucp.ticketflow.dao.manager.DBManager;
import pe.edu.pucp.ticketflow.distrito.model.Distrito;
import pe.edu.pucp.ticketflow.region.model.Region;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DistritoDAOimpl implements DistritoDAO {

    @Override
    public Distrito create(Distrito distrito) {
        String sql = "INSERT INTO Distrito(nombre, idRegion) VALUES (?,?)";

        try(Connection con = DBManager.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, distrito.getNombre());
            ps.setInt(2, distrito.getRegion().getIdRegion());

            int resultado = ps.executeUpdate();
            if(resultado>0){
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int newId = generatedKeys.getInt(1);
                        distrito.setIdDistrito(newId);
                    }
                }
            }
            return distrito;
        } catch (SQLException e){
            throw new RuntimeException("No se puedo crear el Distrito", e);
        }
    }

    @Override
    public Distrito read(Integer id) {
        Distrito distrito= new Distrito();
        String sql = "SELECT * FROM Distrito WHERE idDistrito=?";

        try(Connection con = DBManager.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    distrito.setIdDistrito(rs.getInt("idDistrito"));
                    distrito.setNombre(rs.getString("nombre"));

                    //Construimos Region
                    Region r = new Region();
                    r.setIdRegion(rs.getInt("idRegion"));
                    distrito.setRegion(r);
                    return distrito;
                }
            }
        } catch (SQLException e){
            throw new RuntimeException("No se pudo leer el Distrito", e);
        }
        return null;
    }

    @Override
    public Distrito update(Distrito distrito) {
        String sql = "UPDATE Distrito SET nombre=?, idRegion=?  WHERE idDistrito=?";
        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1, distrito.getNombre());
            ps.setInt(2, distrito.getRegion().getIdRegion());
            ps.setInt(3, distrito.getIdDistrito());

            int affectedRows = ps.executeUpdate();
            if(affectedRows==0){
                throw new RuntimeException("No se encontro el Distrito");
            }
            return distrito;
        } catch (SQLException e){
            throw new RuntimeException("No se pudo actualizar el Distrito", e);
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM Distrito WHERE idDistrito=?";
        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Distrito> listAll(){
        List<Distrito> listaDistrito = new ArrayList<>();
        String sql = "SELECT * FROM Distrito";
        try(Connection con = DBManager.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql)){
            while(rs.next()){

                Distrito distrito = new Distrito();
                distrito.setIdDistrito(rs.getInt("idDistrito"));
                distrito.setNombre(rs.getString("nombre"));

                //Construimos Distrito
                Region r = new Region();
                r.setIdRegion(rs.getInt("idRegion"));
                distrito.setRegion(r);

                listaDistrito.add(distrito);
            }
            return listaDistrito;
        } catch (SQLException e){
            throw new RuntimeException("No se pudo listar Distrito", e);
        }
    }
}
