/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.DSWeb_practica06.data;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


/**
 *
 * @author loken
 */
@Entity
@Table(name="empleados")
public class Empleado implements Serializable{
    
    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empleados_idempleado_seq")
    @SequenceGenerator(name = "empleados_idempleado_seq", sequenceName = "empleados_idempleado_seq",
            initialValue = 1, allocationSize = 1)
    @Column(name = "idempleado")
    private Long idempleado;
    
    @NotNull
    @Column(name = "nombre")
    private String nombre;
    
    @NotNull
    @Column(name = "direccion")
    private String direccion;
    
    @NotNull
    @Column(name = "telefono")
    private String telefono;

    public Empleado(Long idempleado, String nombre, String direccion, String telefono) {
        this.idempleado = idempleado;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Empleado() {
    }
    
    public long getId() {
        return idempleado;
    }

    public void setId(long id) {
        this.idempleado = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
