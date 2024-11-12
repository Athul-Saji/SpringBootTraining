package com.example.ShipPort.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Port {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int portId;
    private String portName;
    private String location;
    @OneToMany(mappedBy = "port", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Ship> ships;

    public void setShips(Ship ship) {
        this.ships.add(ship);
    }
}
