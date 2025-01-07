package com.example.demo.BaseTimeEntity8;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepositoryV8 extends JpaRepository<PostV8, Long> {
}
