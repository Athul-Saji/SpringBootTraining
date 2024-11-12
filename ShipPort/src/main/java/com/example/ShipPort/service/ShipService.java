package com.example.ShipPort.service;

import com.example.ShipPort.model.Port;
import com.example.ShipPort.model.Ship;
import com.example.ShipPort.repo.PortRepo;
import com.example.ShipPort.repo.ShipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipService {

    @Autowired
    private ShipRepo shipRepo;
    @Autowired
    private PortRepo portRepo;
    public Ship createShip(Ship ship, int portId){
        Port port=portRepo.findById(portId).orElse(new Port());
        ship.setPort(port);
        port.setShips(ship);
        if(portRepo.existsByPortId(portId) && !shipRepo.existsById(ship.getId())){
            return shipRepo.save(ship);
        }
        else{
            return null;
        }
    }
    public List<Ship> findAllShips(){
        return shipRepo.findAll();
    }
    public Ship updateShip(Ship ship,int id){
        if(shipRepo.findById(id).isPresent()){
            Ship s=shipRepo.findById(id).orElse(new Ship());
            s.setShipName(ship.getShipName());
            s.setType(ship.getType());
            s.setPort(s.getPort());
            return shipRepo.save(s);
        }
        else{
            return null;
        }
    }

    public boolean removeShip(int id){
        if(shipRepo.findById(id).isPresent()){
            Ship s = shipRepo.findById(id).orElse(null);
            if(s!=null){
            shipRepo.delete(s);
            return true;
            }

        }
        return false;

    }



}
