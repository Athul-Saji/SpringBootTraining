package com.example.ShipPort.controller;


import com.example.ShipPort.exception.DuplicatePortException;
import com.example.ShipPort.model.Port;
import com.example.ShipPort.model.Ship;
import com.example.ShipPort.service.PortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/port")
public class PortController {
    @Autowired
    private PortService portService;

    @PostMapping
    public ResponseEntity<Port> addPort(@RequestBody Port port) throws DuplicatePortException {
        try {
            Port p= portService.createPort(port);
            return ResponseEntity.status(HttpStatus.CREATED).body(p);
        }catch (DuplicatePortException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(port);
        }
    }
    @GetMapping("/{portId}")
    public ResponseEntity<Optional<Port>> fetchPort(@PathVariable int portId){
        if(portService.fetchPort(portId).isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(portService.fetchPort(portId));
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }
}
