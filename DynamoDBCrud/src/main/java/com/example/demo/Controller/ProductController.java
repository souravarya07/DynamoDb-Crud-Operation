package com.example.demo.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @PostMapping(value = "/saveProduct", consumes = "application/json")
    public ResponseEntity<String> saveProduct() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/getProduct", consumes = "application/json")
    public ResponseEntity<String> getProduct() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/updateProduct", consumes = "application/json")
    public ResponseEntity<String> updateProduct() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteProduct", consumes = "application/json")
    public ResponseEntity<String> deleteProduct() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
