package pe.edu.pucp.ticketflow.usuario.model;

import pe.edu.pucp.ticketflow.evento.model.Evento;

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

    public Anfitrion(int idUsuario,String nombre, String apellido,
                     String correo,String contrasenia,String telefono,
                     LocalDate fechaRegistro, EstadoPerfil estado, LocalDate fechaNacimiento,
                     TipoPerfil tipo, String dni, Genero gen, String razonSocial,
                     String ruc, String CuentaBancaria, Banco bank){
        super(idUsuario, nombre, apellido, correo, contrasenia, telefono,
                fechaRegistro, estado, fechaNacimiento, tipo, dni, gen);		this.razonSocial=razonSocial;
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
        return this.ruc;
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
