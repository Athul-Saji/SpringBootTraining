package com.example.ShipPort.service;

import com.example.ShipPort.exception.DuplicatePortException;
import com.example.ShipPort.model.Port;
import com.example.ShipPort.repo.PortRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PortService {
    @Autowired
    private PortRepo portRepo;

    public Port createPort(Port port) throws DuplicatePortException {
        if(portRepo.existsByPortName(port.getPortName())){
            throw new DuplicatePortException(port.getPortName());
        }
        return portRepo.save(port);
    }

    public Optional<Port> fetchPort(int portId){
        Optional<Port> p = Optional.of(portRepo.findById(portId).orElse(new Port()));
        return p;

    }


}
