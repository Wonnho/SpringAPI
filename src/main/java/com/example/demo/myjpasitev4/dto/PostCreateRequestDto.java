package com.example.demo.myjpasitev4.dto;

import com.example.demo.myjpasitev4.PostV4;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostCreateRequestDto {
    //data를 방아다가 우리의 Post로 만드는 역할을 할겠어
 private String title;
 private String content;
 private String author;

public  PostV4 toEntity() {
    return PostV4.builder()
            .tittle(this.title)
            .content(this.content)
            .author(this.author)
            build();


}
}
