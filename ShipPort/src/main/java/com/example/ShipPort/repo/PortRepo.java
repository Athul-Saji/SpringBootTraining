package com.example.ShipPort.repo;

import com.example.ShipPort.model.Port;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortRepo extends JpaRepository<Port,Integer> {
    public boolean existsByPortName(String portName);
    public boolean existsByPortId(int portId);
}
