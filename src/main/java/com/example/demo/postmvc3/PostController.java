package com.example.demo.postmvc3;

import com.example.demo.mysite.Post;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("postController3")
@RequestMapping("/mvc3/posts")
public class PostController {
    PostService postService=new PostService();



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)  //class로 전체로 전달됨
    public Post createPost(@RequestBody Post newPost) {
    return postService.createPost(newPost);
    }

    @GetMapping
    public List<Post> readPost() {
        return postService.readPosts();
    }

    @GetMapping("/{id}")
    public Post readPostById(@PathVariable Long id) {
        return postService.readPostById(id);
    }
}
