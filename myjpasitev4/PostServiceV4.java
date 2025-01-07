package com.example.demo.myjpasitev4;

import com.example.demo.myjpasitev4.dto.PostCreateRequestDto;
import com.example.demo.myjpasitev4.dto.PostListResponseDto;
import com.example.demo.myjpasitev4.dto.PostResponseDto;
import com.example.demo.myjpasitev4.dto.PostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostServiceV4 {

   private final PostRepositoryV4 postRepositoryV4;

   @Transactional
   public PostResponseDto createPost(PostCreateRequestDto requestDto) {

//        post=requestDto.toEntity();
//       postRepositoryV4.save(post);
       PostV4 post=postRepositoryV4.save(requestDto.toEntity());
       return PostResponseDto.from(post);
//       return new PostResponseDto((post.getId(), post.getTitle(), post.getContent(), post.getAuthor())));

   }


   public List<PostListResponseDto> readPosts() {
//       List<PostV4> all=postRepositoryV4.findAll()  //postResponseDto를
      return postRepositoryV4.findAll().stream()
               .map(PostListResponseDto::from)
              .toList();
    //  .map((post) -> PostListResponseDto.from(post))
   }

   public PostResponseDto readPostById(Long id) {
       PostV4 post=postRepositoryV4.findById(id)
               .orElseThrow(()->new IllegalArgumentException());
       return PostResponseDto.from(post);
   }

   @Transactional
   public PostResponseDto updatePost(Long id, PostUpdateRequestDto requestDto) {
       PostV4 post=postRepositoryV4.findById(id)
               .orElseThrow(()->new IllegalArgumentException());
        post.update(requestDto);
//        postRepositoryV4.save(post);
//        transactional에서 영속성 관리를 하면서 commit()이 자동적으로 일어나 수정이 일어난다.
          return PostResponseDto.from(post);
   }

   @Transactional
   public void deletePost(Long id) {
       PostV4 post=postRepositoryV4.findById(id)
               .orElseThrow(()->new IllegalArgumentException());
       postRepositoryV4.delete(post);
   }
}
