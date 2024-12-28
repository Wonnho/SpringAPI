package com.example.demo.postmvc3;

import com.example.demo.mysite.Post;

import java.util.ArrayList;
import java.util.List;


public class PostRepository {
    private List<Post> posts = new ArrayList<>();  //sleect, create, delete ;delegate DB role to it
    private Long id = 0L; //게시글 생성에서 id 생성을 위한 장치

    public Post save(Post newPost) {

//        String title=newPost.getTitle();
//        String content=newPost.getContent();

        Post post = new Post(++id, newPost.getTitle(), newPost.getContent());
        posts.add(post);
        return post;
    }

    public List<Post> findAll() {
        return posts;
    }


    public Post findById(Long id) {
        for (Post post : posts) {
            if(post.getId().equals(id)) {
                return post;
            }

        } return null;
    }
}
