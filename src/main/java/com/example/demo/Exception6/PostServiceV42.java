package com.example.demo.Exception6;

import com.example.demo.Exception6.dto.PostCreateRequestDto;
import com.example.demo.Exception6.dto.PostListResponseDto;
import com.example.demo.Exception6.dto.PostResponseDto;
import com.example.demo.Exception6.dto.PostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostServiceV42 {
    private final PostRepositoryV42 postRepositoryV42;

    @Transactional
    public PostResponseDto createPost(PostCreateRequestDto requestDto){
        
//        PostV4 transientPost = requestDto.toEntity();
//        PostV4 managedPost =  postRepositoryV4.save(transientPost);

        PostV42 post =  postRepositoryV42.save(requestDto.toEntity());

        return PostResponseDto.from(post);
//        return new PostResponseDto(post.getId(), post.getTitle(), post.getContent(), post.getAuthor());
    }
    
    public List<PostListResponseDto> readPosts(){
        return postRepositoryV42.findAll().stream()
                .map(PostListResponseDto::from)
                .toList();
//                .map((post) -> PostListResponseDto.from(post))
    }

    public PostResponseDto readPostById(Long id){
        PostV42 post = postRepositoryV42.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());
        return PostResponseDto.from(post);
    }

    @Transactional
    public PostResponseDto updatePost(Long id, PostUpdateRequestDto requestDto){
//                하나 가져오자 -> 걔를 수정하자 -> save하자
        PostV42 post = postRepositoryV42.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());
        post.update(requestDto);
        return PostResponseDto.from(post);
    }

    @Transactional()
    public void deletePost(Long id){
        // 하나 가져오자 -> 걔를 삭제하자.
        PostV42 post = postRepositoryV42.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());

        postRepositoryV42.delete(post);
    }
}
