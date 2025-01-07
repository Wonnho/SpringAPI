package com.example.demo.BaseTimeEntity8.dto;

import com.example.demo.BaseTimeEntity8.PostV8;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class PostResponseDto {
    private final Long id;

    private final String title;
    private final String content;
    private final String author;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static PostResponseDto from(PostV8 entity) {
        return PostResponseDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .author(entity.getAuthor())
                .createdAt((entity.getCreatedAt()))
                .updatedAt(entity.getUpdatedAt())
                .build();
//        return new PostResponseDto(entity.getId(), entity.getTitle(), entity.getContent(), entity.getAuthor());




    }
}
