package pe.edu.pucp.ticketflow.pago.model;

import pe.edu.pucp.ticketflow.evento.model.Evento;

import java.time.LocalDate;
import java.time.LocalTime;

public class Pago {
    private int idPago;
    private LocalDate fechaPago;
    private LocalDate fechaLimitePago;
    private EstadoPago estado;
    private double totalAPagar;
    private String comprobante;
    private Evento eve;

    // CONSTRUCTORES
    public Pago() {}

    public Pago(int idPago, LocalDate fechaPago, LocalDate fechaLimitePago,
                double totalAPagar, EstadoPago estado, String comprobante, Evento eve) {
        this.idPago = idPago;
        this.fechaPago = fechaPago;
        this.fechaLimitePago = fechaLimitePago;
        this.totalAPagar = totalAPagar;
        this.estado = estado;
        this.comprobante = comprobante;
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

    public LocalDate getFechaLimitePago() {
        return fechaLimitePago;
    }

    public void setFechaLimitePago(LocalDate fechaLimitePago) {
        this.fechaLimitePago = fechaLimitePago;
    }

    public EstadoPago getEstado() {
        return estado;
    }

    public void setEstado(EstadoPago estado) {
        this.estado = estado;
    }

    public double getTotalAPagar() {
        return totalAPagar;
    }

    public void setTotalAPagar(double totalAPagar) {
        this.totalAPagar = totalAPagar;
    }

    public String getComprobante() {
        return comprobante;
    }

    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }

    public Evento getEve() {
        return eve;
    }

    public void setEve(Evento eve) {
        this.eve = eve;
    }
}
