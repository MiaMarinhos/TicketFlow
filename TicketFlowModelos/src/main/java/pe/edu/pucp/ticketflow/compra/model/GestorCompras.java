package pe.edu.pucp.ticketflow.compra.model;

import java.util.ArrayList;
import java.util.List;

public class GestorCompras {
    private List<Compra> listaCompras;

    public GestorCompras(){
        this.listaCompras = new ArrayList<Compra>();
    }

    public void registrarVenta(Compra ven){
        this.listaCompras.add(ven);
    }


}
