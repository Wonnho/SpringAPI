package com.example.demo.postmvc2;

import com.example.demo.mysite.Post;

import java.util.List;

public class PostService {
    PostRepository postRepository=new PostRepository();

    public Post createPost(Post newPost) {
        // controller에게 데이터를 이볅받아서

        //유효성 체크를 한 후에
        String title=newPost.getTitle();
        String content=newPost.getContent();

        //유효성 체크=>business logic 처리. 내가 할 거 가애
        if(title==null||title.isBlank()) {
            throw new RuntimeException("enter title");

        }
        if(content==null||content.isBlank()) {
            throw new IllegalArgumentException("enter content");

        }

        //post를 생성하겠다.

        return postRepository.save(newPost);
    }

public List<Post> readPosts() {
        return postRepository.findAll();
}
}
