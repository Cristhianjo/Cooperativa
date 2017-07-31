package Clases;

/**
 *
 * @author solan
 */
public class Cuenta {

    private int codigo;
    private String ci;
    private String tipo;
    private float saldo;
    private String estado;
    private String nombre;

    public Cuenta(final int codigo, final String ci, final String tipo, 
            final float saldo, final String estado, final String nombre) {
        this.codigo = codigo;
        this.ci = ci;
        this.tipo = tipo;
        this.saldo = saldo;
        this.estado = estado;
        this.nombre = nombre;
    }

    public Cuenta() {

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(final int codigo) {
        this.codigo = codigo;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(final String ci) {
        this.ci = ci;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(final String tipo) {
        this.tipo = tipo;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(final float saldo) {
        this.saldo = saldo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(final String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }
}
