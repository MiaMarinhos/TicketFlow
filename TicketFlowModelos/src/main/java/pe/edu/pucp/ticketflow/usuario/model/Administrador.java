package pe.edu.pucp.ticketflow.usuario.model;

import java.time.LocalDate;


public class Administrador extends Usuario{
    private int codigoAdmin;

    //CONSTRUCTORES
    public Administrador(){}

    public Administrador(int idUsuario,String nombre, String apellido,
                         String correo,String contrasenia,String telefono,
                         LocalDate fechaRegistro, EstadoPerfil estado, LocalDate fechaNacimiento,
                         TipoPerfil tipo, String dni, Genero gen, int codigoAdmin){
        super(idUsuario, nombre, apellido, correo, contrasenia, telefono,
                fechaRegistro, estado, fechaNacimiento, tipo, dni, gen);
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
