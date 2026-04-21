package pe.edu.pucp.ticketflow.dao.impl;

import pe.edu.pucp.ticketflow.dao.ClienteDAO;
import pe.edu.pucp.ticketflow.usuario.model.Cliente;
import pe.edu.pucp.ticketflow.dao.manager.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClienteDAOimp implements ClienteDAO{
    @Override
    public void create(Cliente cliente){

    }
    @Override
    public Cliente read(Integer id){

    }
    @Override
    public void update(Cliente administrador){
        String sql = "";
    }
    @Override
    public void delete(Integer id){
        String sql = "";
    }
}
