package com.deepakvadgama.testing.springmvc;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfileRestController {

    @GetMapping("/get")
    private Person get(@RequestParam String name) {

        // Dummy return
        if (name.equals("John Wick")) {
            return new Person("John Wick", 35,
                    new Address("Spring street", "L.A.", "000992"));
        }

        return null;
    }

    @PostMapping("/save")
    private boolean save(@RequestBody Person person) {
        // Dummy save
        return true;
    }

    @GetMapping("/badrequest")
    private ResponseEntity<String> badRequest() {
        // Dummy save
        return ResponseEntity.badRequest().body("No candy for you");
    }
}

