package com.example.demo.ResponseEntity5.dto;

import com.example.demo.ResponseEntity5.PostV5;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

// title, content, author를 받아다가
// 우리의 Post로 만드는 역할을 하겠어.
@Getter
@NoArgsConstructor
public class PostCreateRequestDto {

    private String title;
    private String content;
    private String author;

    public PostV5 toEntity() {
        return PostV5.builder()
                .title(this.title)
                .content(this.content)
                .author(this.author).build();
    }
}
