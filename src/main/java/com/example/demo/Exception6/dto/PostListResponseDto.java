package com.example.demo.Exception6.dto;

import com.example.demo.Exception6.PostV42;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostListResponseDto {
    private final Long id;

    private final String title;

    public static PostListResponseDto from(PostV42 entity) {
        return PostListResponseDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .build();

    }
}
