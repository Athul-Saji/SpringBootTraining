package com.example.demo.repo;

import com.example.demo.modl.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userrepo extends JpaRepository<user,Long> {
}
