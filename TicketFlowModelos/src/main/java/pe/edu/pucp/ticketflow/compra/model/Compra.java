package pe.edu.pucp.ticketflow.compra.model;

import pe.edu.pucp.ticketflow.evento.model.Evento;
import pe.edu.pucp.ticketflow.usuario.model.Anfitrion;
import pe.edu.pucp.ticketflow.usuario.model.Cliente;

import java.time.LocalDate;
import java.time.LocalTime;

public class Compra {
    private int idVenta;
    private MetodoPago metodo;
    private int cantidadEntradas;
    private LocalDate fechaVenta;
    private LocalTime horaVenta;
    private int puntosUsados;
    private double montoParcial;
    private double descuento;
    private double montoTotal;
    private EstadoCompra estado;

    private Anfitrion anf;
    private Evento eve;
    private Cliente cli;

    // CONSTRUCTORES
    public Compra() {}

    public Compra(int idVenta, MetodoPago metodo, int cantidadEntradas, LocalDate fechaVenta,
                  LocalTime horaVenta, int puntosUsados, double montoParcial, double descuento,
                  double montoTotal, EstadoCompra estado, Anfitrion anf,
                  Evento eve, Cliente cli) {
        this.idVenta = idVenta;
        this.metodo = metodo;
        this.cantidadEntradas = cantidadEntradas;
        this.fechaVenta = fechaVenta;
        this.horaVenta = horaVenta;
        this.puntosUsados = puntosUsados;
        this.montoParcial = montoParcial;
        this.descuento = descuento;
        this.montoTotal = montoTotal;
        this.estado = estado;

        this.anf = anf;
        this.eve = eve;
        this.cli = cli;
    }

    // GETTERS AND SETTERS
    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public MetodoPago getMetodo() {
        return metodo;
    }

    public void setMetodo(MetodoPago metodo) {
        this.metodo = metodo;
    }

    public int getCantidadEntradas() {
        return cantidadEntradas;
    }

    public void setCantidadEntradass(int cantidadEntradas) {
        this.cantidadEntradas = cantidadEntradas;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public LocalTime getHoraVenta() {
        return horaVenta;
    }

    public void setHoraVenta(LocalTime horaVenta) {
        this.horaVenta = horaVenta;
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

}
