package com.example.demo.myjpasitev42;

import com.example.demo.myjpasitev42.dto.PostCreateRequestDto;
import com.example.demo.myjpasitev42.dto.PostListResponseDto;
import com.example.demo.myjpasitev42.dto.PostResponseDto;
import com.example.demo.myjpasitev42.dto.PostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpa/v42/posts")
@RequiredArgsConstructor  // due to DI. postService때문에 필요하다.
public class PostControllerV42 {

    private final PostServiceV4 postServiceV4;

    //Post method /url/ data
    @PostMapping
    public PostResponseDto createPost(@RequestBody PostCreateRequestDto requestDto) {
return postServiceV4.createPost(requestDto);
    }

    @GetMapping
    public List<PostListResponseDto> readPosts() {
        return postServiceV4.readPosts();
    }


//    @GetMapping
//    public ResponseEntity<ApiResponse<List<PostListResponseDto>>> readPosts() {
//       List<PostListResponseDto> data=postServiceV4.readPosts();
//        ApiResponse<List<PostListResponseDto>> response=ApiResponse.ok(data);
//        return ResponseEntity.ok(response);
//    }


    //단건 조회
    @GetMapping("/{id}")
    public PostResponseDto readPostById(@PathVariable Long id) {
       return postServiceV4.readPostById(id);
    }

//    put id 제목/내용 dto data
    @PutMapping("/{id}")
    public PostResponseDto updatePost(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto){
        return postServiceV4.updatePost(id,requestDto);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postServiceV4.deletePost(id);


    }
}