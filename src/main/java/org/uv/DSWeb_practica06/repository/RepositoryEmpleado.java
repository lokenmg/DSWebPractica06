/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package org.uv.DSWeb_practica06.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uv.DSWeb_practica06.data.Empleado;

/**
 *
 * @author loken
 */
public interface RepositoryEmpleado extends JpaRepository<Empleado, Long> {
    
}
