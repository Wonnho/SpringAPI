package com.example.demo.myjpasitev4;

import com.example.demo.myjpasitev4.dto.PostCreateRequestDto;
import com.example.demo.myjpasitev4.dto.PostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jpa/v4/posts")
@RequiredArgsConstructor  // due to DI. postService때문에 필요하다.
public class PostControllerV4 {

    private final PostServiceV4 postServiceV4;

    //Post method /url/ data
    @PostMapping

   public PostResponseDto createPost(@RequestBody PostCreateRequestDto requestedDto) {
//        PostV4 post= requestedDto.toEntity();
        return postServiceV4.createPost(requestedDto);
}
