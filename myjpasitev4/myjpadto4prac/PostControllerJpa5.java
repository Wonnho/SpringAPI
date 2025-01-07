package com.example.demo.myjpadto4prac;

import com.example.demo.myjpadto4prac.dto5.PostRequestDto5;
import com.example.demo.myjpadto4prac.dto5.PostResponseDto5;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jpadto/posts")
public class PostControllerJpa5 {

    private final PostServiceJpa5 postServiceJpa5;

    public PostControllerJpa5(PostServiceJpa5 postServiceJpa5) {
        this.postServiceJpa5 = postServiceJpa5;
    }

    @PostMapping
    public PostResponseDto5 createPost(@RequestBody PostRequestDto5 newPost) {
        return postServiceJpa5.createPost(newPost);
    }

}
