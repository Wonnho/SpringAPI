package com.example.demo.myjpasite;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("jpa/posts")
public class PostControllerJpa {
    private final PostServiceJpa postServiceJpa; //
//    private PostServiceJpa postServiceJpa;

    public PostControllerJpa(PostServiceJpa postServiceJpa) {
        this.postServiceJpa = postServiceJpa;
    }

    @PostMapping
    public PostJpa createPost(@RequestBody PostJpa newPost) {
        return postServiceJpa.createPost(newPost);
    }


    @GetMapping
    public List<PostJpa> readPost() {
        return  postServiceJpa.readPosts();
    }

    //단일조회
    @GetMapping("/{id}")
    public PostJpa readPostById(@PathVariable Long id) {
        return  postServiceJpa.readPostById(id);
    }


    //수정
    @PutMapping("/{id}")
    public PostJpa updatePost(@PathVariable Long id, @RequestBody PostJpa updatedPost) {
        return postServiceJpa.updatePost(id,updatedPost);
    }


    //delete
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postServiceJpa.deletePost(id);
    }
}
