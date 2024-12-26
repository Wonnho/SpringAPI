package com.example.demo.mysite;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostAPI {

    //Post class 의 instance, 즉 게식글을 넣을 List랠 생성
    List<Post> posts=new ArrayList<Post>();  //sleect, create, delete ;delegate DB role to it
    private Long id=1L; //게시글 생성에서 id 생성을 위한 장치


}
