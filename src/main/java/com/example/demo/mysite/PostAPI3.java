package com.example.demo.mysite;

import com.example.demo.mysite.Post;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v3/posts")  //class로 전체로 옮김
public class PostAPI3 {

    //Post class 의 instance, 즉 게식글을 넣을 List랠 생성
    List<Post> posts = new ArrayList<>();  //sleect, create, delete ;delegate DB role to it
    private Long id = 0L; //게시글 생성에서 id 생성을 위한 장치

    {
        //3 초기화 블록
        //인스턴스가 생성되었을 때 한번 실행된다.
        posts.add(new Post(++id, "초기 제목", "초기 내용"));
    }

    //create

    //post/content/url
    //url에 내용을 실어 보내자
    @PostMapping("")
    public Post createPost() {
        Post post = new Post(++id, "제목", "내용");
        posts.add(post);
        return post;
    }

    @GetMapping("")   //전체 조회
    public List<Post> readPosts() {
        return posts;
    }


    //4 단일 조회 : 내용을 구분하기 위해 id가 필요하다.
    @GetMapping("/{id}")   //id가 변수처럼 기능  posts/1,posts/2,...
    public Post readPostById(@PathVariable Long id) { //method 내보웨서 사용해야 하므로 받아와야 한다. 경로상에 있는 id를 받아온다

        //posts에서 post를 가져오자
        for (Post post : posts) {
            if (post.getId().equals(id)) {
                return post;
            }

        }
        return null;

    }


    //5. update
    //변경 내용/id/url
    @PutMapping("{id}")
    public Post updatePost(@PathVariable  Long id) {
        for (Post post : posts) {
            if (post.getId().equals(id)) {
                post.setTitle("수정된 제목");
                post.setContent("수정된 내용");
              return post;
            }

        } return null;
    }


    //6. delete

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable Long id) {
        for (Post post : posts) {
            if(post.getId().equals(id)) {
                posts.remove(post);

                return "게시글이 삭제되었습니다.";
            }

        } return "게시글이 존재하지 않습니다.";
    }
}