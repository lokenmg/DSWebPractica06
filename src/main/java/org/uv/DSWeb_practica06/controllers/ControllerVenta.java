/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.DSWeb_practica06.controllers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uv.DSWeb_practica06.data.DetalleVenta;
import org.uv.DSWeb_practica06.data.Venta;
import org.uv.DSWeb_practica06.repository.RepositoryVenta;

/**
 *
 * @author yacruz
 */
@RestController
@RequestMapping("/api/venta")
public class ControllerVenta {
    
    @Autowired
    private RepositoryVenta ventaRepository;

    @PostMapping
    public ResponseEntity<Venta> crearVenta(@RequestBody Venta venta) {
        Venta ventaGuardada = ventaRepository.save(venta);
        return ResponseEntity.ok(ventaGuardada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> obtenerVenta(@PathVariable Long id) {
        Optional<Venta> venta = ventaRepository.findById(id);
        return venta.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/add-detalle")
    public ResponseEntity<Venta> agregarDetalleVenta(@PathVariable Long id, @RequestBody DetalleVenta detalleVenta) {
        Optional<Venta> optionalVenta = ventaRepository.findById(id);

        if (optionalVenta.isPresent()) {
            Venta venta = optionalVenta.get();
            detalleVenta.setVenta(venta);
            venta.getVentasDetalle().add(detalleVenta);

            Venta ventaGuardada = ventaRepository.save(venta);
            return ResponseEntity.ok(ventaGuardada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarVenta(@PathVariable Long id) {
        if (ventaRepository.existsById(id)) {
            ventaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}
