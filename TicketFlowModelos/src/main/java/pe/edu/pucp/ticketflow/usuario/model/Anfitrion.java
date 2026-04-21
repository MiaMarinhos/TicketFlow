package pe.edu.pucp.ticketflow.usuario.model;

import pe.edu.pucp.ticketflow.evento.model.Evento;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Anfitrion extends Usuario{
    private String razonSocial;
    private String ruc;
    private String cuentaBancaria;
    private Banco bank;
    private List<Evento> eventos;

    //CONSTRUCTORES

    public Anfitrion(){

    }

    public Anfitrion(int idUsuario, String nombre, String apellidoPaterno, String apellidoMaterno,
                     String telefono, String correoElectronico, String contrasena, Date fechaRegistro, int edad,
                     String tipoUsuario, String dni, int idDistrito, int idRegion, String razonSocial,
                     String ruc, String cuentaBancaria, Banco bank){
        super(idUsuario,  nombre,  apellidoPaterno, apellidoMaterno, telefono,  correoElectronico, contrasena, fechaRegistro,
                edad, tipoUsuario, dni, idDistrito, idRegion);		this.razonSocial=razonSocial;
        this.razonSocial=razonSocial;
        this.ruc = ruc;
        this.cuentaBancaria = cuentaBancaria;
        this.bank = bank;

        this.eventos=new ArrayList<>();
    }

    //GETTERS AND SETTERS

    public String getRazonSocial(){
        return this.razonSocial;
    }
    public void setRazonSocial(String razonSocial){
        this.razonSocial=razonSocial;
    }

    public String getRuc(){
        return this.ruc;
    }
    public void setRuc(String ruc){
        this.ruc=ruc;
    }


    public String getCuentaBancaria(){
        return this.cuentaBancaria;
    }
    public void setCuentaBancaria(String cuentaBancaria){
        this.cuentaBancaria = cuentaBancaria;
    }

    public Banco getBank(){
        return this.bank;
    }
    public void setBank(Banco bank){
        this.bank = bank;
    }


    //METODOS


}
