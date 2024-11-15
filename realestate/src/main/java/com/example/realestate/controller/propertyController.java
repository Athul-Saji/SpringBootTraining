package com.example.realestate.controller;

import com.example.realestate.entity.Property;
import com.example.realestate.service.propertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/properties")
public class propertyController {
    @Autowired
    private propertyService p;
    @PostMapping
    public ResponseEntity<Property> setProperty(@RequestBody Property property){
        return ResponseEntity.status(HttpStatus.OK).body(p.setProperty(property));
    }
    @GetMapping
    public ResponseEntity<ArrayList<Property>> getProperty(){
        return ResponseEntity.status(HttpStatus.FOUND).body(p.getProperty());
    }

}
