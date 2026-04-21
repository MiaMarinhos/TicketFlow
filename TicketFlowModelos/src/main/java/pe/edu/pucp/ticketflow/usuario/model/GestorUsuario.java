package pe.edu.pucp.ticketflow.usuario.model;

import java.util.ArrayList;
import java.util.List;

public class GestorUsuario{
    private List<Usuario> listaUsuarios;

    public GestorUsuario(){
        this.listaUsuarios = new ArrayList<Usuario>();
    }

    public void registrarUsuario(Usuario user){
        this.listaUsuarios.add(user);
    }


}
