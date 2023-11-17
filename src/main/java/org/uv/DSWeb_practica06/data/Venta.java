/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.DSWeb_practica06.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author yacruz
 */
@Entity
@Table(name="venta")
public class Venta implements Serializable {
    @Id
    @GeneratedValue(generator = "venta_idventa_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "venta_idventa_seq", sequenceName = "venta_idventa_seq", 
            initialValue = 1, allocationSize = 1)
    @Column(name = "idventa")
    private Long idventa;
    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "total")
    private BigDecimal total;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEmpleado", referencedColumnName = "idEmpleado")
    private Empleado empleado;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "venta")
    private List<DetalleVenta> ventasDetalle = new ArrayList<>();

    public List<DetalleVenta> getVentasDetalle() {
        return ventasDetalle;
    }

    public void setVentasDetalle(List<DetalleVenta> ventasDetalle) {
        this.ventasDetalle = ventasDetalle;
    }
    
    //

    public Empleado getCliente() {
        return empleado;
    }

    public void setCliente(Empleado empleado) {
        this.empleado = empleado;
    }

    public Long getIdventa() {
        return idventa;
    }

    public void setIdventa(Long idventa) {
        this.idventa = idventa;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
//
//    public Long getIdCliente() {
//        return idCliente;
//    }
//
//    public void setIdCliente(Long idCliente) {
//        this.idCliente = idCliente;
//    }
    
    
}
