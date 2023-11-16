/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package org.uv.DSWeb_practica06.data;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author loken
 */
public interface RepositoryEmpleado extends JpaRepository<Empleado, Long> {
    
}
