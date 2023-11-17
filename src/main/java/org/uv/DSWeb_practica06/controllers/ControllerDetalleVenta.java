/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.DSWeb_practica06.controllers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import org.uv.DSWeb_practica06.repository.RepositoryDetalleVenta;

/**
 *
 * @author yacruz
 */
@RestController
@RequestMapping("/api/detalleventa")
public class ControllerDetalleVenta {

    @Autowired
    private RepositoryDetalleVenta detalleVentaRepository;

    @GetMapping("/{id}")
    public ResponseEntity<DetalleVenta> obtenerDetalleVenta(@PathVariable Long id) {
        Optional<DetalleVenta> detalleVenta = detalleVentaRepository.findById(id);
        return detalleVenta.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<DetalleVenta> crearDetalleVenta(@RequestBody DetalleVenta detalleVenta) {
        try {
            DetalleVenta nuevoDetalleVenta = detalleVentaRepository.save(detalleVenta);
            return new ResponseEntity<>(nuevoDetalleVenta, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleVenta> actualizarDetalleVenta(@PathVariable Long id, @RequestBody DetalleVenta detalleVentaActualizado) {
        Optional<DetalleVenta> optionalDetalleVenta = detalleVentaRepository.findById(id);

        if (optionalDetalleVenta.isPresent()) {
            DetalleVenta detalleVentaExistente = optionalDetalleVenta.get();

            detalleVentaExistente.setVenta(detalleVentaActualizado.getVenta());
            detalleVentaExistente.setIdProducto(detalleVentaActualizado.getIdProducto());
            detalleVentaExistente.setPrecio(detalleVentaActualizado.getPrecio());
            detalleVentaExistente.setDescripcion(detalleVentaActualizado.getDescripcion());
            detalleVentaExistente.setCantidad(detalleVentaActualizado.getCantidad());

            DetalleVenta detalleVentaGuardado = detalleVentaRepository.save(detalleVentaExistente);
            return ResponseEntity.ok(detalleVentaGuardado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarDetalleVenta(@PathVariable Long id) {
        if (detalleVentaRepository.existsById(id)) {
            detalleVentaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
