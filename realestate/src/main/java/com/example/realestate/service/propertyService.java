package com.example.realestate.service;

import com.example.realestate.entity.Property;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class propertyService {
    public ArrayList<Property> propertyArrayList = new ArrayList<>();
    public Property setProperty(Property property){
        propertyArrayList.add(property);
        return property;
    }
    public ArrayList<Property> getProperty(){
        return propertyArrayList;
    }

}
