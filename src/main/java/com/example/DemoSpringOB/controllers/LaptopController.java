package com.example.DemoSpringOB.controllers;

import com.example.DemoSpringOB.entities.Laptop;
import com.example.DemoSpringOB.repository.LaptopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {
    private final Logger log = LoggerFactory.getLogger(LaptopController.class);
    private LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository bookRepository) {
        this.laptopRepository = bookRepository;
    }

    //CRUD SOBRE BOOK

    //BUSCAR TODOS LOS LIBROS
    @GetMapping("/api/laptops")
    public List<Laptop> findAll() {
        return laptopRepository.findAll();
    }

    // BUSCAR SOLO 1 LIBRO
    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> findById(@PathVariable Long id) {

        Optional<Laptop> laptopOpt = laptopRepository.findById(id);

        if (laptopOpt.isPresent()) {
            return ResponseEntity.ok(laptopOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // CREAR 1 LIBRO
    @PostMapping("/api/laptops")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers) {
        System.out.println(headers.get("User-Agent"));

        if(laptop.getId() != null) {
            log.warn("intenta crear ordenador con id");
            System.out.println("intenta crear ordenador con id");
            return ResponseEntity.badRequest().build();
        }

        Laptop resultado = laptopRepository.save(laptop);
        return ResponseEntity.ok(resultado);


    }
    // ACTUALIZAR 1 LIBRO
    @PutMapping("/api/laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop) {

        if(laptop.getId() == null){
            log.warn("intenta actualizar ordenador que no existe");
            return ResponseEntity.badRequest().build();
        }

        if(!laptopRepository.existsById(laptop.getId())){
            log.warn("este ordenador no existe ");
            return ResponseEntity.notFound().build();
        }
        Laptop resultado = laptopRepository.save(laptop);
        return ResponseEntity.ok(resultado);
    }


    // BORRAR 1 LIBRO

    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){

        if(!laptopRepository.existsById(id)){
            log.warn("libro borrado");
            return ResponseEntity.notFound().build();
        }

        laptopRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/laptops/all")
    public ResponseEntity<Laptop> deleteAll(){

        log.info("delete all");

        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

}
