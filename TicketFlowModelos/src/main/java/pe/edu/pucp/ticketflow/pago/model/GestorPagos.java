package pe.edu.pucp.ticketflow.pago.model;

import java.util.ArrayList;
import java.util.List;

public class GestorPagos{
    private List<Pago> listaPagos;

    public GestorPagos(){
        this.listaPagos = new ArrayList<Pago>();
    }

    public void registrarPago(Pago pag){
        this.listaPagos.add(pag);
    }


}
