package com.example.demo.ResponseEntity5.dto;

import lombok.Getter;

// title, content, author를 받아다가
// 우리의 Post로 만드는 역할을 하겠어.
@Getter
public class PostUpdateRequestDto {
    private String title;
    private String content;

}
