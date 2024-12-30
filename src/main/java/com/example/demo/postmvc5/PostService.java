package com.example.demo.postmvc5;

import com.example.demo.mysite.Post;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("postServiceMvc5")
public class PostService {
//    PostRepository postRepository=new PostRepository();

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    PostRepository postRepository;

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

public Post readPostById(Long id) {
        //post가 없을 수도 있다.
    Post post=postRepository.findById(id);
   if(post==null) {
       throw new IllegalArgumentException("No Id exists");
   }
    checkPostIsNull(post);
    return post;
}

public Post updatePost(Long id,Post updatedPost) {
        Post post=postRepository.findById(id);
//        if(post==null) {
//            throw new IllegalArgumentException("No Id exists");
//        }
        checkPostIsNull(post);
        validatePostData(updatedPost);

        return postRepository.modify(id,updatedPost); //return it to postController
}

public void deletePost(Long id) {
        Post post=postRepository.findById(id);
       checkPostIsNull(post);
        postRepository.delete(post);

}

public void checkPostIsNull(Post post) {
    if(post==null) {
        throw new IllegalArgumentException("No Id exists");
    }
}

public void validatePostData(Post post) {
   String title=post.getTitle();
   String content=post.getContent();
    //유효성 체크
    if(title==null||title.isBlank()) {
        throw new RuntimeException("enter title");

    }
    if(content==null||content.isBlank()) {
        throw new IllegalArgumentException("enter content");
    }
}
}
