package com.example.demo.BaseTimeEntity8.dto;

import com.example.demo.BaseTimeEntity8.PostV8;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class PostListResponseDto {
    private final Long id;

    private final String title;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public static PostListResponseDto from(PostV8 entity) {
        return PostListResponseDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .createdAt((entity.getCreatedAt()))
                .updatedAt(entity.getUpdatedAt())
                .build();

    }
}
