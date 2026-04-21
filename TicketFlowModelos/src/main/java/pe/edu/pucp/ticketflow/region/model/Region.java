package pe.edu.pucp.ticketflow.region.model;

public class Region {
    private int idRegion;
    private String nombre;

    public Region(){
    }

    public Region(int idRegion, String nombre){
        this.idRegion = idRegion;
        this.nombre = nombre;
    }

    //GETTERS AND SETTERS

    public int getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //METODOS
}
