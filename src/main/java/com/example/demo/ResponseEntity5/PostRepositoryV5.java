package com.example.demo.ResponseEntity5;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepositoryV5 extends JpaRepository<PostV5, Long> {
}
