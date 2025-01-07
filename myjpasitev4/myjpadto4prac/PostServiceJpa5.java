package com.example.demo.myjpadto4prac;

import com.example.demo.myjpadto4prac.dto5.PostRequestDto5;
import com.example.demo.myjpadto4prac.dto5.PostResponseDto5;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostServiceJpa5 {
    private final PostRepositoryJpa5 postRepositoryJpa5;

    public PostServiceJpa5(PostRepositoryJpa5 postRepositoryJpa5) {
        this.postRepositoryJpa5 = postRepositoryJpa5;
    }

    @Transactional
    public PostResponseDto5 createPost(PostRequestDto5 newPost) {
        return PostResponseDto5.from(postRepositoryJpa5.save(newPost.toEntity()));
    }
}
