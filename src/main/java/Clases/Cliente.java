package Clases;

/**
 * @author jhona
 */
public class Cliente {

    private String cedula;

    public Cliente(final String cedula, final String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }
    private String nombre;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(final String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

}
