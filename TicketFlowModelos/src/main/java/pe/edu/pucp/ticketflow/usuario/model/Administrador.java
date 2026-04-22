package pe.edu.pucp.ticketflow.usuario.model;

import java.sql.Date;
import java.time.LocalDate;


public class Administrador extends Usuario{
    private String codigoAdmin;

    //CONSTRUCTORES
    public Administrador(){}

    public Administrador(int idUsuario, String nombre, String apellidoPaterno,String apellidoMaterno,
                         String telefono, String correoElectronico, String contrasena, Date fechaRegistro, int edad,
                         String tipoUsuario, String dni, int idDistrito, int idRegion, String codigoAdmin){
        super(idUsuario,  nombre,  apellidoPaterno, apellidoMaterno, telefono,  correoElectronico, contrasena, fechaRegistro,
                edad, tipoUsuario, dni, idDistrito, idRegion);
        this.codigoAdmin = codigoAdmin;
    }

    //GETTERS AND SETTERS

    public String getCodigoAdmin(){
        return this.codigoAdmin;
    }
    public void setCodigoAdmin(String codigoAdmin){
        this.codigoAdmin=codigoAdmin;
    }
}
