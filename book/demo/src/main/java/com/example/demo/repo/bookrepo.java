package com.example.demo.repo;

import com.example.demo.modl.book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface bookrepo extends JpaRepository<book,Long> {
}
