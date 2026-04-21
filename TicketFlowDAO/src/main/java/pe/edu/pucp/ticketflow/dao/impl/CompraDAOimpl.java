package pe.edu.pucp.ticketflow.dao.impl;

import pe.edu.pucp.ticketflow.compra.model.Compra;
import pe.edu.pucp.ticketflow.dao.CompraDAO;
import pe.edu.pucp.ticketflow.dao.manager.DBManager;

import java.sql.*;

public class CompraDAOimpl implements CompraDAO {
    @Override
    public Compra create(Compra compra){
        String sql = "INSERT INTO compras VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try(Connection con = DBManager.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            //TODO

            int resultado = ps.executeUpdate();
            if(resultado>0){
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int newId = generatedKeys.getInt(1);
                        compra.setIdCompra(newId);
                    }
                }
            }
            return compra;
        } catch (SQLException e){
            throw new RuntimeException("No se puedo crear la Compra", e);
        }
    }
    @Override
    public Compra read(Integer id){
        Compra compra= new Compra();
        String sql = "SELECT * FROM compras WHERE idCompras=?";

        try(Connection con = DBManager.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    //TODO

                    return compra;
                }
            }
        } catch (SQLException e){
            throw new RuntimeException("No se pudo leer la Compra", e);
        }
        return null;
    }
    @Override
    public Compra update(Compra compra){
        String sql = "UPDATE compras SET idCompras=?, entradas_compradas=?, fecha_compra=?, metodo_pago=?, hora_compra=?, estado=?, monto_parcial=?, monto_total=?, idPuntos_bonus=?, idCliente=?, idEvento=? WHERE idCompras=?";
        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){
            //TODO

            int affectedRows = ps.executeUpdate();
            if(affectedRows==0){
                throw new RuntimeException("No se encontro la Compra");
            }
            return compra;
        } catch (SQLException e){
            throw new RuntimeException("No se pudo actualizar la Compra", e);
        }
    }
    @Override
    public void delete(Integer id){
        String sql = "DELETE FROM compras WHERE idCompras=?";
        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);
            int affectedRows = ps.executeUpdate();
            if(affectedRows==0){
                throw new RuntimeException("No se encontro la Compra");
            }
        }catch (SQLException e){
            throw new RuntimeException("No se pudo eliminar la Compra", e);
        }
    }
}
