package com.example.demo.myjpasitev2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostRepositoryJpaV2 {
    @PersistenceUnit
    private final EntityManagerFactory emf;

    public PostJpaV2 save(PostJpaV2 post) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(post); //저장
            tx.commit();
            return post;

        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }


    public PostJpaV2 findById(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(PostJpaV2.class, id);  //정해진 문법
        } finally {

            em.close();
        }
    }

    public List<PostJpaV2> findAll() {
        EntityManager em = emf.createEntityManager();

        //post에서 모든 데이터를 가져오고 피다.
        // select * from posts p
        try {
            return em.createQuery("select p from PostJpaV2 p", PostJpaV2.class)
                    .getResultList(); //table을 entity로 대체하는 정도만 다른다.
        } finally {
            em.close();

        }
    }

    public PostJpaV2 update(Long id, PostJpaV2 updatedPost) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            //update할 entity를 가져온다
            PostJpaV2 post = em.find(PostJpaV2.class, id);

                //수정
            String newTitle = updatedPost.getTitle();
            String newContent = updatedPost.getContent();
            post.update(newTitle, newContent);

            tx.commit();
            return post;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}