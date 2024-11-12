package com.example.demo.service;

import com.example.demo.modl.book;
import com.example.demo.modl.user;
import com.example.demo.repo.bookrepo;
import com.example.demo.repo.userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class userservice {

    @Autowired
    userrepo userepo;
    @Autowired
    bookrepo bookrep;

    public Optional<user> getuser(long id)
    {
        return userepo.findById(id);
    }

    public user adduser(user newuser)
    {
        return userepo.save(newuser);
    }


    public book addbook(book newbook)
    {
        return bookrep.save(newbook);
    }

    public Optional<book> getbook(Long id)
    {
        return bookrep.findById(id);
    }

}
