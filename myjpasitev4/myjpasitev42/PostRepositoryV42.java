package com.example.demo.myjpasitev42;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepositoryV42 extends JpaRepository<PostV4,Long> {

}
