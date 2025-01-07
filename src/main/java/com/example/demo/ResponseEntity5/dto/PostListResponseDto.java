package com.example.demo.ResponseEntity5.dto;

import com.example.demo.ResponseEntity5.PostV5;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostListResponseDto {
    private final Long id;

    private final String title;

    public static PostListResponseDto from(PostV5 entity) {
        return PostListResponseDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .build();

    }
}
