/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package org.uv.DSWeb_practica06.controllers;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.uv.DSWeb_practica06.data.Empleado;
import org.uv.DSWeb_practica06.data.RepositoryEmpleado;

/**
 *
 * @author chel
 */
@Validated
@RestController
@RequestMapping("/api/empleado")
public class ControllerEmpleados {

    @Autowired
    private RepositoryEmpleado repositoryEmpleado;

    @PostMapping
    public ResponseEntity<Empleado> post(@RequestBody Empleado empleado) {
        Empleado empRes = repositoryEmpleado.save(empleado);
        return ResponseEntity.ok(empRes);
    }

    @GetMapping()
    public List<Empleado> list() {
        return repositoryEmpleado.findAll();
    }

    @GetMapping("/{id}")
    public Object get(@PathVariable Long id) {
        Optional<Empleado> optRes = repositoryEmpleado.findById(id);
        return optRes.isPresent() ? optRes.get() : null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empleado> put(@PathVariable Long id, @RequestBody Empleado empleado) {
        Optional<Empleado> optEmpleado = repositoryEmpleado.findById(id);

        if (optEmpleado.isPresent()) {
            Empleado empleadoExistente = optEmpleado.get();
            empleadoExistente.setNombre(empleado.getNombre());
            empleadoExistente.setDireccion(empleado.getDireccion());
            empleadoExistente.setTelefono(empleado.getTelefono());

            Empleado empleadoActualizadoRes = repositoryEmpleado.save(empleadoExistente);
            return ResponseEntity.ok(empleadoActualizadoRes);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (repositoryEmpleado.existsById(id)) {
            repositoryEmpleado.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("msg")
    public String msg() {
        return "Hola mundo";
    }

}