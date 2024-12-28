package com.example.demo.postmvc;

import com.example.demo.mysite.Post;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController("postController")
@RequestMapping("/mvc/posts")
public class PostController {
    PostService postService=new PostService();



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)  //class로 전체로 전달됨
    public Post createPost(@RequestBody Post newPost) {
    return postService.createPost(newPost);
    }
}
