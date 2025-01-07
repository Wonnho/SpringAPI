package com.example.demo.myjpadto4prac;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepositoryJpa5 extends JpaRepository<PostJpa5,Long> {
}
