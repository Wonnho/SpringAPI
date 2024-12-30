package com.example.demo.myjpasite;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceJpa {

    private final PostRepositoryJpa postRepositoryJpa;

    public PostServiceJpa(PostRepositoryJpa postRepositoryJpa) {
        this.postRepositoryJpa = postRepositoryJpa;
    }

    public PostJpa createPost(PostJpa postJpa) {
        return postRepositoryJpa.save(postJpa);
    }

    public List<PostJpa> readPosts() {
        return postRepositoryJpa.findAll();
    }

    public PostJpa readPostById(Long id) {
        return postRepositoryJpa.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No postJpa Exists"));
    }


    public PostJpa updatePost(Long id,PostJpa updatedPost) { //find id to update

        PostJpa post = postRepositoryJpa.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No postJpa Exists"));

//        post.setTitle("gadget");
        String title = updatedPost.getTitle();
        String content = updatedPost.getContent();

        post.setTitle(title);
        post.setContent(content);
    //    post.update(title,content);
//    return postRepositoryJpa.save(post);
        return postRepositoryJpa.save(post.update(title,content));

    }


public void deletePost(Long id) {
        PostJpa post=postRepositoryJpa.findById(id)
                .orElseThrow(()->new IllegalArgumentException("No id Exists"));
        postRepositoryJpa.delete(post);
}


}
