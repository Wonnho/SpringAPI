package com.example.demo.myjpadto4prac.dto5;

import com.example.demo.myjpadto4prac.PostJpa5;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostResponseDto5 {
        private final Long id;
        private final String title;
        private final String content;
        private final String author;

    public static PostResponseDto5 from(PostJpa5 entity) {
        return PostResponseDto5.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .author(entity.getAuthor())
                .build();
    }

}
