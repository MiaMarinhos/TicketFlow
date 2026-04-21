package pe.edu.pucp.ticketflow.usuario.model;

import java.sql.Date;
import java.time.LocalDate;


public class Administrador extends Usuario{
    private int codigoAdmin;

    //CONSTRUCTORES
    public Administrador(){}

    public Administrador(int idUsuario, String nombre, String apellidoPaterno,String apellidoMaterno,
                         String telefono, String correoElectronico, String contrasena, Date fechaRegistro, int edad,
                         String tipoUsuario, String dni, int idDistrito, int idRegion, int codigoAdmin){
        super(idUsuario,  nombre,  apellidoPaterno, apellidoMaterno, telefono,  correoElectronico, contrasena, fechaRegistro,
                edad, tipoUsuario, dni, idDistrito, idRegion);
        this.codigoAdmin = codigoAdmin;
    }

    //GETTERS AND SETTERS

    public int getCodigoAdmin(){
        return this.codigoAdmin;
    }
    public void setCodigoAdmin(int codigoAdmin){
        this.codigoAdmin=codigoAdmin;
    }
}
