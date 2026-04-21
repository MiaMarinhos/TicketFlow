package pe.edu.pucp.ticketflow.compra.model;

import pe.edu.pucp.ticketflow.evento.model.Evento;
import pe.edu.pucp.ticketflow.puntos_bonus.model.PuntosBonus;
import pe.edu.pucp.ticketflow.usuario.model.Anfitrion;
import pe.edu.pucp.ticketflow.usuario.model.Cliente;

import java.time.LocalDate;
import java.time.LocalTime;

public class Compra {
    private int idCompra;
    private MetodoPago metodo;
    private int cantidadEntradas;
    private LocalDate fechaCompra;
    private LocalTime horaCompra;
    private int puntosUsados;
    private double montoParcial;
    private double descuento;
    private double montoTotal;
    private EstadoCompra estado;

    private Anfitrion anf;
    private Evento eve;
    private Cliente cli;
    private PuntosBonus pun;

    // CONSTRUCTORES
    public Compra() {}

    public Compra(int idCompra, MetodoPago metodo, int cantidadEntradas, LocalDate fechaCompra,
                  LocalTime horaCompra, int puntosUsados, double montoParcial, double descuento,
                  double montoTotal, EstadoCompra estado, Anfitrion anf,
                  Evento eve, Cliente cli, PuntosBonus pun) {
        this.idCompra = idCompra;
        this.metodo = metodo;
        this.cantidadEntradas = cantidadEntradas;
        this.fechaCompra = fechaCompra;
        this.horaCompra = horaCompra;
        this.puntosUsados = puntosUsados;
        this.montoParcial = montoParcial;
        this.descuento = descuento;
        this.montoTotal = montoTotal;
        this.estado = estado;

        this.anf = anf;
        this.eve = eve;
        this.cli = cli;
        this.pun = pun;
    }

    // GETTERS AND SETTERS
    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public MetodoPago getMetodo() {
        return metodo;
    }

    public void setMetodo(MetodoPago metodo) {
        this.metodo = metodo;
    }

    public int getCantidadEntradas() {return cantidadEntradas; }

    public void setCantidadEntradass(int cantidadEntradas) {
        this.cantidadEntradas = cantidadEntradas;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public LocalTime getHoraCompra() {
        return horaCompra;
    }

    public void setHoraCompra(LocalTime horaCompra) {
        this.horaCompra = horaCompra;
    }

    public int getPuntosUsados() {
        return puntosUsados;
    }

    public void setPuntosUsados(int puntosUsados) {
        this.puntosUsados = puntosUsados;
    }

    public double getMontoParcial() {
        return montoParcial;
    }

    public void setMontoParcial(double montoParcial) {
        this.montoParcial = montoParcial;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public EstadoCompra getEstado() {
        return estado;
    }

    public void setEstado(EstadoCompra estado) {
        this.estado = estado;
    }

    public Anfitrion getAnf() {
        return anf;
    }

    public void setAnf(Anfitrion anf) {
        this.anf = anf;
    }

    public Evento getEve() {
        return eve;
    }

    public void setEve(Evento eve) {
        this.eve = eve;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public PuntosBonus getPun() { return pun; }

    public void setPuntosBonus(PuntosBonus pun) { this.pun = pun;}

}
