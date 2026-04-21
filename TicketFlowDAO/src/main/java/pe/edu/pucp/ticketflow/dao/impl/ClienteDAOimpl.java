package pe.edu.pucp.ticketflow.dao.impl;

import pe.edu.pucp.ticketflow.dao.ClienteDAO;
import pe.edu.pucp.ticketflow.usuario.model.Cliente;
import pe.edu.pucp.ticketflow.dao.manager.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClienteDAOimpl implements ClienteDAO{
    @Override
    public Cliente create(Cliente cliente){

    }
    @Override
    public Cliente read(Integer id){

    }
    @Override
    public int update(Cliente cliente){
        String sql = "";
    }
    @Override
    public int delete(Integer id){
        String sql = "";
    }
}
