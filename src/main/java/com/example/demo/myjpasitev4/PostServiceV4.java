package com.example.demo.myjpasitev4;

import com.example.demo.myjpasitev4.dto.PostCreateRequestDto;
import com.example.demo.myjpasitev4.dto.PostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostServiceV4 {

   private final PostRepositoryV4 postRepositoryV4;

   public type createPost(PostCreateRequestDto requestDto) {

        post=requestDto.toEntity();
             return  postRepositoryV4.save(post);
       return PostResponseDto.from(post);
//       return new PostResponseDto((post.getId(), post.getTitle(), post.getContent(), post.getAuthor())));

   }
}
