package com.example.ShipPort.controller;

import com.example.ShipPort.model.Ship;
import com.example.ShipPort.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ship")
public class ShipController {
    @Autowired
    private ShipService shipService;

    @PostMapping("/port/{portId}")
    public ResponseEntity<Ship> createShip(@RequestBody Ship ship, @PathVariable int portId){
        if(shipService.createShip(ship,portId)!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(ship);
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @GetMapping
    public ResponseEntity<List<Ship>> findAllShips(){
        if(shipService.findAllShips()!=null){
            return ResponseEntity.status(HttpStatus.OK).body(shipService.findAllShips());
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @PostMapping("/{shipId}")
    public ResponseEntity<Ship> updateShip(@PathVariable int shipId,@RequestBody Ship ship){
        if(shipService.updateShip(ship,shipId)!=null){
            return ResponseEntity.status(HttpStatus.OK).body(ship);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{shipId}")
    public ResponseEntity<String> deleteShip(@PathVariable int shipId){
        if(shipService.removeShip(shipId)){
            return ResponseEntity.status(HttpStatus.OK).body("Ship deleted successfully");
        }
        else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ship not found with ID: "+shipId);
        }
    }


}
