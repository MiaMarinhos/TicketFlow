package pe.edu.pucp.ticketflow.solicitud.model;

import pe.edu.pucp.ticketflow.usuario.model.Administrador;

public class Solicitud{
    private int idSolicitud;
    private String telefonoContacto;
    private String correoContacto;
    private String motivoSolicitud;
    private EstadoSolicitud estado;
    private Administrador admin;

    //CONSTRUCTORES
    public Solicitud(){}

    public Solicitud(int idSolicitud, String telefonoContacto,
                     String correoContacto, String motivoSolicitud,
                     EstadoSolicitud estado){

        this.idSolicitud = idSolicitud;
        this.telefonoContacto = telefonoContacto;
        this.correoContacto = correoContacto;
        this.motivoSolicitud = motivoSolicitud;
        this.estado = estado;
    }

    //GETTERS AND SETTERS

    public int getIdSolicitud(){
        return this.idSolicitud;
    }
    public void setIdSolicitud(int idSolicitud){
        this.idSolicitud=idSolicitud;
    }

    public String getTelefonoContacto(){
        return this.telefonoContacto;
    }
    public void setTelefonoContacto(String telefonoContacto){
        this.telefonoContacto=telefonoContacto;
    }

    public String getCorreoContacto(){
        return this.correoContacto;
    }
    public void setCorreoContacto(String correoContacto){
        this.correoContacto=correoContacto;
    }

    public String getMotivoSolicitud(){
        return this.motivoSolicitud;
    }
    public void setMotivoSolicitud(String motivoSolicitud){
        this.motivoSolicitud=motivoSolicitud;
    }

    public EstadoSolicitud getEstado(){
        return this.estado;
    }
    public void setEstado(EstadoSolicitud estado){
        this.estado=estado;
    }



}