package com.example.parametry;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductApi {
//    można dodać argumenty przez parametr, ścieżkę, headery lub body


    @GetMapping("/products")
    public String getProducts(@RequestParam String name,
                              @RequestParam String surname,
                              @RequestParam(required = false, defaultValue = "Franek") String pseudo) {
        return "Hello with GET " + name + " " + surname;
    }

    @GetMapping("/products/{name}")
    public String getProductsWithName(@PathVariable String name) {
        return "Hello with GET " + name;
    }

    @GetMapping("/productshead")
    public String getProductsWithHeader(@RequestHeader String head) {
        return "Hello with GET " + head;
    }

    @GetMapping("/productsbody")
    public String getProductsWithBody(@RequestBody String body) {
        return "Hello with GET " + body;
    }

    @GetMapping("/products2/{name2}")
    public String getAllTogether(@PathVariable String name2,
                                 @RequestParam String param) {
        return "Hello " + name2 + " sir " + param;
    }

    @GetMapping
    public ResponseEntity<String> getProducts() {
        return new ResponseEntity<>("Hello new world", HttpStatus.OK);
    }
//    nowsze podejście z ResponseEntity
    @GetMapping("/status")
    public ResponseEntity<String> getProducts2() {
        return ResponseEntity.ok("Jest wszystko ok");
    }

    @PutMapping("/products")
    public String putProducts() {
        return "Hello with PUT";
    }

    @PostMapping("/products")
    public String postProducts() {
        return "Hello with POST";
    }

    @DeleteMapping("/products")
    public String deleteProducts() {
        return "Hello with DELETE";
    }
}
