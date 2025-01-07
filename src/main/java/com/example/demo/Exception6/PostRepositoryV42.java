package com.example.demo.Exception6;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepositoryV42 extends JpaRepository<PostV42, Long> {
}
