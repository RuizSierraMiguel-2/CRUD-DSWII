package com.cibertec.cibertec.controller;

import java.util.HashMap;
import java.util.List;

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

import com.cibertec.cibertec.entity.Cliente;
import com.cibertec.cibertec.entity.Producto;
import com.cibertec.cibertec.service.ProductoService;

@RestController
@RequestMapping("/url/productos")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;

    @GetMapping("/listaTodos")
    public List<Producto> getProductos() {
        return productoService.listaProductos();
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarProducto(@RequestBody Producto producto) {
               HashMap<String, Object> salida = new HashMap<>();
            try {
                producto.setIdProducto(0);
                Producto objSalida = productoService.insertaActualizaProducto(producto);
            salida.put("mensaje", "Producto registrado de ID >>> " + objSalida.getIdProducto());
        } catch (Exception e) {
            salida.put("mensaje", "Error al registrar");
        }
        return ResponseEntity.ok(salida);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizaProducto(@RequestBody Producto producto) {
        HashMap<String, Object> salida = new HashMap<>();
        try {
            Producto objSalida = productoService.insertaActualizaProducto(producto);
            salida.put("mensaje", "Producto actualizado de ID >>> " + objSalida.getIdProducto());
        } catch (Exception e) {
            salida.put("mensaje", "Error al actualizar");
        }
        return ResponseEntity.ok(salida);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminaProducto(@PathVariable("id") int id) {
        HashMap<String, Object> salida = new HashMap<>();
        try {
            productoService.eliminaProducto(id);
            salida.put("mensaje", "Producto eliminado de ID >>> " + id);
        } catch (Exception e) {
            salida.put("mensaje", "Error al eliminar");
        }
        return ResponseEntity.ok(salida);
    }

    @GetMapping("/buscarPorId/{id}")
    public ResponseEntity<?> getProductoById(@PathVariable("id") int id) {
        HashMap<String, Object> salida = new HashMap<>();
        try {
            Producto producto = productoService.obtienePorId(id).get();
            salida.put("producto", producto);
        } catch (Exception e) {
            salida.put("mensaje", "Error al buscar");
        }
        return ResponseEntity.ok(salida);
    }
}
