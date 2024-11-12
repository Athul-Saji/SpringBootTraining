package com.example.ShipPort.exception;

public class DuplicatePortException extends Exception{
    public DuplicatePortException(String portName){
        super("Port name "+portName+" already exist");
    }
}
