package com.corenetworks.repaso.excepciones.controlador;

import com.corenetworks.repaso.excepciones.dto.ProductoDTO;
import com.corenetworks.repaso.excepciones.excepciones.ExcepcionPersonalizadaNoEncontrado;
import com.corenetworks.repaso.excepciones.modelo.Producto;
import com.corenetworks.repaso.excepciones.servicio.IProductoServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoControlador {
    @Autowired
    private IProductoServicio servicio;
    @PostMapping
    public ResponseEntity<ProductoDTO> insertar(@Valid @RequestBody ProductoDTO p) throws Exception{
        System.out.println(p.toString());
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Producto> modificar(@RequestBody Producto p) throws Exception{
        //1,Buscar el producto a modificar

        Producto p1 = servicio.listarUno(p.getProductoId());
        if(p1 == null){
            throw new ExcepcionPersonalizadaNoEncontrado("Producto no encontrado con ID "+ p.getProductoId());
        }
        return new ResponseEntity<>(servicio.modificar(p), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Producto>> consultarTodos() throws Exception {
        return new ResponseEntity<>(servicio.listarTodos(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> consultarUno(@PathVariable(name="id") int id) throws Exception{
        //1,Buscar el producto a modificar

        Producto p1 = servicio.listarUno(id);
        if(p1 == null){
            throw new ExcepcionPersonalizadaNoEncontrado("Producto no encontrado con ID "+ id);
        }
        return new ResponseEntity<>(servicio.listarUno(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable(name="id") int id) throws Exception{
        //1,Buscar el producto a modificar

        Producto p1 = servicio.listarUno(id);
        if(p1 == null){
            throw new ExcepcionPersonalizadaNoEncontrado("Producto no encontrado con ID "+ id);
        }
        servicio.eliminar(id);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }

}
