package ar.com.ada.api.empleadas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.empleadas.entities.Categoria;

@RestController
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @PostMapping("/categorias")
    public ResponseEntity<?> crearCategoria(@RequestBody Categoria categoria) {

        GenericResponse respuesta = new GenericResponse();

        service.crearCategoria(categoria);

        respuesta.isOk = true;
        respuesta.id = categoria.getCategoriaId();
        respuesta.message = "Categoria creada";

        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> traerCategorias() { // return Response Entity
        return ResponseEntity.ok(service.traerCategorias()); // return entity con el valor esperado
    }

}
