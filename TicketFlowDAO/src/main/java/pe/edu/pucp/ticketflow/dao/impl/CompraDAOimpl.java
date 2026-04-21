package pe.edu.pucp.ticketflow.dao.impl;

import pe.edu.pucp.ticketflow.compra.model.Compra;
import pe.edu.pucp.ticketflow.compra.model.EstadoCompra;
import pe.edu.pucp.ticketflow.compra.model.MetodoPago;
import pe.edu.pucp.ticketflow.dao.CompraDAO;
import pe.edu.pucp.ticketflow.dao.manager.DBManager;
import pe.edu.pucp.ticketflow.evento.model.Evento;
import pe.edu.pucp.ticketflow.puntos_bonus.model.PuntosBonus;
import pe.edu.pucp.ticketflow.usuario.model.Cliente;

import java.sql.*;
import java.time.LocalDate;
import java.util.LocalDate;


public class CompraDAOimpl implements CompraDAO {
    @Override
    public Compra create(Compra compra){
        String sql = "INSERT INTO compras(entradas_compradas, fecha_compra, metodo_pago, hora_compra, estado, monto_parcial, monto_total, idPuntos_bonus, idCliente, idEvento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try(Connection con = DBManager.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            ps.setInt(1, compra.getCantidadEntradas());
            ps.setDate(2, java.sql.Date.valueOf(compra.getFechaCompra()));
            ps.setString(3, compra.getMetodo().name());
            ps.setTime(4, java.sql.Time.valueOf(compra.getHoraCompra()));
            ps.setString(5, compra.getEstado().name());
            ps.setDouble(6, compra.getMontoParcial());
            ps.setDouble(7, compra.getMontoTotal());
            ps.setInt(8, compra.getPun().getIdPuntosBonus());
            ps.setInt(9, compra.getCli().getIdUsuario());
            ps.setInt(10, compra.getEve().getIdEvento());

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
                    compra.setIdCompra(rs.getInt("idCompras"));
                    compra.setCantidadEntradas(rs.getInt("entradas_compradas"));
                    compra.setFechaCompra(rs.getDate("fecha_compra").toLocalDate());
                    compra.setMetodo(MetodoPago.valueOf(rs.getString("metodo_pago")));
                    compra.setHoraCompra(rs.getTime("hora_compra").toLocalTime());
                    compra.setEstado(EstadoCompra.valueOf(rs.getString("estado")));
                    compra.setMontoParcial(rs.getDouble("monto_parcial"));
                    compra.setMontoTotal(rs.getDouble("monto_total"));

                    PuntosBonus puntosBonus = new PuntosBonus();
                    puntosBonus.setIdPuntosBonus(rs.getInt("idPuntos_bonus"));
                    compra.setPuntosBonus(puntosBonus);

                    Cliente cliente = new Cliente();
                    cliente.setIdUsuario(rs.getInt("idCliente"));
                    compra.setCli(cliente);

                    Evento evento = new Evento();
                    evento.setIdEvento(rs.getInt("idEvento"));
                    compra.setEve(evento);

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
        String sql = "UPDATE compras SET entradas_compradas=?, fecha_compra=?, metodo_pago=?, hora_compra=?, estado=?, monto_parcial=?, monto_total=?, idPuntos_bonus=?, idCliente=?, idEvento=? WHERE idCompras=?";
        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, compra.getCantidadEntradas());
            ps.setDate(2, java.sql.Date.valueOf(compra.getFechaCompra()));
            ps.setString(3, compra.getMetodo().name());
            ps.setTime(4, java.sql.Time.valueOf(compra.getHoraCompra()));
            ps.setString(5, compra.getEstado().name());
            ps.setDouble(6, compra.getMontoParcial());
            ps.setDouble(7, compra.getMontoTotal());
            ps.setInt(8, compra.getPun().getIdPuntosBonus());
            ps.setInt(9, compra.getCli().getIdUsuario());
            ps.setInt(10, compra.getEve().getIdEvento());

            ps.setInt(11, compra.getIdCompra());

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
