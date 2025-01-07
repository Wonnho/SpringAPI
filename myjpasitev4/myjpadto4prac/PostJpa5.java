package com.example.demo.myjpadto4prac;

import com.example.demo.myjpasitev4.dto.PostUpdateRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostJpa5 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private String author;

    @Builder
    public PostJpa5(String title,String content,String author) {
        this.title=title;
        this.content=content;
        this.author=author;
    }

    public PostJpa5 update(PostUpdateRequestDto requestDto) {
        this.title=requestDto.getTitle();
        this.content=requestDto.getContent();
        return this;
    }
}
