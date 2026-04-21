package pe.edu.pucp.ticketflow.solicitud.model;

import java.util.ArrayList;
import java.util.List;

public class GestorSolicitud{
    private List<Solicitud> listaSolicitudes;

    public GestorSolicitud(){
        this.listaSolicitudes = new ArrayList<Solicitud>();
    }

    public void registrarSolicitud(Solicitud sol){
        this.listaSolicitudes.add(sol);
    }


}
