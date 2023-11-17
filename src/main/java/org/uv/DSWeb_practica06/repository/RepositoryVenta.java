/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.DSWeb_practica06.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uv.DSWeb_practica06.data.Venta;

/**
 *
 * @author yacruz
 */
public interface RepositoryVenta extends JpaRepository<Venta, Long> {
    
}
