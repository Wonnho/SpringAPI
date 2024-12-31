package com.example.demo.myjpasitev2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import org.springframework.data.annotation.Persistent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceJpaV2 {

    private final PostRepositoryJpaV2 postRepositoryJpaV2;

    public PostServiceJpaV2(PostRepositoryJpaV2 postRepositoryJpaV2) {
        this.postRepositoryJpaV2 = postRepositoryJpaV2;
    }

    public PostJpaV2 createPost(PostJpaV2 postJpaV2) {
        return postRepositoryJpaV2.save(postJpaV2);



    }

//    전체 조회
    public List<PostJpaV2> readPosts() {
        return postRepositoryJpaV2.findAll();
    }

    // 단일조회
    public PostJpaV2 readPostById(Long id) {
        return postRepositoryJpaV2.findById(id);

    }
//
// 수정
    public PostJpaV2 updatePost(Long id, PostJpaV2 updatedPost) { //find id to update
        return postRepositoryJpaV2.update(id, updatedPost);


        //
//        PostJpaV2 post = postRepositoryJpaV2.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("No postJpa Exists"));
//
////        post.setTitle("gadget");
//        String title = updatedPost.getTitle();
//        String content = updatedPost.getContent();
//
//        post.setTitle(title);
//        post.setContent(content);
//    //    post.update(title,content);
////    return postRepositoryJpa.save(post);
//        return postRepositoryJpaV2.save(post.update(title,content));
//
    }
//
//
//public void deletePost(Long id) {
//        PostJpaV2 post= postRepositoryJpaV2.findById(id)
//                .orElseThrow(()->new IllegalArgumentException("No id Exists"));
//        postRepositoryJpaV2.delete(post);
//}


}
