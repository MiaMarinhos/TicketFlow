package pe.edu.pucp.ticketflow.usuario.model;

import pe.edu.pucp.ticketflow.compra.model.Compra;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario{
    private int puntosBonus;
    private List<Compra> compras;

    //CONSTRUCTORES
    public Cliente(){}

    public Cliente(int idUsuario, String nombre, String apellidoPaterno, String apellidoMaterno,
                   String telefono, String correoElectronico, String contrasena, Date fechaRegistro, int edad,
                   String tipoUsuario, String dni, int idDistrito, int idRegion, int puntosBonus){
        super(idUsuario,  nombre,  apellidoPaterno, apellidoMaterno, telefono,  correoElectronico, contrasena, fechaRegistro,
                edad, tipoUsuario, dni, idDistrito, idRegion);
        this.puntosBonus=puntosBonus;
        this.compras=new ArrayList<>();
    }

    //GETTERS AND SETTERS

    public int getPuntosBonus(){
        return this.puntosBonus;
    }

    public void setPuntosBonus(int puntosBonus){
        this.puntosBonus=puntosBonus;
    }


    //METODOS

}
