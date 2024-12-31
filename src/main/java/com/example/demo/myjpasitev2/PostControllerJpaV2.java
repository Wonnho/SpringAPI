package com.example.demo.myjpasitev2;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("jpa/v2/posts")
public class PostControllerJpaV2 {
    private final PostServiceJpaV2 postServiceJpaV2; //
//    private PostServiceJpa postServiceJ›pa;

    public PostControllerJpaV2(PostServiceJpaV2 postServiceJpaV2) {
        this.postServiceJpaV2 = postServiceJpaV2;
    }

    @PostMapping
    public PostJpaV2 createPost(@RequestBody PostJpaV2 newPost) {
        return postServiceJpaV2.createPost(newPost);
    }
//
//
    @GetMapping
    public List<PostJpaV2> readPost() {
        return  postServiceJpaV2.readPosts();
    }

    //단일조회
    @GetMapping("/{id}")
    public PostJpaV2 readPostById(@PathVariable Long id) {
        return  postServiceJpaV2.readPostById(id);
    }
//
//
    //수정
    @PutMapping("/{id}")
    public PostJpaV2 updatePost(@PathVariable Long id, @RequestBody PostJpaV2 updatedPost) {
        return postServiceJpaV2.updatePost(id,updatedPost);
    }
//
//
//    //delete
//    @DeleteMapping("/{id}")
//    public void deletePost(@PathVariable Long id) {
//        postServiceJpaV2.deletePost(id);
//    }
}
