package pe.edu.pucp.ticketflow.evento.model;

import java.util.ArrayList;
import java.util.List;

public class GestorEvento {
    private List<Evento> listaEventos;

    public GestorEvento(){
        this.listaEventos = new ArrayList<Evento>();
    }

    public void registrarEvento(Evento eve){
        this.listaEventos.add(eve);
    }


}
