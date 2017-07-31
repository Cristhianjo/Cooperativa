/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
/**
 *
 * @author Victoria
 */
public class Movimiento {

    private int codMovi;
    private String tipo;
    private String fecha;
    //dd-dd-
    private float monto;
    private float saldo;

    public Movimiento() {
    }

    public Movimiento(final int codMovi,final  String tipo, final String fecha, final float monto,final  float saldo) {
        this.codMovi = codMovi;
        this.tipo = tipo;
        this.fecha = fecha;
        this.monto = monto;
        this.saldo = saldo;
    }

    public int getCodmovi() {
        return codMovi;
    }

    public void setCodmovi(final int codMovi) {
        this.codMovi = codMovi;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(final String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(final String fecha) {
        this.fecha = fecha;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(final float monto) {
        this.monto = monto;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(final float saldo) {
        this.saldo = saldo;
    }
}
