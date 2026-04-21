package pe.edu.pucp.ticketflow.usuario.model;

import pe.edu.pucp.ticketflow.compra.model.Compra;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario{
    private int puntosBonus;
    private List<Compra> compras;

    //CONSTRUCTORES
    public Cliente(){}

    public Cliente(int idUsuario,String nombre, String apellido,
                   String correo,String contrasenia,String telefono,
                   LocalDate fechaRegistro, EstadoPerfil estado, LocalDate fechaNacimiento,
                   TipoPerfil tipo, String dni, Genero gen, int puntosBonus){
        super(idUsuario, nombre, apellido, correo, contrasenia, telefono,
                fechaRegistro, estado, fechaNacimiento, tipo, dni, gen);
        this.puntosBonus=puntosBonus;
        this.compras=new ArrayList<>();
    }

    //GETTERS AND SETTERS

    public int getPuntosBonus(){
        return this.puntosBonus;
    }

    public void setPuntosBonus(int puntosBonus){
        this.puntosBonus=puntosBonus;
    }


    //METODOS

}
