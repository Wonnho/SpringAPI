package com.example.demo.BaseTimeEntity8;

import com.example.demo.BaseTimeEntity8.dto.PostUpdateRequestDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostV8 extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String title;
    private String content;
    private String author;

    @Builder
    public PostV8(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public PostV8 update(PostUpdateRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        return this;

    }
}
