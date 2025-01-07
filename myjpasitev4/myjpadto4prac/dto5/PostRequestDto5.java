package com.example.demo.myjpadto4prac.dto5;

import com.example.demo.myjpadto4prac.PostJpa5;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostRequestDto5 {
    private String title;
    private String content;
    private String author;

    public PostJpa5 toEntity() {
        return PostJpa5.builder()
                .title(this.title)
                .content(this.content)
                .author(this.author).build();
    }
}
