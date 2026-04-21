package pe.edu.pucp.ticketflow.usuario.model;

import java.time.LocalDate;

public class Usuario {
    private int idUsuario;
    private String nombres;
    private String apellidos;
    private String correo;
    private String contrasenia;
    private String telefono;
    private LocalDate fechaRegistro;
    private EstadoPerfil estado;
    private LocalDate fechaNacimiento;
    private TipoPerfil tipo;
    private String dni;
    private Genero gen;

    //CONSTRUCTORES

    public Usuario(){}

    public Usuario(int idUsuario,String nombres, String apellidos,
                   String correo,String contrasenia,String telefono,
                   LocalDate fechaRegistro, EstadoPerfil estado, LocalDate fechaNacimiento,
                   TipoPerfil tipo, String dni, Genero gen){
        this.idUsuario=idUsuario;
        this.nombres=nombres;
        this.apellidos=apellidos;
        this.correo=correo;
        this.contrasenia=contrasenia;
        this.telefono=telefono;
        this.fechaRegistro=fechaRegistro;
        this.estado = estado;
        this.fechaNacimiento = fechaNacimiento;
        this.tipo = tipo;
        this.dni = dni;
        this.gen = gen;
    }

    //GETTER AND SETTERS

    public int getIdUsuario(){
        return this.idUsuario;
    }
    public void setIdUsuario(int idUsuario){
        this.idUsuario=idUsuario;
    }

    public String getNombres(){
        return this.nombres;
    }
    public void setNombre(String nombres){
        this.nombres=nombres;
    }

    public String getApellidos(){
        return this.apellidos;
    }
    public void setApellido(String apellidos){
        this.apellidos=apellidos;
    }

    public String getCorreo(){
        return this.correo;
    }
    public void setCorreo(String correo){
        this.correo=correo;
    }

    public String getContrasenia(){
        return this.contrasenia;
    }
    public void setContrasenia(String contrasenia){
        this.contrasenia=contrasenia;
    }

    public String getTelefono(){
        return this.telefono;
    }
    public void setTelefono(String telefono){
        this.telefono=telefono;
    }

    public LocalDate getFechaRegistro(){
        return this.fechaRegistro;
    }
    public void setFechaRegistro(LocalDate fechaRegistro){
        this.fechaRegistro=fechaRegistro;
    }

    public EstadoPerfil getEstado(){
        return this.estado;
    }
    public void setEstado(EstadoPerfil estado){
        this.estado=estado;
    }

    public LocalDate getFechaNacimiento(){
        return this.fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento){
        this.fechaNacimiento=fechaNacimiento;
    }

    public TipoPerfil getTipo(){
        return this.tipo;
    }
    public void setTipo(TipoPerfil tipo){
        this.tipo=tipo;
    }

    public String getDni(){
        return this.dni;
    }
    public void setDni(String dni){
        this.dni=dni;
    }

    public Genero getGen(){
        return this.gen;
    }
    public void setGen(Genero gen){
        this.gen=gen;
    }


}
