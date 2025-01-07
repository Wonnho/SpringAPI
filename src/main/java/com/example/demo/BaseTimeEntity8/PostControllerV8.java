package com.example.demo.BaseTimeEntity8;

import com.example.demo.BaseTimeEntity8.dto.PostCreateRequestDto;
import com.example.demo.BaseTimeEntity8.dto.PostListResponseDto;
import com.example.demo.BaseTimeEntity8.dto.PostResponseDto;
import com.example.demo.BaseTimeEntity8.dto.PostUpdateRequestDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpa/v8/posts")
@RequiredArgsConstructor
public class PostControllerV8 {
    private final PostServiceV8 postServiceV8;

//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<com.example.demo.myjpasitev4.ApiResponse<Void>> handleResourceNotFound(ResourceNotFoundException ex) {
//        return ResponseEntity
//                .status(HttpStatus.NOT_FOUND)
//                .body(com.example.demo.myjpasitev4.ApiResponse.error("resoure not found", "NOT_FOUND"));
//    }

    //Post method / url / data
    @PostMapping
    public ResponseEntity<ApiResponse<PostResponseDto>> createPost(@Valid  @RequestBody PostCreateRequestDto reqeustDto){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        ApiResponse.ok(
                                "게시글이 정상적으로 작성되었습니다",
                                "CREATED",
                                postServiceV8.createPost(reqeustDto)
                        )
                );
        
    }

    // Getmethod / url / 전체
    @GetMapping
    public ResponseEntity<ApiResponse<List<PostListResponseDto>>> readPosts(){
        List<PostListResponseDto> data = postServiceV8.readPosts();
        ApiResponse<List<PostListResponseDto>> response = ApiResponse.ok(data);

        return ResponseEntity.ok(response);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PostResponseDto>> readPostById(@PathVariable Long id){

        return ResponseEntity.ok(ApiResponse.ok(postServiceV8.readPostById(id)));
    }

    // PUT id 제목/내용 dto data
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<PostResponseDto>> updatePost(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto){
        return ResponseEntity.ok(ApiResponse.ok(postServiceV8.updatePost(id, requestDto)));
    }

//    @DeleteMapping("/{id}")
////    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public ResponseEntity<Void> deletePost(@PathVariable Long id){
//        postServiceV4.deletePost(id);
//        return  ResponseEntity.noContent().build();
//    }

    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<ApiResponse<Void>> deletePost(@PathVariable Long id){
        postServiceV8.deletePost(id);
        return ResponseEntity.ok(
                ApiResponse.ok(
                        "게시글이 정상적으로 삭제되었습니다",
                        "DELETED",
                        null
                )
        );
    }

//
}
