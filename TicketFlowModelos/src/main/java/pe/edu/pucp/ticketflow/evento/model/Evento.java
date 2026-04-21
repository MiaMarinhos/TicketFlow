package pe.edu.pucp.ticketflow.evento.model;

import pe.edu.pucp.ticketflow.usuario.model.Anfitrion;

import java.time.LocalDate;
import java.time.LocalTime;

public class Evento {
    private int idEvento;
    private String nombreEvento;
    private Categoria cat;
    private LocalDate fecha;
    private String duracion;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private EstadoEvento estado;
    private String ubicacion;
    private String nombreEstablecimiento;
    private double precioEntrada;

    private String urlPoster;

    private int capacidadEntradas;
    private int entradasAdquiridas;
    //private int entradasRestantes;
    private double totalReal;
    private double totalRecaudado;

    private Anfitrion anfi;

    //CONSTRUCTORES

    public Evento(){}

    public Evento(int idEvento, String nombreEvento, Categoria cat,
                  LocalDate fecha, String duracion, LocalTime horaInicio,
                  LocalTime horaFin, EstadoEvento estado, String ubicacion,
                  String nombreEstablecimiento, double precioEntrada,
                  String urlPoster, int capacidadEntradas, int entradasAdquiridas,
                  double totalReal, double totalRecaudado, Anfitrion anfi){

        this.idEvento=idEvento;
        this.nombreEvento=nombreEvento;
        this.cat = cat;
        this.fecha = fecha;
        this.duracion = duracion;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.estado = estado;
        this.ubicacion = ubicacion;
        this.nombreEstablecimiento = nombreEstablecimiento;
        this.precioEntrada = precioEntrada;
        this.urlPoster = urlPoster;
        this.capacidadEntradas = capacidadEntradas;
        this.entradasAdquiridas = entradasAdquiridas;
        this.totalReal = totalReal;
        this.totalRecaudado = totalRecaudado;
        this.anfi = anfi;

    }

    //GETTERS AND SETTERS

    public int getIdEvento() {
        return this.idEvento;
    }
    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getNombreEvento() {
        return this.nombreEvento;
    }
    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public Categoria getCat() {
        return this.cat;
    }
    public void setCat(Categoria cat) {
        this.cat = cat;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDuracion() {
        return this.duracion;
    }
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public LocalTime getHoraInicio() {
        return this.horaInicio;
    }
    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return this.horaFin;
    }
    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public EstadoEvento getEstado() {
        return this.estado;
    }
    public void setEstado(EstadoEvento estado) {
        this.estado = estado;
    }

    public String getUbicacion() {
        return this.ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getNombreEstablecimiento() {
        return this.nombreEstablecimiento;
    }
    public void setNombreEstablecimiento(String nombreEstablecimiento) {
        this.nombreEstablecimiento = nombreEstablecimiento;
    }

    public double getPrecioEntrada() {
        return this.precioEntrada;
    }
    public void setPrecioEntrada(double precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    public String getUrlPoster() {
        return this.urlPoster;
    }
    public void setUrlPoster(String urlPoster) {
        this.urlPoster = urlPoster;
    }

    public int getCapacidadEntradas() {
        return this.capacidadEntradas;
    }
    public void setCapacidadEntradas(int capacidadEntradas) {
        this.capacidadEntradas = capacidadEntradas;
    }

    public int getEntradasAdquiridas() {
        return this.entradasAdquiridas;
    }
    public void setEntradasAdquiridas(int entradasAdquiridas) {
        this.entradasAdquiridas = entradasAdquiridas;
    }

    public double getTotalReal() {
        return this.totalReal;
    }
    public void setTotalReal(double totalReal) {
        this.totalReal = totalReal;
    }

    public double getTotalRecaudado() {
        return this.totalRecaudado;
    }
    public void setTotalRecaudado(double totalRecaudado) {
        this.totalRecaudado = totalRecaudado;
    }

    public Anfitrion getAnfi() {
        return this.anfi;
    }
    public void setAnfi(Anfitrion anfi) {
        this.anfi = anfi;
    }


    //METODOS

}
