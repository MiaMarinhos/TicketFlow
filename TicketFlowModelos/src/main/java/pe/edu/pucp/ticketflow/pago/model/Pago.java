package pe.edu.pucp.ticketflow.pago.model;

import pe.edu.pucp.ticketflow.evento.model.Evento;
import pe.edu.pucp.ticketflow.usuario.model.Anfitrion;

import java.time.LocalDate;
import java.time.LocalTime;

public class Pago {
    private int idPago;
    private LocalDate fechaPago;
    private LocalTime horaPago;
    private double cuentaPorPagar;
    private EstadoPago estado;
    private Anfitrion anf;
    private Evento eve;

    // CONSTRUCTORES
    public Pago() {}

    public Pago(int idPago, LocalDate fechaPago, LocalTime horaPago, double cuentaPorPagar,
                EstadoPago estado, Anfitrion anf, Evento eve) {
        this.idPago = idPago;
        this.fechaPago = fechaPago;
        this.horaPago = horaPago;
        this.cuentaPorPagar = cuentaPorPagar;
        this.estado = estado;
        this.anf = anf;
        this.eve = eve;
    }

    // GETTERS AND SETTERS
    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public LocalTime getHoraPago() {
        return horaPago;
    }

    public void setHoraPago(LocalTime horaPago) {
        this.horaPago = horaPago;
    }

    public double getCuentaPorPagar() {
        return cuentaPorPagar;
    }

    public void setCuentaPorPagar(double cuentaPorPagar) {
        this.cuentaPorPagar = cuentaPorPagar;
    }

    public EstadoPago getEstado() {
        return estado;
    }

    public void setEstado(EstadoPago estado) {
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
}
