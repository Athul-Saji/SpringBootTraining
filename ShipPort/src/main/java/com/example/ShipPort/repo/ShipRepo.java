package com.example.ShipPort.repo;

import com.example.ShipPort.model.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipRepo extends JpaRepository<Ship,Integer> {
    boolean existsById(int id);
}
