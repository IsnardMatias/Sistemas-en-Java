package ar.com.branca.sistema.pojos;

import java.sql.Date;

/**
 *
 * @author Martín
 */
public class Venta {
    
    private int idVenta;
    private double montoVenta;
    private Date fechaVenta;

    public Venta(double montoVenta, Date fechaVenta) {
        this.montoVenta = montoVenta;
        this.fechaVenta = fechaVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public double getMontoVenta() {
        return montoVenta;
    }

    public void setMontoVenta(double montoVenta) {
        this.montoVenta = montoVenta;
    } 
}