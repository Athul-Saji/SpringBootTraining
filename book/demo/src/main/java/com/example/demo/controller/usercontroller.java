package com.example.demo.controller;

import com.example.demo.modl.book;
import com.example.demo.modl.user;
import com.example.demo.service.userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class usercontroller {
    @Autowired
    userservice uservice;

    @GetMapping("user/{id}")
    public ResponseEntity<?> getuser(@PathVariable Long id)
    {
        Optional<user> opt= uservice.getuser(id);
        if(!opt.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.OK).body(opt);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

    }
    @PostMapping("/user")
    public ResponseEntity<user> adduser(@RequestBody user newuser)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(uservice.adduser(newuser));
    }
    @GetMapping("/book/{id}")
    public ResponseEntity<?> getbook(@PathVariable Long id)
    {
        Optional<book> opt1=uservice.getbook(id);
        if(opt1.isPresent())
        {
            return ResponseEntity.status(HttpStatus.OK).body(opt1);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
    @PostMapping("/book")
    public ResponseEntity<book> addbook(@RequestBody book newbook)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(uservice.addbook(newbook));
    }

}
